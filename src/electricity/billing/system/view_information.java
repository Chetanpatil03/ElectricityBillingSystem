package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class view_information extends JFrame implements ActionListener {

    String view;
    JButton cancel;

    view_information(String view){
        super("View Details");
        this.view = view;

        setBounds(350,150,850,650);
        setLayout(null);
        setBackground(Color.white);

        JLabel heading = new JLabel("View customer information");
        heading.setFont(new Font("serif",Font.BOLD,20));
        heading.setBounds(300,0,500,40);
        add(heading);

        JLabel nameLbl = new JLabel("Name");
        nameLbl.setBounds(70,80,100,20);
        add(nameLbl);

        JLabel nameLblText = new JLabel("");
        nameLblText.setBounds(200,80,150,20);
        add(nameLblText);

        JLabel meterLbl = new JLabel("Meter No");
        meterLbl.setBounds(70,140,100,20);
        add(meterLbl);

        JLabel meterLblText = new JLabel("");
        meterLblText.setBounds(200,140,150,20);
        add(meterLblText);


        JLabel addrsLbl = new JLabel("Address : ");
        addrsLbl.setBounds(70,200,100,20);
        add(addrsLbl);

        JLabel addrsLblText = new JLabel("");
        addrsLblText.setBounds(200,200,150,20);
        add(addrsLblText);

        JLabel cityLbl = new JLabel("City : ");
        cityLbl.setBounds(70,260,100,20);
        add(cityLbl);

        JLabel cityLblText = new JLabel("");
        cityLblText.setBounds(200,260,150,20);
        add(cityLblText);

        JLabel stateLbl = new JLabel("State : ");
        stateLbl.setBounds(500,80,100,20);
        add(stateLbl);

        JLabel stateLblText = new JLabel("");
        stateLblText.setBounds(600,80,150,20);
        add(stateLblText);

        JLabel emailLbl = new JLabel("Email : ");
        emailLbl.setBounds(500,140,100,20);
        add(emailLbl);

        JLabel emailLblText = new JLabel("");
        emailLblText.setBounds(600,140,150,20);
        add(emailLblText);

        JLabel phoneLbl = new JLabel("Phone number : ");
        phoneLbl.setBounds(500,200,100,20);
        add(phoneLbl);

        JLabel phoneLblText = new JLabel("");
        phoneLblText.setBounds(600,200,150,20);
        add(phoneLblText);

        try{
            database d = new database();
            ResultSet resultSet = d.statement.executeQuery("select * from new_cust where meter_no = '"+view+"'");

            if (resultSet.next()){
                nameLblText.setText(resultSet.getString("name"));
                meterLblText.setText(resultSet.getString("meter_no"));
                addrsLblText.setText(resultSet.getString("address"));
                cityLblText.setText(resultSet.getString("city"));
                stateLblText.setText(resultSet.getString("state"));
                emailLblText.setText(resultSet.getString("email"));
                phoneLblText.setText(resultSet.getString("phone"));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        cancel =  new JButton("Cancel");
        cancel.setBounds(220,350,120,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/viewInfo.png"));
        Image image = imageIcon.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(100,320,600,300);

        add(label);




        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancel){
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new view_information("");
    }
}
