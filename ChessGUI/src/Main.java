import javax.swing.SwingUtilities;

import ChessBoard.*;

public class Main {
    public static void main (String args []){
        SwingUtilities.invokeLater(() -> new Board());
    }
}
