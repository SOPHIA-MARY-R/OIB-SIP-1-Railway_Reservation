import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login implements ActionListener{
    HashMap<String, String> loginCredentials = new HashMap<>();

    JFrame jFrame = new JFrame();
    JLabel titleLabel = new JLabel("Sign IN!");
    JLabel userNameLabel = new JLabel("Username");
    JTextField userName = new JTextField();
    JLabel userPasswordLabel = new JLabel("Password");
    JPasswordField userPassword = new JPasswordField();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JLabel messageLabel = new JLabel("test message");

    Login(HashMap<String, String> loginCredentials){
        this.loginCredentials = loginCredentials;

        titleLabel.setBounds(100, 25, 200, 50);
        titleLabel.setFont(new Font(null, Font.BOLD, 40));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        userNameLabel.setBounds(50, 100, 90, 25);
        userName.setBounds(145, 100, 200, 35);
        userName.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));//to remove the border around the textField and add padding

        userPasswordLabel.setBounds(50, 150, 90, 25);
        userPassword.setBounds(145, 150, 200, 35);
        userPassword.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        loginButton.setBounds(100, 220, 100, 35);
        loginButton.addActionListener(this);
        loginButton.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        loginButton.setBackground(new Color(102, 178, 255));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusable(false); //removes dotted outline around button text

        resetButton.setBounds(205, 220, 100, 35);
        resetButton.addActionListener(this);
        resetButton.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        resetButton.setBackground(new Color(255, 102, 178));
        resetButton.setForeground(Color.WHITE);
        resetButton.setFocusable(false); 

        messageLabel.setBounds(100, 270, 200, 35);
        messageLabel.setVisible(false);
        messageLabel.setFont(new Font(null, Font.BOLD, 14));
        messageLabel.setOpaque(true);//to add background to JLabel
        messageLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        messageLabel.setHorizontalAlignment(JLabel.CENTER);

        // jFrame.getContentPane().setBackground(new Color(175, 205, 250));
        jFrame.getContentPane().setBackground(Color.PINK);
        jFrame.add(titleLabel);
        jFrame.add(userNameLabel);
        jFrame.add(userName);
        jFrame.add(userPasswordLabel);
        jFrame.add(userPassword);
        jFrame.add(loginButton);
        jFrame.add(resetButton);
        jFrame.add(messageLabel);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(420, 420);
        jFrame.setLayout(null);
        jFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == resetButton){
            userName.setText("");
            userPassword.setText("");
        }
        if(e.getSource() == loginButton){
            String user = userName.getText();
            String pwd = String.valueOf(userPassword.getPassword());//cause it's a password

            if(loginCredentials.containsKey(user)){
                if(loginCredentials.get(user).equals(pwd)){
                    messageLabel.setVisible(true);
                    messageLabel.setForeground(Color.WHITE);
                    messageLabel.setBackground(new Color(0, 153, 0));
                    messageLabel.setText("Login SUCCESSFULL!!");

                    //removes all components present in the frame
                    jFrame.getContentPane().removeAll();
                    
                    jFrame.repaint();
                    new Welcome(jFrame); //opens welcome page in the same frame
                    // jFrame.dispose(); //clears the frame
                }
                else{
                    messageLabel.setVisible(true);
                    messageLabel.setForeground(Color.WHITE);
                    messageLabel.setBackground(Color.RED);
                    messageLabel.setText("WRONG Password!!");
                }
            }
            else{
                messageLabel.setVisible(true);
                messageLabel.setForeground(Color.WHITE);
                messageLabel.setBackground(Color.RED);
                messageLabel.setText("User NOT FOUND!!");
            }
        }
    }

}