package view;

import Dao.CardDao;
import Dao.CashCardDao;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class newCardCashView {
    //新建购物卡
    public static void init(){
        JFrame newcardFrame = new JFrame("办理购物卡账号");
        JLabel message = new JLabel("请输入信息...");
        JLabel card_l = new JLabel("购物卡号:");
        JLabel name_l = new JLabel("姓名:");
        JTextField card_t = new JTextField(20);
        JTextField name_t = new JTextField(20);
        JTextField vipCard_t = new JTextField(20);
        JButton enter = new JButton("确定");
        JButton cancel = new JButton("取消");
        JLabel isVip_l = new JLabel("是否拥有会员卡");
        JLabel vipCard_l = new JLabel("会员卡号：");
        JRadioButton isVip_y =new JRadioButton("是");
        JRadioButton isVip_n = new JRadioButton("否");
        ButtonGroup bg = new ButtonGroup();
        //设置控件格式
        message.setFont(new Font("宋体",Font.BOLD,15));
        message.setBounds(10,30,100,25);
        card_l.setBounds(30,100,100,25);
        card_t.setBounds(100,100,200,25);
        name_l.setBounds(30,165,100,25);
        name_t.setBounds(100,165,200,25);
        isVip_l.setBounds(30,130,100,25);
        isVip_y.setBounds(140,130,40,30);
        isVip_n.setBounds(230,130,40,30);
        vipCard_l.setBounds(30,200,100,25);
        vipCard_t.setBounds(100,200,200,25);
        enter.setBounds(100,250,100,22);
        cancel.setBounds(230,250,100,22);

        name_t.setEditable(false);
        vipCard_t.setEditable(false);


        //添加控件
        JPanel panel = new JPanel();
        panel.setLayout(null);
        newcardFrame.add(panel);
        bg.add(isVip_y);
        bg.add(isVip_n);
        panel.add(message);
        panel.add(card_l);
        panel.add(card_t);
        panel.add(name_l);
        panel.add(name_t);
        panel.add(isVip_l);
        panel.add(isVip_y);
        panel.add(isVip_n);
        panel.add(enter);
        panel.add(cancel);
        panel.add(vipCard_l);
        panel.add(vipCard_t);
        newcardFrame.setResizable(false);
        newcardFrame.setSize(500,450);
        newcardFrame.setVisible(true);
        newcardFrame.setLocation(500,400);
        newcardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //添加单选按钮的点击事件
        isVip_y.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        name_t.setEditable(true);
                        vipCard_t.setEditable(true);
                    }
                });
            }
        });
        isVip_n.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        name_t.setEditable(false);
                        vipCard_t.setEditable(false);
                    }
                });
            }
        });

        //添加确定按钮的点击事件
        enter.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        String card = card_t.getText();

                        if (true/*!card.equals("") && !name.equals("")*/){
                            CashCardDao cc = new CashCardDao();
                            CardDao cd = new CardDao();
                            if (vipCard_t.isEditable()){
                                String name = name_t.getText();
                                String vipcard = vipCard_t.getText();
                                try {
                                    //判断会员输入是否正确，正确即注册新购物卡
                                    Object[] vip_result = cd.selectCashCard(vipcard,name);
                                    if (vip_result[0] != null){
                                        int result = cc.insertCashCard(card,vipcard);
                                        if (result > 0){
                                            JOptionPane.showMessageDialog(null,"注册购物卡成功！");
                                        }
                                        else {
                                            JOptionPane.showMessageDialog(null,"注册购物卡失败！");
                                        }
                                    }
                                    else {
                                        JOptionPane.showMessageDialog(null,"会员卡号或姓名不能为空！");
                                    }
                                } catch (SQLException ex) {
                                    ex.printStackTrace();
                                }
                            }
                            else{
                                try {
                                    //注册没有会员卡的购物卡
                                    int result = cc.insertCashCard(card);
                                    if (result > 0){
                                        JOptionPane.showMessageDialog(null,"注册购物卡成功！");
                                    }
                                    else {
                                        JOptionPane.showMessageDialog(null,"注册购物卡失败！");
                                    }

                                } catch (SQLException ex) {
                                    ex.printStackTrace();
                                }

                            }

                        }
                        else {
                            JOptionPane.showMessageDialog(null,"卡号或用户名不能为空！");
                        }
                    }
                });
            }
        });
    }



}
