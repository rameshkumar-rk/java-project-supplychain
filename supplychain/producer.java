package supplychain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.*;

/**
 *
 * @author Home
 */
public class producer {
    Scanner sc=new Scanner(System.in);
    
    void adddetails_p(){
        try{
        System.out.println("Enter the P_id");
        String p_id=sc.next();
        System.out.println("Enter the quantity");
        int quantity=sc.nextInt();
        System.out.println("Enter the quality in terms of grade");
        String quality=sc.next();
        System.out.println("Enter the date_entered");
        String date_entered=sc.next();
        System.out.println("Enter the date_exited");
        String date_exited=sc.next();
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/phpmyadmin","root","");  
        String status="yes";
        String  sql="insert into producer values('"+p_id+"','"+quantity+"','"+quality+"','"+date_entered+"','"+date_exited+"','"+status+"')";
        Statement stmt=con.createStatement();
       stmt.executeUpdate(sql);  
        }
        catch(Exception e){
            System.out.println(e);
        }
        
    }
    void validate_details_p(){
        try{
        System.out.println("enter the LEVEL_ID you want to verify");
        String tl_id=sc.next();
         System.out.println("enter the PRODUCT_ID you want to verify");
        String p_id=sc.next();
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/phpmyadmin","root","");  
        String  sql="select * from intermediate_auth where level_id='"+tl_id+"'";
        Statement stmt=con.createStatement();
       ResultSet rs1= stmt.executeQuery(sql);
       while(rs1.next())
        {
            System.out.println("LEVEL-ID:"+rs1.getString("level_id"));
            System.out.println("QUANTITY:"+rs1.getString("quantity"));
            System.out.println("QUALITY:"+rs1.getString("quality"));
            System.out.println("RETENTION-PERIOD:"+rs1.getString("retention_period"));
            System.out.println("DATE-ENTERED:"+rs1.getString("date_entered"));
            
            System.out.println("DATE-EXITED:"+rs1.getString("date_exited"));
            System.out.println("STATUS:"+rs1.getString("status"));
            System.out.println("PRODUCT-ID:"+rs1.getString("p_id"));
            System.out.println("PURPOSE:"+rs1.getString("purpose"));
           }
    System.out.println("enter\n1-if the above information is correct\n2-if not");
    int val=sc.nextInt();
    String no="no",yes="yes";
    String r="null";
    if(val==2){
            Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/phpmyadmin","root","");
            String sql1="update phpmyadmin.intermediate_auth set status='"+no+"' where level_id='"+tl_id+"' ";
            Statement stmt1=con1.createStatement();
            stmt1.executeUpdate(sql1);
             
            }
    else
    {
     Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/phpmyadmin","root","");
           String sql1="insert into block values('"+p_id+"','"+tl_id+"','"+yes+"','"+r+"')";
             Statement stmt1=con1.createStatement();
             stmt1.executeUpdate(sql1);
                
    }

        }
        catch(Exception e){
            System.out.println(e);
        }
        
    }
}


