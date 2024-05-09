package view;

import service.ClassManage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QueryStuView extends JFrame {
    JLabel id=new JLabel("请输入学生的id");
    JTextField textid=new JTextField(15);
    JButton confirm=new JButton("确定");
    JButton cancel=new JButton("取消");
    JLabel labelstu=new JLabel("学生信息表");
    JLabel labelscore=new JLabel("成绩信息表");

    JPanel p1=new JPanel();
    JPanel p2=new JPanel();
    JPanel p3=new JPanel();
    JPanel p4=new JPanel();
    String[] stucolumnname={"姓名","性别","学号"};
    String[] scorecolumnname={"学科","分数","教师"};
public QueryStuView(){
    this.setLayout(new GridLayout(4,4,10,10));
    this.setTitle("学生信息查询");
    this.setSize(1000,700);

    DefaultTableModel stumodel=new DefaultTableModel();
    DefaultTableModel scoremodel=new DefaultTableModel();

    stumodel.setColumnIdentifiers(stucolumnname);
    scoremodel.setColumnIdentifiers(scorecolumnname);

    JTable stutable = new JTable(stumodel);
    JTable scoretable=new JTable(scoremodel);
    JScrollPane scrollstu=new JScrollPane(stutable);
    JScrollPane scrollscore=new JScrollPane(scoretable);

    p1.setBorder(BorderFactory.createEmptyBorder(70,0,0,0));
    p1.add(id);
    p1.add(textid);
    p2.add(confirm);
    p2.add(cancel);
    p3.add(labelstu);
    p3.add(scrollstu);
    p4.add(labelscore);
    p4.add(scrollscore);

    this.add(p1);
    this.add(p2);
    this.add(p3);
    this.add(p4);

    confirm.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                stumodel.setRowCount(0);
                scoremodel.setRowCount(0);
                ClassManage.querystu(textid.getText(),stumodel,scoremodel);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,"查找失败","警告",JOptionPane.WARNING_MESSAGE);
            }
        }
    });
    cancel.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    });
    }
}
