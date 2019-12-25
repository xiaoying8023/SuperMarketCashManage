package view;

import Dao.UserDao;
import javafx.beans.binding.ObjectBinding;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class LoginView {

    public Object[] result = null;
    //超市收银系统主界面————登录界面
    public LoginView(){
        JFrame mainFrame = new JFrame("收银管理系统");
        JButton login = new JButton("登录");
        JLabel register = new JLabel("注册?");
        JLabel findPassward = new JLabel("修改密码");
        JTextField jobNumber = new JTextField(20);
        JPasswordField password = new JPasswordField(20);
        JLabel jobNumber_l = new JLabel("工号:");
        JLabel passward_l = new JLabel("密码：");
        JLabel superMarket = new JLabel("超市收银管理系统");
        superMarket.setFont(new Font("宋体",Font.BOLD,20));
        superMarket.setBounds(160,100,400,20);
        jobNumber_l.setBounds(150,190,100,20);
        jobNumber.setBounds(190,190,120,20);
        passward_l.setBounds(150,220,100,20);
        password.setBounds(190,220,120,20);
        login.setBounds(210,260,80,25);
        register.setBounds(330,190,50,20);
        findPassward.setBounds(320,220,100,20);
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
                    new RegisterView().init();
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
                        new FindPasswardView().init();
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
                        if (!jobnum.equals("") && !pwd.equals("")){
                            UserDao user = new UserDao();
                            try {
                                result = user.selectUser(jobnum,pwd);
                                if (result[0] != null){
                                    JOptionPane.showMessageDialog(null,"登录成功！");
                                    jobNumber.setText("");
                                    password.setText("");
                                    mainFrame.dispose();
                                    new MenuView(jobnum, (String) result[1]);
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
}
