package App;

import view.LoginView;
import javax.swing.SwingUtilities;

public class App {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LoginView().setVisible(true);
            }
        });
    }
}
