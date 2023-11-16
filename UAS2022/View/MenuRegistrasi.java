package UAS2022.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import UAS2022.Controller.Controller;
import UAS2022.Model.CategoryUser;
import UAS2022.Model.User;

public class MenuRegistrasi {

    public MenuRegistrasi() {
        int x_fieldCoord = 100;
        JFrame mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(350, 400);
        mainFrame.setResizable(false);
        // mainFrame.setLayout(null);
        mainFrame.setTitle("Menu Login");
        mainFrame.setLayout(null);
        mainFrame.setLocationRelativeTo(null);

        ImageIcon logoImage = new ImageIcon("F:\\Praktikum PBO\\Latihan UAS\\LatUAS\\src\\UAS2022\\Images\\logo.png");
        JLabel logo = new JLabel(logoImage);
        logo.setBounds(0, 0, 250, 250);

        mainFrame.add(logo);

        JPanel regisForm = new JPanel(null);

        JLabel name = new JLabel("Name:");
        name.setBounds(10, 20, 80, 25);
        regisForm.add(name);

        JTextField nameField = new JTextField(20);
        nameField.setBounds(x_fieldCoord, 20, 165, 25);
        regisForm.add(nameField);

        JLabel email = new JLabel("Email:");
        email.setBounds(10, 50, 80, 25);
        regisForm.add(email);

        JTextField emailField = new JTextField(20);
        emailField.setBounds(x_fieldCoord, 50, 165, 25);
        regisForm.add(emailField);

        JLabel password = new JLabel("Password:");
        password.setBounds(10, 80, 80, 25);
        regisForm.add(password);

        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setBounds(x_fieldCoord, 80, 165, 25);
        regisForm.add(passwordField);

        JLabel categoryLabel = new JLabel("Kategori:");
        categoryLabel.setBounds(10, 110, 80, 25);
        regisForm.add(categoryLabel);

        ArrayList<CategoryUser> categories = Controller.getAllUserCategories();
        String[] strCategories = new String[categories.size()];
        for (int i = 0; i < strCategories.length; i++) {
            strCategories[i] = categories.get(i).getName();
        }
        JComboBox<String> category = new JComboBox<>(strCategories);
        regisForm.add(category);
        category.setBounds(x_fieldCoord, 110, 150, 25);

        JLabel userPhoto = new JLabel("Foto:");
        userPhoto.setBounds(10, 140, 80, 25);
        regisForm.add(userPhoto);

        JFileChooser fileChooser = new JFileChooser();
        JButton browseButton = new JButton("BROWSE...");
        browseButton.setBounds(x_fieldCoord, 140, 25, 25);
        regisForm.add(browseButton);

        JTextField photoPath = new JTextField(20);
        photoPath.setEnabled(false);
        photoPath.setBounds(140, 140, 100, 25);
        regisForm.add(photoPath);

        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    photoPath.setText(selectedFile.getAbsolutePath());
                }
            }
        });

        JButton back = new JButton("Kembali");
        back.setBounds(35, 185, 100, 25);
        regisForm.add(back);

        back.addActionListener(e -> {
            mainFrame.dispose();
            new MainMenu();
        });

        JButton registrationButton = new JButton("REGISTRASI");
        registrationButton.setBounds(145, 185, 120, 25);
        regisForm.add(registrationButton);

        registrationButton.addActionListener(e -> {
            if (emailField.getText().isBlank() || passwordField.getPassword().length == 0
                    || nameField.getText().isBlank() || photoPath.getText().isBlank()) {
                JOptionPane.showMessageDialog(mainFrame, "Pastikan field-field sudah terisi", "WARNING",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    User newUser = new User(Controller.generateUserID(),
                            Controller.getIdCategory(category.getSelectedItem().toString()), nameField.getText(),
                            photoPath.getText(), emailField.getText(), String.valueOf(passwordField.getPassword()));
                    System.out.println(newUser.toString());
                    Controller.insertNewUser(newUser);
                    JOptionPane.showMessageDialog(mainFrame, "Registrasi Sukses", "LOGIN",
                            JOptionPane.INFORMATION_MESSAGE);
                    mainFrame.dispose();
                    new MainMenu();
                } catch (Exception e1) {
                    JOptionPane.showConfirmDialog(mainFrame, "Telah terjadi kesalahan", "ERROR",
                            JOptionPane.ERROR_MESSAGE);
                    e1.printStackTrace();
                }
            }
        });

        regisForm.setBounds(25, 125, 400, 700);

        mainFrame.add(regisForm);
        mainFrame.setVisible(true);

    }
}
