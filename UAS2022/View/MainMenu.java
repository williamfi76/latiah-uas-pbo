package UAS2022.View;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MainMenu {
    
    public MainMenu() {
        JFrame mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(720, 640);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setTitle("Main Menu");
        mainFrame.setLayout(new GridLayout(0, 1));

        Font titleFont = new Font("Arial", Font.BOLD, 36);
        Font subTitleFont = new Font("Arial", Font.BOLD, 18);
        JLabel titlePage = new JLabel("MENU UTAMA", SwingConstants.CENTER);
        titlePage.setFont(titleFont);
        mainFrame.add(titlePage);
        JPanel buttonPanel = new JPanel();
        JButton loginButton = new JButton("LOGIN PENGGUNA");
        loginButton.setFont(subTitleFont);
        JButton registrationButton = new JButton("REGISTRASI PENGGUNA");
        registrationButton.setFont(subTitleFont);
        JButton searchButton = new JButton("LIHAT DATA PENGGUNA BERDASARKAN KATEGORI DIPILIH");
        searchButton.setFont(subTitleFont);
        buttonPanel.add(loginButton);
        buttonPanel.add(registrationButton);
        buttonPanel.add(searchButton);
        buttonPanel.setLayout(new GridLayout(0, 1));
        mainFrame.add(buttonPanel);

        registrationButton.addActionListener(e -> {
            new MenuRegistrasi();
            mainFrame.dispose();
        });

        loginButton.addActionListener(e -> {
            new MenuLogin();
            mainFrame.dispose();
        });

        // searchButton.addActionListener(e -> {
        //     mainFrame.dispose();
        // });

        mainFrame.setVisible(true);
    }
}
