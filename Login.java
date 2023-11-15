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
    JLabel userNameLabel = new JLabel("Username");
    JTextField userName = new JTextField();
    JLabel userPasswordLabel = new JLabel("Password");
    JPasswordField userPassword = new JPasswordField();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JLabel messageLabel = new JLabel("test message");

    Login(HashMap<String, String> loginCredentials){
        this.loginCredentials = loginCredentials;

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

        resetButton.setBounds(205, 220, 100, 35);
        resetButton.addActionListener(this);
        resetButton.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        resetButton.setBackground(new Color(255, 102, 178));
        resetButton.setForeground(Color.WHITE);

        messageLabel.setBounds(125, 260, 250, 35);
        messageLabel.setFont(new Font(null, Font.ITALIC, 25));

        jFrame.getContentPane().setBackground(new Color(204, 255, 255));
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

}