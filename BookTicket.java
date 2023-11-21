import java.awt.Color;
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
import javax.swing.border.EmptyBorder;

public class BookTicket implements ActionListener {
    TrainInfo t = new TrainInfo();
    ArrayList<Train> trainInfo = t.getTrainInfo();

    JFrame jFrame;
    JLabel userLabel = new JLabel("Hello user!");
    JLabel titleLabel = new JLabel("RESERVE!");

    String stations[] = { "DINDIGUL JN - DG (KODAIKANAL)", "CHENNAI EGMORE - MS (CHENNAI)", "MGR CHENNAI CTL - MAS (CHENNAI)" };
    String trains[][] = {
        {"TEJAS EXPRESS", "MS QLN EXPRESS", "PANDIAN SF EXP", "VAIGAI SF EXP", "POTHIGAI SF EXP", "MS GURUVAYUR EXP", "QLN MS EXPRESS", "GUV CHENNAI EXP", "PGT MAS EXPRESS", "MAS PGT EXPRESS", "MAS BDNK SF EXP"},//trains that stop at Dindigul
        {"TEJAS EXPRESS", "MS QLN EXPRESS", "PANDIAN SF EXP", "VAIGAI SF EXP", "POTHIGAI SF EXP", "MS GURUVAYUR EXP", "QLN MS EXPRESS", "GUV CHENNAI EXP"}, //trains that stop at Egmore
        {"PGT MAS EXPRESS", "MAS PGT EXPRESS", "MAS BDNK SF EXP"} //trains that stop at Central
    };
    JLabel sourceLabel = new JLabel("From");
    JComboBox<String> source = new JComboBox<>(stations);
    JLabel destinationLabel = new JLabel("To");
    JComboBox<String> destination = new JComboBox<>(stations);
    JLabel trainNameLabel = new JLabel("TrainName");
    JComboBox<String> trainName = new JComboBox<>();

    // JLabel trainNoLabel = new JLabel("TrainNo");
    // String trainNos[] = {"22651", "22652"};
    // JComboBox<String> trainNo = new JComboBox<>(trainNos);
    // JLabel trainNameLabel = new JLabel("Train Name");
    // JLabel trainName = new JLabel(" ");
    // HashMap<String, String> trainNames = new HashMap<>(){{
    // put("22651", "PGT MAS");
    // put("22652", "PANDIAN MS");
    // }};

    public BookTicket(JFrame jFrame, String user) {
        this.jFrame = jFrame;

        userLabel.setText("Hello, " + user + "!");
        userLabel.setBounds(290, 10, 100, 25);
        userLabel.setOpaque(true);
        userLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        titleLabel.setBounds(100, 30, 200, 25);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        sourceLabel.setBounds(10, 60, 35, 30);
        source.setBounds(50, 60, 150, 30);
        source.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        source.setBackground(Color.WHITE);
        source.setFocusable(false);

        destinationLabel.setBounds(210, 60, 20, 30);
        destination.setBounds(240, 60, 150, 30);
        destination.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        trainNameLabel.setBounds(10, 100, 35, 30);
        trainName.setBounds(50, 100, 150, 30);
        trainName.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

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

        jFrame.add(userLabel);
        jFrame.add(titleLabel);
        jFrame.add(sourceLabel);
        jFrame.add(source);
        jFrame.add(destinationLabel);
        jFrame.add(destination);
        jFrame.add(trainNameLabel);
        jFrame.add(trainName);
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
