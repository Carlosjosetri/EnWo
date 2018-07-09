package EnWo;

import EnWo.vista.LogIn;
import EnWo.game.Gui;

public class EnWo {

    /**
     * @param args the command line arguments
     */
    public static void main(String... args) throws InterruptedException {
//        Gui.jugar();
        new LogIn().setVisible(true);
    }

}
