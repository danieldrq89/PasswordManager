package core;

import core.manager.CryptoManager;
import core.manager.XmlManager;
import core.model.LoginUser;
import core.model.LoginUserList;
import core.model.VaultEntry;
import core.model.VaultEntryList;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

public class DatabaseChecker {
    private static final String DB_LOGIN_PATH = "database_login.xml";
    private static final String DB_VAULT_PATH = "database_vault.xml";

    static VaultEntryList vaultEntryList;
    static LoginUserList loginUserList;

    public static void checkDatabase() {

        //LOGIN


        loginUserList = new LoginUserList();
        Path path_login = Paths.get(DB_LOGIN_PATH);


        if (!Files.exists(path_login)) {
            try {

                LoginUser rootUser = new LoginUser(CryptoManager.encrypt("root"), CryptoManager.encrypt("root"));
                loginUserList.addUser(rootUser);
                XmlManager.write(loginUserList, DB_LOGIN_PATH);

                System.out.println("Base de datos para logins creada con éxito en: " + path_login.toAbsolutePath());
            } catch (Exception e) {
                System.err.println("Error crítico al crear la base de datos login : " + e.getMessage());
                System.exit(1);
            }
        }

        // VAULT


        Path path_vault = Paths.get(DB_VAULT_PATH);
        if (!Files.exists(path_vault)) {
            vaultEntryList = new VaultEntryList();
            try {
                VaultEntry vaultEntryTest = new VaultEntry(CryptoManager.encrypt("test.com"), CryptoManager.encrypt("test"), CryptoManager.encrypt("test"));
                vaultEntryList.addVault(vaultEntryTest);

                XmlManager.write(vaultEntryList, DB_VAULT_PATH);
                System.out.println("DB Vaults creada: " + path_vault.toAbsolutePath());
            } catch (Exception e) {
                System.err.println("Error en vaults DB: " + e.getMessage());
                System.exit(1);
            }

        }
    }


}