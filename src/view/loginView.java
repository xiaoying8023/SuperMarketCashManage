package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class loginView {
    //超市收银系统主界面————登录界面
    private loginView(){
        JFrame mainFrame = new JFrame("收银管理系统");
        JButton login = new JButton("登录");
        JLabel register = new JLabel("注册?");
        JTextField jobNUmber = new JTextField("123456",20);
        JPasswordField password = new JPasswordField(20);
        JLabel jobNUmber_l = new JLabel("工号:");
        JLabel passward_l = new JLabel("密码：");
        JLabel superMarket = new JLabel("超市收银管理系统");
        superMarket.setFont(new Font("宋体",Font.BOLD,20));
        superMarket.setBounds(160,100,400,20);
        jobNUmber_l.setBounds(180,220,100,20);
        jobNUmber.setBounds(230,220,100,20);
        passward_l.setBounds(180,250,100,20);
        password.setBounds(230,250,100,20);
        login.setBounds(200,280,80,20);
        register.setBounds(350,220,50,20);
        JPanel center = new JPanel();
        center.setLayout(null);
        mainFrame.add(center,BorderLayout.CENTER);
        center.add(superMarket);
        center.add(jobNUmber_l);
        center.add(jobNUmber);
        center.add(passward_l);
        center.add(password);
        center.add(login);
        center.add(register);
        mainFrame.setLocation(550,300);
        mainFrame.setSize(500,500);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        register.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               SwingUtilities.invokeLater((new Runnable() {
                   @Override
                   public void run() {

                   }
               }));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                register.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                register.setForeground(Color.blue);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                register.setCursor(Cursor.getDefaultCursor());
                register.setForeground(Color.BLACK);
            }
        });
    }

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(loginView::new);
//    }

}
