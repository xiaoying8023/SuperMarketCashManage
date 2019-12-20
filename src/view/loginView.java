package view;

import javax.swing.*;
import java.awt.*;

public class loginView {
    //超市收银系统主界面————登录界面
    private loginView(){
        JFrame mainFrame = new JFrame("收银管理系统");
        JButton login = new JButton("登录");
        JButton register = new JButton("注册");
        JTextField jobNUmber = new JTextField("123456",20);
        JPasswordField password = new JPasswordField(20);
        JLabel jobNUmber_l = new JLabel("工号:");
        JLabel passward_l = new JLabel("密码：");
        jobNUmber_l.setBounds(0,15,20,30);
        jobNUmber.setBounds(20,15,50,30);

        JPanel center = new JPanel();
        center.setLayout(null);
        mainFrame.add(center,BorderLayout.CENTER);
        center.add(jobNUmber_l);
        center.add(jobNUmber);
        center.add(passward_l);
        center.add(password);
        JPanel bottom = new JPanel();
        mainFrame.add(bottom,BorderLayout.PAGE_END);
        center.add(login);
        center.add(register);
        mainFrame.setLocation(500,500);
        mainFrame.setSize(500,500);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(loginView::new);
    }

}
