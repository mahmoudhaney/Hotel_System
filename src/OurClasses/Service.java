package OurClasses;

import Databases.DatebaseActions;
import java.io.File;
import java.io.FileWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Service {
    private String number;
    private String name;
    private String price;
    private String status;
    
    // ==================Setters & Getters======================================
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    // ==================File Methods======================================
    public static void add(int serviceNo, String serviceName, float price, String serviceStatus){ //For Services
        try{
            DatebaseActions.setData("insert into service values('"+serviceNo+"', '"+serviceName+"','"+price+"','"+serviceStatus+"')", "Service Added Successfully");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }        
    }
    
    public static ResultSet get(){
        String Query = "select * from service";
        ResultSet result = Databases.DatebaseActions.getDate(Query);
        return result;
    }
    
    public static void update(int checkedId, String serviceName, float price, String serviceStatus){
        DatebaseActions.setData("update service set name = '"+ serviceName +"', price = '"+ price +"',status = '"+ serviceStatus +"' " + " where id = " + checkedId + "" ,"Service Updated");
    }
    
    public static void delete(int id){
        DatebaseActions.setData("delete from service where id = " + id + "", "Service Deleted");
    }
}
