package core.model;

import core.manager.CryptoManager;
import jakarta.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "users_database") // Nombre de la etiqueta raíz en el XML
@XmlAccessorType(XmlAccessType.FIELD)
public class LoginUserList {

    @XmlElement(name = "user")
    private List<LoginUser> users = new ArrayList<>();

    public LoginUserList() {}
    public List<LoginUser> getUsers() {
        return users;
    }

    public void addUser(LoginUser user) {
        this.users.add(user);
    }

    public Boolean defaultLogin(String username , String password) {

        String userEnc = CryptoManager.encrypt(username);
        String passEnc = CryptoManager.encrypt(password);

        return users.stream().anyMatch(user ->
                user.getUsername().equals(userEnc) &&
                        user.getPasswordHash().equals(passEnc)
        );
//                .filter(user -> user.getUsername().equals(username) && user.getPasswordHash().equals(password))
//                .findFirst();

    }
}