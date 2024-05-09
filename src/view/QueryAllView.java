package view;

import service.ClassManage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class QueryAllView extends JFrame{
    JLabel text=new JLabel("学生信息查询");
    DefaultTableModel model=new DefaultTableModel();
    JTable queryall=new JTable(model);
    JScrollPane jScrollPane=new JScrollPane(queryall);
    JPanel p1=new JPanel();
    JPanel p2=new JPanel();

    public QueryAllView(){
        this.setTitle("学生成绩查询");
        this.setSize(1000,700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] columnname={"姓名","性别","学号","科目","分数"};
        model.setColumnIdentifiers(columnname);
        p1.add(text);
        p2.add(jScrollPane);

        this.add(p1);
        this.add(p2);
        try{
            ClassManage.queryall(model);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"查询失败","警告",JOptionPane.WARNING_MESSAGE);
        }
    }
}
