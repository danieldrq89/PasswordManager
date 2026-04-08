package ui;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class MainWindow extends JFrame {

    public MainWindow() {
        setTitle("Mi Gestor de Contraseñas");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        PasswordManager passwordManager = new PasswordManager();
        add(passwordManager);

        LoginPanel panelLogin = new LoginPanel();
        add(panelLogin);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainWindow m = new MainWindow();
            m.setVisible(true);
        });
    }

    public void mostrarGestor() {
        getContentPane().removeAll();
        add(new PasswordManager());
        revalidate();
        repaint();
    }
}