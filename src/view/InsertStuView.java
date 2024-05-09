package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import service.StuManage;

public class InsertStuView extends JFrame {
    JLabel labelname=new JLabel("请输入您的姓名");
    JLabel labelgender=new JLabel("请输入您的性别");
    JLabel labelid=new JLabel("请输入您的学号");
    JTextField textname=new JTextField(15);
    JTextField textgender=new JTextField(15);
    JTextField textid=new JTextField(15);
    JButton confirm=new JButton("确定");
    JButton cancel=new JButton("取消");
    JPanel p1=new JPanel();
    JPanel p2=new JPanel();
    JPanel p3=new JPanel();
    JPanel p4=new JPanel();
    public InsertStuView(){
        this.setSize(500,300);
        this.setTitle("请添加学生信息");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(4,1,10,10));

        p1.add(labelname);
        p1.add(textname);
        p2.add(labelgender);
        p2.add(textgender);
        p3.add(labelid);
        p3.add(textid);
        p4.add(confirm);
        p4.add(cancel);

        this.add(p1);
        this.add(p2);
        this.add(p3);
        this.add(p4);
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    StuManage.insertStudata(textname.getText(),textgender.getText(),textid.getText());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,"添加失败","警告",JOptionPane.WARNING_MESSAGE);
                }
                dispose();
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
