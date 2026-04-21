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
    public int value;
    private static final long serialVersionUID = 1L;
    transient BufferedImage sheet;
    {   try {
            sheet = ImageIO.read(ClassLoader.getSystemResourceAsStream("pieces.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected int sheetScale = sheet != null ? sheet.getWidth(null) / 6 : 100;
    public transient ImageIcon icon;
    Board board;

    public Piece(Board board, int col, int row, boolean isWhite) {
        this.board = board;
        this.col = col;
        this.row = row;
        this.isWhite = isWhite;
    }

    public void drawPiece(Graphics2D g2d){
        g2d.drawImage(icon.getImage(), xPos, yPos, null);
    }
}


