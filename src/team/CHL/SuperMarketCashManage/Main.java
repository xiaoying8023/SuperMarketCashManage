package team.CHL.SuperMarketCashManage;

import view.LoginView;

import javax.swing.*;
import java.awt.*;

public class Main {
//主程序
public static void main(String[] args) {
    SwingUtilities.invokeLater(LoginView::new);
}

}
