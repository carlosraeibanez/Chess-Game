package pieces;

public class rook extends pieces {
    public rook(String pieceColor, String gridPosition){
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
