package core.model;

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
}