package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class update_information extends JFrame  implements ActionListener {
    JLabel nameText;
    JTextField addText,cityText,emailText,stateText,phoneText;
    String meter;
    JButton cancel,update;

    update_information(String meter){
        super("Update Information");
        this.meter = meter;

        setBounds(400,150,777,450);
        getContentPane().setBackground(new Color(229,255,227));
        setLayout(null);

        JLabel heading = new JLabel("Update Customer Information");
        heading.setBounds(50,10,40,40);
        heading.setFont(new Font("serif",Font.BOLD,20));
        add(heading);

        JLabel name = new JLabel("Name : ");
        name.setBounds(30,70,100,20);
        add(name);

        nameText = new JLabel("");
        nameText.setBounds(150,70,200,20);
        add(nameText);

        JLabel meterNo = new JLabel("");
        meterNo.setBounds(30,110,100,20);
        add(meterNo);

        JLabel meterText = new JLabel("");
        meterText.setBounds(150,118,100,20);
        add(meterText);

        JLabel address = new JLabel("Address : ");
        address.setBounds(30,158,100,20);
        add(address);

        addText = new JTextField();
        addText.setBounds(150,158,200,20);
        add(addText);

        JLabel city = new JLabel("City : ");
        city.setBounds(30,190,100,20);
        add(city);

        cityText = new JTextField();
        cityText.setBounds(150,190,200,20);
        add(cityText);

        JLabel state = new JLabel("State : ");
        state.setBounds(30,230,100,20);
        add(state);

        stateText = new JTextField();
        stateText.setBounds(150,230,200,20);
        add(stateText);

        JLabel email = new JLabel("Email : ");
        email.setBounds(30,270,100,20);
        add(email);

        emailText = new JTextField();
        emailText.setBounds(150,270,200,20);
        add(emailText);

        JLabel phone = new JLabel("Phone : ");
        phone.setBounds(30,310,100,20);
        add(phone);

        phoneText = new JTextField();
        phoneText.setBounds(30,310,200,20);
        add(phoneText);

        try{
            database d = new database();

            ResultSet resultSet = d.statement.executeQuery("select * from new_cust where meter_no = '"+meter+"'");

            if (resultSet.next()){
                nameText.setText(resultSet.getString("name"));
                meterText.setText(resultSet.getString("meter_no"));
                addText.setText(resultSet.getString("address"));
                cityText.setText(resultSet.getString("city"));
                stateText.setText(resultSet.getString("state"));
                phoneText.setText(resultSet.getString("phone_no"));
                emailText.setText(resultSet.getString("email"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }








    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new update_information("");
    }
}
