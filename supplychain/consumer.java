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

public class consumer {
    Scanner sc=new Scanner(System.in);
    public void track()
    {
       try{
        String p;
        System.out.println("Enter the P_id to track:");
        p=sc.next();
        
        //int i=check_productid(p);
        //if(i==0)
        //    System.out.println("invalid input");
        //else
          //  System.out.println("valid input");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/phpmyadmin","root","");  
        String  sql="select * from block where p_id='"+p+"'";
        Statement stmt=con.createStatement();
          ResultSet rs1= stmt.executeQuery(sql);
          String tp_id="";
       while(rs1.next())
        {
            tp_id=rs1.getString("p_id");
        }   
        if(tp_id!="") {
        System.out.println("Valid Product id..");
        Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/phpmyadmin","root","");  
        String  sql1="select * from producer where p_id='"+p+"'";
        Statement stmt1=con1.createStatement();
          ResultSet rs2= stmt1.executeQuery(sql1);
          System.out.println("\nThe details entered by the producers are!!!:\n");
          while(rs2.next()){
              System.out.println("PRODUCT-ID:"+rs2.getString("p_id"));
              System.out.println("Quantity:"+rs2.getString("quantity"));
              System.out.println("Quality:"+rs2.getString("quality"));
              System.out.println("Date_entered:"+rs2.getString("date_entered"));
              System.out.println("Date_exited:"+rs2.getString("date_exited"));
              System.out.println("Status:"+rs2.getString("status"));
                            }
          
         Connection con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/phpmyadmin","root","");  
        String  sql2="select * from intermediate_auth where p_id='"+p+"'";
        Statement stmt2=con2.createStatement();
        //  System.out.println("The details entered by the Intermediate authorities are:");
          ResultSet rs3= stmt2.executeQuery(sql2);
        
          if(rs3.next()){
               System.out.println("LEVEL-ID:"+rs1.getString("level_id"));
             
             
             System.out.println("QUANTITY:"+rs3.getString("quantity"));
              System.out.println("QUALITY:"+rs3.getString("quality"));
              System.out.println("DATE-ENTERED:"+rs3.getString("date_entered"));
              System.out.println("DATE EXITED:"+rs3.getString("date_exited"));
              System.out.println("STATUS:"+rs3.getString("status"));
               System.out.println("PRODUCT-ID:"+rs3.getString("p_id"));
              System.out.println("RETENTION PERIOD:"+rs3.getString("retention_period"));
              
              System.out.println("PURPOSE:"+rs3.getString("purpose"));
              
                            }
                        }
        else{
        System.out.println("Entered product id  is INVALID");
        }
            
            

        

        }
       
       catch(Exception e)
       {
           
       }
    }
    
}
