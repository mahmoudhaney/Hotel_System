package OurFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class FileHandler {
    //============Constructors===================
    public FileHandler(){
        
    }
    //============************************--add Methods--****************************************************========================                
    public static void Add(String name, String email, String password, String Address){ //For Receptionist
        try{
            FileWriter file = new FileWriter("D:\\Netbeans_Projects\\Hotel Reservation System\\src\\OurFiles\\Receptionist.txt", true);
            file.write(name + " " + email + " " + password + " " + Address + "\n");
            file.close();
            JOptionPane.showMessageDialog(null, "User Added Successfully, Now You Can Login");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }       
    }
                   
    public static void Add(int id, String name, String email, String department, double salary){ //For Employees
        try{
            FileWriter file = new FileWriter("D:\\Netbeans_Projects\\Hotel Reservation System\\src\\OurFiles\\Employees.txt", true);
            file.write(id + " " + name + " " + email + " " + department + " " + salary + "\n");
            file.close();
            JOptionPane.showMessageDialog(null, "Employee Added Successfully");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }       
    }
    
    public static void Add(int roomNo, String roomType, float price, String roomStatus){ //For Rooms
        try{
            FileWriter file = new FileWriter("D:\\Netbeans_Projects\\Hotel Reservation System\\src\\OurFiles\\Rooms.txt", true);
            file.write(roomNo + " " + roomType + " " + price + " " + roomStatus + "\n");
            file.close();
            JOptionPane.showMessageDialog(null, "Room Added Successfully");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }       
    }
    
    public static void AddService(int serviceNo, String serviceName, float price, String serviceStatus){ //For Services
        try{
            FileWriter file = new FileWriter("D:\\Netbeans_Projects\\Hotel Reservation System\\src\\OurFiles\\Services.txt", true);
            file.write(serviceNo + " " + serviceName + " " + price + " " + serviceStatus + "\n");
            file.close();
            JOptionPane.showMessageDialog(null, "Service Added Successfully");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }       
    }
    
    public static void Add(String name, String mobile, String gender, String id, String checkInDate, String roomType, int roomNo, float price){ //For Guests
        try{
            FileWriter file = new FileWriter("D:\\Netbeans_Projects\\Hotel Reservation System\\src\\OurFiles\\Guests.txt", true);
            file.write(name + " " + mobile + " " + gender + " " + id + " " + checkInDate + " " + roomType + " " + roomNo + " " + price + "\n");
            file.close();
            JOptionPane.showMessageDialog(null, "Room Booked Successfully");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    //============************************--getDate Methods--****************************************************====================
    public static String[] getLogin(){
        ArrayList<String> data = new ArrayList<String>();
        String[] info = null;
        File file = new File("D:\\Netbeans_Projects\\Hotel Reservation System\\src\\OurFiles\\Receptionist.txt");
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
    
    public static String[] getEmployee(){
        ArrayList<String> data = new ArrayList<String>();
        String[] info = null;
        File file = new File("D:\\Netbeans_Projects\\Hotel Reservation System\\src\\OurFiles\\Employees.txt");
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
    
    public static String[] getRoom(){
        ArrayList<String> data = new ArrayList<String>();
        String[] info = null;
        File file = new File("D:\\Netbeans_Projects\\Hotel Reservation System\\src\\OurFiles\\Rooms.txt");
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
    
    public static String[] getService(){
        ArrayList<String> data = new ArrayList<String>();
        String[] info = null;
        File file = new File("D:\\Netbeans_Projects\\Hotel Reservation System\\src\\OurFiles\\Services.txt");
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
    
    public static String[] getGuest(){
        ArrayList<String> data = new ArrayList<String>();
        String[] info = null;
        File file = new File("D:\\Netbeans_Projects\\Hotel Reservation System\\src\\OurFiles\\Guests.txt");
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
    
    //============************************--updateDate Methods--*************************************************====================
    public static void updateEmployee (int checkedId, int id, String name, String email, String department, double salary){
        ArrayList<String> ourDate = new ArrayList<String>();
        File file = new File("D:\\Netbeans_Projects\\Hotel Reservation System\\src\\OurFiles\\Employees.txt");
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
            
            FileWriter write = new FileWriter("D:\\Netbeans_Projects\\Hotel Reservation System\\src\\OurFiles\\Employees.txt");
            for(int i=0;i<ourDate.size();i++)    
                write.write(ourDate.get(i)+"\n");
            write.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }       
    }
    
    public static void updateRoom (int checkedId, int roomNo, String roomType, float price, String roomStatus){
        ArrayList<String> ourDate = new ArrayList<String>();
        File file = new File("D:\\Netbeans_Projects\\Hotel Reservation System\\src\\OurFiles\\Rooms.txt");
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
                    ourDate.set(i,roomNo + " " + roomType + " " + price + " " + roomStatus);
            }
            
            FileWriter write = new FileWriter("D:\\Netbeans_Projects\\Hotel Reservation System\\src\\OurFiles\\Rooms.txt");
            for(int i=0;i<ourDate.size();i++)    
                write.write(ourDate.get(i)+"\n");
            write.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }       
    }
    
    public static void updateService (int checkedId, int serviceNo, String serviceName, float price, String serviceStatus){
        ArrayList<String> ourDate = new ArrayList<String>();
        File file = new File("D:\\Netbeans_Projects\\Hotel Reservation System\\src\\OurFiles\\Services.txt");
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
                    ourDate.set(i,serviceNo + " " + serviceName + " " + price + " " + serviceStatus);
            }
            
            FileWriter write = new FileWriter("D:\\Netbeans_Projects\\Hotel Reservation System\\src\\OurFiles\\Services.txt");
            for(int i=0;i<ourDate.size();i++)    
                write.write(ourDate.get(i)+"\n");
            write.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }       
    }
    
    //============************************--deleteDate Methods--*************************************************====================
    public static void deleteEmployee(int id){
        ArrayList<String> ourDate = new ArrayList<String>();
        File file = new File("D:\\Netbeans_Projects\\Hotel Reservation System\\src\\OurFiles\\Employees.txt");
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
            
            FileWriter write = new FileWriter("D:\\Netbeans_Projects\\Hotel Reservation System\\src\\OurFiles\\Employees.txt");
            for(int i=0;i<ourDate.size();i++)    
                write.write(ourDate.get(i)+"\n");
            write.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public static void deleteRoom(int id){
        ArrayList<String> ourDate = new ArrayList<String>();
        File file = new File("D:\\Netbeans_Projects\\Hotel Reservation System\\src\\OurFiles\\Rooms.txt");
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
            
            FileWriter write = new FileWriter("D:\\Netbeans_Projects\\Hotel Reservation System\\src\\OurFiles\\Rooms.txt");
            for(int i=0;i<ourDate.size();i++)    
                write.write(ourDate.get(i)+"\n");
            write.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public static void deleteService(int id){
        ArrayList<String> ourDate = new ArrayList<String>();
        File file = new File("D:\\Netbeans_Projects\\Hotel Reservation System\\src\\OurFiles\\Services.txt");
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
            
            FileWriter write = new FileWriter("D:\\Netbeans_Projects\\Hotel Reservation System\\src\\OurFiles\\Services.txt");
            for(int i=0;i<ourDate.size();i++)    
                write.write(ourDate.get(i)+"\n");
            write.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public static void deleteGuest(int id){
        ArrayList<String> ourDate = new ArrayList<String>();
        File file = new File("D:\\Netbeans_Projects\\Hotel Reservation System\\src\\OurFiles\\Guests.txt");
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
            
            FileWriter write = new FileWriter("D:\\Netbeans_Projects\\Hotel Reservation System\\src\\OurFiles\\Guests.txt");
            for(int i=0;i<ourDate.size();i++)    
                write.write(ourDate.get(i)+"\n");
            write.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    //*********************************************************************
    
}
