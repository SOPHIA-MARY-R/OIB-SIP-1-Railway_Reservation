public class Train {
    String src, dest, trainName, trainNo, time;
    double sleeperFare, sittingFare;

    public Train(String src, String dest, String trainName, String trainNo, String time, double sleeperFare, double sittingFare){
        this.src = src;
        this.dest = dest;
        this.trainName = trainName;
        this.trainNo = trainNo;
        this.time = time;
        this.sittingFare = sittingFare;
        this.sleeperFare = sleeperFare;
    }
}
