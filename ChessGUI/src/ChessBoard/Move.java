package ChessBoard;


import Pieces.*;
public class Move {
// ATTRIBUTES
    int initialX;
    int initialY;

    int finalX;
    int finalY;

    Piece piece;
    Piece captured;
    
// CONSTRUCTOR
public Move(Board board, Piece piece, int finalCol, int finalRow){
    this.initialX = piece.col;
    this.initialY = piece.row;
    this.finalX = finalCol;
    this.finalY = finalRow;
    this.piece = piece;
    this.captured = board.getPiece(finalX, finalY);
}

// VALIDATES MOVES TO BE IMPLEMENTED IN EACH SUBCLASS
public void isValid(Move move){

}

}
