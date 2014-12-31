/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xianzhi.testweb;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PingTest {
  public static void main(String args[])
     {
     String[] addrs= {"www.baidu.com"};
         if (addrs.length < 1)
         {
             System.out.println("syntax Error!");
         }
         else
         {
             for(int i=0;i<addrs.length;i++){
             String line = null;
             try
             {
                 Process pro = Runtime.getRuntime().exec("ping " + addrs[i]+" -l 1000 -n 4");
                 BufferedReader buf = new BufferedReader(new InputStreamReader(pro.getInputStream()));
                 while((line = buf.readLine()) != null){
                   
                      System.out.println(line);
                   
                    //System.out.println("your speed is:"+(1000/Integer.parseInt(value))+"KB");               
           
                 }        
             }
             catch(Exception ex)
             {
                 System.out.println(ex.getMessage());
             }
           }
         }
       }
 
}
