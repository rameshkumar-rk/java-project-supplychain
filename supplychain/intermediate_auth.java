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
public class intermediate_auth {
    Scanner sc=new Scanner(System.in);
    
    void adddetails_i(){
        try{
        System.out.println("Enter the level_id");
        String level_id=sc.next();
         System.out.println("Enter the producer_id");
        String p_id=sc.next();
         System.out.println("Enter the Purpose");
        String purpose=sc.next();
        System.out.println("Enter the quantity");
        int quantity=sc.nextInt();
        System.out.println("Enter the quality in terms of grade");
        String quality=sc.next();
         System.out.println("Enter the retention period");
        int retention_period=sc.nextInt();
        System.out.println("Enter the date_entered");
        String date_entered=sc.next();
        System.out.println("Enter the date_exited");
        String date_exited=sc.next();
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/phpmyadmin","root","");  
        String status="yes";
        String  sql="insert into intermediate_auth values('"+level_id+"','"+quantity+"','"+quality+"','"+retention_period+"','"+date_entered+"','"+date_exited+"','"+status+"','"+p_id+"','"+purpose+"')";
        Statement stmt=con.createStatement();
       stmt.executeUpdate(sql);  
        }
        catch(Exception e){
            System.out.println(e);
        }
        
    }
    void validate_details_i(){
      try{
        System.out.println("Enter the level_id you want to verify");
        String tl_id=sc.next();
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
    System.out.println("Enter\n1-if the above information is CORRECT and\n2- if NOT");
    int val=sc.nextInt();
    String no="no";
    if(val==2){
            Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/phpmyadmin","root","");
           String sql1="update phpmyadmin.intermediate_auth set status='"+no+"' where level_id='"+tl_id+"' ";
             Statement stmt1=con1.createStatement();
             stmt1.executeUpdate(sql1);
             
            }

        }
        catch(Exception e){
            System.out.println(e);
        }
        
    }  
    }
    
    



