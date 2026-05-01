package ChessBoard;

import javax.swing.*;
import java.awt.*;

public class Settings extends JDialog {
    @SuppressWarnings("unused")
    private Board board;

// SETTINGS TAB IN TOP LEFT
    public Settings(Board board) {
        super(board, "Settings", true);
        this.board = board;
        setLayout(new GridLayout(4, 2, 10, 10));
        setSize(300, 250);
        setLocationRelativeTo(board);
// BOARD SELECTOR
        add(new JLabel(" Board Theme:"));
        String[] themes = {"Classic", "Modern Gray", "Woodland"};
        JComboBox<String> themeBox = new JComboBox<>(themes);
        themeBox.addActionListener(e -> {
            String selected = (String) themeBox.getSelectedItem();
            if (selected.equals("Classic")) 
                board.updateBoardTheme(new Color(255, 255, 240), new Color(54, 69, 79));
            else if (selected.equals("Modern Gray")) 
                board.updateBoardTheme(Color.LIGHT_GRAY, Color.DARK_GRAY);
            else if (selected.equals("Woodland")) 
                board.updateBoardTheme(new Color(245, 222, 179), new Color(139, 69, 19));
        });
        add(themeBox);

// BOARD SIZING
        add(new JLabel(" Board Size:"));
        String[] sizes = {"Small (600)", "Medium (800)", "Large (1000)"};
        JComboBox<String> sizeBox = new JComboBox<>(sizes);
        sizeBox.addActionListener(e -> {
            int index = sizeBox.getSelectedIndex();
            if (index == 0) board.updateBoardSize(600);
            else if (index == 1) board.updateBoardSize(800);
            else if (index == 2) board.updateBoardSize(1000);
        });
        add(sizeBox);

// TO ADD NEW SPRITE SHEET
        add(new JLabel("Piece Color"));
        String[] colors = {"Default", "Blue", "Pink"};
        JComboBox<String> colorsBox = new JComboBox<>(colors);
        colorsBox.addActionListener(e -> {
            String colorSelected = (String) colorsBox.getSelectedItem();
            if (colorSelected != null) {
                board.updatePieceColors(colorSelected.toLowerCase());
            }
        });
        add(colorsBox);
    }
}