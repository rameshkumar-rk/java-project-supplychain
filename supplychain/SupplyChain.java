/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supplychain;

import java.util.Scanner;

/**
 *
 * @author Home
 */
public class SupplyChain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Login l=new Login();
        block b=new block();
        consumer c=new consumer();
        Government_officials g=new Government_officials();
        producer p=new producer();
        intermediate_auth i=new intermediate_auth();
        block bl=new block();
       System.out.println("\t\tWelcome To Smart Subsidy System....");
        Scanner sc=new Scanner(System.in);
    System.out.println("Enter\n1-Producer\n2-customer\n3-intermediate_authority\n4-government_officials\n5-exit\n6-New Account");
    int ch=sc.nextInt();
    switch(ch){
        case 1:
           l.loginas("1");
           
            System.out.println("Enter\n1-Add details\n2-Validate details\n3-Exit");
            int ch1=sc.nextInt();
            switch(ch1){
                case 1:
                    p.adddetails_p();
                    break;
                case 2:
                    p.validate_details_p();
                    break;
                case 3:
                    System.exit(-1);
            }
            break;
           
        case 2:
            l.loginas("2");
             System.out.println("Enter\n1-Track\n2-Report\n 3-Exit");
            int ch5=sc.nextInt();
            switch(ch5){
                case 1:
                   c.track();
                  break;
                case 2:
                    bl.report();
                    break;
                case 3:
                    System.exit(-1);
            }
            break;
        case 3:
            l.loginas("3");
            System.out.println("Enter\n1-Add details\n 2-Validate details\n3-Exit");
            int ch3=sc.nextInt();
            switch(ch3){
                case 1:
                    i.adddetails_i();
                    break;
                case 2:
                    i.validate_details_i();
                    break;
                case 3:
                    System.exit(-1);
            }
            break;
        case 4:
            l.loginas("4");
            System.out.println("Enter\n1-Add details\n 2-Validate details\n3-Exit");
            int ch4=sc.nextInt();
            switch(ch4){
                case 1:
                    g.adddetails_i();
                    break;
                case 2:
                    g.validate_details_g();
                    break;
                case 3:
                    System.exit(-1);
            }
            break;
            
        case 5:
            System.exit(-1);
        case 6:
            l.newl();
            
    }
    }
    
}
