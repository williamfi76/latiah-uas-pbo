package UAS2022.View;

import java.awt.HeadlessException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import UAS2022.Controller.Controller;

public class MenuLogin {
    public MenuLogin() {
        JFrame mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(350, 350);
        mainFrame.setResizable(false);
        // mainFrame.setLayout(null);
        mainFrame.setTitle("Menu Login");
        mainFrame.setLayout(null);
        mainFrame.setLocationRelativeTo(null);

        ImageIcon logoImage = new ImageIcon("F:\\Praktikum PBO\\Latihan UAS\\LatUAS\\src\\UAS2022\\Images\\logo.png");
        JLabel logo = new JLabel(logoImage);
        logo.setBounds(0, 0, 250, 250);

        mainFrame.add(logo);

        JPanel loginForm = new JPanel(null);

        JLabel email = new JLabel("Email:");
        email.setBounds(10, 20, 80, 25);
        loginForm.add(email);

        JTextField emailField = new JTextField(20);
        emailField.setBounds(100, 20, 165, 25);
        loginForm.add(emailField);

        JLabel password = new JLabel("Password:");
        password.setBounds(10, 50, 80, 25);
        loginForm.add(password);

        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setBounds(100, 50, 165, 25);
        loginForm.add(passwordField);

        JButton back = new JButton("Kembali");
        back.setBounds(35, 95, 100, 25);
        loginForm.add(back);

        back.addActionListener(e -> {
            mainFrame.dispose();
            new MainMenu();
        });

        JButton loginButton = new JButton("LOGIN");
        loginButton.setBounds(145, 95, 100, 25);
        loginForm.add(loginButton);

        loginButton.addActionListener(e -> {
            if (emailField.getText().isBlank() || passwordField.getPassword().length == 0) {
                JOptionPane.showMessageDialog(mainFrame, "Pastikan kedua field sudah terisi", "WARNING",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    if (Controller.checkValidity(emailField.getText(), String.valueOf(passwordField.getPassword()))) {
                        mainFrame.dispose();
                        JOptionPane.showMessageDialog(mainFrame, "Login Sukses", "LOGIN",
                                JOptionPane.INFORMATION_MESSAGE);
                        new MainMenu();
                    } else {
                        JOptionPane.showMessageDialog(mainFrame, "Login GAGAL", "LOGIN",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } catch (HeadlessException e1) {
                    e1.printStackTrace();
                }
            }
        });

        loginForm.setBounds(25, 125, 400, 200);

        mainFrame.add(loginForm);
        mainFrame.setVisible(true);
    }
}
