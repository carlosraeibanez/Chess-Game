package pieces;

public class knight extends pieces{
    public knight(String pieceColor, String gridPosition){
        super(pieceColor, gridPosition);
    }
    @Override
    public void possibleMoves(){
    }

    @Override
    public String getPieceID(){
        return "N";
    }


}
