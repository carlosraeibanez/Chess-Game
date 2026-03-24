package pieces;

public class pawn extends pieces {
    public pawn(String pieceColor, String gridPosition){
        super(pieceColor, gridPosition);
    }
    @Override
    public void possibleMoves(){
    }

    @Override
    public String getPieceID(){
        return "P";
    }


}
