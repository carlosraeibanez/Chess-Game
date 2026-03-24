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
        allPieces.clear(); // Resets the board
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
        // Add rook, knight, queen, king
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
        System.out.println("   A  B  C  D  E  F  G  H");
        for (int i = 0; i < 8; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < 8; j++) {
                if (board[i][j] != null) {
                    System.out.format("%-3s",board[i][j].getRepresentation() + " "); 
                } 
                else {
                    if ((i+j)%2 != 0) {
                        System.out.print("## ");
                    } else {
                        System.out.print("   ");
                    }
                }
            }
            System.out.println();
        }
    }

    public static void movePiece(String from, String to){
        int[] start = decode(from);
        int [] end = decode(to);

        pieces attacker = board[start[0]][start[1]];
        pieces takenPieces = board[end[0]][end[1]];

        if (attacker == null){
            System.out.println("No Piece to take");
        }
        
        if (takenPieces != null) {
            if (takenPieces.getRepresentation().charAt(0) == attacker.getRepresentation().charAt(0)) {
                System.out.println("Invalid Move: Your own piece");
                return;
            }
            else {
                System.out.println(attacker.getRepresentation() + " takes " + takenPieces.getRepresentation());
            }
        }
        board[end[0]][end[1]] = attacker;
        board[start[0]][start[1]] = null;
        attacker.setGridPosition(to.toLowerCase());
    }

    private static int[] decode(String pos) {
        int col = pos.toLowerCase().charAt(0) - 'a'; 
        int row = 8 - Character.getNumericValue(pos.charAt(1)); 
        return new int[]{row, col};


    }
}