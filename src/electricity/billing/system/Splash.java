package electricity.billing.system;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame {
    Splash(){
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/Splash/Splash.jpg"));
        Image image1 = imageIcon.getImage().getScaledInstance(850,600,Image.SCALE_DEFAULT);
        ImageIcon imageIcon2 = new ImageIcon(image1);
        JLabel imagelable = new JLabel(imageIcon2);

        add(imagelable);
        setSize(850,600);
        setLocation(500,200); //from center

        setVisible(true);

        try{
            Thread.sleep(3000); //to hold for 3sec
            setVisible(false);

            new Login();
        } catch (Exception e) {
            e.printStackTrace();
//            System.out.println(e);
        }

        //27.29 First video
    }
    public static void main(String[] args) {
        new Splash();
    }
}
