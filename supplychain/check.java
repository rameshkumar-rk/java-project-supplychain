/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supplychain;

/**
 *
 * @author Home
 */
public class check {
    int check_productid(String t){
       String p="^p_.{3}$";
        int s;
        if(t.matches(p))
            s=1;
        else
            s=0;
        
        return s;
    }
    int check_consumerid(String t){
       String p="^c_.{3}$";
        int s;
        if(t.matches(p))
            s=1;
        else
            s=0;
        
        return s;
    }
    int check_intermediate_authid(String t){
       String p="^i_.{3}$";
        int s;
        if(t.matches(p))
            s=1;
        else
            s=0;
        
        return s;
    }
}
