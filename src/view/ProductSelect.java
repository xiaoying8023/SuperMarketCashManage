package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ProductSelect {
    //信息查询界面
    public static void init(){
        JFrame registerFrame = new JFrame("商品信息查询");
        JLabel message = new JLabel("请输入商品ID或名称...");
        JLabel label = new JLabel("商品信息：");
        JLabel selectMessage = new JLabel();

        JTable table = new JTable();

        JTextField id = new JTextField(20);
        JButton select = new JButton("查询");
        label.setFont(new Font("宋体",Font.BOLD,15));
        message.setFont(new Font("宋体",Font.BOLD,15));
        message.setBounds(10,30,200,25);
        id.setBounds(40,60,400,25);
        select.setBounds(370,90,60,20);
        label.setBounds(10,110,90,20);
        selectMessage.setBounds(40,130,400,250);
        selectMessage.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel panel = new JPanel();
        panel.setLayout(null);
        registerFrame.add(panel);
        panel.add(message);
        panel.add(id);
        panel.add(select);
        panel.add(label);
        panel.add(selectMessage);
        registerFrame.setResizable(false);
        registerFrame.setSize(500,450);
        registerFrame.setVisible(true);
        registerFrame.setLocation(500,400);
        id.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()==KeyEvent.VK_ENTER) {
                    //回车查询
                }
            }
        });
        select.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        //点击查询
                    }
                });
            }
        });

        Map map = new HashMap();



    }

}
