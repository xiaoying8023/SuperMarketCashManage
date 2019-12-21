package view;

import javafx.beans.binding.ObjectBinding;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoginView {
    //超市收银系统主界面————登录界面
    private LoginView(){
        JFrame mainFrame = new JFrame("收银管理系统");
        JButton login = new JButton("登录");
        JLabel register = new JLabel("注册?");
        JLabel findPassward = new JLabel("修改密码");
        JTextField jobNumber = new JTextField("123456",20);
        JPasswordField password = new JPasswordField(20);
        JLabel jobNumber_l = new JLabel("工号:");
        JLabel passward_l = new JLabel("密码：");
        JLabel superMarket = new JLabel("超市收银管理系统");
        superMarket.setFont(new Font("宋体",Font.BOLD,20));
        superMarket.setBounds(160,100,400,20);
        jobNumber_l.setBounds(180,210,100,20);
        jobNumber.setBounds(230,210,100,20);
        passward_l.setBounds(180,240,100,20);
        password.setBounds(230,240,100,20);
        login.setBounds(210,270,80,25);
        register.setBounds(350,210,50,20);
        findPassward.setBounds(340,240,100,20);
        JPanel center = new JPanel();
        center.setLayout(null);
        mainFrame.add(center,BorderLayout.CENTER);
        center.add(superMarket);
        center.add(jobNumber_l);
        center.add(jobNumber);
        center.add(passward_l);
        center.add(password);
        center.add(login);
        center.add(register);
        center.add(findPassward);
        mainFrame.setLocation(550,300);
        mainFrame.setSize(500,400);
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
        findPassward.addMouseListener(new MouseAdapter() {
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
                findPassward.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                findPassward.setForeground(Color.blue);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                findPassward.setCursor(Cursor.getDefaultCursor());
                findPassward.setForeground(Color.BLACK);
            }
        });
        login.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        String jobnum = jobNumber.getText();
                        String pwd = String.valueOf(password.getPassword());
                        if (jobnum != null || pwd != null){
                            JDBC.jdbc jdbc = new JDBC.jdbc();
                            try {
                                ArrayList lists = jdbc.selectuser(jobnum,pwd);
                                if (lists.size()!=0){
                                    JOptionPane.showMessageDialog(null,"登录成功！");
                                }
                                else{
                                    JOptionPane.showMessageDialog(null,"用户名或密码错误！");
                                }
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"账号或密码不能为空！");
                        }

                    }
                });
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                login.setCursor(Cursor.getDefaultCursor());
            }
        });
    }

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(LoginView::new);
//    }

}
