import java.util.ArrayList;
import java.util.Random;

public class Ticket extends Train {
    private ArrayList<Passenger> passengerList = new ArrayList<>();
    String seatClass;
    int PNRNumber;
    double totalFare;
    String date;
    public Ticket(String src, String dest, String trainName, String trainNo, String date, String time, double sleeperFare,
            double sittingFare, String seatClass) {
        super(src, dest, trainName, trainNo, time, sleeperFare, sittingFare);
        this.date = date;
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

    public int generatePNRNumber(){
        Random random = new Random();
        int pnrNumber =  1000000000 + random.nextInt(900000000);
        PNRNumber = pnrNumber;
        return pnrNumber;
    }
}
