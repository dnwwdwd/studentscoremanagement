package view;

import service.StuManage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteStuView extends JFrame {
    JLabel labelid=new JLabel("请输入您想删除学生的学号");
    JTextField textField=new JTextField(15);
    JPanel p1=new JPanel();
    JPanel p2=new JPanel();
    JButton confirm=new JButton("确定");
    JButton cancel=new JButton("取消");
    public DeleteStuView(){
        this.setSize(500,300);
        this.setLayout(new GridLayout(2,1,0,0));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("删除学生");
        p1.add(labelid);
        p1.add(textField);
        p2.add(confirm);
        p2.add(cancel);
        p1.setBorder(BorderFactory.createEmptyBorder(70,0,0,0));
        this.add(p1);
        this.add(p2);

        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    StuManage.deleteStudata(textField.getText());
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,"删除失败","警告",JOptionPane.WARNING_MESSAGE);
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
