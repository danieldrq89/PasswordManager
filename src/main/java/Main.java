import core.DatabaseChecker;
import ui.MainWindow;

public class Main {
    public static void main(String[] args) {
        DatabaseChecker.checkDatabase();
        MainWindow.main(null);
    }
}