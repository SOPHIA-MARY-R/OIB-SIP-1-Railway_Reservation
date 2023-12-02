import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class AddPassenger {
    JFrame jFrame;
    Ticket ticket;
    ArrayList<Passenger> passengerList = new ArrayList<>();

    JLabel titleLabel = new JLabel("ADD PASSENGERS");
    JLabel nameLabel = new JLabel("Name");
    JTextField name = new JTextField();
    JLabel genderLabel = new JLabel("Gender");
    JComboBox<String> gender = new JComboBox<>(new String[]{"Male", "Female", "Other"});
    JLabel ageLabel = new JLabel("Age");
    JSpinner age = new JSpinner(new SpinnerNumberModel(18, 1, 120, 1));
    JButton addButton = new JButton("ADD");
    //TABLE
    DefaultTableModel tableModel = new DefaultTableModel();
    JTable passengerTable = new JTable(tableModel);
    int serialNumber = 1;
    JButton bookButton = new JButton("Book");

    public AddPassenger(Ticket ticket, JFrame jFrame){
        this.ticket = ticket;
        this.jFrame = jFrame;

        titleLabel.setBounds(100, 20, 200, 20);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        nameLabel.setBounds(10, 60, 100, 20);
        name.setBounds(10, 85, 100, 30);
        name.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        name.setBackground(Color.WHITE);

        genderLabel.setBounds(120, 60, 100, 20);
        gender.setBounds(120, 85, 100, 30);
        gender.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        gender.setBackground(Color.WHITE);

        ageLabel.setBounds(230, 60, 100, 20);
        age.setBounds(230, 85, 100, 30);
        age.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        age.setBackground(Color.WHITE);

        addButton.setBounds(340, 85, 60, 30);
        addButton.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        addButton.setBackground(new Color(255, 102, 178));
        addButton.setForeground(Color.WHITE);
        addButton.setFocusable(false);

        tableModel.addColumn("SNo");
        tableModel.addColumn("Name");
        tableModel.addColumn("Gender");
        tableModel.addColumn("Age");

        for (int i = 0; i < gender.getComponentCount(); i++) {
            if (gender.getComponent(i) instanceof JComponent) {
                ((JComponent) gender.getComponent(i)).setBorder(new EmptyBorder(0, 0, 0, 0));
                gender.getComponent(i).setBackground(Color.WHITE);
            }
        }

        for (int i = 0; i < age.getComponentCount(); i++) {
            if (age.getComponent(i) instanceof JComponent) {
                ((JComponent) age.getComponent(i)).setBorder(new EmptyBorder(0, 0, 0, 0));
                age.getComponent(i).setBackground(Color.WHITE);
            }
        }

        addButton.addActionListener(e -> addPassenger());

        bookButton.addActionListener(e -> {
            ticket.setPassengerList(passengerList);
            jFrame.getContentPane().removeAll();
            jFrame.repaint();
            new DisplayTicket(ticket, jFrame);
        });

        JScrollPane tableScrollPane = new JScrollPane(passengerTable);
        tableScrollPane.setBounds(25, 150, 350, 150);
        tableScrollPane.getViewport().setBackground(Color.PINK);
        tableScrollPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        passengerTable.getTableHeader().setBackground(new Color(96, 96, 196));
        passengerTable.getTableHeader().setForeground(Color.WHITE);
        passengerTable.getTableHeader().setFont(new Font(null, Font.BOLD, 13));

        bookButton.setBounds(170, 340, 70, 30);
        bookButton.setBackground(new Color(0, 153, 153));
        bookButton.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        bookButton.setForeground(Color.WHITE);
        bookButton.setFocusable(false);

        jFrame.add(titleLabel);
        jFrame.add(nameLabel);
        jFrame.add(name);
        jFrame.add(genderLabel);
        jFrame.add(gender);
        jFrame.add(ageLabel);
        jFrame.add(age);
        jFrame.add(addButton);
        jFrame.add(tableScrollPane);
        jFrame.add(bookButton);
    }

    private void addPassenger(){
        String passengerName = name.getText();
        String passengerGender = (String) gender.getSelectedItem();
        int passengerAge = (int) age.getValue();
        passengerList.add(new Passenger(passengerName, passengerAge, passengerGender, serialNumber));

        Object[] rowData = {serialNumber, passengerName, passengerGender, passengerAge};
        tableModel.addRow(rowData);
        serialNumber++;

        name.setText("");
        gender.setSelectedIndex(0);
        age.setValue(18);
    }
}
