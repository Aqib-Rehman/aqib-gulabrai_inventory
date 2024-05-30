package project;

 
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class ItemSelector extends JFrame {
    private JList itemList;
    private DefaultListModel listModel;
    private JButton selectButton;
        private JComboBox mainComboBox;
    private JFrame mainFrame;
    private UserAccountRecord uar;

    public ItemSelector(JFrame mainFrame, JComboBox mainComboBox, int flag, UserAccountRecord uar) {
         this.mainFrame = mainFrame;
        this.mainComboBox = mainComboBox;
        this.uar = uar;
        setTitle("Record Selector");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        initializeUI();
        
         Toolkit kit=this.getToolkit();
    Dimension d=kit.getScreenSize();
    this.setBounds(0,0,d.width,d.height);
        
        loadDataFromDatabase(flag);
        
        
      int itemCount = mainComboBox.getItemCount();
//        Object[] items = new Object[itemCount];
         Set comboBoxItemSet = new HashSet();
        for (int i = 0; i < itemCount; i++) {
//            items[i] = mainComboBox.getItemAt(i);
            if(flag==1){
                CustomerRecord cr = (CustomerRecord) mainComboBox.getItemAt(i);
            comboBoxItemSet.add(cr.name);
            }
           else if(flag==2){
                ProductRecord pr = (ProductRecord) mainComboBox.getItemAt(i);
            comboBoxItemSet.add(pr.name);
            }
        }
        
         
        
        int[] indicesToSelect = listModelToSelectIndices(comboBoxItemSet);
            itemList.setSelectedIndices(indicesToSelect);
      
    }
    
    
     private int[] listModelToSelectIndices(Set selectedItems) {
       Vector indices = new Vector();
        for (int i = 0; i < listModel.getSize(); i++) {
            if (selectedItems.contains(listModel.getElementAt(i).toString())) {
                indices.add(new Integer(i));
            }
        }
        
        int[] indicesArray = new int[indices.size()];
        for (int i = 0; i < indices.size(); i++) {
            indicesArray[i] = ((Integer)indices.get(i)).intValue();
        }
        return indicesArray;
    }
     

    private void initializeUI() {
        listModel = new DefaultListModel();
        itemList = new JList(listModel);
        itemList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane scrollPane = new JScrollPane(itemList);

        
        selectButton = new JButton("Select");
        selectButton.addActionListener(new ActionListener() {
         
            public void actionPerformed(ActionEvent e) {
                Object[] selectedItems = itemList.getSelectedValues();
                StringBuffer  sb = new StringBuffer ("Selected items: ");
                for (int i = 0; i < selectedItems.length; i++) {
                    sb.append(selectedItems[i]);
                    if (i < selectedItems.length - 1) {
                        sb.append(",");
                    }
                }
//                JOptionPane.showMessageDialog(null, sb.toString());
                
                mainComboBox.removeAllItems(); // Clear existing items in the combo box
                for (int i = 0; i < selectedItems.length; i++) {
                    mainComboBox.addItem(selectedItems[i]);
                }
//                mainFrame.setVisible(true);
                ItemSelector.this.dispose(); // Close the ItemSelector frame
           
                
//                setVisible(false);
//                new UsersManagement().setProducts(selectedItems);
            }
        });

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(selectButton, BorderLayout.SOUTH);

        getContentPane().add(panel);
    }
    
    

    private void loadDataFromDatabase(int flag) {     
        try {
            
            if(flag==1){
                
//                     java.util.Vector v=DatabaseManager.getAllCustomers(ua);
                     java.util.Vector v=DatabaseManager.getCustomers(uar);
                   for (int i=0;i<v.size();i++) {
//                String itemName = v.get(i).toString();
                listModel.addElement(v.get(i));
            }
                   
            }
            else if (flag==2){
                   java.util.Vector v=DatabaseManager.getProduct(uar);
                   for (int i=0;i<v.size();i++) {
//                String itemName = v.get(i).toString();
                listModel.addElement(v.get(i));
            }
            }
        
        } catch (Exception ex) {
            ex.printStackTrace();
        }  
    }
    
    
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            
            public void run() {
//                new ItemSelector().setVisible(true);
            }
        });
    }
}
