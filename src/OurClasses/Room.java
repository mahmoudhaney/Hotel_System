package OurClasses;

import Databases.DatebaseActions;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Room {
    private String number;
    private String type;
    private String price;
    private String status;
    
    // ==================Setters & Getters======================================
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
    public static void add(int roomNo, String roomType, float price, String roomStatus){ //For Rooms
        try{
            DatebaseActions.setData( "insert into room values('"+roomNo+"', '"+roomType+"','"+price+"','"+roomStatus+"')" , "Room Added Successfully");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }      
    }
    
    public static ResultSet get(){
        String Query = "select * from room";
        ResultSet result = Databases.DatebaseActions.getDate(Query);
        return result;
    }
    
    public static void update(int checkedId, String roomType, float price, String roomStatus){
        DatebaseActions.setData("update room set type = '"+ roomType +"', price = '"+ price +"',status = '"+ roomStatus +"' " + " where id = " + checkedId + "" ,"");    
    }
    
    public static void delete(int id){
        DatebaseActions.setData("delete from room where id = " + id + "", "Room Deleted");
    }

    
    
}
