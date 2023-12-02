import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class DisplayTicket {
    Ticket ticket;
    JFrame jFrame;

    JLabel titleLabel = new JLabel("TICKET");
    JLabel arrivalLabel = new JLabel("Arrival");
    JLabel arrival = new JLabel();
    JLabel departureLabel = new JLabel("Departure");
    JLabel departure = new JLabel();
    JLabel dateAndTime = new JLabel();
    JLabel pnrLabel = new JLabel("PNR");
    JLabel pnr = new JLabel();
    JLabel trainNoTrainNameLabel = new JLabel("Train No./Train Name");
    JLabel trainNoTrainName = new JLabel();
    JLabel classLabel = new JLabel("Class");
    JLabel seatClass = new JLabel();
    JLabel passengerDetailsLabel = new JLabel("Passenger Details");
    JLabel sNoLabel = new JLabel("#");
    JLabel nameLabel = new JLabel("Name");
    JLabel genderLabel = new JLabel("Gender");
    JLabel ageLabel = new JLabel("Age");
    JLabel statusLabel = new JLabel("Booking Status");
    JLabel seatNoLabel = new JLabel("Seat No");
    JLabel paymentDetailsLabel = new JLabel("Payment Details");
    JLabel ticketFareLabel = new JLabel("Ticket Fare (Rs.)");
    JLabel totalFareLabel = new JLabel("Total Fare (Rs.)");
    JLabel ticketFare = new JLabel();
    JLabel totalFare = new JLabel();
    JButton cancelButton = new JButton("Cancel Ticket");

    public DisplayTicket(Ticket ticket, JFrame jFrame){
        this.ticket = ticket;
        this.jFrame = jFrame;
        ArrayList<Passenger> passengerList = ticket.getPassengerList();
        jFrame.setSize(580, 600);
        jFrame.getContentPane().setBackground(new Color(255, 255, 240));

        titleLabel.setBounds(250, 20, 80, 20);
        titleLabel.setFont(new Font(null, Font.BOLD, 18));
        titleLabel.setForeground(new Color(220, 20, 60));

        arrivalLabel.setBounds(30, 50, 80, 20);
        arrivalLabel.setFont(new Font(null, Font.BOLD, 12));
        arrival.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        arrival.setBounds(30, 75, 250, 30);
        arrival.setText(ticket.src);
        arrival.setOpaque(true);
        arrival.setBackground(Color.PINK);

        departureLabel.setBounds(300, 50, 80, 20);
        departureLabel.setFont(new Font(null, Font.BOLD, 12));
        departure.setBounds(300, 75, 250, 30);
        departure.setOpaque(true);
        departure.setBackground(Color.PINK);
        departure.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        departure.setText(ticket.dest);

        dateAndTime.setBounds(180, 110, 250, 30);
        dateAndTime.setText("Date: " + ticket.date + " | Time: " + ticket.time);

        pnrLabel.setBounds(60, 150, 80, 30);
        pnr.setBounds(60, 180, 80, 30);
        pnr.setForeground(new Color(0, 153, 153));
        pnr.setText(String.valueOf(ticket.generatePNRNumber()));

        trainNoTrainNameLabel.setBounds(200, 150, 200, 30);
        trainNoTrainName.setBounds(200, 180, 200, 30);
        trainNoTrainName.setText(ticket.trainNo + " / " + ticket.trainName);
        trainNoTrainName.setForeground(new Color(0, 153, 153));

        classLabel.setBounds(440, 150, 80, 30);
        seatClass.setBounds(440, 180, 80, 30);
        seatClass.setText(ticket.seatClass);
        seatClass.setForeground(new Color(0, 153, 153));

        passengerDetailsLabel.setBounds(30, 220, 150, 30);
        passengerDetailsLabel.setForeground(new Color(58, 59, 60));
        passengerDetailsLabel.setFont(new Font(null, Font.BOLD, 15));

        sNoLabel.setBounds(30, 250, 20, 30);
        sNoLabel.setForeground(new Color(220, 20, 60));
        sNoLabel.setFont(new Font(null, Font.BOLD, 14));
        
        nameLabel.setBounds(50, 250, 100, 30);
        nameLabel.setForeground(new Color(220, 20, 60));
        nameLabel.setFont(new Font(null, Font.BOLD, 14));

        genderLabel.setBounds(200, 250, 100, 30);
        genderLabel.setForeground(new Color(220, 20, 60));
        genderLabel.setFont(new Font(null, Font.BOLD, 14));

        ageLabel.setBounds(300, 250, 50, 30);
        ageLabel.setForeground(new Color(220, 20, 60));
        ageLabel.setFont(new Font(null, Font.BOLD, 14));

        statusLabel.setBounds(350, 250, 130, 30);
        statusLabel.setForeground(new Color(220, 20, 60));
        statusLabel.setFont(new Font(null, Font.BOLD, 14));

        seatNoLabel.setBounds(480, 250, 100, 30);
        seatNoLabel.setForeground(new Color(220, 20, 60));
        seatNoLabel.setFont(new Font(null, Font.BOLD, 14));

        int size = 280;
        String coach;
        double fare = 0.0;
        for(int index=0; index<passengerList.size(); index++){
            JLabel sNo = new JLabel(String.valueOf((index)+1));
            sNo.setBounds(30, size, 20, 30);
            jFrame.add(sNo);

            JLabel name = new JLabel(passengerList.get(index).name);
            name.setBounds(50, size, 100, 30);
            jFrame.add(name);

            JLabel gender = new JLabel(passengerList.get(index).gender);
            gender.setBounds(200, size, 100, 30);
            jFrame.add(gender);

            JLabel age = new JLabel(String.valueOf(passengerList.get(index).age));
            age.setBounds(300, size, 50, 30);
            jFrame.add(age);
            
            JLabel status = new JLabel(passengerList.get(index).status);
            status.setBounds(350, size, 130, 30);
            jFrame.add(status);

            if(ticket.seatClass.equals("SLEEPER")){
                coach = "S1";
                fare = ticket.sleeperFare;
            }
            else{
                coach = "D1";
                fare = ticket.sittingFare;
            }

            JLabel seatNo = new JLabel(coach + " / " + passengerList.get(index).seatNo);
            seatNo.setBounds(480, size, 100, 30);
            jFrame.add(seatNo);

            size += 30;
        }
        size += 10;

        paymentDetailsLabel.setBounds(30, size, 150, 30);
        paymentDetailsLabel.setForeground(new Color(58, 59, 60));
        paymentDetailsLabel.setFont(new Font(null, Font.BOLD, 15));

        size += 40;
        ticketFareLabel.setBounds(30, size, 150, 10);
        ticketFare.setBounds(190, size, 80, 10);
        ticketFare.setText(String.valueOf(fare));
        ticketFare.setForeground(new Color(220, 20, 60));

        size += 30;
        totalFareLabel.setBounds(30, size, 150, 10);
        totalFare.setBounds(190, size, 80, 10);
        totalFare.setText(String.valueOf(ticket.calculateTotalFare()));
        totalFare.setForeground(new Color(220, 20, 60));

        size += 40;
        cancelButton.setBounds(200, size, 150, 40);
        cancelButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        cancelButton.setBackground(new Color(255, 0, 0));
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFocusable(false); 

        cancelButton.addActionListener(e -> {
            JOptionPane.showInputDialog(
                null,
                "Enter PNR Number of Ticket",
                "Are you sure to cancel the ticket?",
                JOptionPane.QUESTION_MESSAGE
            );
            new Welcome();
            jFrame.dispose();
        });

        jFrame.add(titleLabel);
        jFrame.add(arrivalLabel);
        jFrame.add(arrival);
        jFrame.add(departureLabel);
        jFrame.add(departure);
        jFrame.add(dateAndTime);
        jFrame.add(pnrLabel);
        jFrame.add(trainNoTrainNameLabel);
        jFrame.add(classLabel);
        jFrame.add(pnr);
        jFrame.add(trainNoTrainName);
        jFrame.add(seatClass);
        jFrame.add(passengerDetailsLabel);
        jFrame.add(sNoLabel);
        jFrame.add(nameLabel);
        jFrame.add(genderLabel);
        jFrame.add(ageLabel);
        jFrame.add(statusLabel);
        jFrame.add(seatNoLabel);
        jFrame.add(paymentDetailsLabel);
        jFrame.add(ticketFareLabel);
        jFrame.add(ticketFare);
        jFrame.add(totalFareLabel);
        jFrame.add(totalFare);
        jFrame.add(cancelButton);
    }
}
