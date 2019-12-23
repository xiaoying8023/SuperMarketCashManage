package view;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class CashCardView {
    //购物卡管理界面
    public static void init() {
        //购物卡窗口
        JFrame cashcardwindow = new JFrame("CashCardWindow");
        cashcardwindow.setVisible(true);
        cashcardwindow.setSize(600, 400);
        cashcardwindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cashcardwindow.setLocation(600, 300);
        cashcardwindow.setResizable(false);

        //购物卡面板
        JPanel cashcardpanel = new JPanel();
        cashcardpanel.setLayout(null);

        //ID标签
        JLabel cashcardIDlable = new JLabel("购物卡ID");
        cashcardIDlable.setFont(new Font("宋体",Font.BOLD,20));
        cashcardIDlable.setBounds(30, 20, 100, 20);

        //ID输入框
        JTextField cashcardIDtextfield = new JTextField(300);
        cashcardIDtextfield.setFont(new Font("宋体",Font.BOLD,20));
        cashcardIDtextfield.setBounds(150, 20, 270, 20);

        //查询按钮
        JButton cashcardinquirebutton = new JButton("查询");
        cashcardinquirebutton.setBounds(480, 20, 70, 20);

        //显示框
        JTable cashcardtable = new JTable();
        Object[] columnName = {"购物卡号","会员卡号","金额"};
        DefaultTableModel tableModel = (DefaultTableModel) cashcardtable.getModel();
        for (int i=0;i<columnName.length;i++){
            tableModel.addColumn(columnName[i]);
        }


        JScrollPane jScrollPane = new JScrollPane(cashcardtable);
        jScrollPane.setBounds(40, 70, 500, 200);
        cashcardtable.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        //充值按钮
        JButton cashcardrechargebutton = new JButton("充值");
        cashcardrechargebutton.setBounds(150, 300, 60, 30);

        //办理按钮
        JButton cashcardbuildbutton = new JButton("办理");
        cashcardbuildbutton.setBounds(400, 300, 60, 30);

        //集成控件
        cashcardwindow.add(cashcardpanel);
        cashcardpanel.add(cashcardIDlable);
        cashcardpanel.add(cashcardIDtextfield);
        cashcardpanel.add(cashcardinquirebutton);
        cashcardpanel.add(jScrollPane);
        cashcardpanel.add(cashcardrechargebutton);
        cashcardpanel.add(cashcardbuildbutton);

        //查询按钮事件
        cashcardinquirebutton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println("查询");
            }
        });
        //充值按钮事件
        cashcardrechargebutton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println("充值");
                JOptionPane.showInputDialog("请输入金额：");
            }
        });
        //办理按钮事件
        cashcardbuildbutton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println("办理");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CashCardView::init);
    }

}

