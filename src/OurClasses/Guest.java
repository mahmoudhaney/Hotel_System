package OurClasses;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Guest {
    private String name;
    private String mobile;
    private String gender;
    private String idproof;
    private String checkInDate;
    private Room room;
    final static String GuestPath = "D:\\Netbeans_Projects\\Hotel_System\\src\\OurFiles\\Guests.txt";
    
    // ==================Constructors======================================

    // ==================Setters & Getters======================================
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdproof() {
        return idproof;
    }

    public void setIdproof(String idproof) {
        this.idproof = idproof;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public static String getGuestPath() {
        return GuestPath;
    }    
    
    // ==================File Methods======================================
    public static void add(String name, String mobile, String gender, String id, String checkInDate, String roomType, int roomNo, float price){ //For Guests
        try{
            FileWriter file = new FileWriter(GuestPath, true);
            file.write(name + " " + mobile + " " + gender + " " + id + " " + checkInDate + " " + roomType + " " + roomNo + " " + price + "\n");
            file.close();
            JOptionPane.showMessageDialog(null, "Room Booked Successfully");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public static String[] get(){
        ArrayList<String> data = new ArrayList<String>();
        String[] info = null;
        File file = new File(GuestPath);
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
    
    public static void delete(int id){
        ArrayList<String> ourDate = new ArrayList<String>();
        File file = new File(GuestPath);
        String info = "";
        
        try{
            Scanner in = new Scanner(file);
            while (in.hasNext()){
                ourDate.add(in.nextLine());
            }
            
            String[] checkedDate = null;            
            for(int i=0;i<ourDate.size();i++)
            {
                info = ourDate.get(i);
                checkedDate = info.split("\\s");
                if(Integer.parseInt(checkedDate[6]) == id)
                    ourDate.remove(i);
            }
            
            FileWriter write = new FileWriter(GuestPath);
            for(int i=0;i<ourDate.size();i++)    
                write.write(ourDate.get(i)+"\n");
            write.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}
