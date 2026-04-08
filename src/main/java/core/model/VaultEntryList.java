package core.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "vaults_database")
@XmlAccessorType(XmlAccessType.FIELD)
public class VaultEntryList {
    @XmlElement(name = "vault")
    private List<VaultEntry> vaults = new ArrayList<>();

    public VaultEntryList(){};

    public List<VaultEntry> getVaults() {
        return vaults;
    }

    public void addVault(VaultEntry vault) {
        this.vaults.add(vault);
    }
}
