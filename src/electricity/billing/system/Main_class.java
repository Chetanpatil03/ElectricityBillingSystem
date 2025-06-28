package electricity.billing.system;

import javax.swing.*;
import java.awt.*;

public class Main_class extends JFrame {

    public Main_class(){
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/ebs.png"));
        Image image = imageIcon.getImage().getScaledInstance(1300,830,Image.SCALE_DEFAULT);

        ImageIcon two = new ImageIcon(image);
        JLabel imageICON = new JLabel(two);
        add(imageICON);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("Menu");
        menu.setFont(new Font("serif",Font.PLAIN,15));
        menuBar.add(menu);

        JMenuItem newCustomer = new JMenuItem("New Customer");
        newCustomer.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon customerOne = new ImageIcon(ClassLoader.getSystemResource("icon/newcustomer.png"));
        Image customerImage = customerOne.getImage().getScaledInstance(24,24,Image.SCALE_DEFAULT);
        newCustomer.setIcon(new ImageIcon(customerImage));
        menu.add(newCustomer);


        JMenuItem customerDetails = new JMenuItem("Customer Details");
        customerDetails.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon customerDetailsOne = new ImageIcon(ClassLoader.getSystemResource("icon/customerDetails.png"));
        Image customerDetailsImage = customerDetailsOne.getImage().getScaledInstance(24,24,Image.SCALE_DEFAULT);
        customerDetails.setIcon(new ImageIcon(customerDetailsImage));
        menu.add(customerDetails);

        JMenuItem depositDetails = new JMenuItem("Deposit Details");
        depositDetails.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon depositDetailsOne = new ImageIcon(ClassLoader.getSystemResource("icon/depositdetails.png"));
        Image depositDetailsImage = depositDetailsOne.getImage().getScaledInstance(24,24,Image.SCALE_DEFAULT);
        depositDetails.setIcon(new ImageIcon(depositDetailsImage));
        menu.add(depositDetails);

        JMenuItem calculateBill = new JMenuItem("Calculate Bill");
        calculateBill.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon calculateBillIcon = new ImageIcon(ClassLoader.getSystemResource("icon/calculatorbills.png"));
        Image calculateBillImage = calculateBillIcon.getImage().getScaledInstance(24,24,Image.SCALE_DEFAULT);
        calculateBill.setIcon(new ImageIcon(calculateBillImage));
        menu.add(calculateBill);

        JMenu informationMenu = new JMenu("Information");
        informationMenu.setFont(new Font("serif",Font.PLAIN,15));
        menuBar.add(informationMenu);

        JMenuItem upInfo = new JMenuItem("Update Information");
        upInfo.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon updateInfoIcon = new ImageIcon(ClassLoader.getSystemResource("icon/refresh.png"));
        Image upInfoImg = updateInfoIcon.getImage().getScaledInstance(24,24,Image.SCALE_DEFAULT);
        upInfo.setIcon(new ImageIcon(upInfoImg));
        informationMenu.add(upInfo);

        JMenuItem viewInfo = new JMenuItem("View Information");
        viewInfo.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon viewInfoIcon = new ImageIcon(ClassLoader.getSystemResource("icon/information.png"));
        Image viewInfoImg = viewInfoIcon.getImage().getScaledInstance(24,24,Image.SCALE_DEFAULT);
        viewInfo.setIcon(new ImageIcon(viewInfoImg));
        informationMenu.add(viewInfo);

        JMenu userMenu = new JMenu("User");
        userMenu.setFont(new Font("serif",Font.PLAIN,15));
        menuBar.add(userMenu);

        JMenuItem payBill = new JMenuItem("Pay Bill");
        payBill.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon payBillIcon = new ImageIcon(ClassLoader.getSystemResource("icon/pay.png"));
        Image payBillImg = payBillIcon.getImage().getScaledInstance(24,24,Image.SCALE_DEFAULT);
        payBill.setIcon(new ImageIcon(payBillImg));
        userMenu.add(payBill);

        JMenuItem billDetails = new JMenuItem("Bill Details");
        billDetails.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon billDetailsIcon = new ImageIcon(ClassLoader.getSystemResource("icon/details.png"));
        Image billDetailsImg = billDetailsIcon.getImage().getScaledInstance(24,24,Image.SCALE_DEFAULT);
        billDetails.setIcon(new ImageIcon(billDetailsImg));
        userMenu.add(billDetails);

        JMenu billMenu = new JMenu("Bill");
        billMenu.setFont(new Font("serif",Font.PLAIN,15));
        menuBar.add(billMenu);

        JMenuItem generateBill = new JMenuItem("Generate Bill");
        generateBill.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon genBillIcon = new ImageIcon(ClassLoader.getSystemResource("icon/bill.png"));
        Image genBillImg = genBillIcon.getImage().getScaledInstance(24,24,Image.SCALE_DEFAULT);
        generateBill.setIcon(new ImageIcon(genBillImg));
        billMenu.add(generateBill);

        JMenu utilityMenu = new JMenu("Utility");
        utilityMenu.setFont(new Font("serif",Font.PLAIN,15));
        menuBar.add(utilityMenu);

        JMenuItem notePad = new JMenuItem("Notepad");
        notePad.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon notepadIcon = new ImageIcon(ClassLoader.getSystemResource("icon/notepad.png"));
        Image notepadImg = notepadIcon.getImage().getScaledInstance(24,24,Image.SCALE_DEFAULT);
        notePad.setIcon(new ImageIcon(notepadImg));
        utilityMenu.add(notePad);

        JMenuItem calculator = new JMenuItem("Calculator");
        calculator.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon calculatorIcon = new ImageIcon(ClassLoader.getSystemResource("icon/calculator.png"));
        Image calculatorImg = calculatorIcon.getImage().getScaledInstance(24,24,Image.SCALE_DEFAULT);
        calculator.setIcon(new ImageIcon(calculatorImg));
        utilityMenu.add(calculator);

        JMenu exitMenu = new JMenu("Exit");
        exitMenu.setFont(new Font("serif",Font.PLAIN,15));
        menuBar.add(exitMenu);

        JMenuItem exit = new JMenuItem("Exit");
        exit.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon exitIcon = new ImageIcon(ClassLoader.getSystemResource("icon/exit.png"));
        Image exitImg = exitIcon.getImage().getScaledInstance(24,24,Image.SCALE_DEFAULT);
        exit.setIcon(new ImageIcon(exitImg));
        exitMenu.add(exit);


        setLayout(new FlowLayout());
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main_class();
    }
}
