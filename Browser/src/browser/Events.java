/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package browser;
import static browser.NewJFrame.jList1;
import javax.swing.DefaultListModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author hp
 */
public class Events extends Start{
    public static ArrayList<String> values1=new ArrayList<String>();
    public int formWidth;
    public int formHeight;
    
    public Events(){
        
        super();
        
    }
    public static boolean Checker(String s){
    String[] bannedList={"fuck","shit"};    
        for(String i:bannedList){
            if(s.contains(i)){
                return true;
            }
        }
    return false;
    }
    public static void Submittion2(){
        SqlOpreations.SubmitScore2();
        JOptionPane.showMessageDialog(null, "您完成了！");
        System.exit(0);
    }
    public static void Initialization2(){
                  DefaultListModel dlm=new DefaultListModel();
          
          for(int i=0;i<values1.size();i++){
            String str=values1.get(i);
           
            dlm.addElement(str);
            }
            NewJFrame1.jList1.setModel(dlm);
            
            NewJFrame1.jList1.setSelectedIndex(0);
            NewJFrame1.lblComm1.setText(NewJFrame1.jList1.getSelectedValue().toString());
            NewJFrame1.lblComm2.setText(NewJFrame1.jList1.getSelectedValue().toString());
    }
    public static void ReChoose(){
        DefaultListModel dlm=new DefaultListModel();
        dlm.clear();
        jList1.setModel(dlm);
    }
    public static void showJPanel1(){
        values=Start.jList1.getSelectedValuesList();
        
               if (!(values.size()<3)){
                   for(String i:values){
                    values1.add(i);
                        }
                   judger=true;
               }else{
               JOptionPane.showMessageDialog(null, "请选择至少3个老师！"); 
               }
           
       }
    public static void addItem(){
        DefaultListModel dlm=new DefaultListModel();
        for(int i=0;i<values.size();i++){
            String str=values.get(i);
            
            dlm.addElement(str);
        }
            NewJFrame.jList1.setModel(dlm);
            
            
    }
    public static void addLater(){
        
        NewJFrame.lblEvaluate.add(NewJFrame.lblText1.getText().substring(0,1));
        NewJFrame.lblEvaluate.add(NewJFrame.lblText2.getText().substring(0,1));
        NewJFrame.lblEvaluate.add(NewJFrame.lblText3.getText().substring(0,1));
        NewJFrame.lblEvaluate.add(NewJFrame.lblText4.getText().substring(0,1));
        NewJFrame.lblEvaluate.add(NewJFrame.lblText5.getText().substring(0,1));
        NewJFrame.lblEvaluate.add(NewJFrame.lblText6.getText().substring(0,1));
        NewJFrame.lblEvaluate.add(NewJFrame.lblText7.getText().substring(0,1));
        NewJFrame.lblEvaluate.add(NewJFrame.lblText8.getText().substring(0,1));
        NewJFrame.lblEvaluate.add(NewJFrame.lblText9.getText().substring(0,1));
        NewJFrame.lblEvaluate.add(NewJFrame.lblText10.getText().substring(0,1));
        NewJFrame.evalScore.add(Integer.valueOf(NewJFrame.jComboBox1.getSelectedItem().toString()));
        NewJFrame.evalScore.add(Integer.valueOf(NewJFrame.jComboBox2.getSelectedItem().toString()));
        NewJFrame.evalScore.add(Integer.valueOf(NewJFrame.jComboBox3.getSelectedItem().toString()));
        NewJFrame.evalScore.add(Integer.valueOf(NewJFrame.jComboBox4.getSelectedItem().toString()));
        NewJFrame.evalScore.add(Integer.valueOf(NewJFrame.jComboBox5.getSelectedItem().toString()));
        NewJFrame.evalScore.add(Integer.valueOf(NewJFrame.jComboBox6.getSelectedItem().toString()));
        NewJFrame.evalScore.add(Integer.valueOf(NewJFrame.jComboBox7.getSelectedItem().toString()));
        NewJFrame.evalScore.add(Integer.valueOf(NewJFrame.jComboBox8.getSelectedItem().toString()));
        NewJFrame.evalScore.add(Integer.valueOf(NewJFrame.jComboBox9.getSelectedItem().toString()));
        NewJFrame.evalScore.add(Integer.valueOf(NewJFrame.jComboBox10.getSelectedItem().toString()));
        //最后来一个clear语句
    }
       public static void ChangeValue(){
           value1=NewJFrame.jList1.getSelectedValue().toString();
            NewJFrame.jLabel3.setText(value1);
       }
      public static void Initialization(){
          SqlOpreations.getQuerys();
          NewJFrame.jList1.setSelectedIndex(0);
          ChangeValue();
      }
      public static void Submittion(){
          value1=NewJFrame.jLabel3.getText();
          Events.addLater();
          
          if(!(value1.length()==0)){
              try{
          SqlOpreations.SubmitScore();
          values.remove(0);
          DefaultListModel dlm=new DefaultListModel();
          
            for(int i=0;i<values.size();i++){
            String str=values.get(i);
            
            dlm.addElement(str);
            }
            NewJFrame.jList1.setModel(dlm);
          NewJFrame.jList1.setSelectedIndex(0);
          ChangeValue();
          
              }catch(NullPointerException e){
                  JOptionPane.showMessageDialog(null, "您完成了！"); 
                  
              }
          }else{
             JOptionPane.showMessageDialog(null, "您完成了！"); 
            
            
          }
         
          
      }
    }
    
    

