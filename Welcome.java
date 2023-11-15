import javax.swing.JFrame;
import javax.swing.JLabel;

public class Welcome {
    JFrame jFrame;
    JLabel welcomeLabel = new JLabel("WELCOME!");

    Welcome(JFrame jFrame){
        this.jFrame = jFrame;
        welcomeLabel.setBounds(0, 0, 200, 35);
        
        jFrame.add(welcomeLabel);
        // jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // jFrame.setSize(420, 420);
        // jFrame.setLayout(null);
        jFrame.setVisible(true);
    }
}