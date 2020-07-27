/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supplychain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author Home
 */
public class block {
    Scanner sc=new Scanner(System.in);
    void report(){
        try{
        System.out.println("Enter the product id you want to report");
        String tp_id=sc.next();
        String rep;
        System.out.println("Enter the report");
        rep=sc.next();
        String sql="update phpmyadmin.block set report='"+rep+"' where p_id='"+tp_id+"' ";
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/phpmyadmin","root","");
        Statement stmt=con.createStatement();
         stmt.executeUpdate(sql);
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        }
}
