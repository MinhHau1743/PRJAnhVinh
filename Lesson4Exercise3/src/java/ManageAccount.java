
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

    public static ArrayList<Account> getListAccount() {
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
    }

}
