/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loffer_shop;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Master
 */
public class DBConnection {
    
    public static Connection connect()
    {
        Connection conn=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory?", "root","");
            //JOptionPane.showMessageDialog(null,"Connection Success");
            } 
        catch (Exception e){
            JOptionPane.showMessageDialog(null,e);
        }return conn;
    } 
}
