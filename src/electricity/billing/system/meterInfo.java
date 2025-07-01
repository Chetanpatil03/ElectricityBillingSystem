package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class meterInfo extends JFrame implements ActionListener {

    JButton submit;
    Choice chMeterLoc,chMeterType,chPhaseCode,chBillType;
    String meternumber;

    public meterInfo(String meternumber){
        super("Meter Information");

        this.meternumber = meternumber;

        setSize(700,500);
        setLocation(400,200);
//        setLayout(null);
        setLayout(new BorderLayout());

        JLabel heading,meterNo,meterLoc,meterType,phaseCode,billType,day;



        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(213, 181, 123));
        add(panel,"Center");

//        panel.setBounds(0, 0, 700, 500);  // set bounds of panel
//        add(panel);                      // add only once



        heading = new JLabel("Meter Information");
        heading.setBounds(100,10,200,20);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(heading);

        meterNo = new JLabel("Meter number :");
        meterNo.setBounds(50,80,100,20);
        panel.add(meterNo);

        JLabel meterNoText = new JLabel(meternumber);
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


        phaseCode = new JLabel("Phase Code: ");
        phaseCode.setBounds(50,200,100,20);
        panel.add(phaseCode);

        chPhaseCode = new Choice();
        chPhaseCode.setBounds(180,200,100,20);
        chPhaseCode.addItem("011");
        chPhaseCode.addItem("022");
        chPhaseCode.addItem("033");
        chPhaseCode.addItem("044");
        chPhaseCode.addItem("055");
        chPhaseCode.addItem("066");
        chPhaseCode.addItem("077");
        chPhaseCode.addItem("088");
        chPhaseCode.addItem("099");
        panel.add(chPhaseCode);

        billType = new JLabel("Bill Type");
        billType.setBounds(50,240,100,20);
        panel.add(billType);

        chBillType = new Choice();
        chBillType.setBounds(180,240,100,20);
        chBillType.addItem("Normal");
        chBillType.addItem("Industrial");
        panel.add(chBillType);

        day = new JLabel("30 Days billing time");
        day.setBounds(50,280,200,20);
        panel.add(day);


        JLabel note = new JLabel("Note :-");
        note.setBounds(50,320,100,20);
        panel.add(note);

        JLabel note1 = new JLabel("By default Bill is calculated 30 days only");
        note1.setBounds(180,320,300,20);
        panel.add(note1);


        submit = new JButton("Submit");
        submit.setBounds(120,370,100,25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        panel.add(submit);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/details.png"));
        Image image = imageIcon.getImage().getScaledInstance(230,230,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);

        add(label,"East");


//        add(panel);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit){
//            database code

            String smeter_no = meternumber;
            String smeter_loc = chMeterLoc.getSelectedItem();
            String smeter_type = chMeterType.getSelectedItem();
            String sphase_code = chPhaseCode.getSelectedItem();
            String sbill_type = chBillType.getSelectedItem();
            String sdays = "30";


            try{

                database d = new database();

                String query = "insert into meter_info('"+smeter_no+"','"+smeter_loc+"','"+smeter_type+"','"+sphase_code+"','"+sbill_type+"','"+sdays+"')";

                d.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Meter information saved");
                setVisible(false);

            }
            catch (Exception E){
                E.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        new meterInfo("");
    }
}
