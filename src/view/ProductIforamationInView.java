package view;

import Dao.GoodsDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;

public class ProductIforamationInView {
    //商品信息录入模块界面
    public static void init(){
//        frame.dispose();
        JFrame registerFrame = new JFrame("商品信息录入");
        JLabel message = new JLabel("请输入商品信息...");
        JLabel id_l = new JLabel("id:");
        JLabel name_l = new JLabel("商品名称:");
        JLabel price_l = new JLabel("价格:");
        JLabel stock_l = new JLabel("入库数量:");
        JTextField id = new JTextField(20);
        JTextField name = new JTextField(20);
        JTextField price = new JTextField(20);
        JTextField stock = new JTextField(20);
        JButton enter = new JButton("确定");
        JButton cancel = new JButton("取消");
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
                        LocalDate date = LocalDate.now();

                        //数据类型转换
                        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        String time = date.format(fmt);

                        if (id_text != null && name_text != null && price_text != null && stock_text != null){
                            GoodsDao good = new GoodsDao();
                            try {
                                Object[] selectResult = good.selectProduct(name_text);
                                //如果商品存在，更新现有商品信息；如果商品不存在，添加新的商品信息
                                if (selectResult[0] == null){
                                    int result = good.updateProduct(name_text,price_text,stock_text,time);
                                    if (result != 0){
                                        JOptionPane.showMessageDialog(null,"商品信息更新成功！");
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(null,"商品信息更新失败！");
                                    }

                                }
                                else{
                                    int result = good.insertProduct(id_text,name_text,price_text,stock_text,time);
                                    if (result != 0){
                                        JOptionPane.showMessageDialog(null,"已添加新商品信息！");
                                    }
                                    else {
                                        JOptionPane.showMessageDialog(null,"添加新商品失败！");
                                    }

                                }

                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }

                        }
                        else {
                            JOptionPane.showMessageDialog(null,"输入信息不能为空！");
                        }


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
}
