package OurClasses;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Room {
    private String number;
    private String type;
    private String price;
    private String status;
    final static String RoomPath = "D:\\Netbeans_Projects\\Hotel_System\\src\\OurFiles\\Rooms.txt";
    
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
    public static String getRoomPath() {
        return RoomPath;
    }
    
    // ==================File Methods======================================
    public static void add(int roomNo, String roomType, float price, String roomStatus){ //For Rooms
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
    
    public static String[] get(){
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
    
    public static void update(int checkedId, int roomNo, String roomType, float price, String roomStatus){
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
    
    public static void delete(int id){
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

    
    
}
