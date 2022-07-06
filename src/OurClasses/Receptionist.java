package OurClasses;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
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
            FileWriter file = new FileWriter(ReceptionistPath, true);
            file.write(name + " " + email + " " + password + " " + Address + "\n");
            file.close();
            JOptionPane.showMessageDialog(null, "User Added Successfully, Now You Can Login");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }       
    }
    
    public static String[] get(){
        ArrayList<String> data = new ArrayList<String>();
        String[] info = null;
        File file = new File(ReceptionistPath);
        try{
            Scanner in = new Scanner(file);
            while(in.hasNext()){
                data.add(in.nextLine());
            }
            info = data.toArray(new String[0]);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return info;
    }
    
    
    
}
