/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.sql.Timestamp;

/**
 *
 * @author Aqib Rehman
 */
public class Test {
    public static void main(String args[]){
         Timestamp ts =  new Timestamp(new java.util.Date().getTime());
        System.out.println(ts);
    }
}
