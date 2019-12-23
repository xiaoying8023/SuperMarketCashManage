package view;

import javax.swing.*;
import java.awt.*;

public class newCardCashView {
    //新建购物卡
    public static void init(){
        JFrame newcardFrame = new JFrame("办理购物卡账号");
        JLabel message = new JLabel("请输入信息...");
        JLabel card_l = new JLabel("购物卡号:");
        JLabel name_l = new JLabel("姓名:");
        JTextField card = new JTextField(20);
        JTextField name_t = new JTextField(20);
        JButton enter = new JButton("确定");
        JButton cancel = new JButton("取消");
        //设置控件格式
        message.setFont(new Font("宋体",Font.BOLD,15));
        message.setBounds(10,30,100,25);
        card_l.setBounds(30,100,100,25);
        card.setBounds(100,100,200,25);
        name_l.setBounds(30,130,100,25);
        name_t.setBounds(100,130,200,25);
        enter.setBounds(100,220,100,22);
        cancel.setBounds(230,220,100,22);
        //添加控件
        JPanel panel = new JPanel();
        panel.setLayout(null);
        newcardFrame.add(panel);
        panel.add(message);
        panel.add(card_l);
        panel.add(card);
        panel.add(name_l);
        panel.add(name_t);
        panel.add(enter);
        panel.add(cancel);
        newcardFrame.setResizable(false);
        newcardFrame.setSize(500,450);
        newcardFrame.setVisible(true);
        newcardFrame.setLocation(500,400);
        newcardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



}
