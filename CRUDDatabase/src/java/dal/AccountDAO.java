/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import entity.Account;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author minhh
 */
public class AccountDAO extends DBContext {

    PreparedStatement statement;
    ResultSet resultSet;
    
    /**
     * lấy về toàn bộ Account từ Database
     * @return List
     */
    public List<Account> findAll() {
        List<Account> list = new ArrayList<>();
        //- connect with DB
        connection = getConnection();
        //- chuẩn bị câu lệnh SQL
        String sql = "select * from Account";
        try {
            //- Tạo đối tượng PrepareStatement
            statement = connection.prepareStatement(sql);
            //- Set parameter ( optional )

            //- Thực thi câu lệnh
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Account account = new Account();
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                account.setId(id);
                account.setUsername(username);
                account.setPassword(password);
                // add to collection
                list.add(account);

            }
            //- trả về kết quả
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Đảm bảo đóng các tài nguyên
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }
    
    public static void main(String[] args) {
        AccountDAO dao = new AccountDAO();
        for (Account account : dao.findAll()) {
            System.out.println(account);
        }
    }

}
