package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import service.ClassManage;

public class InsertClassView extends JFrame{
    JLabel id=new JLabel("请输入要添加的num");
    JLabel subject=new JLabel("请输入要添加课程名");
    JLabel score =new JLabel("请输入该课程的分数");
    JLabel teacher=new JLabel("请输入该课程的老师");
    JTextField textid=new JTextField(15);
    JTextField textsubject=new JTextField(15);
    JTextField textscore=new JTextField(15);
    JTextField textteacher=new JTextField(15);
    JButton confirm=new JButton("确定");
    JButton cancel=new JButton("取消");
    JPanel p1=new JPanel();
    JPanel p2=new JPanel();
    JPanel p3=new JPanel();
    JPanel p4=new JPanel();
    JPanel p5=new JPanel();
    public InsertClassView(){
        this.setSize(500,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(5,1,10,10));
        this.setTitle("成绩添加");

        p1.add(id);
        p1.add(textid);
        p2.add(subject);
        p2.add(textsubject);
        p3.add(score);
        p3.add(textscore);
        p4.add(teacher);
        p4.add(textteacher);
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
                try{
                    ClassManage.insertclass(textid.getText(),textsubject.getText(),Integer.parseInt(textscore.getText()),textteacher.getText());
                }catch(Exception ex){
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
