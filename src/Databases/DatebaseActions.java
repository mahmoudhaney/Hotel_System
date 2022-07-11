package Databases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DatebaseActions {
    public static void setData(String Query, String msg){
        Connection connection = null;
        Statement statement = null;
        try{
            connection = (Connection) ConnectionProvider.getCon();
            statement = connection.createStatement();
            statement.executeUpdate(Query);
            if(!msg.equals(""))
                JOptionPane.showMessageDialog(null, msg);
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

            }
        }
    }
    
    public static ResultSet getDate(String query){
        Connection connection = null;
        Statement statement = null;
        ResultSet rsultSet = null;
        
        try{
            connection = ConnectionProvider.getCon();
            statement = connection.createStatement();
            rsultSet = statement.executeQuery(query);
            return rsultSet;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}
