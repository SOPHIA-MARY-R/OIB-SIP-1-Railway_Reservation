import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Welcome implements ActionListener{
    Credentials credentials = new Credentials();
    JFrame jFrame = new JFrame();
    JLabel welcomeLabel = new JLabel("WELCOME!");
    JButton loginButton = new JButton("Login");
    JButton registerButton = new JButton("Register");

    public Welcome(){
        welcomeLabel.setBounds(100, 150, 200, 50);
        welcomeLabel.setFont(new Font(null, Font.BOLD, 30));
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        
        loginButton.setBounds(100, 220, 100, 35);
        loginButton.addActionListener(this);
        loginButton.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        loginButton.setBackground(new Color(102, 178, 255));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusable(false); //removes dotted outline around button text

        registerButton.setBounds(205, 220, 100, 35);
        registerButton.addActionListener(this);
        registerButton.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        registerButton.setBackground(new Color(255, 102, 178));
        registerButton.setForeground(Color.WHITE);
        registerButton.setFocusable(false); 

        jFrame.getContentPane().setBackground(Color.PINK);
        jFrame.add(welcomeLabel);
        jFrame.add(loginButton);
        jFrame.add(registerButton);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(420, 420);
        jFrame.setLayout(null);
        jFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginButton){
            jFrame.getContentPane().removeAll();
            jFrame.repaint();
            new Login(jFrame, credentials);
        }
        else if(e.getSource() == registerButton){
            jFrame.getContentPane().removeAll();
            jFrame.repaint();
            new Register(jFrame, credentials);
        }
    }
}