import core.DatabaseChecker;
import core.manager.XmlManager;
import core.model.LoginUser;
import core.model.LoginUserList;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.annotation.XmlElement;
import ui.MainWindow;


public class Main {
    public static void main(String[] args) {
        DatabaseChecker.checkDatabase();
        MainWindow.main(null);
    }
}