import javax.swing.JFrame;

public class DisplayTicket {
    Ticket ticket;
    JFrame jFrame;

    public DisplayTicket(Ticket ticket, JFrame jFrame){
        this.ticket = ticket;
        this.jFrame = jFrame;
        
        System.out.println();
        System.out.println(ticket.src);
        System.out.println(ticket.dest);
        System.out.println(ticket.trainName);
        System.out.println(ticket.trainNo);
        System.out.println(ticket.time);
        System.out.println(ticket.PNRNumber);
        System.out.println(ticket.seatClass);
        for(Passenger passenger : ticket.getPassengerList()){
            System.out.println(passenger.name + " " + passenger.gender + " " + passenger.age);
        }
        System.out.println(ticket.sleeperFare);
        System.out.println(ticket.sittingFare);
        System.out.println(ticket.calculateTotalFare());
        System.out.println();
    }
}
