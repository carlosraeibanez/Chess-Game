package pieces;

public class bishop extends pieces {

    //Bishop Constructor
    public bishop(String pieceColor, String gridPosition) {
        // This 'super' call passes the data to the pieces class
        super(pieceColor, gridPosition);
    }

    //Possible Moves Method (Specific to Bisop)
    @Override
    public void possibleMoves(){
    }

    @Override
    public String getPieceID(){
        return "P";
    }
}
