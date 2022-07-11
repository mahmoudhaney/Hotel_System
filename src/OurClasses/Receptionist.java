package OurClasses;

import Databases.DatebaseActions;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Receptionist {
    private String name;
    private String email;
    private String password;
    private String Address;
    final static String ReceptionistPath = "D:\\Netbeans_Projects\\Hotel_System\\src\\OurFiles\\Receptionist.txt";
    
    // ==================Setters & Getters======================================
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public static String getReceptionistPath() {
        return ReceptionistPath;
    }
    
    // ==================File Methods======================================
    public static void add(String name, String email, String password, String Address){ //For Receptionist
        try{
            String Query = "insert into receptionist values('"+name+"','"+email+"','"+password+"','"+Address+"')";
            DatebaseActions.setData(Query, "Registered Successfully, Now you Need to Login");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }       
    }
    
    public static boolean login(String email, String password){
        try{
            String Query = "select * from receptionist where email = '"+email+"' and password = '"+password+"'";
            ResultSet rs = Databases.DatebaseActions.getDate(Query);
            if(rs.next())
            {
                return true;
            }
            else
                return false;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return false;
        }   
    }
    
    
    
}
