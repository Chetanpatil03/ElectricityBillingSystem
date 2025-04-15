package electricity.billing.system;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame {
    Splash(){
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/Splash/Splash.jpg"));
        Image image1 = imageIcon.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
        ImageIcon imageIcon2 = new ImageIcon(image1);
        JLabel imagelable = new JLabel(imageIcon2);

        add(imagelable);
        setSize(600,400);
        setLocation(500,200); //from center




        setVisible(true);

        //27.29 First video
    }
    public static void main(String[] args) {
        new Splash();
    }
}
