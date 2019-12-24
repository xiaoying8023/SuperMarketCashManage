package view;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class CashView {
    //结账管理界面
    CashView(){
        JFrame cashFrame=new JFrame();
        cashFrame.setSize(500,520);
        cashFrame.setLocation(400, 250);
        cashFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //查询面板
        JPanel panel=new JPanel();
        JLabel productID_l=new JLabel("商品号:");
        JTextField productID = new JTextField(10);
        JTable productTable = new JTable();
        Object[] columnName = {"ID","名称","单价","数量","是否选中"};
        DefaultTableModel tableModel = (DefaultTableModel) productTable.getModel();
        for (int i=0;i<columnName.length;i++){
            tableModel.addColumn(columnName[i]);
        }Object[] data = {"1","1","1","1"};
        tableModel.addRow(data);
        JCheckBox box = new JCheckBox();
        productTable.getColumnModel().getColumn(3).setCellRenderer(new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jTable, Object o, boolean b, boolean b1, int i, int i1) {
                box.setHorizontalAlignment((int)0.5);
                box.setSelected(false);
                return box;
            }
        });
        JScrollPane jScrollPane = new JScrollPane(productTable);
        productTable.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JButton addProduct=new JButton("添加");
        panel.add(productID_l,FlowLayout.LEFT);
        panel.add(productID);
        panel.add(addProduct);
        panel.add(jScrollPane);
        cashFrame.add(panel,BorderLayout.PAGE_START);//将查询面板添加到就frame上面
        JTextArea jTextArea=new JTextArea(5,20);

        JPanel jPane2=new JPanel();//结账面板
        JButton jButton2=new JButton("结账");//结账按钮
        JTextField jTextField2=new JTextField(10);//显示金额
        JLabel jLabel2=new JLabel("元");//最后点缀元
        jPane2.add(jTextField2);
        jPane2.add(jLabel2);
        jPane2.add(jButton2);
        cashFrame.add(jPane2,BorderLayout.PAGE_END);
        cashFrame.setVisible(true);
    }
    public static void main(String[] args) {
        CashView cashView=new CashView();

    }
}

