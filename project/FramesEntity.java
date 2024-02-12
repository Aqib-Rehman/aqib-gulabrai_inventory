/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aqib Rehman
 */
public class FramesEntity {
    
  List  framesList;
  List framesDesc;
  List  framesIds;
 
  
  public FramesEntity(){ 
      framesList =  new ArrayList();
      framesList.add("CUSTOMER");
      framesList.add("CASH TRANSACTION");
      framesList.add("PRODUCT");
      framesList.add("PURCHASE BOOK");
      framesList.add("SALE BOOK");
      framesList.add("VOUCHER");      
      framesList.add("CASH BOOK");
      framesList.add("CR/DT BOOK");
      framesList.add("A/C PAY/REC");
      framesList.add("CASH REGISTER");
      framesList.add("AC CLOSING");
      framesList.add("PRINTING REPORTS");
      
       framesIds =  new ArrayList();
       for(int i=0;i<framesList.size();i++)
           framesIds.add(i+"");
  
   framesDesc =  new ArrayList();
  }
  
  public List getAllFrames(){
      return framesList;
  }
   public List getAllFramesIds(){
      return framesIds;
  }
   
    
    public String getFrameName(int id){
        return framesList.get(id).toString();
    }
    public String getDesc(int id){
        return framesDesc.get(id).toString();
    }
     public int getId(String value){
        return framesList.indexOf(value);
    }
}
