package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegisterView {
    //注册页面
    public static void init(){
        //frame.dispose();
        //定义控件
        JFrame registerFrame = new JFrame("收银员账号注册");
        JLabel message = new JLabel("请输入信息...");
        JLabel no_l = new JLabel("工号:");
        JLabel name_l = new JLabel("姓名:");
        JLabel passward_l = new JLabel("密码:");
        JTextField no_t = new JTextField(20);
        JTextField name_t = new JTextField(20);
        JPasswordField passward = new JPasswordField(20);
        JButton enter = new JButton("确定");
        JButton cancel = new JButton("取消");
        //设置控件格式
        no_t.setEditable(false);
        message.setFont(new Font("宋体",Font.BOLD,15));
        message.setBounds(10,30,100,25);
        no_l.setBounds(30,100,100,25);
        no_t.setBounds(80,100,200,25);
        name_l.setBounds(30,130,100,25);
        name_t.setBounds(80,130,200,25);
        passward_l.setBounds(30,160,100,25);
        passward.setBounds(80,160,200,25);
        enter.setBounds(100,220,100,22);
        cancel.setBounds(230,220,100,22);
        //添加控件
        JPanel panel = new JPanel();
        panel.setLayout(null);
        registerFrame.add(panel);
        panel.add(message);
        panel.add(no_l);
        panel.add(no_t);
        panel.add(name_l);
        panel.add(name_t);
        panel.add(passward_l);
        panel.add(passward);
        panel.add(enter);
        panel.add(cancel);
        registerFrame.setResizable(false);
        registerFrame.setSize(500,450);
        registerFrame.setVisible(true);
        registerFrame.setLocation(500,400);
        enter.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
            }
        });
        cancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
            }
        });
    }
}
