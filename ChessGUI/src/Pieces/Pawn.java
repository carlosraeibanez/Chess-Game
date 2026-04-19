package Pieces;

import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import ChessBoard.Board;

public class Pawn extends Piece{
    public Pawn (Board board, int col, int row, boolean isWhite) {
        super(board, col, row, isWhite);
        this.pieceName = "Pawn";

        BufferedImage sub = sheet.getSubimage(5 * sheetScale, isWhite ? 0 : sheetScale, sheetScale, sheetScale);
        this.icon = new ImageIcon(sub.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
    }



}
