package ui;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    public MainWindow() {
        setTitle("Mi Gestor de Contraseñas");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        LoginPanel panelLogin = new LoginPanel();
        add(panelLogin);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainWindow m = new MainWindow();
            m.setVisible(true);
        });
    }
}