package ChessBoard;

import Pieces.*;
import javax.swing.*;
import java.awt.*;

public class Board extends JFrame {
/*FINAL VARIABLES - Sets the base size of 8x8, Initializes an array of JPanel objects with coordinates*/
    private final int CHESS_BOARD_SIZING = 8;
    private final JPanel [][] CHESS_SQUARES = new JPanel[CHESS_BOARD_SIZING][CHESS_BOARD_SIZING];

/*BOARD CONSTRUCTOR AND INITIALIZATION*/
    public Board(){
        setTitle("Chess Game");
        setSize(800, 800); 
        setLayout(new GridLayout(CHESS_BOARD_SIZING, CHESS_BOARD_SIZING));
        setLocationRelativeTo(null); // ADDED A CENTERING TO THE BOARD

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initializeBoard();
        addPieces();
        setVisible(true);
    }

/*INITIALIZATION METHOD - Creates a new Jpanel which is alternating Eggshell white and Charcoal gray. 
Create method that can change the colors in settings */
    private void initializeBoard(){
        for (int i = 0; i < CHESS_BOARD_SIZING; i++) {
            for (int j = 0; j < CHESS_BOARD_SIZING; j++) {
                JPanel square = new JPanel();

                if ((i + j) % 2 == 0) {
                    square.setBackground(new Color(255, 255, 240)); // EGGSHELL WHITE
                } else {
                    square.setBackground(new Color(54, 69, 79));  // CHARCOAL GREY
                }
                
                CHESS_SQUARES[i][j] = square;
                add(square);
            }
        }
    }

    public void addPieces() {

    //PAWNS ADDED (CAN PROBABLY USE FOR LOOPS FOR COLUMBS AND ROWS)
        Pawn whitePawn1 = new Pawn(this, 0, 6, true);
        CHESS_SQUARES[6][0].add(new JLabel(whitePawn1.icon));
        Pawn whitePawn2 = new Pawn(this, 1, 6, true);
        CHESS_SQUARES[6][1].add(new JLabel(whitePawn2.icon));
        Pawn whitePawn3 = new Pawn(this, 2, 6, true);
        CHESS_SQUARES[6][2].add(new JLabel(whitePawn3.icon));
        Pawn whitePawn4 = new Pawn(this, 3, 6, true);
        CHESS_SQUARES[6][3].add(new JLabel(whitePawn4.icon));
        Pawn whitePawn5 = new Pawn(this, 4, 6, true);
        CHESS_SQUARES[6][4].add(new JLabel(whitePawn5.icon));
        Pawn whitePawn6 = new Pawn(this, 5, 6, true);
        CHESS_SQUARES[6][5].add(new JLabel(whitePawn6.icon));
        Pawn whitePawn7 = new Pawn(this, 6, 6, true);
        CHESS_SQUARES[6][6].add(new JLabel(whitePawn7.icon));
        Pawn whitePawn8 = new Pawn(this, 7, 6, true);
        CHESS_SQUARES[6][7].add(new JLabel(whitePawn8.icon));
        Pawn blackPawn1 = new Pawn(this, 0, 0, false);
        CHESS_SQUARES[1][0].add(new JLabel(blackPawn1.icon));
        Pawn blackPawn2 = new Pawn(this, 0, 1, false);
        CHESS_SQUARES[1][1].add(new JLabel(blackPawn2.icon));
        Pawn blackPawn3 = new Pawn(this, 0, 2, false);
        CHESS_SQUARES[1][2].add(new JLabel(blackPawn3.icon));
        Pawn blackPawn4 = new Pawn(this, 0, 3, false);
        CHESS_SQUARES[1][3].add(new JLabel(blackPawn4.icon));
        Pawn blackPawn5 = new Pawn(this, 0, 4, false);
        CHESS_SQUARES[1][4].add(new JLabel(blackPawn5.icon));
        Pawn blackPawn6 = new Pawn(this, 0, 5, false);
        CHESS_SQUARES[1][5].add(new JLabel(blackPawn6.icon));
        Pawn blackPawn7 = new Pawn(this, 0, 6, false);
        CHESS_SQUARES[1][6].add(new JLabel(blackPawn7.icon)); 
        Pawn blackPawn8 = new Pawn(this, 0, 7, false);
        CHESS_SQUARES[1][7].add(new JLabel(blackPawn8.icon));        
        
    // KNIGHTS 
        Knight whiteKnight1 = new Knight(this, 1, 7, true);
        CHESS_SQUARES[7][1].add(new JLabel(whiteKnight1.icon));
        Knight whiteKnight2 = new Knight(this, 6, 7, true);
        CHESS_SQUARES[7][6].add(new JLabel(whiteKnight2.icon));
        Knight blackKnight1 = new Knight(this, 1, 0, false);
        CHESS_SQUARES[0][1].add(new JLabel(blackKnight1.icon));
        Knight blackKnight2 = new Knight(this, 6, 0, false);
        CHESS_SQUARES[0][6].add(new JLabel(blackKnight2.icon));

    // BISHOPS
        Bishop whiteBishop1 = new Bishop(this, 7, 5, true);
        CHESS_SQUARES[7][5].add(new JLabel(whiteBishop1.icon));
        Bishop whiteBishop2 = new Bishop(this, 7, 2, true);
        CHESS_SQUARES[7][2].add(new JLabel(whiteBishop2.icon));
        Bishop blackBishop1 = new Bishop(this, 7, 0, false);
        CHESS_SQUARES[0][5].add(new JLabel(blackBishop1.icon));
        Bishop blackBishop2 = new Bishop(this, 7, 0, false);
        CHESS_SQUARES[0][2].add(new JLabel(blackBishop2.icon));

    // ROOKS
        Rook whiteRook1 = new Rook(this, 0, 7, true);
        CHESS_SQUARES[7][0].add(new JLabel(whiteRook1.icon));        

        revalidate();
        repaint();
    }
}