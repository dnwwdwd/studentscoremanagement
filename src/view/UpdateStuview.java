package view;
import service.StuManage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateStuview extends JFrame{
    JLabel labeloldid=new JLabel("请输入您要修改学生的学号");
    JLabel labelname=new JLabel("请输入您要修改后的姓名");
    JLabel labelgender=new JLabel("请输入您要修改后的性别");
    JLabel labelid=new JLabel("请输入您要修改后的学号");
    JTextField textFieldoldid=new JTextField(15);
    JTextField textname=new JTextField(15);
    JTextField textgender=new JTextField(15);
    JTextField textid=new JTextField(15);
    JButton confirm=new JButton("确定");
    JButton cancel=new JButton("取消");
    JPanel p1=new JPanel();
    JPanel p2=new JPanel();
    JPanel p3=new JPanel();
    JPanel p4=new JPanel();
    JPanel p5=new JPanel();
    public UpdateStuview(){
        this.setSize(500,300);
        this.setTitle("请修改学生信息");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(5,1,10,10));
        p1.add(labeloldid);
        p1.add(textFieldoldid);
        p2.add(labelname);
        p2.add(textname);
        p3.add(labelgender);
        p3.add(textgender);
        p4.add(labelid);
        p4.add(textid);
        p5.add(confirm);
        p5.add(cancel);

        this.add(p1);
        this.add(p2);
        this.add(p3);
        this.add(p4);
        this.add(p5);
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    StuManage.updateStudata(textname.getText(),textgender.getText(),textid.getText(),textFieldoldid.getText());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,"修改失败","警告",JOptionPane.WARNING_MESSAGE);
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
