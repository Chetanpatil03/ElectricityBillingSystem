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

        JPanel panel = new JPanel();
        panel.setLayout(null);


        setBounds(400,150,777,450);
        getContentPane().setBackground(new Color(229,255,227));
        setLayout(null);

        JLabel heading = new JLabel("Update Customer Information");
        heading.setBounds(50,10,400,40);
        heading.setFont(new Font("serif",Font.BOLD,20));
        panel.add(heading);

        JLabel name = new JLabel("Name : ");
        name.setBounds(30,70,100,20);
        panel.add(name);

        nameText = new JLabel("");
        nameText.setBounds(150,70,200,20);
        nameText.setFont(new Font("monospaced",Font.BOLD,20));
        panel.add(nameText);

        JLabel meterNo = new JLabel("Meter no:");
        meterNo.setBounds(30,110,100,20);
        panel.add(meterNo);

        JLabel meterText = new JLabel("");
        meterText.setBounds(150,118,100,20);
        meterText.setFont(new Font("monospaced",Font.BOLD,20));
        panel.add(meterText);

        JLabel address = new JLabel("Address : ");
        address.setBounds(30,158,100,20);
        panel.add(address);

        addText = new JTextField();
        addText.setBounds(150,158,200,20);
        panel.add(addText);

        JLabel city = new JLabel("City : ");
        city.setBounds(30,190,100,20);
        panel.add(city);

        cityText = new JTextField();
        cityText.setBounds(150,190,200,20);
        panel.add(cityText);

        JLabel state = new JLabel("State : ");
        state.setBounds(30,230,100,20);
        panel.add(state);

        stateText = new JTextField();
        stateText.setBounds(150,230,200,20);
        panel.add(stateText);

        JLabel email = new JLabel("Email : ");
        email.setBounds(30,270,100,20);
        panel.add(email);

        emailText = new JTextField();
        emailText.setBounds(150,270,200,20);
        panel.add(emailText);

        JLabel phone = new JLabel("Phone : ");
        phone.setBounds(30,310,100,20);
        panel.add(phone);

        phoneText = new JTextField();
        phoneText.setBounds(150,310,200,20);
        panel.add(phoneText);

        try{
            database d = new database();

            ResultSet resultSet = d.statement.executeQuery("select * from new_cust where meter_no = '"+meter+"'");

            if (resultSet.next()){
                nameText.setText(resultSet.getString("name"));
                meterText.setText(resultSet.getString("meter_no"));
                addText.setText(resultSet.getString("address"));
                cityText.setText(resultSet.getString("city"));
                stateText.setText(resultSet.getString("state"));
                emailText.setText(resultSet.getString("email"));
                phoneText.setText(resultSet.getString("phone"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        update = new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(50,360,120,25);
        update.addActionListener(this);
        panel.add(update);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(200,360,120,25);
        cancel.addActionListener(this);
        panel.add(cancel);


        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/update.png"));
        Image image = imageIcon.getImage().getScaledInstance(350,410,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel imageLabel = new JLabel(imageIcon1);
        imageLabel.setBounds(360,0,350,410);


        setLayout(new BorderLayout());

        add(imageLabel,"West");
        add(panel,"Center");

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == update){

            String saddress = addText.getText();
            String scity = cityText.getText();
            String sstate = stateText.getText();
            String semail = emailText.getText();
            String sphone = phoneText.getText();

            try{
                database d = new database();

                String Query = "update new_cust set address='"+saddress+"',city='"+scity+"',state = '"+sstate+"',email = '"+semail+"',phone='"+sphone+"' where meter_no = '"+meter+"' ";
                d.statement.executeUpdate(Query);
                JOptionPane.showMessageDialog(null,"Customer Data updated Successfully");
                setVisible(false);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Error "+ex.getMessage());
                ex.printStackTrace();
            }


        } else if (e.getSource()==cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new update_information("");
    }
}
