package Databases;

import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Tables {
    public static void main(String[] args){
        Connection connection = null;
        Statement statement = null;
        try{
            connection = (Connection) ConnectionProvider.getCon();
            statement = connection.createStatement();
            //For Receptionist
            //statement.executeUpdate("create table receptionist(name varchar(50), email varchar(200), password varchar(200), address varchar(200))");
            //For Guests
            //statement.executeUpdate("create table guest(name varchar(50), mobile varchar(15), gender varchar(10), idproof varchar(30), checkindate date, roomtype varchar(30), roomnumber varchar(30), roomprice varchar(30))");
            //For Employees
            //statement.executeUpdate("create table employee(id int, name varchar(100), email varchar(200), department varchar(50), salary float)");
            //For Rooms
            //statement.executeUpdate("create table room(id int, type varchar(50), price float, status varchar(50))");
            //For Services
            //statement.executeUpdate("create table service(id int, name varchar(50), price float, status varchar(50))");
            JOptionPane.showMessageDialog(null, "Table Created Successfully");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            try{
                connection.close();
                statement.close();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
}
