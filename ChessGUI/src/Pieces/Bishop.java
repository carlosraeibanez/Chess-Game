package Pieces;

import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import ChessBoard.Board;

public class Bishop extends Piece{
    public Bishop (Board board, int col, int row, boolean isWhite) {
        super(board, col, row, isWhite);
        this.pieceName = "Bishop";

        if (isWhite == true){
            BufferedImage sub = sheet.getSubimage(2 * sheetScale, 0, sheetScale, sheetScale);
            this.icon = new ImageIcon(sub.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        }
        else {
            BufferedImage sub = sheet.getSubimage(2 * sheetScale, sheetScale, sheetScale, sheetScale);
            this.icon = new ImageIcon(sub.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        }
    }

    @Override
    public boolean isValidMove(int targetCol, int targetRow) {
        if (!super.isValidMove(targetCol, targetRow)) return false;
        if (Math.abs(targetCol - col) != Math.abs(targetRow - row)) return false;

        int colStep = (targetCol > col) ? 1 : -1;
        int rowStep = (targetRow > row) ? 1 : -1;

        for (int i = 1; i < Math.abs(targetCol - col); i++) {
            if (board.getPiece(col + i * colStep, row + i * rowStep) != null) return false;
        }
        return true;
    }
}
