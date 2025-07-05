package electricity.billing.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.xml.transform.Result;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class bill_details extends JFrame {
    String meter;
    JButton close;
    bill_details(String meter){
        super("Bill Details");
        this.meter = meter;

        setBounds(400,150,700,600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Bill details ...");
        heading.setBounds(30,30,200,25);
        heading.setFont(new Font("serif",Font.BOLD,25));
        add(heading);

        JTable table = new JTable();
        add(table);
        try{
            database d = new database();

            ResultSet resultSet = d.statement.executeQuery("select * from bill where meter_no = '"+meter+"'");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (Exception e) {
            e.printStackTrace();
        }


        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBackground(new Color(232, 223, 223));
        scrollPane.setBounds(0,100,700,600);
        add(scrollPane);



        close = new JButton("Close");
        close.setBounds(550,30,100,20);
        close.setBackground(Color.BLACK);
        close.setForeground(Color.WHITE);
        add(close);
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });




        setVisible(true);
    }

    public static void main(String[] args) {
        new bill_details("");
    }
}
