package view;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Vector;

import javax.sound.midi.Soundbank;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Dao.CashCardDao;

import com.sun.javafx.geom.AreaOp.AddOp;

//购物卡管理界面
public class CashCardView {
    
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
		JLabel cashcardIDlable = new JLabel("ID");
		cashcardIDlable.setFont(new Font("宋体",Font.BOLD,20));
		cashcardIDlable.setBounds(80, 20, 50, 30);
		cashcardIDlable.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		//ID输入框
		JTextField cashcardIDtextfield = new JTextField(300);
		cashcardIDtextfield.setFont(new Font("宋体",Font.BOLD,20));
		cashcardIDtextfield.setBounds(150, 20, 300, 30);
		cashcardIDtextfield.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		//查询按钮
		JButton cashcardinquirebutton = new JButton("查询");
		cashcardinquirebutton.setBounds(480, 20, 50, 30);
		cashcardinquirebutton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		//显示框
		JTable cashcardtable = new JTable();
		cashcardtable.setBounds(80, 70, 450, 220);
		cashcardtable.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		DefaultTableModel defaulttablemodle = (DefaultTableModel)cashcardtable.getModel();
		JScrollPane scrollpane = new JScrollPane(cashcardtable);
		scrollpane.setBounds(80, 70, 450, 220);
		scrollpane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		Object[] columnarr = {"购物卡号", "会员卡号", "余额"};
		for (int i = 0; i < columnarr.length; i++) {
			defaulttablemodle.addColumn(columnarr[i]);
		}
		
		
		
		
		//充值按钮
		JButton cashcardrechargebutton = new JButton("充值");
		cashcardrechargebutton.setBounds(150, 300, 60, 30);
		cashcardrechargebutton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				
		//办理按钮
		JButton cashcardbuildbutton = new JButton("办理");
		cashcardbuildbutton.setBounds(400, 300, 60, 30);
		cashcardbuildbutton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		//集成控件
		cashcardwindow.add(cashcardpanel);
		cashcardpanel.add(cashcardIDlable);
		cashcardpanel.add(cashcardIDtextfield);
		cashcardpanel.add(cashcardinquirebutton);
		cashcardpanel.add(scrollpane);
		cashcardpanel.add(cashcardrechargebutton);
		cashcardpanel.add(cashcardbuildbutton);	
		
		//事件
		//查询按钮事件
		cashcardinquirebutton.addMouseListener(new MouseAdapter() {
			 public void mouseClicked(MouseEvent e) {
				 
				
				 if(defaulttablemodle.getRowCount() == 1)
					 defaulttablemodle.removeRow(defaulttablemodle.getRowCount() - 1);
		
				 String s_card = cashcardIDtextfield.getText();
				 CashCardDao cashcarddao = new CashCardDao();		 
				try {
					String s_money = cashcarddao.inquireMoney(s_card);
					String v_card = cashcarddao.inquireVipCard(s_card);
					Object[] columnarr1 = {s_card, v_card, s_money};
					
					defaulttablemodle.addRow(columnarr1);
					
					
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}			
			 }
		});
		//充值按钮事件
		cashcardrechargebutton.addMouseListener(new MouseAdapter() {
			 public void mouseClicked(MouseEvent e) {
				 System.out.println("充值");
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
		//CashCardView window = new CashCardView();
		//window.init();
	}
	
}

