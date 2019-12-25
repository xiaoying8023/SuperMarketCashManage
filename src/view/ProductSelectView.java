package view;

import Dao.GoodsDao;
import Util.SwingUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ProductSelectView {
    //信息查询界面
    public static void init(){
        JFrame productFrame = new JFrame("商品信息查询");
        JLabel message = new JLabel("请输入商品名称...");
        JLabel label = new JLabel("商品信息：");
        JTable table=new JTable();
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("名称");
        tableModel.addColumn("价格");
        tableModel.addColumn("库存");
        tableModel.addColumn("入库时间");
        JScrollPane jScrollPane = new JScrollPane(table);
        jScrollPane.setBounds(40,130,400,220);
        table.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JTextField id = new JTextField(20);
        JButton select = new JButton("查询");
        label.setFont(new Font("宋体",Font.BOLD,15));
        message.setFont(new Font("宋体",Font.BOLD,15));
        message.setBounds(10,30,200,25);
        id.setBounds(40,60,400,25);
        select.setBounds(370,90,60,20);
        label.setBounds(10,110,90,20);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        productFrame.add(panel);
        panel.add(message);
        panel.add(id);
        panel.add(select);
        panel.add(label);
        panel.add(jScrollPane);
        productFrame.setResizable(false);
        productFrame.setSize(500,400);
        productFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        productFrame.setVisible(true);
        productFrame.setLocation(550,300);
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
                        String name = id.getText();
                        GoodsDao goodsDao = new GoodsDao();
                        try {
                            Object[] data= goodsDao.selectProduct(name);
                            if (data[0] !=null){
                                //将返回的结果添加到显示表
                                tableModel.addRow(data);
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"该商品不存在！");
                            }


                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                });
            }
        });





    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ProductSelectView::init);
    }

}
