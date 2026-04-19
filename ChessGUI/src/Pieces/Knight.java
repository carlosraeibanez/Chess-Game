package Pieces;

import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import ChessBoard.Board;

public class Knight extends Piece{
    public Knight(Board board, int col, int row, boolean isWhite) {
    super(board, col, row, isWhite);
    this.pieceName = "Knight";
    
    BufferedImage sub = sheet.getSubimage(3 * sheetScale, isWhite ? 0 : sheetScale, sheetScale, sheetScale);
    this.icon = new ImageIcon(sub.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
}
}

