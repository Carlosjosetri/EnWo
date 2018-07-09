package EnWo;

import EnWo.game.Gui;
import EnWo.vista.SignUp;

public class EnWo {

    /**
     * @param args the command line arguments
     */
    public static void main(String... args) throws InterruptedException {
//        Gui.jugar();
        new SignUp().setVisible(true);
    }

}
