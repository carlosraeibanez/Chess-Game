package ChessBoard;

import Pieces.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Board extends JFrame {
/*FINAL VARIABLES - Sets the base size of 8x8, Initializes an array of JPanel objects with coordinates*/
    private final int CHESS_BOARD_SIZING = 8;
    private final JPanel [][] CHESS_SQUARES = new JPanel[CHESS_BOARD_SIZING][CHESS_BOARD_SIZING];

    public ArrayList<Piece> piecesList = new ArrayList<Piece>();

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
        Knight whiteKnight = new Knight(this, 1, 7, true);
        CHESS_SQUARES[7][1].add(new JLabel(whiteKnight.icon));
        revalidate();
        repaint();
    }
}