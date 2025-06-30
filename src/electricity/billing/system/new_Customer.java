package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class new_Customer extends JFrame {

    JLabel heading,custName,meterNo,address,city,state,email,phone,meterText;
    JTextField nameText,addText,cityText,stateText,emailText,phoneText;
    JButton nextBtn,cancelBtn;

    new_Customer(){
        super("New Customer");
        setBounds(400,200,700,500);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(244, 226, 176));


        heading = new JLabel("New Customer");
        heading.setBounds(100,10,200,20);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(heading);

        custName = new JLabel("Customer Name");
        custName.setBounds(50,80,100,20);
        panel.add(custName);

        nameText = new JTextField();
        nameText.setBounds(180,80,150,20);
        panel.add(nameText);

        meterNo = new JLabel("Meter No");
        meterNo.setBounds(50,120,150,20);
        panel.add(meterNo);

        meterText = new JLabel();
        meterText.setBounds(180,120,150,20);
        panel.add(meterText);

        Random random = new Random();
        long number = random.nextLong() % 1000000;

        meterText.setText(""+Math.abs(number));


        address = new JLabel("Address");
        address.setBounds(50,160,150,20);
        panel.add(address);

        addText = new JTextField();
        addText.setBounds(180,160,150,20);
        panel.add(addText);

        city = new JLabel("City");
        city.setBounds(50,200,150,20);
        panel.add(city);

        cityText = new JTextField();
        cityText.setBounds(180,200,150,20);
        panel.add(cityText);

        state = new JLabel("State");
        state.setBounds(50,240,150,20);
        panel.add(state);

        stateText = new JTextField();
        stateText.setBounds(180,240,150,20);
        panel.add(stateText);

        email = new JLabel("Email");
        email.setBounds(50,280,150,20);
        panel.add(email);

        emailText = new JTextField();
        emailText.setBounds(180,280,150,20);
        panel.add(emailText);

        phone = new JLabel("Phone no");
        phone.setBounds(50,320,150,20);
        panel.add(phone);

        phoneText = new JTextField();
        phoneText.setBounds(180,320,150,20);
        panel.add(phoneText);

        nextBtn = new JButton("Next");
        nextBtn.setBounds(120,390,100,25);
        nextBtn.setBackground(Color.BLACK);
        nextBtn.setForeground(Color.WHITE);
        panel.add(nextBtn);

        cancelBtn = new JButton("Cancel");
        cancelBtn.setBounds(250,390,100,25);
        cancelBtn.setBackground(Color.BLACK);
        cancelBtn.setForeground(Color.WHITE);
        panel.add(cancelBtn);









        setLayout(new BorderLayout());
        add(panel,"Center");

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/boy.png"));
        Image image = imageIcon.getImage().getScaledInstance(230,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel imagelbl = new JLabel(imageIcon1);

        add(imagelbl,"West");


        setVisible(true);
    }

    public static void main(String[] args) {
        new new_Customer();
    }
}
