package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class MainView extends JFrame {
    private final Map<String,String> userhashmap=new HashMap<>();
    JPanel p1=new JPanel();
    JPanel p2=new JPanel();
    JPanel p3=new JPanel();
    JPanel p4=new JPanel();
    JLabel welcome=new JLabel("欢迎来到学生信息管理系统");
    JLabel username=new JLabel("账号:");
    JLabel password=new JLabel("密码:");

    JTextField usernametext=new JTextField(10);
    JPasswordField passwordField=new JPasswordField(10);

    JButton confirm=new JButton("确认");
    JButton exit=new JButton("退出");
    JButton register=new JButton("注册");
    public MainView() {
        this.setTitle("学生信息管理系统");
        this.setSize(800, 500);
        this.setLayout(new GridLayout(4, 1,10,10));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        p4.add(welcome);
        p1.add(username);
        p1.add(usernametext);
        p2.add(password);
        p2.add(passwordField);
        p3.add(confirm);
        p3.add(register);
        p3.add(exit);

        this.add(p4);
        this.add(p1);
        this.add(p2);
        this.add(p3);
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==register){
                    if(userhashmap.containsKey(usernametext.getText())){
                        JOptionPane.showMessageDialog(null,"注册失败，您的账号已存在","警告",JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    userhashmap.put(usernametext.getText(),passwordField.getText());
                    JOptionPane.showMessageDialog(null,"注册成功","通知",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == confirm) {
                    if (userhashmap.containsKey(usernametext.getText())) {
                        if (userhashmap.get(usernametext.getText()).equals(passwordField.getText())) {
                            JOptionPane.showMessageDialog(null,"登陆成功","通知",JOptionPane.INFORMATION_MESSAGE);
                            dispose();
                            ManagerView mv=new ManagerView();
                            mv.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null,"密码错误","警告",JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"该用户不存在","警告",JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
    public static void main(String[] args) {
        MainView m=new MainView();
        m.setVisible(true);
    }
}
