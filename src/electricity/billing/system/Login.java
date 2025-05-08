package electricity.billing.system;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {

    JTextField usernameTxt,passwordTxt;
    Choice loginchoice;
    JButton loginBtn,resetBtn,singUpBtn;

    Login(){
        super("Login");

        getContentPane().setBackground(Color.white);

//        adding the components

//        username
        JLabel usernamelbl = new JLabel("Username");
        usernamelbl.setBounds(300,60,100,30);
        add(usernamelbl);

        usernameTxt = new JTextField();
        usernameTxt.setBounds(400,60,150,20);
        add(usernameTxt);

//        password

        JLabel passwordlbl = new JLabel("Password");
        passwordlbl.setBounds(300,100,100,30);
        add(passwordlbl);

        passwordTxt = new JTextField();
        passwordTxt.setBounds(400,100,150,20);
        add(passwordTxt);

//        login as drop down menu options : User and Admin
        JLabel loginAslbl = new JLabel("Login as");
        loginAslbl.setBounds(300,140,100,30);
        add(loginAslbl);

        loginchoice = new Choice();
        loginchoice.setBounds(400,140,100,20);
        loginchoice.addItem("ADMIN");
        loginchoice.addItem("USER");

        add(loginchoice);

//        buttons

        loginBtn = new JButton("Login");
        loginBtn.setBounds(330,180,100,20);
        add(loginBtn);

        resetBtn = new JButton("Reset");
        resetBtn.setBounds(460,180,100,20);
        add(resetBtn);

        singUpBtn = new JButton("Signup");
        singUpBtn.setBounds(400,220,100,20);
        add(singUpBtn);

//      image download

        ImageIcon profileOne = new ImageIcon(ClassLoader.getSystemResource("./icon/profile.png"));
        Image profileTwo = profileOne.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);

        ImageIcon fprofileOne = new ImageIcon(profileTwo);
        JLabel profilelable = new JLabel(fprofileOne);

        profilelable.setBounds(5,5,250,250);

        add(profilelable);






        setSize(640,300);
        setLocation(400,200);
        setLayout(null);



        setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }
}
