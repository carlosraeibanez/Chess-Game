

import javax.swing.SwingUtilities;

import ChessBoard.Board;

public class Main {
    public static void main (String args []){
        SwingUtilities.invokeLater(() -> new Board());
    }
}
