package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Signup extends JFrame implements ActionListener{
    Choice loginAsCho;
    JTextField meterText,employerText,userNameText,nameText,passwordText;
    JButton create,back;
    public Signup(){
        super("Signup");
        getContentPane().setBackground(new Color(168,203,255));

        JLabel createAs = new JLabel("Create account as : ");
        createAs.setBounds(30,50,125,20);
        add(createAs);

        loginAsCho = new Choice();
        loginAsCho.setBounds(170,50,125,20);
        loginAsCho.addItem("ADMIN");
        loginAsCho.addItem("CUSTOMER");
        add(loginAsCho);

        JLabel meterNo = new JLabel("Meter Number : ");
        meterNo.setBounds(30,100,125,20);
        meterNo.setVisible(false);
        add(meterNo);

        meterText = new JTextField();
        meterText.setBounds(170,100,125,25);
        meterText.setVisible(false);
        add(meterText);

        JLabel employer = new JLabel("Employer Id : ");
        employer.setBounds(30,100,125,20);
        employer.setVisible(true);
        add(employer);

        employerText = new JTextField();
        employerText.setBounds(170,100,125,25);
        employerText.setVisible(true);
        add(employerText);


        JLabel userName = new JLabel("Username ");
        userName.setBounds(30,140,125,25);
        add(userName);

        userNameText = new JTextField();
        userNameText.setBounds(170,140,125,20);
        add(userNameText);

        JLabel name = new JLabel("Name");
        name.setBounds(30,180,125,20);
        add(name);

        nameText = new JTextField();
        nameText.setBounds(170,180,125,20);
        add(nameText);

        JLabel password = new JLabel("Password");
        password.setBounds(30,220,125,20);
        add(password);

        passwordText = new JTextField();
        passwordText.setBounds(170,220,125,20);
        add(passwordText);

        create = new JButton("Create");
        create.setBackground(new Color(66, 127, 219));
        create.setForeground(Color.white);
        create.setBounds(50,280,100,25);
        add(create);
        create.addActionListener(this);

        back = new JButton("Back");
        back.setBackground(new Color(66, 127, 219));
        back.setForeground(Color.white);
        back.setBounds(180,280,100,25);
        add(back);
        back.addActionListener(this);


        ImageIcon boyOne = new ImageIcon(ClassLoader.getSystemResource("./icon/boy.png"));
        Image boyTwo = boyOne.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon fBoyOne = new ImageIcon(boyTwo);
        JLabel boyLabel = new JLabel(fBoyOne);

        boyLabel.setBounds(320,30,250,250);
        add(boyLabel);

        loginAsCho.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String user = loginAsCho.getSelectedItem();

                if(user.equals("ADMIN")){
                    meterNo.setVisible(false);
                    meterText.setVisible(true);
                    employer.setVisible(true);
                    employerText.setVisible(true);

                } else if (user.equals("CUSTOMER")) {
                    meterNo.setVisible(true);
                    meterText.setVisible(true);
                    employer.setVisible(false);
                    employerText.setVisible(false);
                }

            }
        });



        setLayout(null);
        setSize(600,380);
        setLocation(500,200);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == create){
            String sloginAs = loginAsCho.getSelectedItem();
            String susername = userNameText.getText();
            String spassword = passwordText.getText();
            String sname = nameText.getText();
            String smeter = meterText.getText();

            try{
                database d = new database();
                String query = null;
                query = "insert into signup value('"+smeter+"','"+susername+"','"+sname+"','"+spassword+"','"+sloginAs+"')";
                d.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Account created");
                setVisible(false);
                new Login();
            }
            catch (Exception ex){
                ex.printStackTrace();
            }

        }
        else if(e.getSource() == back){
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new Signup();
    }
}
