package com.lazy.load;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by denys on 6/8/2017.
 */
public class Main {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setSize(500, 500);
        jFrame.show();
        JLabel label = new JLabel();
        jFrame.getContentPane().add(label);
        //from db
        //SELECT companyName from COMAPNIES
        List<Company> companies = new ArrayList();

        //SELECT deprtmentTitle FROM DEPARTMENTS where/join COMPANY NAME

        Company c1 = new Company();
        c1.setCompanyName("C1");
        Company c2 = new Company();
        c2.setCompanyName("C2");
        label.setText("<HTML><BODY><table><tr><td>C1</td></tr><tr><td>C2</td></tr></table></BODY></HTML>");
    }


}
