package ui;

import core.DatabaseChecker;
import core.manager.CryptoManager;
import core.manager.XmlManager;
import core.model.VaultEntry;
import core.model.VaultEntryList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


public class PasswordManager extends JPanel {
    static final String DB_PATH_VAULTS = "database_vault.xml";
    private static  VaultEntryList vaultEntryList ;
    private DefaultTableModel modelo;
    public PasswordManager() {
        vaultEntryList = new VaultEntryList();
        vaultEntryList = XmlManager.read(vaultEntryList.getClass(),DB_PATH_VAULTS);

        setLayout(new BorderLayout());

        JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton btnAñadir = new JButton("Añadir Nueva");


        JButton btnRefrescar = new JButton("Refrescar");


        JButton btnEliminar = new JButton("Eliminar");

        panelSuperior.add(btnAñadir);
        panelSuperior.add(btnRefrescar);
        panelSuperior.add(btnEliminar);
        add(panelSuperior, BorderLayout.NORTH);

        String[] columnas = {"Sitio Web", "Usuario", "Contraseña"};
        Object[][] datos = {
        };

        modelo = new DefaultTableModel(datos, columnas);
        JTable tabla = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tabla);

        add(scrollPane, BorderLayout.CENTER);

        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelInferior.add(new JLabel("Made by Daniel de la Rosa"));
        add(panelInferior, BorderLayout.SOUTH);


        btnEliminar.addActionListener(e -> {
            int fila = tabla.getSelectedRow();

            deleteFromIndex(fila);

            refrescarDatos();
        });

        btnRefrescar.addActionListener(e -> {
            refrescarDatos();
        });

        btnAñadir.addActionListener(e -> {
            AddVaultPanel.mostrarFormulario(this,vaultEntryList,DB_PATH_VAULTS);
        });

        refrescarDatos();
    }

    public  void refrescarDatos() {

        vaultEntryList = XmlManager.read(vaultEntryList.getClass(),DB_PATH_VAULTS);

        modelo.setRowCount(0);

        for(VaultEntry entry : vaultEntryList.getVaults()) {
            Object[] fila = {
                    CryptoManager.decrypt(entry.getUrl()),
                    CryptoManager.decrypt(entry.getUsername()),
                    CryptoManager.decrypt(entry.getPassword())
            };
            modelo.addRow(fila);
        }



        System.out.println();
    }

    public static void deleteFromIndex(int index) {
        vaultEntryList.getVaults().remove(index);
        XmlManager.write(vaultEntryList,DB_PATH_VAULTS);

        System.out.println("Deleted index:" + index);
    }

}
