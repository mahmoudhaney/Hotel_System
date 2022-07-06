package OurClasses;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Employee{
    private String id;
    private String name;
    private String email;
    private String department;
    private String salary;
    final static String EmployeePath = "D:\\Netbeans_Projects\\Hotel_System\\src\\OurFiles\\Employees.txt";
    
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

    public static String getEmployeePath() {
        return EmployeePath;
    }
    
    
    
    // ==================File Methods======================================
    public static void add(int id, String name, String email, String department, double salary){ //For Employees
        try{
            FileWriter file = new FileWriter(EmployeePath, true);
            file.write(id + " " + name + " " + email + " " + department + " " + salary + "\n");
            file.close();
            JOptionPane.showMessageDialog(null, "Employee Added Successfully");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }       
    }
    
    public static String[] get(){
        ArrayList<String> data = new ArrayList<String>();
        String[] info = null;
        File file = new File(EmployeePath);
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
    
    public static void update(int checkedId, int id, String name, String email, String department, double salary){
        ArrayList<String> ourDate = new ArrayList<String>();
        File file = new File(EmployeePath);
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
                if(Integer.parseInt(checkedDate[0]) == checkedId)
                    ourDate.set(i,id + " " + name + " " + email + " " + department + " " + salary);
            }
            
            FileWriter write = new FileWriter(EmployeePath);
            for(int i=0;i<ourDate.size();i++)    
                write.write(ourDate.get(i)+"\n");
            write.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }       
    }
    
    public static void delete(int id){
        ArrayList<String> ourDate = new ArrayList<String>();
        File file = new File(EmployeePath);
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
                if(Integer.parseInt(checkedDate[0]) == id)
                    ourDate.remove(i);
            }
            
            FileWriter write = new FileWriter(EmployeePath);
            for(int i=0;i<ourDate.size();i++)    
                write.write(ourDate.get(i)+"\n");
            write.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
