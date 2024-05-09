package view;

import service.ClassManage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateClassView extends JFrame{
    JLabel id=new JLabel("请输入要修改学生的id");
    JLabel subject=new JLabel("请输入您要哪个课程的分数");
    JLabel score=new JLabel("请输入您修改后的成绩");
    JTextField textid=new JTextField(15);
    JTextField textsubject=new JTextField(15);
    JTextField textscore=new JTextField(15);
    JButton confirm=new JButton("确定");
    JButton cancel=new JButton("取消");
    JPanel p1=new JPanel();
    JPanel p2=new JPanel();
    JPanel p3=new JPanel();
    JPanel p4=new JPanel();
    public UpdateClassView(){
        this.setTitle("学生成绩修改");
        this.setLayout(new GridLayout(4,1,10,10));
        this.setSize(500,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        p1.add(id);
        p1.add(textid);
        p2.add(subject);
        p2.add(textsubject);
        p3.add(score);
        p3.add(textscore);
        p4.add(confirm);
        p4.add(cancel);

        this.add(p1);
        this.add(p2);
        this.add(p3);
        this.add(p4);
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    ClassManage.updateclass(textid.getText(),textsubject.getText(),Integer.parseInt(textscore.getText()));
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,"成绩修改失败","警告",JOptionPane.WARNING_MESSAGE);
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
