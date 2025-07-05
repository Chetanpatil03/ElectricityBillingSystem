package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class pay_bill extends JFrame implements ActionListener {
    String meter;
    JButton pay,back;
    Choice choMonth;
    pay_bill(String meter){
        super("Pay bill");
        setLayout(null);
        setBounds(400,200,900,600);

        JLabel heading = new JLabel("Pay bill");
        heading.setFont(new Font("Tahoma",Font.BOLD,25));
        heading.setBounds(120,5,400,30);
        add(heading);

        JLabel meterNo = new JLabel("Meter No");
        meterNo.setBounds(35,80,200,20);
        add(meterNo);

        JLabel meterText = new JLabel("");
        meterText.setBounds(300,80,200,20);
        add(meterText);

        JLabel name = new JLabel("Name");
        name.setBounds(35,140,200,20);
        add(name);

        JLabel nameText = new JLabel("");
        nameText.setBounds(300,140,200,20);
        add(nameText);

        JLabel month = new JLabel("Month");
        month.setBounds(35,200,200,20);
        add(month);

        choMonth = new Choice();
        choMonth.setBounds(300,200,150,20);

        choMonth.add("January");
        choMonth.add("February");
        choMonth.add("March");
        choMonth.add("April");
        choMonth.add("May");
        choMonth.add("June");
        choMonth.add("July");
        choMonth.add("August");
        choMonth.add("September");
        choMonth.add("October");
        choMonth.add("November");
        choMonth.add("December");
        add(choMonth);


        JLabel unit = new JLabel("Unit");
        unit.setBounds(35,260,200,20);
        add(unit);

        JLabel unitText = new JLabel("");
        unitText.setBounds(300,260,200,20);
        add(unitText);

        JLabel totalBill = new JLabel("Total bill");
        totalBill.setBounds(35,320,200,20);
        add(totalBill);

        JLabel totalBillText = new JLabel("");
        totalBillText.setBounds(300,320,200,20);
        add(totalBillText);

        JLabel status = new JLabel("Status");
        status.setBounds(35,380,200,20);
        add(status);

        JLabel statusText = new JLabel("");
        statusText.setBounds(300,380,200,20);
        statusText.setForeground(Color.RED);
        add(statusText);

        try{
            database d = new database();
            ResultSet resultSet = d.statement.executeQuery("select * from new_cust where meter_no = '"+meter+"'");

            while (resultSet.next()){
                nameText.setText(resultSet.getString("name"));
                meterText.setText(resultSet.getString("meter_no"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        choMonth.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                database d = new database();

                try{
                    ResultSet resultSet = d.statement.executeQuery("select * from bill where meter_no = '"+meter+"' and month = '"+choMonth.getSelectedItem()+"'");

                    while (resultSet.next()){
                        unitText.setText(resultSet.getString("unit"));
                        totalBillText.setText(resultSet.getString("total_bill"));
                        statusText.setText(resultSet.getString("status"));
                    }

                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        pay = new JButton("Pay");
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.WHITE);
        pay.setBounds(100,460,100,25);
        add(pay);
        pay.addActionListener(this);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(250,460,100,25);
        add(back);
        back.addActionListener(this);











        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pay){
            try {
                database d = new database();
                d.statement.executeUpdate("update bill set status = 'paid' where meter_no = '"+meter+"' and month = '"+choMonth.getSelectedItem()+"'");

            }
            catch (Exception ex){
                ex.printStackTrace();
            }
            setVisible(false);
            new payment_bill(meter);
        }
        else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new pay_bill("");
    }
}
