import java.util.ArrayList;

public class Ticket extends Train {
    ArrayList<Passenger> passengerList = new ArrayList<Passenger>();
    String seatClass;
    public Ticket(String src, String dest, String trainName, String trainNo, String time, double sleeperFare,
            double sittingFare, String seatClass, ArrayList<Passenger> passengerList) {
        super(src, dest, trainName, trainNo, time, sleeperFare, sittingFare);
        this.seatClass = seatClass;
        this.passengerList = passengerList;
    }
}
