package core.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class VaultEntry {
    @XmlElement(name = "site_url")
    private String url;

    @XmlElement(name = "username")
    private String username;

    @XmlElement(name = "password")
    private String password;

    public VaultEntry (){}

    public VaultEntry(String url , String username, String password) {
        this.password = password;
        this.url = url;
        this.username = username;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
