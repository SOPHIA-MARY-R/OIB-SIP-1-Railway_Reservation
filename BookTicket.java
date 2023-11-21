import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;
/* JDateChooser Reference:- https://www.youtube.com/watch?v=9u2PgBf2jC4 */

public class BookTicket implements ActionListener {
    TrainInfo t = new TrainInfo();
    ArrayList<Train> trainInfo = t.getTrainInfo();

    JFrame jFrame;
    JLabel userLabel = new JLabel("Hello user!");
    JLabel titleLabel = new JLabel("RESERVE!");

    String stations[] = { "DINDIGUL JN - DG (KODAIKANAL)", "CHENNAI EGMORE - MS (CHENNAI)", "MGR CHENNAI CTL - MAS (CHENNAI)" };
    JLabel sourceLabel = new JLabel("From");
    JComboBox<String> source = new JComboBox<>(stations);
    JLabel destinationLabel = new JLabel("To");
    JComboBox<String> destination = new JComboBox<>(stations);
    JLabel trainNameLabel = new JLabel("TrainName");
    JComboBox<String> trainName = new JComboBox<>();
    JLabel trainNumberLabel = new JLabel("No");
    JTextField trainNumber = new JTextField();
    JLabel dateChooserLabel = new JLabel("JourneyDate");
    JDateChooser dateChooser = new JDateChooser();

    public BookTicket(JFrame jFrame, String user) {
        this.jFrame = jFrame;

        userLabel.setText("Hello, " + user + "!");
        userLabel.setBounds(290, 10, 100, 25);
        userLabel.setOpaque(true);
        userLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        titleLabel.setBounds(100, 30, 200, 25);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        sourceLabel.setBounds(40, 60, 80, 30);
        source.setBounds(120, 60, 250, 30);
        source.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        source.setBackground(Color.WHITE);      

        destinationLabel.setBounds(40, 100, 80, 30);
        destination.setBounds(120, 100, 250, 30);
        destination.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        destination.setBackground(Color.WHITE);

        trainNameLabel.setBounds(40, 140, 80, 30);
        trainName.setBounds(120, 140, 150, 30);
        trainName.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        trainName.setBackground(Color.WHITE);

        trainNumberLabel.setBounds(275, 140, 65, 30);
        trainNumber.setBounds(300, 140, 70, 30);
        trainNumber.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        trainNumber.setBackground(Color.WHITE);
        trainNumber.setEditable(false);

        dateChooserLabel.setBounds(40, 180, 80, 30);
        dateChooser.setBounds(120, 180, 250, 30);
        dateChooser.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        dateChooser.setBackground(Color.WHITE);

        for (int i = 0; i < source.getComponentCount(); i++) {
            if (source.getComponent(i) instanceof JComponent) {
                ((JComponent) source.getComponent(i)).setBorder(new EmptyBorder(0, 0, 0, 0));
                ((JComponent) source.getComponent(i)).setBackground(Color.WHITE);
            }
            if (source.getComponent(i) instanceof AbstractButton) {
                ((AbstractButton) source.getComponent(i)).setBorderPainted(false);
            }
        }
        for (int i = 0; i < destination.getComponentCount(); i++) {
            if (destination.getComponent(i) instanceof JComponent) {
                ((JComponent) destination.getComponent(i)).setBorder(new EmptyBorder(0, 0, 0, 0));
                ((JComponent) destination.getComponent(i)).setBackground(Color.WHITE);
            }
            if (destination.getComponent(i) instanceof AbstractButton) {
                ((AbstractButton) destination.getComponent(i)).setBorderPainted(false);
            }
        }
        for (int i = 0; i < trainName.getComponentCount(); i++) {
            if (trainName.getComponent(i) instanceof JComponent) {
                ((JComponent) trainName.getComponent(i)).setBorder(new EmptyBorder(0, 0, 0, 0));
                ((JComponent) trainName.getComponent(i)).setBackground(Color.WHITE);
            }
            if (trainName.getComponent(i) instanceof AbstractButton) {
                ((AbstractButton) trainName.getComponent(i)).setBorderPainted(false);
            }
        }
        for( Component text : dateChooser.getComponents()){
            ((JComponent)text).setBorder(new EmptyBorder(0, 0, 0, 0));
            ((JComponent)text).setBackground(Color.WHITE);
        }

        source.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                updateTrainNames();
            }
        });

        destination.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e){
                updateTrainNames();
            }
        });

        trainName.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e){
                updateTrainNumber();
            }
        });

        jFrame.add(userLabel);
        jFrame.add(titleLabel);
        jFrame.add(sourceLabel);
        jFrame.add(source);
        jFrame.add(destinationLabel);
        jFrame.add(destination);
        jFrame.add(trainNameLabel);
        jFrame.add(trainName);
        jFrame.add(trainNumberLabel);
        jFrame.add(trainNumber);
        jFrame.add(dateChooserLabel);
        jFrame.add(dateChooser);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    private void updateTrainNames(){
        String selectedSource = (String) source.getSelectedItem();
        String selectedDestination = (String) destination.getSelectedItem();
        System.out.println(selectedSource + " " + selectedDestination);
        trainName.removeAllItems();

        for(Train train : trainInfo){
            if(train.src.equals(selectedSource) && train.dest.equals(selectedDestination)){
                trainName.addItem(train.trainName);//first trainName is the JComboBox name and second trainName is one of teh attributes of the train class
            }
        }
    }    

    public void updateTrainNumber(){
        trainNumber.setText("");
        for(Train train : trainInfo){
            if(train.trainName.equals(String.valueOf(trainName.getSelectedItem()))){
                trainNumber.setText(train.trainNo);
                return;
            }
        }
    }

    // just for debugging purpose
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.getContentPane().setBackground(Color.PINK);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(420, 420);
        jFrame.setLayout(null);
        jFrame.setVisible(true);
        new BookTicket(jFrame, "Sophia");
    }
}
