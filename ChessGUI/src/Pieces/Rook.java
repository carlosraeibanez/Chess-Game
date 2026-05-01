package Pieces;

import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import ChessBoard.Board;

public class Rook extends Piece{
    public Rook (Board board, int col, int row, boolean isWhite) {
        super(board, col, row, isWhite);
        this.pieceName = "Rook";

        if (isWhite == true){
            BufferedImage sub = sheet.getSubimage(4 * sheetScale, 0, sheetScale, sheetScale);
            this.icon = new ImageIcon(sub.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        }
        else {
            BufferedImage sub = sheet.getSubimage(4 * sheetScale, sheetScale, sheetScale, sheetScale);
            this.icon = new ImageIcon(sub.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        }
    }

    @Override
    public boolean isValidMove(int targetCol, int targetRow) {
        if (!super.isValidMove(targetCol, targetRow)) return false;
        if (col != targetCol && row != targetRow) return false;

        int colStep = Integer.compare(targetCol, col);
        int rowStep = Integer.compare(targetRow, row);

        for (int i = 1; i < Math.max(Math.abs(targetCol - col), Math.abs(targetRow - row)); i++) {
            if (board.getPiece(col + i * colStep, row + i * rowStep) != null) return false;
        }
        return true;
    }
}
