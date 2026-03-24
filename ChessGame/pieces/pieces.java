package pieces;

/** Abstract class representing a generic chess piece. */
public abstract class pieces {
    protected String pieceColor; // Changed to protected for subclasses
    protected String gridPosition; // Grid position assignment

    public pieces(String pieceColor, String gridPosition) {
        this.pieceColor = pieceColor;
        this.gridPosition = gridPosition;
    }

    /** Returns the 2-character identification (color + peice name) */
    public String getRepresentation() {
        char colorChar = pieceColor.equalsIgnoreCase("white") ? 'w' : 'b';
        return "" + colorChar + getPieceID();
    }

    /** Returns the position of the piece */
    public String getGridPosition() { 
        return gridPosition; 
    }

    public void setGridPosition(String position){
        this.gridPosition = position;
    }
    
    public abstract void possibleMoves();
    public abstract String getPieceID();
}