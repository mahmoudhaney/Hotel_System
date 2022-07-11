package OurClasses;

import Databases.DatebaseActions;
import java.io.File;
import java.io.FileWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Employee{
    private String id;
    private String name;
    private String email;
    private String department;
    private String salary;
    
    // ==================Setters & Getters======================================
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    
    
    // ==================File Methods======================================
    public static void add(int id, String name, String email, String department, double salary){ //For Employees
        try{
            DatebaseActions.setData("insert into employee values('"+id+"', '"+name+"','"+email+"','"+department+"','"+salary+"')", "Added Successfully");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }     
    }
    
    public static ResultSet get(){
        String Query = "select * from employee";
        ResultSet result = Databases.DatebaseActions.getDate(Query);
        return result;
    }
    
    public static ResultSet getSpecific(int id){
        ResultSet result = Databases.DatebaseActions.getDate("select * from employee where id = " + id+ "");
        return result;
    }
    
    public static void update(int checkedId, String name, String email, String department, double salary){
        DatebaseActions.setData("update employee set name = '"+ name +"', email = '"+ email +"',department = '"+ department +"', salary = "+ salary + " where id = " + checkedId + "" ,"Employee Updated");
    }
    
    public static void delete(int id){
        DatebaseActions.setData("delete from employee where id = " + id + "", "Employee Deleted");
    }
}
