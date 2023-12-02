import java.util.ArrayList;

public class TrainInfo {
    private final ArrayList<Train> trainInfo = new ArrayList<>(){{
        add(new Train("CHENNAI EGMORE - MS (CHENNAI)", "DINDIGUL JN - DG (KODAIKANAL)", "TEJAS EXPRESS", "22671", "06:00 to 11:03", 0.00, 980.00));
        add(new Train("CHENNAI EGMORE - MS (CHENNAI)", "DINDIGUL JN - DG (KODAIKANAL)", "MS QLN EXPRESS", "16101", "17:00 to 23:02", 265.00, 720.00));
        add(new Train("CHENNAI EGMORE - MS (CHENNAI)", "DINDIGUL JN - DG (KODAIKANAL)", "PANDIAN SF EXP", "12637", "21:40 to 03:52", 295.00, 765.00));
        add(new Train("CHENNAI EGMORE - MS (CHENNAI)", "DINDIGUL JN - DG (KODAIKANAL)", "VAIGAI SF EXP", "12635", "13:50 to 20:05", 0.00, 180.00));
        add(new Train("CHENNAI EGMORE - MS (CHENNAI)", "DINDIGUL JN - DG (KODAIKANAL)", "POTHIGAI SF EXP", "12661", "20:40 to 02:57", 295.00, 765.00));
        add(new Train("CHENNAI EGMORE - MS (CHENNAI)", "DINDIGUL JN - DG (KODAIKANAL)", "MS GURUVAYUR EXP", "16127", "09:45 to 16:25", 0.00, 165.00));
        add(new Train("DINDIGUL JN - DG (KODAIKANAL)", "CHENNAI EGMORE - MS (CHENNAI)", "TEJAS EXPRESS", "22672", "15:47 to 21:15", 0.00, 1140.00));
        add(new Train("DINDIGUL JN - DG (KODAIKANAL)", "CHENNAI EGMORE - MS (CHENNAI)", "VAIGAI SF EXP", "12636", "07:35 to 14:10", 0.00, 180.00));
        add(new Train("DINDIGUL JN - DG (KODAIKANAL)", "CHENNAI EGMORE - MS (CHENNAI)", "PANDIAN SF EXP", "12638", "22:20 to 05:10", 295.00, 765.00));
        add(new Train("DINDIGUL JN - DG (KODAIKANAL)", "CHENNAI EGMORE - MS (CHENNAI)", "QLN MS EXPRESS", "16102", "20:00 to 03:05", 265.00, 720.00));
        add(new Train("DINDIGUL JN - DG (KODAIKANAL)", "CHENNAI EGMORE - MS (CHENNAI)", "POTHIGAI SF EXP", "12662", "22:35 to 05:40", 295.00, 765.00));
        add(new Train("DINDIGUL JN - DG (KODAIKANAL)", "CHENNAI EGMORE - MS (CHENNAI)", "GUV CHENNAI EXP", "16128", "13:20 to 20:35", 165.00, 265.00));
        add(new Train("DINDIGUL JN - DG (KODAIKANAL)", "MGR CHENNAI CTL - MAS (CHENNAI)", "PGT MAS EXPRESS", "22652", "19:40 to 04:05", 325.00, 190.00));
        add(new Train("MGR CHENNAI CTL - MAS (CHENNAI)", "DINDIGUL JN - DG (KODAIKANAL)", "MAS PGT EXPRESS", "22651", "21:40 to 06:00", 325.00, 190.00));
        add(new Train("MGR CHENNAI CTL - MAS (CHENNAI)", "DINDIGUL JN - DG (KODAIKANAL)", "MAS BDNK SF EXP", "20601", "22:30 to 05:57", 325.00, 835.00));
    }};

    public ArrayList<Train> getTrainInfo(){
        return trainInfo;
    }
}
