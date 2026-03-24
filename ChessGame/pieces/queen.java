package pieces;

public class queen extends pieces{
    public queen(String pieceColor, String gridPosition) {
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
