package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.beans.binding.ObjectExpression;
import utils.Utils;

import javax.swing.table.DefaultTableModel;

public class ClassManage {
    public static void insertclass(String id,String subject,int score,String teacher)throws Exception{
        Connection connection=Utils.getConnection();
        String sql="insert into classes(class_id,subject,score,teacher) values(?,?,?,?)";
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        preparedStatement.setString(1,id);
        preparedStatement.setString(2,subject);
        preparedStatement.setInt(3,score);
        preparedStatement.setString(4,teacher);
        int i =preparedStatement.executeUpdate();
        Utils.Close(preparedStatement,connection);
    }
    public static void updateclass(String id,String subject,int score)throws Exception{
        Connection connection=Utils.getConnection();
        String sql="update classes set score=? where class_id=(select stu_num from stu where id=?) and subject=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setInt(1,score);
        preparedStatement.setString(2,id);
        preparedStatement.setString(3,subject);
        int i=preparedStatement.executeUpdate();
        Utils.Close(preparedStatement,connection);
    }
    public static void deleteclass(String id,String subject)throws Exception{
        Connection connection=Utils.getConnection();
        String sql="DELETE FROM classes WHERE class_id = (SELECT stu_num FROM stu WHERE id = ?) AND subject = ?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,id);
        preparedStatement.setString(2,subject);
        int i=preparedStatement.executeUpdate();
        Utils.Close(preparedStatement,connection);
    }
    public static void querystu(String id, DefaultTableModel stumodel,DefaultTableModel scoremodel)throws Exception{
        Connection connection=Utils.getConnection();
        String sql="select name,gender,id from stu where id=?";
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        preparedStatement.setString(1,id);
        ResultSet rs=preparedStatement.executeQuery();
        while(rs.next()){
            String stu_name=rs.getString("name");
            String stu_gender=rs.getString("gender");
            String stu_id=rs.getString("id");
            stumodel.addRow(new Object[]{stu_name,stu_gender,stu_id});
        }

        String queryscoresql="select subject,score,teacher from classes where class_id=(select stu_num from stu where id=?)";
        PreparedStatement preparedStatement1=connection.prepareStatement(queryscoresql);
        preparedStatement1.setString(1,id);
        ResultSet rs1=preparedStatement1.executeQuery();
        while(rs1.next()){
            String subject=rs1.getString("subject");
            int score=rs1.getInt("score");
            String teacher=rs1.getString("teacher");
            scoremodel.addRow(new Object[]{subject,score,teacher});
        }
        Utils.Close(rs,preparedStatement,connection);
    }
    public static void queryall(DefaultTableModel model)throws Exception{
        Connection connection=Utils.getConnection();
        Statement statement= connection.createStatement();
        String sql="select stu.name,stu.gender,stu.id,classes.subject,classes.score from stu left join classes on stu.stu_num=classes.class_id";
        ResultSet rs=statement.executeQuery(sql);
        while(rs.next()){
            String name=rs.getString("name");
            String gender=rs.getString("gender");
            String id=rs.getString("id");
            String subject=rs.getString("subject");
            Object score=rs.getObject("score");
            if(score==null){
                model.addRow(new Object[]{name,gender,id,subject,""});
            }
            model.addRow(new Object[]{name,gender,id,subject,score});
        }
        Utils.Close(statement,connection);
    }
}
