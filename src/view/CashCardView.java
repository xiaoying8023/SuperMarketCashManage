package view;

import Dao.CashCardDao;
import Util.SwingUtil;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
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
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        String cashid = cashcardIDtextfield.getText();
                        if (!cashid.equals("")){
                            CashCardDao cc = new CashCardDao();
                            try {
                                Object[] obj = cc.selectCashCard(cashid);
                                if (obj[0] != null){
                                    tableModel.addRow(obj);
                                }
                                else{
                                    JOptionPane.showMessageDialog(null,"该账户不存在！");
                                }
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }
                            System.out.println("111");

                        }
                        else{
                            JOptionPane.showMessageDialog(null,"输入卡号不能为空！");
                        }
                    }
                });
            }
        });
        //充值按钮事件
        cashcardrechargebutton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                //获取充值金额
                String addMoneyStr = JOptionPane.showInputDialog("请输入要充值的金额");

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {

                        String cashcard = (String) cashcardtable.getValueAt(cashcardtable.getSelectedRow(),0);
                        Double money = Double.parseDouble((String) cashcardtable.getValueAt(cashcardtable.getSelectedRow(),2));

                        if (!addMoneyStr.equals("")){
                            Double addMoney = Double.parseDouble(addMoneyStr);
                            CashCardDao cc = new CashCardDao();
                            try {
                                int result = cc.updateMoney(cashcard,String.valueOf(money += addMoney));
                                System.out.println(result);
                                if (result != -1){
                                    JOptionPane.showMessageDialog(null,"充值成功！");
                                }
                                else{
                                    JOptionPane.showMessageDialog(null,"充值失败！");
                                }

                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"输入金额不能为空！");
                        }
                    }
                });
            }
        });

        //办理按钮事件
        cashcardbuildbutton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println("办理");
                new newCardCashView().init();

            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CashCardView::init);
    }

}

