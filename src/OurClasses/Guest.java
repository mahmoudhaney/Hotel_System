package OurClasses;

import Databases.DatebaseActions;
import java.io.File;
import java.io.FileWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Guest {
    private String name;
    private String mobile;
    private String gender;
    private String idproof;
    private String checkInDate;
    //private Room room;
    

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
    
    // ==================File Methods======================================
    public static void add(String name, String mobile, String gender, String idproof, String checkInDate, String roomType, int roomNo, float price){ //For Guests
        try{
            DatebaseActions.setData("insert into guest values('"+name+"', '"+mobile+"','"+gender+"','"+idproof+"','"+checkInDate+"','"+roomType+"','"+roomNo+"','"+price+"')", "Guest Added Successfully");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        } 
    }
    
    public static ResultSet get(){
        String Query = "select * from guest";
        ResultSet result = Databases.DatebaseActions.getDate(Query);
        return result;
    }
    
    public static void delete(int id){
        DatebaseActions.setData("delete from guest where roomnumber = " + id + "", "Guest Checkedout");
    }
    
}
