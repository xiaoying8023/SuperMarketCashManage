package view;

import Util.SwingUtil;
import com.mysql.jdbc.Util;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuView {
    //选择所需功能
    public void init(){
        //frame.dispose();
        JFrame menuFrame = new JFrame("菜单");

        //处理头像
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\SuperMarketCashManage\\src\\photo.jpg");
        Image image =imageIcon.getImage();
        SwingUtil swing = new SwingUtil();
        imageIcon=swing.createAutoAdjustIcon(image,true);
        JLabel photo = new JLabel(imageIcon,JLabel.CENTER);
        photo.setBorder(BorderFactory.createLineBorder(Color.BLACK));




        JTextArea user = new JTextArea("\n工号：\n\n姓名：\n",5,20);
        user.setFont(new Font("宋体",Font.BOLD,20));
        user.setEditable(false);
        user.setBackground(Color.GRAY);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("文件");
        JMenuItem menuItem = new JMenuItem("退出");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('Q', InputEvent.CTRL_DOWN_MASK));
        menu.add(menuItem);
        menuBar.add(menu);
        menuFrame.setJMenuBar(menuBar);

        JPanel down = new JPanel();

        JButton in = new JButton("商品信息录入");
        JButton find = new JButton("商品信息查询");
        JButton cash = new JButton("结账");
        JButton cashCard = new JButton("购物卡管理");

        user.setBounds(10,10,200,150);
        photo.setBounds(300,25,100,100);
        in.setBounds(80,200,120,22);
        find.setBounds(240,200,120,22);
        cash.setBounds(80,240,120,22);
        cashCard.setBounds(240,240,120,22);

        down.setLayout(null);
        menuFrame.add(down);
        down.add(user);
        down.add(photo);
        down.add(in);
        down.add(find);
        down.add(cash);
        down.add(cashCard);
        menuFrame.setLocation(550,300);
        menuFrame.setSize(500,400);
        menuFrame.setResizable(false);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setVisible(true);
        in.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        menuFrame.dispose();
                       new ProductIforamationInView().init();

                    }
                });
            }
        });
        find.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        menuFrame.dispose();
                    }
                });
            }
        });
        cash.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        menuFrame.dispose();
                    }
                });
            }
        });
        cashCard.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        menuFrame.dispose();

                    }
                });
            }
        });
    }


}
