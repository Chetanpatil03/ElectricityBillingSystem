package electricity.billing.system;

import javax.swing.*;
import java.awt.*;

public class meterInfo extends JFrame  {

    JButton submit;
    Choice chMeterLoc,chMeterType,chPhaseCode,chBillType;

    public meterInfo(){
        super("Meter Information");

        setSize(700,500);
        setLocation(400,200);
        setLayout(null);
//        setLayout(new BorderLayout());

        JLabel heading,meterNo,meterLoc,meterType,phaseCode,billType;



        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(213, 181, 123));
//        add(panel,"West");

        panel.setBounds(0, 0, 700, 500);  // set bounds of panel
        add(panel);                      // add only once



        heading = new JLabel("Meter Information");
        heading.setBounds(100,10,200,20);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(heading);

        meterNo = new JLabel("Meter number :");
        meterNo.setBounds(50,80,100,20);
        panel.add(meterNo);

        JLabel meterNoText = new JLabel();
        meterNoText.setBounds(180,80,150,20);
        panel.add(meterNoText);

//        get meter no from new_Customer

        meterLoc = new JLabel("Meter Location");
        meterLoc.setBounds(50,120,100,20);
        panel.add(meterLoc);

        chMeterLoc = new Choice();
        chMeterLoc.setBounds(180,120,100,20);

        chMeterLoc.addItem("Outside");
        chMeterLoc.addItem("Inside");
        panel.add(chMeterLoc);

        meterType = new JLabel("Meter Location");
        meterType.setBounds(50,160,100,20);
        panel.add(meterType);

        chMeterType = new Choice();
        chMeterType.setBounds(180,160,100,20);

        chMeterType.addItem("Electric Meter");
        chMeterType.addItem("Solar Meter");
        chMeterType.addItem("Smart Meter");
        panel.add(chMeterType);


















//        add(panel);
        setVisible(true);

    }

    public static void main(String[] args) {
        new meterInfo();
    }
}
