package electricity.billing.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class deposite_details extends JFrame {

    JButton search;
    Choice meterNoCho,nameCho;
    JTable table;
    deposite_details(){
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
            ResultSet rs = d.statement.executeQuery("select * from new_cust");
            while (rs.next()){
                meterNoCho.add(rs.getString("meter_no"));
            }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error "+e.getMessage());
            e.printStackTrace();

        }

        JLabel searchByName = new JLabel("Search by meter Name");
        searchByName.setBounds(350,20,150,25);
        add(searchByName);

        nameCho = new Choice();
        nameCho.setBounds(500,20,100,25);
        add(nameCho);

        try{
            database d =new database();
            ResultSet rs = d.statement.executeQuery("select * from new_cust");
            while (rs.next()){
                nameCho.add(rs.getString("name"));
            }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error "+e.getMessage());
            e.printStackTrace();

        }

        table = new JTable();
        try{

            database d = new database();

            ResultSet resultSet = d.statement.executeQuery("select * from new_cust");
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





        setVisible(true);

    }

    public static void main(String[] args) {
        new deposite_details();
    }
}
