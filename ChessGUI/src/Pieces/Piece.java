package Pieces;

import ChessBoard.Board;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;

public class Piece implements Serializable{ // SUPERCLASS OF ALL PIECES

/* ATTRIBUTES OF PIECES X Y POSITIONS AND */
    public int col;
    public int row;
    public int xPos;
    public int yPos;

    public boolean isWhite;
    public String pieceName;
    //public int value;
    private static final long serialVersionUID = 1L;
    transient BufferedImage sheet;
    public String fileName = "pieces.png";
    public boolean isFirstMove = true;

        {   try {sheet = ImageIO.read(ClassLoader.getSystemResourceAsStream(fileName));}
            catch (IOException e) {e.printStackTrace();}}
    protected int sheetScale = sheet != null ? sheet.getWidth(null) / 6 : 100;
    public transient ImageIcon icon;
    public Board board; // CHANGED TO PUBLIC SO LOADGAME() CAN SEE

    public Piece(Board board, int col, int row, boolean isWhite) {
        this.board = board;
        this.col = col;
        this.row = row;
        this.isWhite = isWhite;
    }

    
    public void setFileName(String fileName){
        this.fileName = fileName;
    }
    public void loadIcon() {
        try {
            BufferedImage sheet = ImageIO.read(ClassLoader.getSystemResourceAsStream(fileName));
            int size = sheet.getWidth() / 6;
            int colIndex = getSheetColIndex();
            int rowIndex = isWhite ? 0 : 1;
            
            BufferedImage subImage = sheet.getSubimage(colIndex * size, rowIndex * size, size, size);
            this.icon = new ImageIcon(subImage.getScaledInstance(70, 70, Image.SCALE_SMOOTH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int getSheetColIndex() {
        if (this instanceof King) return 0;
        if (this instanceof Queen) return 1;
        if (this instanceof Bishop) return 2;
        if (this instanceof Knight) return 3;
        if (this instanceof Rook) return 4;
        return 5;
    }

    // VALIDATES MOVES TO BE IMPLEMENTED IN EACH SUBCLASS
    public boolean isValidMove(int targetCol, int targetRow) {
        if (targetCol < 0 || targetCol >= 8 || targetRow < 0 || targetRow >= 8) {
            return false;
        }
        
        Piece targetPiece = board.getPiece(targetCol, targetRow);
        if (targetPiece != null && targetPiece.isWhite == this.isWhite) {
            return false;
        }
        
        return true;
    }

    // RESETS POSITION IF MOVE ISNT VALID WHEN DRAGGED
    public void resetPosition() {
        this.xPos = col * board.tileSize;
        this.yPos = row * board.tileSize;
}
}