import java.util.ArrayList;

public class Ticket extends Train {
    private ArrayList<Passenger> passengerList = new ArrayList<Passenger>();
    String seatClass;
    Long PNRNumber;
    double totalFare;
    public Ticket(String src, String dest, String trainName, String trainNo, String time, double sleeperFare,
            double sittingFare, String seatClass) {
        super(src, dest, trainName, trainNo, time, sleeperFare, sittingFare);
        this.seatClass = seatClass;
    }

    public void setPassengerList(ArrayList<Passenger> passengerList){
        this.passengerList = passengerList;
    }

    public ArrayList<Passenger> getPassengerList(){
        return passengerList;
    }

    public double calculateTotalFare(){
        if(seatClass.equals("SLEEPER")){
            totalFare = passengerList.size() * sleeperFare;
        }
        else{
            totalFare = passengerList.size() * sittingFare;
        }
        return totalFare;
    }
}
