/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HealthCare;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class koneksi {
    private static Connection mysqlkonek;
    public static Connection koneksiDB() throws SQLException{
        if(mysqlkonek==null){
            try{
                String DB="jdbc:mysql://localhost:3306/dbhealthcare";
                String Username = "root";
                String Password = "";
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                mysqlkonek = (Connection) DriverManager.getConnection(DB,Username, Password);
                JOptionPane.showMessageDialog(null, "Connection Sucessfully");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Connection Failed");
            }
        }
        return mysqlkonek;
    }
}
