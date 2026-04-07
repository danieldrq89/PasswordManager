package core;

import core.manager.XmlManager;
import core.model.LoginUser;
import core.model.LoginUserList;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

public class DatabaseChecker {
    private static final String DB_PATH = "database.xml";
    static LoginUserList loginUserList;
    public static void checkDatabase() {
        loginUserList = new LoginUserList();
        Path path = Paths.get(DB_PATH);

        if (!Files.exists(path)) {
            try {
                Files.createFile(path);

                LoginUser rootUser = new LoginUser("root", "root");
                loginUserList.addUser(rootUser);
                XmlManager.write(loginUserList, "database.xml");

                System.out.println("Base de datos creada con éxito en: " + path.toAbsolutePath());
            } catch (IOException e) {
                System.err.println("Error crítico al crear la base de datos: " + e.getMessage());
                System.exit(1);
            }
        }
    }


}