/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package browser;
import java.sql.*;
import javax.swing.DefaultListModel;
/**
 *
 * @author hp
 */
public class SqlOpreations {
    public static String sql;
    private static String grade;
    private static String classroom;
    // JDBC 驱动名及数据库 URL
  
   public static final String DB_URL = "jdbc:mysql://98.159.99.176:3306/a0329115325";
 public static final String Driver="com.mysql.jdbc.Driver";
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "a0329115325";
    static final String PASS = "20010709Hoxha";
 
    public static void Connect(){
        Connection conn = null;
        Statement stmt = null;
        try{
            // 注册 JDBC 驱动
            Class.forName("com.mysql.jdbc.Driver");
        
            // 打开链接
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            // 执行查询
            stmt = conn.createStatement();
            grade=Start.jComboBox1.getSelectedItem().toString();
            classroom=Start.jComboBox2.getSelectedItem().toString();
            //这里可以有一个switch语句
                    
                    String temp=grade+classroom;
                    
                    sql = "SELECT id, Subject, Teacher FROM eval_10 WHERE Class=" + temp;
               
            //sql=
            ResultSet rs = stmt.executeQuery(sql);
            DefaultListModel dlm=new DefaultListModel();
            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                int id  = rs.getInt("id");
                String subject = rs.getString("Subject");
                String teacher = rs.getString("Teacher");
    
                // 输出数据
                
                dlm.addElement(grade+subject+"_"+teacher);
                
            }
            Start.jList1.setModel(dlm);
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        
    }
    public static void getQuerys(){
        {
        Connection conn = null;
        Statement stmt = null;
        try{
            // 注册 JDBC 驱动
            Class.forName("com.mysql.jdbc.Driver");
        
            // 打开链接
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            // 执行查询
            stmt = conn.createStatement();
            
           
                    sql = "SELECT id, Item, Question FROM query";
            //sql=
            ResultSet rs = stmt.executeQuery(sql);
            DefaultListModel dlm=new DefaultListModel();
            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                
                int id  = rs.getInt("id");
                switch(id){
                    case 1:
                        NewJFrame.lblText1.setText(rs.getString("Item")+rs.getString("Question"));  //给不同label赋值
                    case 2:
                        NewJFrame.lblText2.setText(rs.getString("Item")+rs.getString("Question"));  //给不同label赋值
                    case 3:
                        NewJFrame.lblText3.setText(rs.getString("Item")+rs.getString("Question"));  //给不同label赋值
                    case 4:
                        NewJFrame.lblText4.setText(rs.getString("Item")+rs.getString("Question"));  //给不同label赋值
                    case 5:
                        NewJFrame.lblText5.setText(rs.getString("Item")+rs.getString("Question"));  //给不同label赋值
                    case 6:
                        NewJFrame.lblText6.setText(rs.getString("Item")+rs.getString("Question"));  //给不同label赋值
                    case 7:
                        NewJFrame.lblText7.setText(rs.getString("Item")+rs.getString("Question"));  //给不同label赋值
                    case 8:
                        NewJFrame.lblText8.setText(rs.getString("Item")+rs.getString("Question"));  //给不同label赋值
                    case 9:
                        NewJFrame.lblText9.setText(rs.getString("Item")+rs.getString("Question"));  //给不同label赋值
                    case 10:
                        NewJFrame.lblText10.setText(rs.getString("Item")+rs.getString("Question"));  //给不同label赋值
                }
                
    
                // 输出数据
                
                
                
            }
            
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        
    }
    }
    public static void SubmitScore2(){
        String good=NewJFrame1.lblComm1.getText();
        String baad=NewJFrame1.lblComm2.getText();
        
        int midString=good.indexOf("_");
        String subjectString=good.substring(2,midString);
        String teacherString=good.substring(midString+1);
       
        Connection conn=null;
        Statement stmt=null;
                try{
            // 注册 JDBC 驱动
            Class.forName("com.mysql.jdbc.Driver");
        
            // 打开链接
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            // 执行查询
             sql = "SELECT * FROM eval_txt";
            PreparedStatement pstmt=conn.prepareStatement(sql);
            
            
               
            sql="insert into eval_txt(Teacher,Item,Reason,Subject) values(?,?,?,?)";  
            pstmt=conn.prepareStatement(sql);
           pstmt.setString(1, teacherString);
            pstmt.setString(2, "good");   //一会再添加个分数
            pstmt.setString(3, NewJFrame1.txtEval.getText());
            pstmt.setString(4, subjectString);
            
           int res=pstmt.executeUpdate();
        
            midString=baad.indexOf("_");
            subjectString=baad.substring(2,midString);
            teacherString=baad.substring(midString+1);
            sql="insert into eval_txt(Teacher,Item,Reason,Subject) values(?,?,?,?)";  
            pstmt=conn.prepareStatement(sql);
           pstmt.setString(1, teacherString);
            pstmt.setString(2, "baad");   //一会再添加个分数
            pstmt.setString(3, NewJFrame1.txtEval1.getText());
            pstmt.setString(4, subjectString);
           res= pstmt.executeUpdate();
            sql="insert into eval_txt(Teacher,Item,Reason,Subject) values(?,?,?,?)";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, "School");
            pstmt.setString(2, "Comments");
            pstmt.setString(3,NewJFrame1.txtEval2.getText());
            pstmt.setString(4,"Comments");
           res= pstmt.executeUpdate();
            
            pstmt.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }
        
    
    public static void SubmitScore(){
        {
        
            Events.addLater();
            //System.out.println(NewJFrame.lblEvaluate.get(0).toString());
            String gradeString=Start.value1.substring(0,2);
            int midString=Start.value1.indexOf("_");
            String subjectString=Start.value1.substring(2,midString);
            String teacherString=Start.value1.substring(midString+1);
            int population=1;
        Connection conn = null;
        Statement stmt = null;
        
        try{
            // 注册 JDBC 驱动
            Class.forName("com.mysql.jdbc.Driver");
        
            // 打开链接
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            // 执行查询
            
            PreparedStatement pstmt=conn.prepareStatement(sql);
            for(int i=0;i<10;i++){     
            String tempsql=" Subject = '"+subjectString+"' and Teacher = '"+teacherString+"' and Grade = "+gradeString+" and Item = '"+NewJFrame.lblEvaluate.get(i) + "'";
            sql="select * from eval_new where "+tempsql;    //加单引号！！1
            
            pstmt=conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                int originalscore=rs.getInt("Score");
                int originalpopulation=rs.getInt("Population");
                int finalscore=originalscore+NewJFrame.evalScore.get(i);
                int finalpopulation=originalpopulation+1;
                sql="update eval_new set Score="+finalscore+",Population="+finalpopulation+" where "+tempsql;
                System.out.println(sql);
                pstmt=conn.prepareStatement(sql);
                pstmt.executeUpdate();
            }
            else{
               
            sql="insert into eval_new(Subject,Item,Score,Population,Grade,Teacher) values(?,?,?,?,?,?)";  
            pstmt=conn.prepareStatement(sql);
           pstmt.setString(1, subjectString);
            pstmt.setString(2, NewJFrame.lblEvaluate.get(i));   //一会再添加个分数
            pstmt.setInt(3, NewJFrame.evalScore.get(i));
            pstmt.setInt(4, population);
            pstmt.setString(5, gradeString);
            pstmt.setString(6, teacherString);
            int res=pstmt.executeUpdate();
            }
            }
            // 展开结果集数据库
            NewJFrame.lblEvaluate.clear();
            NewJFrame.evalScore.clear();
            
            // 完成后关闭
            
            pstmt.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }
    }
    }
    

    

