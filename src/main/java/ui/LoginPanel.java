package ui;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {
    private JTextField userField;
    private JPasswordField passField;
    private JButton loginButton;

    public LoginPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(10, 10, 10, 10); // Margen entre componentes
        gbc.fill = GridBagConstraints.HORIZONTAL; // Que se expandan a lo ancho

        gbc.gridx = 0; // Columna 0
        gbc.gridy = 0; // Fila 0
        add(new JLabel("User:"), gbc);

        gbc.gridx = 1; // Columna 1
        userField = new JTextField(15);
        add(userField, gbc);

        gbc.gridx = 0; // Columna 0
        gbc.gridy = 1; // Fila 1
        add(new JLabel("Password:"), gbc);

        gbc.gridx = 1; // Columna 1
        passField = new JPasswordField(15);
        add(passField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER; // Centrado
        gbc.fill = GridBagConstraints.NONE; // Que no se estire a lo ancho

        loginButton = new JButton("Log In");
        loginButton.setPreferredSize(new Dimension(120, 35));

        loginButton.addActionListener(e -> {
            String user = userField.getText();
            char[] password = passField.getPassword();
            System.out.println("Intentando login para: " + user);
        });

        add(loginButton, gbc);
    }
}