package ChessBoard;

import javax.swing.*;
import java.awt.*;

public class SettingsDialog extends JDialog {
    private Board board;

    public SettingsDialog(Board board) {
        super(board, "Settings", true);
        this.board = board;
        setLayout(new GridLayout(4, 2, 10, 10));
        setSize(300, 250);
        setLocationRelativeTo(board);

        // 1. Board Theme Selector
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

        // 2. Board Size Selector
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

        // 3. Piece Style (Placeholder for now)
        add(new JLabel(" Piece Style:"));
        JButton pieceBtn = new JButton("Change Sprites");
        pieceBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Select a new sprite sheet file!");
            // Here you would call a method to reload piece images
        });
        add(pieceBtn);

        JButton closeBtn = new JButton("Close");
        closeBtn.addActionListener(e -> dispose());
        add(new JLabel("")); // Spacer
        add(closeBtn);
    }
}