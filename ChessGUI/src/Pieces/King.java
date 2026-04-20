package Pieces;

import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import ChessBoard.Board;

public class King extends Piece{
        public King (Board board, int col, int row, boolean isWhite) {
        super(board, col, row, isWhite);
        this.pieceName = "King";

        if (isWhite == true){
            BufferedImage sub = sheet.getSubimage(0, 0, sheetScale, sheetScale);
            this.icon = new ImageIcon(sub.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        }
        else {
            BufferedImage sub = sheet.getSubimage(0, sheetScale, sheetScale, sheetScale);
            this.icon = new ImageIcon(sub.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        }
    }


}
