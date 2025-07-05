package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class generate_bill extends JFrame implements ActionListener {
    String meter;
    Choice choMonth;
    JTextArea area;
    JButton bill;
    generate_bill(String meter){
        super("Generate bill");
        this.meter = meter;

        setLayout(new BorderLayout());
        JPanel panel = new JPanel();

        JLabel heading = new JLabel("Generate bill");


        JLabel meterNo = new JLabel(meter);




        choMonth = new Choice();
//        choMonth.setBounds(300,200,150,20);

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
//        add(choMonth);

        area = new JTextArea(50,15);
        area.setText("\n\t ************ click on the  **************** \n\t********** Generate bill **************");
        area.setFont(new Font("sanserif",Font.ITALIC,15));


        JScrollPane pane = new JScrollPane(area);
        add(pane);

        panel.add(heading);
        panel.add(meterNo);
        panel.add(choMonth);

        add(panel,"North");

        bill = new JButton("Generate Bill");
        bill.addActionListener(this);

        add(bill,"South");





        setBounds(400,200,700,500);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            database d = new database();
            String smonth = choMonth.getSelectedItem();
            area.setText("\n\n Power limited \n Electricity bill for the month of '"+smonth+"',2023 ");

            ResultSet resultSet = d.statement.executeQuery("select * from new_cust where meter_no = '"+meter+"'");

            if (resultSet.next()){
                area.append("\n    Customer Name        : "+resultSet.getString("name"));
                area.append("\n    Customer Meter Number: "+resultSet.getString("meter_no"));
                area.append("\n    Customer Address     : "+resultSet.getString("address"));
                area.append("\n    Customer City        : "+resultSet.getString("city"));
                area.append("\n    Customer State       : "+resultSet.getString("state"));
                area.append("\n    Customer Email       : "+resultSet.getString("email"));
                area.append("\n    Customer Phone Number       : "+resultSet.getString("phone"));

            }

            resultSet = d.statement.executeQuery("select * from meter_info where meter_no ='"+meter+"'");
            if (resultSet.next()){
                area.append("\n    Customer Meter Location        : "+resultSet.getString("meter_loc"));
                area.append("\n    Customer Meter Type: "+resultSet.getString("meter_type"));
                area.append("\n    Customer Phase Code   : "+resultSet.getString("phase_code"));
                area.append("\n    Customer Bill Type        : "+resultSet.getString("bill_type"));
                area.append("\n    Customer Days      : "+resultSet.getString("days"));
            }

            resultSet = d.statement.executeQuery("select * from tax");
            if (resultSet.next()){
                area.append("\n    Cost Per Unit        : "+resultSet.getString("cost_per_unit"));
                area.append("\n   Meter Rent: "+resultSet.getString("meter_rent"));
                area.append("\n   Service Charge   : "+resultSet.getString("service_charge"));
                area.append("\n   Service Tax        : "+resultSet.getString("service_tax"));
                area.append("\n   Swacch Bharat Acss     : "+resultSet.getString("swachh_bharat"));
                area.append("\n   Fixed Tax     : "+resultSet.getString("fixed_tax"));

            }

            resultSet = d.statement.executeQuery("select * from bill where meter_no = '"+meter+"' and month = '"+choMonth.getSelectedItem()+"'");
            if (resultSet.next()) {
                area.append("\n    Current Month       : " + resultSet.getString("month"));
                area.append("\n   Units Consumed: " + resultSet.getString("unit"));
                area.append("\n   Total Charges   : " + resultSet.getString("total_bill"));
                area.append("\n Total Payable: "+resultSet.getString("total_bill"));
            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new generate_bill("");
    }
}
