package hk.edu.polyu.comp.comp2021.jungle.gui;


import hk.edu.polyu.comp.comp2021.jungle.controller.GameController;
import hk.edu.polyu.comp.comp2021.jungle.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

/**
 * Generates window with graphics
 */
public class Table {
    private final JFrame gameFrame;
    private BoardPanel boardPanel;
    private static final Dimension OUTER_FRAME_DIMENSION = new Dimension(600, 600);
    private static final Dimension BOARD_PANEL_DIMENSION = new Dimension(400, 350);
    private static final Dimension TILE_PANEL_DIMENSION = new Dimension(10, 10);
    private Color plainTileColor = Color.decode("#FFFACD");
    private Color riverTileColor = Color.decode("#0080FF");
    private Color white = Color.decode("#FFFFFF");
    private Board board;
    private Player p1,p2,turn;
    private Position[] position;
    private boolean isFrist = false;
    private boolean isFinished = false;
    private final int width = 80;
    private final int height = 60;
    String imgPath = Table.class.getResource("").getPath();

    /**
     *
     * @param board board
     * @param player1 plaayer1
     * @param player2 player2
     * @param turn player's turn
     */
    public Table(Board board,Player player1, Player player2,Player turn){
        this.gameFrame = new JFrame("Jungle Game");
        this.gameFrame.setLayout(new BorderLayout());
        final JMenuBar tableMenuBar = createTableMenuBar();
        this.gameFrame.setJMenuBar(tableMenuBar);
        this.gameFrame.setSize(OUTER_FRAME_DIMENSION);
        this.boardPanel = new BoardPanel(board);
        this.gameFrame.add(this.boardPanel, BorderLayout.CENTER);
        this.gameFrame.add(new JLabel("Turn: "+ turn.getName()),BorderLayout.SOUTH);
        this.gameFrame.setVisible(true);
        this.board = board;
        this.turn = turn;
        p1 = player1;
        p2 = player2;
    }

    /**
     *
     * @param board board
     *  Updates board according to the movement
     */
    public void updateTable(Board board){
        this.board=board;
        gameFrame.remove(boardPanel);
        this.boardPanel = new BoardPanel(board);
        this.gameFrame.add(this.boardPanel, BorderLayout.CENTER);
        gameFrame.revalidate();
        gameFrame.repaint();

    }

    /**
     *
     * @return Menu Bar window
     */
    public JMenuBar createTableMenuBar(){
        final JMenuBar tableMenuBar = new JMenuBar();
        tableMenuBar.add(createFileMenu());
        return tableMenuBar;
    }

    /**
     *
     * @return Menu options
     */
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

    /**
     *  Generates the Board Panel
     */
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

    /**
     * Generates each tile of the panel
     */
    private class TilePanel extends JPanel {
        private final int tileX;
        private final int tileY;



        TilePanel(final BoardPanel boardPanel,
                  final int tileX, final int tileY,
                  Board board) {
            super(new GridBagLayout());
            this.tileX = tileX;
            this.tileY = tileY;
            this.addMouseListener(new MyMouseListener());
            setPreferredSize(TILE_PANEL_DIMENSION);
            assignTileColor(board);
            assignAnimal(board);
            this.setBorder(BorderFactory.createLineBorder(Color.black));
            validate();
        }


        /**
         *  Assigns a color to each tile based on its position
         * @param board board
         */
        private void assignTileColor(Board board) {
            Block[][] blocks = board.getBoard();
            switch (blocks[tileX][tileY].getBlockType()) {
                case 0: {
                    setBackground(plainTileColor);
                    break;
                }
                case 1: {
                    setBackground(riverTileColor);

                    break;
                }
                case 2: {
                    setBackground(white);
                    JLabel label = new JLabel();
                    ImageIcon imageIcon = new ImageIcon(new ImageIcon(imgPath + "/sources/trap.png").getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
                    label.setIcon(imageIcon);

                    add(label);
                    break;
                }
                case 3: {
                    setBackground(white);
                    JLabel label = new JLabel();
                    ImageIcon imageIcon = new ImageIcon(new ImageIcon(imgPath + "/sources/den.png").getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
                    label.setIcon(imageIcon);

                    add(label);
                    break;
                }
            }
        }

        /**
         * Assigns an animal to each panel depending on its position
         * @param board
         */
        public void assignAnimal(Board board) {
            Block[][] blocks = board.getBoard();
            if (blocks[tileX][tileY].getA() == null) {
                return;
            }
            switch (blocks[tileX][tileY].getA().getRank()) {
                case 1: {
                    if (blocks[tileX][tileY].getA().getPly().getId() == 1) {

                        JLabel label = new JLabel();
                        ImageIcon imageIcon = new ImageIcon(new ImageIcon(imgPath + "/sources/animals/PLAYER1/Rat.png").getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
                        label.setIcon(imageIcon);
                        label.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                int x =blocks[tileX][tileY].getA().getP().getX();
                                int y =blocks[tileX][tileY].getA().getP().getY();
                                System.out.println("x:"+x+" y:"+y);
                            }
                        });
                        add(label);


                    } else {
                        JLabel label = new JLabel();
                        ImageIcon imageIcon = new ImageIcon(new ImageIcon(imgPath + "/sources/animals/PLAYER2/Rat2.png").getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
                        label.setIcon(imageIcon);
                        label.addMouseListener(new MyMouseListener());
                        add(label);
                    }
                    break;
                }
                case 2: {
                    if (blocks[tileX][tileY].getA().getPly().getId() == 1) {
                        JLabel label = new JLabel();
                        ImageIcon imageIcon = new ImageIcon(new ImageIcon(imgPath + "/sources/animals/PLAYER1/Cat.png").getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
                        label.setIcon(imageIcon);
                        label.addMouseListener(new MyMouseListener());
                        add(label);
                    } else {
                        JLabel label = new JLabel();
                        ImageIcon imageIcon = new ImageIcon(new ImageIcon(imgPath + "/sources/animals/PLAYER2/Cat2.png").getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
                        label.setIcon(imageIcon);
                        label.addMouseListener(new MyMouseListener());
                        add(label);
                    }
                    break;
                }
                case 3: {
                    if (blocks[tileX][tileY].getA().getPly().getId() == 1) {
                        JLabel label = new JLabel();
                        ImageIcon imageIcon = new ImageIcon(new ImageIcon(imgPath + "/sources/animals/PLAYER1/Dog.png").getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
                        label.setIcon(imageIcon);
                        label.addMouseListener(new MyMouseListener());
                        add(label);
                    } else {
                        JLabel label = new JLabel();
                        ImageIcon imageIcon = new ImageIcon(new ImageIcon(imgPath + "/sources/animals/PLAYER2/Dog2.png").getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
                        label.setIcon(imageIcon);
                        label.addMouseListener(new MyMouseListener());
                        add(label);
                    }

                    break;
                }
                case 4: {
                    if (blocks[tileX][tileY].getA().getPly().getId() == 1) {
                        JLabel label = new JLabel();
                        ImageIcon imageIcon = new ImageIcon(new ImageIcon(imgPath + "/sources/animals/PLAYER1/Wolf.png").getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
                        label.setIcon(imageIcon);
                        label.addMouseListener(new MyMouseListener());
                        add(label);
                    } else {
                        JLabel label = new JLabel();
                        ImageIcon imageIcon = new ImageIcon(new ImageIcon(imgPath + "/sources/animals/PLAYER2/Wolf2.png").getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
                        label.setIcon(imageIcon);
                        label.addMouseListener(new MyMouseListener());
                        add(label);
                    }


                    break;
                }
                case 5: {
                    if (blocks[tileX][tileY].getA().getPly().getId() == 1) {
                        JLabel label = new JLabel();
                        ImageIcon imageIcon = new ImageIcon(new ImageIcon(imgPath + "/sources/animals/PLAYER1/Leopard.png").getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
                        label.setIcon(imageIcon);
                        label.addMouseListener(new MyMouseListener());
                        add(label);
                    } else {
                        JLabel label = new JLabel();
                        ImageIcon imageIcon = new ImageIcon(new ImageIcon(imgPath + "/sources/animals/PLAYER2/Leopard2.png").getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
                        label.setIcon(imageIcon);
                        label.addMouseListener(new MyMouseListener());
                        add(label);
                    }

                    break;
                }
                case 6: {
                    if (blocks[tileX][tileY].getA().getPly().getId() == 1) {
                        JLabel label = new JLabel();
                        ImageIcon imageIcon = new ImageIcon(new ImageIcon(imgPath + "/sources/animals/PLAYER1/Tiger.png").getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
                        label.setIcon(imageIcon);
                        label.addMouseListener(new MyMouseListener());
                        add(label);
                    } else {
                        JLabel label = new JLabel();
                        ImageIcon imageIcon = new ImageIcon(new ImageIcon(imgPath + "/sources/animals/PLAYER2/Tiger2.png").getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
                        label.setIcon(imageIcon);
                        label.addMouseListener(new MyMouseListener());
                        add(label);
                    }

                    break;
                }
                case 7: {
                    if (blocks[tileX][tileY].getA().getPly().getId() == 1) {
                        JLabel label = new JLabel();
                        ImageIcon imageIcon = new ImageIcon(new ImageIcon(imgPath + "/sources/animals/PLAYER1/Lion.png").getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
                        label.setIcon(imageIcon);
                        label.addMouseListener(new MyMouseListener());
                        add(label);
                    } else {
                        JLabel label = new JLabel();
                        ImageIcon imageIcon = new ImageIcon(new ImageIcon(imgPath + "/sources/animals/PLAYER2/Lion2.png").getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
                        label.setIcon(imageIcon);
                        label.addMouseListener(new MyMouseListener());
                        add(label);
                    }
                    break;
                }
                case 8: {
                    if (blocks[tileX][tileY].getA().getPly().getId() == 1) {
                        JLabel label = new JLabel();
                        ImageIcon imageIcon = new ImageIcon(new ImageIcon(imgPath + "/sources/animals/PLAYER1/Elephant.png").getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
                        label.setIcon(imageIcon);
                        label.addMouseListener(new MyMouseListener());
                        add(label);

                    } else {
                        JLabel label = new JLabel();
                        ImageIcon imageIcon = new ImageIcon(new ImageIcon(imgPath + "/sources/animals/PLAYER2/Elephant2.png").getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
                        label.setIcon(imageIcon);
                        label.addMouseListener(new MyMouseListener());
                        add(label);
                    }
                    break;
                }


            }


        }

        /**
         *  Executes the movement of the mouse
         */
        class MyMouseListener implements MouseListener{

            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("mouseClicked");
                JPanel panel = (JPanel)e.getSource();
                if(!isFrist) {
                    position[0] = new Position(tileY, tileX);
                    System.out.println(position[0]);
                    isFrist=false;
                }
                else{
                    position[1] = new Position(tileY,tileX);
                    System.out.println(position[1]);
                }
                isFinished=true;


            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

        }
    }

    /**
     *
     * @param player player
     * @return position
     */
    public Position[] getInputFromTable (Player player){
        return position;
    }



    }


