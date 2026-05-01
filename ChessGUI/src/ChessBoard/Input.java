package ChessBoard;

import Pieces.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class Input extends MouseAdapter {
    Board board;
    private int startCol, startRow;

    public Input(Board board) {
        this.board = board;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int col = e.getX() / board.tileSize;
        int row = e.getY() / board.tileSize;
        
        Piece clickedPiece = board.getPiece(col, row);

        if (board.chosenPiece != null) {
            Move move = new Move(board, board.chosenPiece, col, row);
            
            if (board.chosenPiece.isValidMove(col, row)) {
                board.makeMove(move);
                board.chosenPiece = null;
            } else if (clickedPiece != null && clickedPiece.isWhite == board.chosenPiece.isWhite) {
                board.chosenPiece = clickedPiece;
                startCol = col;
                startRow = row;
            } else {
                board.chosenPiece = null;
            }
        } else {
            if (clickedPiece != null) {
                board.chosenPiece = clickedPiece;
                startCol = col;
                startRow = row;
            }
        }
        board.repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (board.chosenPiece != null) {
            board.chosenPiece.xPos = e.getX() - board.tileSize / 2;
            board.chosenPiece.yPos = e.getY() - board.tileSize / 2;
            board.repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int col = e.getX() / board.tileSize;
        int row = e.getY() / board.tileSize;

        if (board.chosenPiece != null) {
            if (col != startCol || row != startRow) {
                Move move = new Move(board, board.chosenPiece, col, row);
                
                if (board.chosenPiece.isValidMove(col, row)) {
                    board.makeMove(move);
                    board.chosenPiece = null;
                } else {
                    board.chosenPiece.xPos = startCol * board.tileSize;
                    board.chosenPiece.yPos = startRow * board.tileSize;
                }
            }
        }
        board.repaint();
    }
}