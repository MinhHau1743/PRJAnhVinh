
import java.awt.AWTEventMulticaster;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author minhh
 */
public class ManageAccount {

    private static ArrayList<Account> listAccount;
    private static ArrayList<Role> listRole;

    public ArrayList<Account> getListAccount() {
        return listAccount;
    }

    public ArrayList<Role> getListRole() {
        return listRole;
    }

    public ManageAccount() {
        listAccount = new ArrayList<>();
        listRole = new ArrayList<>();
        Role roleUser = new Role(1, "User");
        Role roleAdmin = new Role(0, "Admin");
        listRole.add(roleAdmin);
        listRole.add(roleUser);
        
        listAccount.add(new Account("1", "1", true, roleUser));
        listAccount.add(new Account("2", "1", true, roleUser));
        listAccount.add(new Account("3", "1", true, roleAdmin));
        listAccount.add(new Account("4", "1", true, roleAdmin));
        
        
//        for (Account account : listAccount) {
//            
//        }
   }

    ArrayList<Account> findByKeyword(String keyword) {
        ArrayList<Account> listSearch = new ArrayList<>();
        for (Account account : listAccount) {
            // check Username Account = keyword
            if (account.getUsername().toUpperCase().contains(keyword.toUpperCase())) {
                listSearch.add(account);
            }
        }
        return listSearch;
    }

    Account findByUsername(String username) {
        for (Account account : listAccount){
            if (account.getUsername().equalsIgnoreCase(username)) {
                return account;
            }
        }
        return null;
    }

    void removeAccount(Account account) {
        listAccount.remove(account);
    }

}
