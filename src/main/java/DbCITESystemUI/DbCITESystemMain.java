
package DbCITESystemUI;

import DbCITESystemModels.*;
import java.awt.EventQueue;


public class DbCITESystemMain {
    
 public static void main(String[] args) {
        // TODO code application logic here
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                LoginPage loginPage = new LoginPage();
                loginPage.setVisible(true);

            }
        });
    }
}
