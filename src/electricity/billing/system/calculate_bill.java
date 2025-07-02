package electricity.billing.system;

import com.mysql.cj.protocol.x.ReusableOutputStream;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class calculate_bill extends JFrame implements ActionListener {
    Choice choMeterNo,choMonth;
    JLabel nameText,addText;
    JTextField unitText;
    JButton submit,cancel;
    calculate_bill(){
        super("Calculate Bill");

        JPanel panel = new JPanel();
        panel.setBackground(new Color(223, 214, 214));
        panel.setLayout(null);

        JLabel heading = new JLabel("Calculate Electricity Bill");
        heading.setBounds(70,10,300,25);
        heading.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(heading);

        JLabel meterNo = new JLabel("Meter Number");
        meterNo.setBounds(50,80,100,20);
        panel.add(meterNo);

        choMeterNo = new Choice();

        try{

            database d = new database();
            ResultSet resultSet = d.statement.executeQuery("select * from new_cust");

            while(resultSet.next()){
                choMeterNo.add(resultSet.getString("meter_no"));
            }

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error : "+e.getMessage());
            e.printStackTrace();
        }

        choMeterNo.setBounds(180,80,100,20);
        panel.add(choMeterNo);

        JLabel custName = new JLabel("Customer Name");
        custName.setBounds(50,120,100,20);
        panel.add(custName);

        nameText = new JLabel("");
        nameText.setBounds(180,120,100,20);
        panel.add(nameText);

        JLabel custAdd = new JLabel("Customer Address");
        custAdd.setBounds(50,160,100,20);
        panel.add(custAdd);

        addText = new JLabel("");
        addText.setBounds(180,160,100,20);
        panel.add(addText);

        choMeterNo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    database d = new database();

                    ResultSet resultSet = d.statement.executeQuery("select * from new_cust where meter_no = '" + choMeterNo.getSelectedItem() + "'");

                    while (resultSet.next()) {
                        nameText.setText(resultSet.getString("name"));
                        addText.setText(resultSet.getString("address"));
                    }

                } catch (Exception E) {
                    JOptionPane.showMessageDialog(null, "Error " + E.getMessage());
                    E.printStackTrace();
                }
            }
        });

        JLabel unitCons = new JLabel("Unit Consumed");
        unitCons.setBounds(50,200,100,20);
        panel.add(unitCons);

        unitText = new JTextField();
        unitText.setBounds(180,200,100,20);
        panel.add(unitText);

        JLabel month = new JLabel("Month");
        month.setBounds(50,240,100,20);
        panel.add(month);

        choMonth = new Choice();

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

        choMonth.setBounds(180,240,100,20);
        panel.add(choMonth);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(80,300,100,25);
        submit.addActionListener(this);

        panel.add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(220,300,100,25);
        cancel.addActionListener(this);

        panel.add(cancel);


        setLayout(new BorderLayout());

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/budget.png"));
        Image image = imageIcon.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);

        add(panel,"Center");
        add(label,"East");


















        add(panel);
        setBounds(400,200,650,400);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==submit){
            try{
                database d =new database();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Error "+ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new calculate_bill();
    }
}
