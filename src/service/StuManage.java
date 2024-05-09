package service;
import utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class StuManage {
    public static void insertStudata(String name,String gender,String id) throws Exception{
        Connection connection=Utils.getConnection();
        String sql="insert into stu(name,gender,id) values(?,?,?)";
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,gender);
        preparedStatement.setString(3,id);
        int i=preparedStatement.executeUpdate();
        Utils.Close(preparedStatement,connection);
    }
    public static void deleteStudata(String id)throws Exception{
        Connection connection=Utils.getConnection();
        String sql="delete from stu where id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,id);
        int i=preparedStatement.executeUpdate();
        Utils.Close(preparedStatement,connection);
    }
    public  static void updateStudata(String name,String gender,String id,String oldid)throws Exception{
        Connection connection=Utils.getConnection();
        String sql="update stu set name=?,gender=?,id=? where id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,gender);
        preparedStatement.setString(3,id);
        preparedStatement.setString(4,oldid);
        int i=preparedStatement.executeUpdate();
        Utils.Close(preparedStatement,connection);
    }
}
