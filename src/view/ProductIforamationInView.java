package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProductIforamationInView {
    //商品信息录入模块界面
    public static void init(){
<<<<<<< HEAD
=======
//        frame.dispose();
>>>>>>> 548357600bc61503d29f4bb5dfc8aa15bcc57a94
        JFrame registerFrame = new JFrame("商品信息录入");
        JLabel message = new JLabel("请输入商品信息...");
        JLabel id_l = new JLabel("id:");
        JLabel name_l = new JLabel("商品名称:");
        JLabel price_l = new JLabel("价格:");
        JLabel stock_l = new JLabel("入库数量:");
        JLabel date_l = new JLabel("入库时间:");
        JTextField id = new JTextField(20);
        JTextField name = new JTextField(20);
        JTextField price = new JPasswordField(20);
        JTextField stock = new JPasswordField(20);
        JTextField date = new JPasswordField(20);
        JButton enter = new JButton("提交");
        JButton cancel = new JButton("返回");
        //设置控件格式
        message.setFont(new Font("宋体",Font.BOLD,15));
        message.setBounds(10,30,150,25);
        id_l.setBounds(20,100,100,25);
        id.setBounds(80,100,200,25);
        name_l.setBounds(20,130,100,25);
        name.setBounds(80,130,200,25);
        price_l.setBounds(20,160,100,25);
        price.setBounds(80,160,200,25);
        stock_l.setBounds(20,190,100,25);
        stock.setBounds(80,190,200,25);
        date_l.setBounds(20,220,100,25);
        date.setBounds(80,220,200,25);
        enter.setBounds(100,280,100,22);
        cancel.setBounds(230,280,100,22);
        //添加控件
        JPanel panel = new JPanel();
        panel.setLayout(null);
        registerFrame.add(panel);
        panel.add(message);
        panel.add(id_l);
        panel.add(id);
        panel.add(name_l);
        panel.add(name);
        panel.add(price_l);
        panel.add(price);
        panel.add(stock_l);
        panel.add(stock);
        panel.add(date_l);
        panel.add(date);
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
                        //提交按钮点击事件
                        String id_text = id.getText();
                        String name_text = name.getText();
                        String price_text = price.getText();
                        String stock_text = stock.getText();
                        String date_text = date.getText();


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
                        //返回按钮点击事件
                        new MenuView();
                    }
                });
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ProductIforamationInView::init);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ProductIforamationInView::init);
    }
}
