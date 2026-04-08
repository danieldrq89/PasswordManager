package ui;

import core.manager.CryptoManager;
import core.manager.XmlManager;
import core.model.VaultEntry;
import core.model.VaultEntryList;
import ui.PasswordManager;

import javax.swing.*;
import java.awt.*;

public class AddVaultPanel {

    public static void mostrarFormulario(PasswordManager parent, VaultEntryList vaultEntryList,String DB_PATH_VAULTS) {
        // Creamos el panel temporal
        JPanel panelForm = new JPanel(new GridLayout(3, 2, 10, 10));

        JTextField txtUrl = new JTextField();
        JTextField txtUser = new JTextField();
        JPasswordField txtPass = new JPasswordField();

        panelForm.add(new JLabel("URL/Sitio:"));
        panelForm.add(txtUrl);
        panelForm.add(new JLabel("Usuario:"));
        panelForm.add(txtUser);
        panelForm.add(new JLabel("Contraseña:"));
        panelForm.add(txtPass);

        int result = JOptionPane.showConfirmDialog(parent, panelForm,
                "Añadir Nueva Credencial", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String url = CryptoManager.encrypt(txtUrl.getText().trim());
            String user = CryptoManager.encrypt(txtUser.getText().trim());
            String pass = CryptoManager.encrypt(new String(txtPass.getPassword()));



            if (!url.isEmpty() && !user.isEmpty() && !pass.isEmpty()) {
                VaultEntry nuevaEntry = new VaultEntry(url, user, pass);
                vaultEntryList.getVaults().add(nuevaEntry);
                XmlManager.write(vaultEntryList, DB_PATH_VAULTS);
                parent.refrescarDatos();
            }
        }
    }
}