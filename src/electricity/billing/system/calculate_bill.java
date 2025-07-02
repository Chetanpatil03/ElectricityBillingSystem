package electricity.billing.system;

import javax.swing.*;
import java.awt.*;

public class calculate_bill extends JFrame {
    calculate_bill(){
        super("Calculate Bill");

        JPanel panel = new JPanel();
        panel.setBackground(new Color(223, 214, 214));
        panel.setLayout(null);




        setBounds(400,200,650,400);

    }

    public static void main(String[] args) {
        new calculate_bill();
    }
}
