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

public class Register implements ActionListener{
    Credentials credentials;
    HashMap<String, String> loginCredentials;

    JFrame jFrame;
    JLabel titleLabel = new JLabel("Sign UP!");
    JLabel userNameLabel = new JLabel("Username");
    JTextField userName = new JTextField();
    JLabel emailLabel = new JLabel("Email");
    JTextField email = new JTextField();
    JLabel userPasswordLabel = new JLabel("Password");
    JPasswordField userPassword = new JPasswordField();
    JLabel userConfirmPasswordLabel = new JLabel("Repeat Password");
    JPasswordField userConfirmPassword = new JPasswordField();
    JButton registerButton = new JButton("Register");
    JButton resetButton = new JButton("Reset");
    JButton loginButton = new JButton("Login?");
    JLabel messageLabel = new JLabel("test message");

    public Register(JFrame jFrame, Credentials credentials){
        this.credentials = credentials;
        this.jFrame = jFrame;

        titleLabel.setBounds(100, 25, 200, 50);
        titleLabel.setFont(new Font(null, Font.BOLD, 40));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        userNameLabel.setBounds(50, 100, 120, 25);
        userName.setBounds(175, 100, 200, 35);
        userName.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));//to remove the border around the textField and add padding

        emailLabel.setBounds(50, 150, 120, 25);
        email.setBounds(175, 150, 200, 35);
        email.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        userPasswordLabel.setBounds(50, 200, 120, 25);
        userPassword.setBounds(175, 200, 200, 35);
        userPassword.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        userConfirmPasswordLabel.setBounds(50, 250, 120, 25);
        userConfirmPassword.setBounds(175, 250, 200, 35);
        userConfirmPassword.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        registerButton.setBounds(50, 300, 100, 35);
        registerButton.addActionListener(this);
        registerButton.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        registerButton.setBackground(new Color(102, 178, 255));
        registerButton.setForeground(Color.WHITE);
        registerButton.setFocusable(false); //removes dotted outline around button text

        resetButton.setBounds(155, 300, 100, 35);
        resetButton.addActionListener(this);
        resetButton.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        resetButton.setBackground(new Color(255, 102, 178));
        resetButton.setForeground(Color.WHITE);
        resetButton.setFocusable(false); 

        loginButton.setBounds(260, 300, 100, 35);
        loginButton.addActionListener(this);
        loginButton.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        loginButton.setBackground(new Color(204, 153, 255));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusable(false); 

        messageLabel.setBounds(100, 340, 200, 35);
        messageLabel.setVisible(false);
        messageLabel.setFont(new Font(null, Font.BOLD, 14));
        messageLabel.setOpaque(true);//to add background to JLabel
        messageLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        messageLabel.setHorizontalAlignment(JLabel.CENTER);
        
        jFrame.add(titleLabel);
        jFrame.add(userNameLabel);
        jFrame.add(userName);
        jFrame.add(emailLabel);
        jFrame.add(email);
        jFrame.add(userPasswordLabel);
        jFrame.add(userPassword);
        jFrame.add(userConfirmPasswordLabel);
        jFrame.add(userConfirmPassword);
        jFrame.add(registerButton);
        jFrame.add(resetButton);
        jFrame.add(loginButton);
        jFrame.add(messageLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == resetButton){
            userName.setText("");
            email.setText("");
            userPassword.setText("");
            userConfirmPassword.setText("");
        }
        else if(e.getSource() == registerButton){
            String user = userName.getText();
            String pwd1 = String.valueOf(userPassword.getPassword());//because it's a password
            String pwd2 = String.valueOf(userConfirmPassword.getPassword());
            loginCredentials = credentials.getLoginCredentials();
            System.out.println(user + " " + pwd1 + " " + pwd2);

            if(loginCredentials.containsKey(user)){
                messageLabel.setVisible(true);
                messageLabel.setForeground(Color.WHITE);
                messageLabel.setBackground(Color.RED);
                messageLabel.setText("User already EXISTS!!");
            }
            else{
                if(!pwd1.equals(pwd2)){
                    messageLabel.setVisible(true);
                    messageLabel.setForeground(Color.WHITE);
                    messageLabel.setBackground(Color.RED);
                    messageLabel.setText("Passwords MISMATCH!!");
                }
                else{
                    messageLabel.setVisible(true);
                    messageLabel.setForeground(Color.WHITE);
                    messageLabel.setBackground(Color.RED);
                    messageLabel.setText("Registration SUCCESSFUL!!");
                    credentials.setLoginCredentials(user, pwd1);
                    System.out.println(credentials.getLoginCredentials());
                    //removes all components present in the frame
                    jFrame.getContentPane().removeAll();
                    jFrame.repaint();
                    new Login(jFrame, credentials);
                }
            }
        }
        else if(e.getSource() == loginButton){
            jFrame.getContentPane().removeAll();
            jFrame.repaint();
            new Login(jFrame, credentials);
        }
    }

}