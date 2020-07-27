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
import java.sql.PreparedStatement;
import java.util.Scanner;

/**
 *
 * @author Home
 */
public class Login {
    Scanner sc=new Scanner(System.in);
    public void newl()
    {
        try{
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/phpmyadmin","root","");  
        String u1="",p1="",ch1="";
        System.out.println("Enter the USERNAME:");
        u1=sc.next();
        System.out.println("Enter the PASSWORD");
        p1=sc.next();
         System.out.println("Enter the TYPE");
        ch1=sc.next();
        String sqll="insert into login values('"+u1+"','"+p1+"','"+ch1+"')";
        Statement stmt=con.createStatement();
       stmt.executeUpdate(sqll); }
        catch(Exception e )
        {
            System.out.println(e);
            
        }
    }
   
    public void loginas(String ch)
    {
 PreparedStatement pst = null;
  ResultSet rs = null;    
  
        try{
        String u,p;
         int r;
        System.out.println("Enter the username:");
        u=sc.next();
        System.out.println("Enter the password");
        p=sc.next();
      Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/phpmyadmin","root","");
      String  sql="select user,pass from login where user='"+u+ "' and pass='"+p+"' and ch='"+ch+"'";
       /*String  sql="select * from login where user=? and pass=? and ch=?";
         
            pst = con.prepareStatement(sql);
            pst.setString(1, "'%"+u+"%'");
            pst.setString(2, "'%"+p+"%'");
            pst.setString(3, "'%"+ch+"%'");
            rs = pst.executeQuery(); */
      Statement stmt=con.createStatement();
        ResultSet rs1=stmt.executeQuery(sql);
       
         
         if(rs1.next()){
                        
               System.out.println("Login Success");
         
         }
            else{
                System.out.println("Login Failed"); 
             //return 0;
          
               System.exit(-1);
            }

        }
    catch(Exception e)
    {
        System.out.println(e);
 
   }
       
}
}
