package gameState;

import pieces.*;
import java.util.ArrayList;
import java.util.List;

/** Manages the chessboard, initializs the board, and pieces */
public class gameState {
    private static pieces[][] board = new pieces[8][8]; // 8x8 2D array
    private static List<pieces> allPieces = new ArrayList<>(); //List of pieces

    /** Populates the list of pieces with their starting positions */
    public static void pieceInitialize() {
        allPieces.clear();
        // Add White Pawns
        for (char i = 'a'; i <= 'h'; i++) {
            allPieces.add(new pawn("white", i + "2"));
        }
        // Add rook, knight, queen, king
        allPieces.add(new rook("white", "a1")); 
        allPieces.add(new rook("white", "h1")); 
        allPieces.add(new knight("white", "b1"));
        allPieces.add(new knight("white", "g1"));
        allPieces.add(new bishop("white", "c1"));
        allPieces.add(new bishop("white", "f1"));
        allPieces.add(new queen("white","d1"));
        allPieces.add(new king("white","e1"));

        // Blakc pawns
        for (char i = 'a'; i <= 'h'; i++) {
            allPieces.add(new pawn("black", i + "7"));
        }
        allPieces.add(new rook("black", "a8")); 
        allPieces.add(new rook("black", "h8")); 
        allPieces.add(new knight("black", "b8"));
        allPieces.add(new knight("black", "g8"));
        allPieces.add(new bishop("black", "c8"));
        allPieces.add(new bishop("black", "f8"));
        allPieces.add(new queen("black","d8"));
        allPieces.add(new king("black","e8"));
    }

    /** Initializes board*/
    public static void boardInitialize() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) board[i][j] = null;
        }

        for (pieces p : allPieces) {
            String pos = p.getGridPosition(); 
            int col = pos.toLowerCase().charAt(0) - 'a'; 
            int row = 8 - Character.getNumericValue(pos.charAt(1)); 
            if (row >= 0 && row < 8 && col >= 0 && col < 8) {
                board[row][col] = p;
            }
        }
    }

    /** Displays the current game state of the board in the terminal */
    public static void display() {
        System.out.println("   A  B  C  D  E  F  G  H"); // Top labels [cite: 13]
        for (int i = 0; i < 8; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    System.out.print("## ");
                } else {
                    System.out.print(board[i][j].getRepresentation() + " ");
                }
            }
            System.out.println();
        }
    }
}