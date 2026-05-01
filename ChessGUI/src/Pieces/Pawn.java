package Pieces;

import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import ChessBoard.Board;

public class Pawn extends Piece{
    public Pawn (Board board, int col, int row, boolean isWhite) {
        super(board, col, row, isWhite);
        this.pieceName = "Pawn";
        if (isWhite == true){
            BufferedImage sub = sheet.getSubimage(5 * sheetScale, 0, sheetScale, sheetScale);
            this.icon = new ImageIcon(sub.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        }
        else {
            BufferedImage sub = sheet.getSubimage(5 * sheetScale, sheetScale, sheetScale, sheetScale);
            this.icon = new ImageIcon(sub.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        }
    }

    @Override
    public boolean isValidMove(int targetCol, int targetRow) {
        if (!super.isValidMove(targetCol, targetRow)) {
            return false;
        }
        int direction = isWhite ? -1 : 1;

        // FORWARD
        if (targetCol == col && targetRow == row + direction && board.getPiece(targetCol, targetRow) == null) {
            return true;
        }

        // FIRST MOVE FORWARD CAN BE 2 SQUARES
        if (isFirstMove && targetCol == col && targetRow == row + (direction * 2) 
            && board.getPiece(targetCol, targetRow) == null 
            && board.getPiece(targetCol, row + direction) == null) {
            return true;
        }

        // DiAGONAL CAPTuRES
        if (Math.abs(targetCol - col) == 1 && targetRow == row + direction) {
            Piece targetPiece = board.getPiece(targetCol, targetRow);
            if (targetPiece != null && targetPiece.isWhite != this.isWhite) {
                return true;
            }
        }
        return false;
    }
}