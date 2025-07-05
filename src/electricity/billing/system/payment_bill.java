package electricity.billing.system;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class payment_bill extends JFrame implements ActionListener {
    String meter;
    JButton back;
    payment_bill(String meter){
        super("Payment bill");
        this.meter = meter;

        setBounds(400,150,800,600);
        setLayout(null);

        JEditorPane editorPane = new JEditorPane();
        editorPane.setEditable(false);
//        add(editorPane);
        try{
            editorPane.setPage("https://paytm.com/online-payments");
            editorPane.setBounds(400,150,800,600);

        } catch (Exception e) {
            e.printStackTrace();
            editorPane.setContentType("text/html");
            editorPane.setText("<html>Error! Error! Error! Error! Error!</html>");

        }

        JScrollPane scrollPane = new JScrollPane(editorPane);
        add(scrollPane);
        scrollPane.setBounds(0,0,800,550);

        back = new JButton("Back");
        back.setBounds(650,520,80,30);
        back.addActionListener(this);
        add(back);





        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new pay_bill(meter);
    }

    public static void main(String[] args) {
        new payment_bill("");
    }
}
