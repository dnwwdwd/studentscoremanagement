package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerView extends JFrame{

     JButton insert=new JButton("添加学生信息");
     JButton delete=new JButton("删除学生");
    JButton update=new JButton("学生信息修改");
    JButton query=new JButton("查询学生信息");
    JButton queryall=new JButton("查询所有学生信息");

    JButton insertclass=new JButton("添加成绩信息");
    JButton deleteclass=new JButton("删除成绩信息");
    JButton updateclass=new JButton("修改成绩信息");
    JLabel labelstu=new JLabel("学生管理系统");//设置“学生管理系统”标签
    JLabel labelclass=new JLabel("成绩管理系统");//设置“成绩管理系统”标签

    public ManagerView(){
        this.setTitle("学生成绩管理");
        this.setSize(1200,500);
        this.setLayout(new GridBagLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //设置每个按钮长，高为140，120
        Dimension dimension=new Dimension(140,30);//通过setPreferredSize()方法来设置按钮和标签大小，但要传入Dimension对象
        insert.setPreferredSize(dimension);
        delete.setPreferredSize(dimension);
        update.setPreferredSize(dimension);
        query.setPreferredSize(dimension);
        queryall.setPreferredSize(dimension);
        insertclass.setPreferredSize(dimension);
        deleteclass.setPreferredSize(dimension);
        updateclass.setPreferredSize(dimension);
        labelstu.setPreferredSize(dimension);
        labelclass.setPreferredSize(dimension);

        GridBagConstraints constraintsleft=new GridBagConstraints();
        constraintsleft.gridx = 0; // 列为0
        constraintsleft.gridy = GridBagConstraints.RELATIVE; // 按钮的行相对于前一个按钮的行
        constraintsleft.anchor = GridBagConstraints.CENTER; // 设置水平方向上的位置居中
        constraintsleft.fill = GridBagConstraints.HORIZONTAL; // 填充水平方向
        /*constraintsleft.weightx = 0.5; // 水平方向上的权重为0.5*/
        constraintsleft.insets = new Insets(5, 5, 5, 200); // 设置按钮的内边距
        constraintsleft.ipadx = 10;

        this.add(labelstu,constraintsleft);
        this.add(insert,constraintsleft);
        this.add(delete,constraintsleft);
        this.add(update,constraintsleft);
        this.add(query,constraintsleft);
        this.add(queryall,constraintsleft);

        GridBagConstraints constraintsright=new GridBagConstraints();
        constraintsright.gridx=1;
        constraintsleft.gridy = GridBagConstraints.RELATIVE; // 按钮的行相对于前一个按钮的行
        constraintsleft.anchor = GridBagConstraints.CENTER; // 设置水平方向上的位置居中
        constraintsleft.fill = GridBagConstraints.HORIZONTAL; // 填充水平方向
        /*constraintsleft.weightx = 0.5; // 水平方向上的权重为0.5*/
        constraintsleft.insets = new Insets(5, 200, 5, 5); // 设置按钮的内边距
        constraintsleft.ipadx = 10;

        this.add(labelclass,constraintsright);
        this.add(insertclass,constraintsright);
        this.add(deleteclass,constraintsright);
        this.add(updateclass,constraintsright);

        insert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InsertStuView insertStuView=new InsertStuView();
                insertStuView.setVisible(true);
            }
        });
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteStuView deleteStuView=new DeleteStuView();
                deleteStuView.setVisible(true);
            }
        });
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateStuview updateStuview=new UpdateStuview();
                updateStuview.setVisible(true);
            }
        });
        query.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                QueryStuView queryStuView=new QueryStuView();
                queryStuView.setVisible(true);
            }
        });
        insertclass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InsertClassView insertClassView=new InsertClassView();
                insertClassView.setVisible(true);
            }
        });
        deleteclass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteClassView deleteClassView=new DeleteClassView();
                deleteClassView.setVisible(true);
            }
        });
        updateclass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateClassView updateClassView =new UpdateClassView();
                updateClassView.setVisible(true);
            }
        });
/*        p1.add(insert);
        p2.add(delete);
        p3.add(query);
        p4.add(update);
        p5.add(orderby);*/
        queryall.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                QueryAllView queryAllView=new QueryAllView();
                queryAllView.setVisible(true);
            }
        });
    }
}
