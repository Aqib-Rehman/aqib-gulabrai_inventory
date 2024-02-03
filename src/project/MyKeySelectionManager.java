package project;
import javax.swing.*;

/**
 * Title:        Database for Industrial Management
 * Description:  The designed system solve all major problems of existing system.
 * Copyright:    Copyright (c) 2014
 * @author Jay Kumar
 * @version 2.0
 */

public class MyKeySelectionManager implements JComboBox.KeySelectionManager{

    long lastKeyTime=0;
    String pattern="";

    public int selectionForKey(char key,ComboBoxModel model){

    //find index of selected item

    int index=1;

    Object item=model.getSelectedItem();

    if(item!=null){

      for(int i=0; i<model.getSize(); i++){
       if(item.equals(model.getElementAt(i) ) ){

       index=i;
       break;
       }//end if

    }//end loop

 }//end outer if


 //get the current time
  long currentTime=System.currentTimeMillis();


 //get the last key type less 300 ms, append to current pattern
 if(currentTime-lastKeyTime <300){
    pattern+=(""+key).toLowerCase();
 }
else{
      pattern=(""+key).toLowerCase();
      char ch=pattern.charAt(0);

      if(ch==27)return 0;

}//end else


//save current time

lastKeyTime=currentTime;

//search forward for current selection


for(int i=index+1; i<model.getSize(); i++){

String s=model.getElementAt(i).toString().toLowerCase();

if(s.startsWith(pattern)){
 return i;
}

}//end for llop

//search from top to current selection

for(int i=0; i<index; i++){

  if(model.getElementAt(i)!=null){
     String s=model.getElementAt(i).toString().toLowerCase();
     if(s.startsWith(pattern) ){
     return i;
     }
  }//end if

}//end for loop

return -1;

}//end method

}//end inner class
