package OurClasses;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Service {
    private String number;
    private String name;
    private String price;
    private String status;
    final static String ServicePath = "D:\\Netbeans_Projects\\Hotel_System\\src\\OurFiles\\Services.txt";
    
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

    public static String getServicePath() {
        return ServicePath;
    }
    
    // ==================File Methods======================================
    public static void add(int serviceNo, String serviceName, float price, String serviceStatus){ //For Services
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
    
    public static String[] get(){
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
    
    public static void update(int checkedId, int serviceNo, String serviceName, float price, String serviceStatus){
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
    
    public static void delete(int id){
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
}
