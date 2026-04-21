package ChessBoard;


import Pieces.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class Input extends MouseAdapter{
    Board board;
    public Input(Board board){
        this.board = board;
    }

    @Override
    public void mousePressed(MouseEvent e){
        int col = e.getX()/100;
        int row = e.getY()/100;

        Piece pieceXY = board.getPiece(col, row);
        if (pieceXY != null){
            board.chosenPiece = pieceXY;
        }
    }

    @Override
    public void mouseDragged(MouseEvent e){
        if (board.chosenPiece != null) {
            board.chosenPiece.xPos = e.getX() - 100 / 2;
            board.chosenPiece.yPos = e.getY() - 100 / 2;            
        }
        board.repaint();
    } 

    @Override
    public void mouseReleased(MouseEvent e){
        int col = e.getX()/100;
        int row = e.getY()/100;
        
        if (board.chosenPiece != null) {
            Move move = new Move(board, board.chosenPiece, col, row);

            board.makeMove(move);
        }


        board.chosenPiece = null;
        board.repaint();
    }

}
