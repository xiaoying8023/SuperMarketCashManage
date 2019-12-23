package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FindPasswardView {
    //修改密码界面
    public static void init(){
        JFrame passwardFrame = new JFrame("收银员账号密码修改");
        JLabel message = new JLabel("请输入信息...");
        JLabel no_l = new JLabel("工号:");
        JLabel name_l = new JLabel("姓名:");
        JLabel passward_l_old = new JLabel("旧密码:");
        JLabel passward__l_new = new JLabel("新密码:");
        JTextField no_t = new JTextField(20);
        JTextField name_t = new JTextField(20);
        JPasswordField passward_old = new JPasswordField(20);
        JPasswordField passward_new = new JPasswordField(20);
        JButton enter = new JButton("确定");
        JButton cancel = new JButton("取消");
        //设置控件格式
        message.setFont(new Font("宋体",Font.BOLD,15));
        message.setBounds(10,30,100,25);
        no_l.setBounds(30,100,100,25);
        no_t.setBounds(80,100,200,25);
        name_l.setBounds(30,130,100,25);
        name_t.setBounds(80,130,200,25);
        passward_l_old.setBounds(30,160,100,25);
        passward_old.setBounds(80,160,200,25);
        passward__l_new.setBounds(30,190,100,25);
        passward_new.setBounds(80,190,200,25);
        enter.setBounds(100,250,100,22);
        cancel.setBounds(230,250,100,22);
        //添加控件
        JPanel panel = new JPanel();
        panel.setLayout(null);
        passwardFrame.add(panel);
        panel.add(message);
        panel.add(no_l);
        panel.add(no_t);
        panel.add(name_l);
        panel.add(name_t);
        panel.add(passward_l_old);
        panel.add(passward_old);
        panel.add(passward__l_new);
        panel.add(passward_new);
        panel.add(enter);
        panel.add(cancel);
        passwardFrame.setResizable(false);
        passwardFrame.setSize(500,450);
        passwardFrame.setVisible(true);
        passwardFrame.setLocation(500,400);
        passwardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        enter.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        //确定按钮点击事件
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
                        passwardFrame.dispose();
                        new LoginView();
                    }
                });
            }
        });
    }

}
