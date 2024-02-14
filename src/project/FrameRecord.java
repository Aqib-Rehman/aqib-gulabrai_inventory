/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author Aqib Rehman
 */
public class FrameRecord {
        private String  label;
        private boolean isSelected = false;

        public FrameRecord(String label)
        {
            this.label = label;
        }
        public boolean isSelected()
        {
            return isSelected;
        } 
        public void setSelected(boolean isSelected)
        {
            this.isSelected = isSelected;
        }
        public String toString()
        {
            return label;
        }
    }
