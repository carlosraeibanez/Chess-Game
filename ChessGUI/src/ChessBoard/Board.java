package ChessBoard;

import Pieces.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.io.*;

public class Board extends JFrame {
/*FINAL VARIABLES - Sets the base size of 8x8, Initializes an array of JPanel objects with coordinates*/
    private final int CHESS_BOARD_SIZING = 8;
    private final JPanel [][] CHESS_SQUARES = new JPanel[CHESS_BOARD_SIZING][CHESS_BOARD_SIZING];
    ArrayList<Piece> pieceList = new ArrayList<>();
    public Piece chosenPiece;
    public int tileSize = 800 / 8;

/*BOARD CONSTRUCTOR AND INITIALIZATION*/
    public Board(){
        setTitle("Chess Game");
        setSize(800, 800); 
        setLayout(new GridLayout(CHESS_BOARD_SIZING, CHESS_BOARD_SIZING));
        setLocationRelativeTo(null); // ADDED A CENTERING TO THE BOARD

        Input input = new Input(this);
        this.addMouseListener(input);
        this.addMouseMotionListener(input);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initializeBoard();
        addPieces();
        setupMenuBar();
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

    //PAWNS ADDED NOW USING FOR LOOPS
    for (int i = 0; i < 8; i++) {
    Pawn whitePawn = new Pawn(this, i, 6, true);
        pieceList.add(whitePawn);
        CHESS_SQUARES[6][i].add(new JLabel(whitePawn.icon));
    }
    for (int j = 0; j < 8; j++) {
    Pawn blackPawn = new Pawn(this, j, 1, false);
        pieceList.add(blackPawn);
        CHESS_SQUARES[1][j].add(new JLabel(blackPawn.icon));
    }
        
    // KNIGHTS 
        Knight whiteKnight1 = new Knight(this, 1, 7, true);
        CHESS_SQUARES[7][1].add(new JLabel(whiteKnight1.icon));
        pieceList.add(whiteKnight1);
        Knight whiteKnight2 = new Knight(this, 6, 7, true);
        CHESS_SQUARES[7][6].add(new JLabel(whiteKnight2.icon));
        pieceList.add(whiteKnight2);
        Knight blackKnight1 = new Knight(this, 1, 0, false);
        CHESS_SQUARES[0][1].add(new JLabel(blackKnight1.icon));
        pieceList.add(blackKnight1);
        Knight blackKnight2 = new Knight(this, 6, 0, false);
        CHESS_SQUARES[0][6].add(new JLabel(blackKnight2.icon));
        pieceList.add(blackKnight2);

    // BISHOPS
        Bishop whiteBishop1 = new Bishop(this, 5, 7, true);
        CHESS_SQUARES[7][5].add(new JLabel(whiteBishop1.icon));
        pieceList.add(whiteBishop1);
        Bishop whiteBishop2 = new Bishop(this, 2, 7, true);
        CHESS_SQUARES[7][2].add(new JLabel(whiteBishop2.icon));
        pieceList.add(whiteBishop2);
        Bishop blackBishop1 = new Bishop(this, 5, 0, false);
        CHESS_SQUARES[0][5].add(new JLabel(blackBishop1.icon));
        pieceList.add(blackBishop1);
        Bishop blackBishop2 = new Bishop(this, 2, 0, false);
        CHESS_SQUARES[0][2].add(new JLabel(blackBishop2.icon));
        pieceList.add(blackBishop2);

    // ROOKS
        Rook whiteRook1 = new Rook(this, 0, 7, true);
        CHESS_SQUARES[7][0].add(new JLabel(whiteRook1.icon));       
        pieceList.add(whiteRook1); 
        Rook whiteRook2 = new Rook(this, 7, 7, true);
        pieceList.add(whiteRook2);
        CHESS_SQUARES[7][7].add(new JLabel(whiteRook2.icon));  
        Rook blackRook1 = new Rook(this, 0, 0, false);
        pieceList.add(blackRook1);
        CHESS_SQUARES[0][0].add(new JLabel(blackRook1.icon));        
        Rook blackRook2 = new Rook(this, 7, 0, false);
        pieceList.add(blackRook2);
        CHESS_SQUARES[0][7].add(new JLabel(blackRook2.icon));  

    // QUEENS
        Queen whiteQueen = new Queen(this, 3, 7, true);
        CHESS_SQUARES[7][3].add(new JLabel(whiteQueen.icon));
        pieceList.add(whiteQueen);
        Queen blackQueen = new Queen(this, 4, 0, false);
        CHESS_SQUARES[0][4].add(new JLabel(blackQueen.icon));
        pieceList.add(blackQueen);

    // KINGS
        King whiteKing = new King(this, 4,7,true);
        CHESS_SQUARES[7][4].add(new JLabel(whiteKing.icon));
        pieceList.add(whiteKing);
        King blackKing = new King(this, 3, 0, false);
        CHESS_SQUARES[0][3].add(new JLabel(blackKing.icon));   
        pieceList.add(blackKing);    

        
        revalidate();
        repaint();
    }

// GETTER FOR PIECE
    public Piece getPiece(int col, int row){
        for (Piece piece : pieceList){
            if (piece.col == col && piece.row == row) {
                return piece;
            }
        }
        return null;
    }

// MAKES THE MOVE ON THE BOARD, REVALIDATES AND THEN REPAINTS THE BOARD SUCH THAT THE GUI RESPONDS
    public void makeMove(Move move){
        move.piece.col = move.finalX;
        move.piece.row = move.finalY;

        JPanel oldSquare = CHESS_SQUARES[move.initialY][move.initialX];
        JPanel newSquare = CHESS_SQUARES[move.finalY][move.finalX];

        if (oldSquare.getComponentCount() > 0) {
        Component component = oldSquare.getComponent(0);
        oldSquare.removeAll(); 
            if (move.captured != null) {
                if (move.captured instanceof King) {
                    String winner = move.piece.isWhite ? "White Player" : "Black Player";
                    showEndgamePopup(winner);
                }
                pieceList.remove(move.captured);
            }
        newSquare.removeAll();
        newSquare.add(component);
        move.piece.isFirstMove = false;
        revalidate();
        repaint();
        }

    }

// CREATED END GAME POP UP WHEN KING IS CAPTURED
    private void showEndgamePopup(String winner) {
        JOptionPane.showMessageDialog(this, "Game Over, " + winner + " wins!", "Checkmate", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
    }

//SETTINGS FOR THE BOARD
    public void updateBoardTheme(Color light, Color dark) {
        for (int i = 0; i < CHESS_BOARD_SIZING; i++) {
            for (int j = 0; j < CHESS_BOARD_SIZING; j++) {
                if ((i + j) % 2 == 0) {
                    CHESS_SQUARES[i][j].setBackground(light);
                } else {
                    CHESS_SQUARES[i][j].setBackground(dark);
                }
            }
        }
    }

// BOARD SIZING CHANGE
    public void updateBoardSize(int size) {
        this.setSize(size, size);
        this.setLocationRelativeTo(null);
    }

// PIECES ARE ALL CHANGED
public void updatePieceColors(String colorChosen) {
    String newFile;
    if (colorChosen.equals("blue")) {
        newFile = "blue.png";
    } else if (colorChosen.equals("pink")) {
        newFile = "pink.png";
    } else {
        newFile = "pieces.png";
    }

    for (Piece piece : pieceList) {
        piece.setFileName(newFile);
        piece.loadIcon();
    }
    refreshBoardGraphics();
}

// REFRESHES THE BOARD TO REFLECT CHANGE IN updatePieceCOlos()
private void refreshBoardGraphics() {
    for (int i = 0; i < CHESS_BOARD_SIZING; i++) {
        for (int j = 0; j < CHESS_BOARD_SIZING; j++) {
            CHESS_SQUARES[i][j].removeAll();
        }
    }
    for (Piece p : pieceList) {
        CHESS_SQUARES[p.row][p.col].add(new JLabel(p.icon));
    }
    revalidate();
    repaint();
}

// MENU SYSTEM AT THE TOP LEFT FOR NEW GAME, LOAD GAME, and SAVE GAME (as a serialization)
    private void setupMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu gameMenu = new JMenu("Game");
        JMenuItem newGameItem = new JMenuItem("New Game");
        newGameItem.addActionListener(e -> resetGame());
        JMenuItem saveGameItem = new JMenuItem("Save Game");
        saveGameItem.addActionListener(e -> saveGame());
        JMenuItem loadGameItem = new JMenuItem("Load Game");
        loadGameItem.addActionListener(e -> loadGame());

        gameMenu.add(newGameItem);
        gameMenu.add(saveGameItem);
        gameMenu.add(loadGameItem);
        menuBar.add(gameMenu);

        this.setJMenuBar(menuBar);
        JMenuItem settingsItem = new JMenuItem("Settings");
        settingsItem.addActionListener(e -> {
            Settings settings = new Settings(this);
            settings.setVisible(true);
        });
        gameMenu.add(settingsItem);
    }

    private void resetGame() {
        pieceList.clear();
        for (int i = 0; i < CHESS_BOARD_SIZING; i++) {
            for (int j = 0; j < CHESS_BOARD_SIZING; j++) {
                CHESS_SQUARES[i][j].removeAll();
            }
        }
        addPieces();
        revalidate();
        repaint();
    }

    private void saveGame() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("chess_save.dat"))) {
            out.writeObject(pieceList);
            JOptionPane.showMessageDialog(this, "Game Saved");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error SAving");
        }
    }


// NEED TO FIX LOAD GAME BECAUSE THE SPRITES CANNOT BE SERIALIZED, change to keep the data except the sprite
// then redraw after the data is loaded in
    private void loadGame() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("chess_saved_game.dat"))) {
            ArrayList<Piece> loadedPieces = (ArrayList<Piece>) in.readObject();
            pieceList.clear();
            for (int i = 0; i < CHESS_BOARD_SIZING; i++) {
                for (int j = 0; j < CHESS_BOARD_SIZING; j++) {
                    CHESS_SQUARES[i][j].removeAll();
                }
            }
            pieceList = loadedPieces;
            for (Piece p : pieceList) {
                CHESS_SQUARES[p.row][p.col].add(new JLabel(p.icon));
            }

            revalidate();
            repaint();
            JOptionPane.showMessageDialog(this, "Game Loaded!");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error Loading.");
        }
    }

}