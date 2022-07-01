package OurFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class FileHandler {
    //=============Paths=========================
    static String EmployeePath = "D:\\Netbeans_Projects\\Hotel Reservation System\\src\\OurFiles\\Employees.txt";
    static String GuestPath = "D:\\Netbeans_Projects\\Hotel Reservation System\\src\\OurFiles\\Guests.txt";
    static String ReceptionistPath = "D:\\Netbeans_Projects\\Hotel Reservation System\\src\\OurFiles\\Receptionist.txt";
    static String RoomPath = "D:\\Netbeans_Projects\\Hotel Reservation System\\src\\OurFiles\\Rooms.txt";
    static String ServicePath = "D:\\Netbeans_Projects\\Hotel Reservation System\\src\\OurFiles\\Services.txt";
    // ================================Getters=======================================
    public static String getEmployeePath() {
        return EmployeePath;
    }

    public static String getGuestPath() {
        return GuestPath;
    }

    public static String getReceptionistPath() {
        return ReceptionistPath;
    }

    public static String getRoomPath() {
        return RoomPath;
    }

    public static String getServicePath() {
        return ServicePath;
    }
    
    //============Constructors===================
    public FileHandler(){}
    //============************************--add Methods--****************************************************========================                
    public static void Add(String name, String email, String password, String Address){ //For Receptionist
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
                   
    public static void Add(int id, String name, String email, String department, double salary){ //For Employees
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
    
    public static void Add(int roomNo, String roomType, float price, String roomStatus){ //For Rooms
        try{
            FileWriter file = new FileWriter(RoomPath, true);
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
            FileWriter file = new FileWriter(ServicePath, true);
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
            FileWriter file = new FileWriter(GuestPath, true);
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
    
    public static String[] getEmployee(){
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
    
    public static String[] getRoom(){
        ArrayList<String> data = new ArrayList<String>();
        String[] info = null;
        File file = new File(RoomPath);
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
        File file = new File(ServicePath);
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
    
    //============************************--updateDate Methods--*************************************************====================
    public static void updateEmployee (int checkedId, int id, String name, String email, String department, double salary){
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
    
    public static void updateRoom (int checkedId, int roomNo, String roomType, float price, String roomStatus){
        ArrayList<String> ourDate = new ArrayList<String>();
        File file = new File(RoomPath);
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
            
            FileWriter write = new FileWriter(RoomPath);
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
        File file = new File(ServicePath);
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
            
            FileWriter write = new FileWriter(ServicePath);
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
    
    public static void deleteRoom(int id){
        ArrayList<String> ourDate = new ArrayList<String>();
        File file = new File(RoomPath);
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
            
            FileWriter write = new FileWriter(RoomPath);
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
        File file = new File(ServicePath);
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
            
            FileWriter write = new FileWriter(ServicePath);
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
    //*********************************************************************
    
}
