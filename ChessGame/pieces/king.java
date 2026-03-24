package pieces;

public class king extends pieces{
    public king(String pieceColor, String gridPosition){
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
