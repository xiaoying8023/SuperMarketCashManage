package view;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CashView {
    //结账管理界面
    CashView(){
        JFrame cashFrame=new JFrame();
        cashFrame.setSize(500,300);
        cashFrame.setLocation(400, 500);
        cashFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cashFrame.setLayout(new BorderLayout());
        JPanel jPanel=new JPanel();//查询面板
        JLabel jLabel=new JLabel("商品号");
        JTextField jTextField=new JTextField(10);//用来输入商品号的输入框
        JButton jButton=new JButton("添加");
        jButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
        jPanel.add(jLabel);
        jPanel.add(jTextField);
        jPanel.add(jButton);
        cashFrame.add(jPanel,BorderLayout.PAGE_START);//将查询面板添加到就frame上面
        JTextArea jTextArea=new JTextArea(5,20);
        cashFrame.add(jTextArea,BorderLayout.CENTER);
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

