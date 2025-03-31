import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Login {
    // Store usernames and passwords
    private static HashMap<String, String> userDatabase = new HashMap<>();

    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("Login System");
        frame.setSize(350, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 2));

        // Create components
        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField();
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        JButton signUpButton = new JButton("Sign Up");
        JLabel resultLabel = new JLabel();

        // Add action listener for login
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputUsername = userField.getText();
                String inputPassword = new String(passField.getPassword());

                if (authenticate(inputUsername, inputPassword)) {
                    resultLabel.setText("Login successful!");
                } else {
                    resultLabel.setText("Invalid username or password.");
                }
            }
        });

        // Add action listener for sign up
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newUsername = userField.getText();
                String newPassword = new String(passField.getPassword());

                if (newUsername.isEmpty() || newPassword.isEmpty()) {
                    resultLabel.setText("Username or password cannot be empty.");
                } else if (userDatabase.containsKey(newUsername)) {
                    resultLabel.setText("Username already exists.");
                } else {
                    userDatabase.put(newUsername, newPassword);
                    resultLabel.setText("Sign up successful! You can now log in.");
                }
            }
        });

        // Add components to frame
        frame.add(userLabel);
        frame.add(userField);
        frame.add(passLabel);
        frame.add(passField);
        frame.add(loginButton);
        frame.add(signUpButton);
        frame.add(resultLabel);

        // Set frame visibility
        frame.setVisible(true);
    }

    // Authentication method
    private static boolean authenticate(String username, String password) {
        return userDatabase.containsKey(username) && userDatabase.get(username).equals(password);
    }
}