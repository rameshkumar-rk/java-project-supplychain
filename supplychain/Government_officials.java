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
public class Government_officials {
    Scanner sc=new Scanner(System.in);
    
    void adddetails_i(){
        try{
        System.out.println("Enter the GOVERNMENT-ID");
        String gov_id=sc.next();
         System.out.println("Enter the RANK");
        String r=sc.next();
         System.out.println("Enter PRODUCT ID");
        String p_id=sc.next();
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/phpmyadmin","root","");  
        String status="yes";
        String  sql="insert into gov values('"+gov_id+"','"+r+"','"+p_id+"','"+status+"')";
        Statement stmt=con.createStatement();
       stmt.executeUpdate(sql);  
        }
        catch(Exception e){
            System.out.println(e);
        }
        
}
    void validate_details_g(){
        try{
        System.out.println("enter the LEVEL-ID you want to verify");
        String tl_id=sc.next();
         System.out.println("enter the PRODUCT-ID you want to verify");
        String p_id=sc.next();
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/phpmyadmin","root","");  
        String  sql="select * from producer where p_id='"+p_id+"'";
        Statement stmt=con.createStatement();
       
        


        ResultSet rs1= stmt.executeQuery(sql);
while(rs1.next())
        {
            System.out.println("PRODUCT_ID:"+rs1.getString("p_id"));
            
           
            
            System.out.println("QUANTITY"+rs1.getString("quantity"));
            
            System.out.println("QUALITY"+rs1.getString("quality"));
            System.out.println("DATE-ENTERED"+rs1.getString("date_entered"));
            
            System.out.println("DATE-EXITED"+rs1.getString("date_exited"));
            System.out.println("STATUS"+rs1.getString("status"));
        }
    System.out.println("enter\n1-If the above information is CORRECT\n2- if NOT");
    int val=sc.nextInt();
    String no="no";
    if(val==2){
            Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/phpmyadmin","root","");
           String sql1="update phpmyadmin.producer set status='"+no+"' where p_id='"+p_id+"' ";
             Statement stmt1=con1.createStatement();
             stmt1.executeUpdate(sql1);
             
            }
   

        }
        catch(Exception e){
            System.out.println(e);
        }
        
    }
}
