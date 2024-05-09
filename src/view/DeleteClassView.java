package view;

import service.ClassManage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteClassView extends JFrame{
    JLabel id=new JLabel("请输入学生的id");
    JLabel subject=new JLabel("请输入您要删除哪个课程");
    JTextField textid=new JTextField(15);
    JTextField textsubject=new JTextField(15);
    JButton confirm=new JButton("确定");
    JButton cancel=new JButton("取消");
    JPanel p1=new JPanel();
    JPanel p2=new JPanel();
    JPanel p3=new JPanel();
    JPanel p4=new JPanel();
    public DeleteClassView(){
        this.setTitle("学生成绩删除");
        this.setLayout(new GridLayout(3,1,10,10));
        this.setSize(500,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        p1.add(id);
        p1.add(textid);
        p2.add(subject);
        p2.add(textsubject);
        p3.add(confirm);
        p3.add(cancel);

        this.add(p1);
        this.add(p2);
        this.add(p3);
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    ClassManage.deleteclass(textid.getText(),textsubject.getText());
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,"成绩删除失败","警告",JOptionPane.WARNING_MESSAGE);
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

