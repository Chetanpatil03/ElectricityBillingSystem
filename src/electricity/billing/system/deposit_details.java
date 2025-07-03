package electricity.billing.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class deposit_details extends JFrame implements ActionListener {

    JButton search,print,close;
    Choice meterNoCho,monthChoice;
    JTable table;
    deposit_details(){
        super("Deposit Details");
        setLayout(null);
        getContentPane().setBackground(new Color(228, 222, 222));
        setBounds(400,200,700,500);

        JLabel searchByMet = new JLabel("Search by meter number ");
        searchByMet.setBounds(20,20,150,25);
        add(searchByMet);

        meterNoCho = new Choice();
        meterNoCho.setBounds(180,20,100,25);
        add(meterNoCho);

        try{
            database d =new database();
            ResultSet rs = d.statement.executeQuery("select * from bill");
            while (rs.next()){
                meterNoCho.add(rs.getString("meter_no"));
            }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error "+e.getMessage());
            e.printStackTrace();

        }



        JLabel searchByMonth = new JLabel("Search by Month");
        searchByMonth.setBounds(350,20,150,25);
        add(searchByMonth);

        monthChoice = new Choice();
        monthChoice.setBounds(500,20,100,25);
        add(monthChoice);
        monthChoice.add("January");
        monthChoice.add("February");
        monthChoice.add("March");
        monthChoice.add("April");
        monthChoice.add("May");
        monthChoice.add("June");
        monthChoice.add("July");
        monthChoice.add("August");
        monthChoice.add("September");
        monthChoice.add("October");
        monthChoice.add("November");
        monthChoice.add("December");


        table = new JTable();
        try{

            database d = new database();

            ResultSet resultSet = d.statement.executeQuery("select * from bill");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error "+e.getMessage());
            e.printStackTrace();
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0,100,700,500);
        scrollPane.setBackground(Color.WHITE);
        add(scrollPane);

        search = new JButton("Search");
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);

        search.setBounds(20,70,100,20);
        add(search);
        search.addActionListener(this);

        print = new JButton("Print");
        print.setBackground(Color.BLACK);
        print.setForeground(Color.WHITE);

        print.setBounds(140,70,100,20);
        add(print);
        print.addActionListener(this);

        close = new JButton("Close");
        close.setBackground(Color.BLACK);
        close.setForeground(Color.WHITE);

        close.setBounds(550,70,100,20);
        add(close);
        close.addActionListener(this);





        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search){

            String query_search = "select * from bill where meter_no = '"+meterNoCho.getSelectedItem()+"' and month = '"+monthChoice.getSelectedItem()+"' ";



            try {
                database d = new database();

                ResultSet resultSet = d.statement.executeQuery(query_search);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (e.getSource()==print) {

            try {
                table.print();
            }
            catch (Exception ex){
                ex.printStackTrace();
            }


        } else if (e.getSource() == close) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new deposit_details();
    }
}
