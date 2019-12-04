package hk.edu.polyu.comp.comp2021.jungle.gui;


import hk.edu.polyu.comp.comp2021.jungle.controller.GameController;
import hk.edu.polyu.comp.comp2021.jungle.model.Block;
import hk.edu.polyu.comp.comp2021.jungle.model.Board;
import hk.edu.polyu.comp.comp2021.jungle.model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class Table {
    private final JFrame gameFrame;
    private final BoardPanel boardPanel;
    private static final Dimension OUTER_FRAME_DIMENSION = new Dimension(600, 600);
    private static final Dimension BOARD_PANEL_DIMENSION = new Dimension(400, 350);
    private static final Dimension TILE_PANEL_DIMENSION = new Dimension(10, 10);
    private Color plainTileColor = Color.decode("#FFFACD");
    private Color riverTileColor = Color.decode("#0080FF");
    private Board board;
    private Player p1,p2,turn;

    public Table(Board board,Player player1, Player player2,Player turn){
        this.gameFrame = new JFrame("Jungle Game");
        this.gameFrame.setLayout(new BorderLayout());
        final JMenuBar tableMenuBar = createTableMenuBar();
        this.gameFrame.setJMenuBar(tableMenuBar);
        this.gameFrame.setSize(OUTER_FRAME_DIMENSION);
        this.boardPanel = new BoardPanel(board);
        this.gameFrame.add(this.boardPanel, BorderLayout.CENTER);
        this.gameFrame.setVisible(true);
        this.board = board;
        this.turn = turn;
        p1 = player1;
        p2 = player2;

    }

    public JMenuBar createTableMenuBar(){
        final JMenuBar tableMenuBar = new JMenuBar();
        tableMenuBar.add(createFileMenu());
        return tableMenuBar;
    }

    private JMenu createFileMenu(){
        final JMenu fileMenu = new JMenu("File");

        final JMenuItem saveG = new JMenuItem("Save Game File");
        saveG.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                GameController savedGame = new GameController(board,p1,p2,turn);
            }
        });
        fileMenu.add(saveG);
        return fileMenu;
    }

    private class BoardPanel extends JPanel{
        final List<TilePanel> boardTiles;

        BoardPanel(Board board){
            super(new GridLayout(9,7));
            this.boardTiles = new ArrayList<>();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 7; j++) {
                    final TilePanel tilePanel = new TilePanel(this, i, j, board);
                    this.boardTiles.add(tilePanel);
                    add(tilePanel);
                }
            }
            setPreferredSize(BOARD_PANEL_DIMENSION);
            validate();
        }
    }

    private class TilePanel extends JPanel{
        private final int tileX;
        private final int tileY;

        TilePanel(final BoardPanel boardPanel,
                  final int tileX, final int tileY,
                  Board board){
            super(new GridBagLayout());
            this.tileX = tileX;
            this.tileY = tileY;
            setPreferredSize(TILE_PANEL_DIMENSION);
            assignTileColor(board);
            this.setBorder(BorderFactory.createLineBorder(Color.black));
            validate();
        }

        private void assignTileColor(Board board) {
            Block[][] blocks = board.getBoard();
            switch(blocks[tileX][tileY].getBlockType()){
                case 0:{
                    setBackground(plainTileColor);
                    break;
                }
                case 1:{
                    setBackground(riverTileColor);
                    break;
                }
                case 2:{
                    //will need images for 2 and 3
                    break;
                }
                case 3:{
                    break;
                }
            }
        }
    }
}
