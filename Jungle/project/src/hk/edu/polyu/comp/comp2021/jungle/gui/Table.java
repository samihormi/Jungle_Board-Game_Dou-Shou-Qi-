package hk.edu.polyu.comp.comp2021.jungle.gui;


import hk.edu.polyu.comp.comp2021.jungle.controller.GameController;
import hk.edu.polyu.comp.comp2021.jungle.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

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
    private Position[] position=new Position[2];
    private boolean isFrist = false;
    private boolean isFinished = false;
    String imgPath = Table.class.getResource("").getPath();
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
    public void updateTable(Board board){
        this.board=board;
        gameFrame.remove(boardPanel);
        this.boardPanel = new BoardPanel(board);
        this.gameFrame.add(this.boardPanel, BorderLayout.CENTER);
        gameFrame.revalidate();
        gameFrame.repaint();
        if(turn.getId()==p1.getId())
            turn=p2;
        else
            turn=p1;
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
                    final TilePanel tilePanel = new TilePanel(this, j, i, board);
                    this.boardTiles.add(tilePanel);
                    add(tilePanel);

                }
            }
            setPreferredSize(BOARD_PANEL_DIMENSION);
            validate();
        }
    }

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
        



        private void assignTileColor(Board board) {
            Block[][] blocks = board.getBoard();
            switch (blocks[tileY][tileX].getBlockType()) {
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
                    ImageIcon imageIcon = new ImageIcon(new ImageIcon(imgPath + "/sources/trap.png").getImage().getScaledInstance(80, 60, Image.SCALE_DEFAULT));
                    label.setIcon(imageIcon);

                    add(label);
                    break;
                }
                case 3: {
                    setBackground(white);
                    JLabel label = new JLabel();
                    ImageIcon imageIcon = new ImageIcon(new ImageIcon(imgPath + "/sources/den.png").getImage().getScaledInstance(80, 60, Image.SCALE_DEFAULT));
                    label.setIcon(imageIcon);

                    add(label);
                    break;
                }
            }
        }

        public void assignAnimal(Board board) {
            Block[][] blocks = board.getBoard();
            if (blocks[tileY][tileX].getA() == null) {
                return;
            }
            switch (blocks[tileY][tileX].getA().getRank()) {
                case 1: {
                    if (blocks[tileY][tileX].getA().getPly().getId() == 1) {

                        JLabel label = new JLabel();
                        ImageIcon imageIcon = new ImageIcon(new ImageIcon(imgPath + "/sources/animals/PLAYER1/Rat.png").getImage().getScaledInstance(80, 60, Image.SCALE_DEFAULT));
                        label.setIcon(imageIcon);
                        label.addMouseListener(new MyMouseListener());
                        add(label);


                    } else {
                        JLabel label = new JLabel();
                        ImageIcon imageIcon = new ImageIcon(new ImageIcon(imgPath + "/sources/animals/PLAYER2/Rat2.png").getImage().getScaledInstance(80, 60, Image.SCALE_DEFAULT));
                        label.setIcon(imageIcon);
                        label.addMouseListener(new MyMouseListener());
                        add(label);
                    }
                    break;
                }
                case 2: {
                    if (blocks[tileY][tileX].getA().getPly().getId() == 1) {
                        JLabel label = new JLabel();
                        ImageIcon imageIcon = new ImageIcon(new ImageIcon(imgPath + "/sources/animals/PLAYER1/Cat.png").getImage().getScaledInstance(80, 60, Image.SCALE_DEFAULT));
                        label.setIcon(imageIcon);
                        label.addMouseListener(new MyMouseListener());
                        add(label);
                    } else {
                        JLabel label = new JLabel();
                        ImageIcon imageIcon = new ImageIcon(new ImageIcon(imgPath + "/sources/animals/PLAYER2/Cat2.png").getImage().getScaledInstance(80, 60, Image.SCALE_DEFAULT));
                        label.setIcon(imageIcon);
                        label.addMouseListener(new MyMouseListener());
                        add(label);
                    }
                    break;
                }
                case 3: {
                    if (blocks[tileY][tileX].getA().getPly().getId() == 1) {
                        JLabel label = new JLabel();
                        ImageIcon imageIcon = new ImageIcon(new ImageIcon(imgPath + "/sources/animals/PLAYER1/Dog.png").getImage().getScaledInstance(80, 60, Image.SCALE_DEFAULT));
                        label.setIcon(imageIcon);
                        label.addMouseListener(new MyMouseListener());
                        add(label);
                    } else {
                        JLabel label = new JLabel();
                        ImageIcon imageIcon = new ImageIcon(new ImageIcon(imgPath + "/sources/animals/PLAYER2/Dog2.png").getImage().getScaledInstance(80, 60, Image.SCALE_DEFAULT));
                        label.setIcon(imageIcon);
                        label.addMouseListener(new MyMouseListener());
                        add(label);
                    }

                    break;
                }
                case 4: {
                    if (blocks[tileY][tileX].getA().getPly().getId() == 1) {
                        JLabel label = new JLabel();
                        ImageIcon imageIcon = new ImageIcon(new ImageIcon(imgPath + "/sources/animals/PLAYER1/Wolf.png").getImage().getScaledInstance(80, 60, Image.SCALE_DEFAULT));
                        label.setIcon(imageIcon);
                        label.addMouseListener(new MyMouseListener());
                        add(label);
                    } else {
                        JLabel label = new JLabel();
                        ImageIcon imageIcon = new ImageIcon(new ImageIcon(imgPath + "/sources/animals/PLAYER2/Wolf2.png").getImage().getScaledInstance(80, 60, Image.SCALE_DEFAULT));
                        label.setIcon(imageIcon);
                        label.addMouseListener(new MyMouseListener());
                        add(label);
                    }


                    break;
                }
                case 5: {
                    if (blocks[tileY][tileX].getA().getPly().getId() == 1) {
                        JLabel label = new JLabel();
                        ImageIcon imageIcon = new ImageIcon(new ImageIcon(imgPath + "/sources/animals/PLAYER1/Leopard.png").getImage().getScaledInstance(80, 60, Image.SCALE_DEFAULT));
                        label.setIcon(imageIcon);
                        label.addMouseListener(new MyMouseListener());
                        add(label);
                    } else {
                        JLabel label = new JLabel();
                        ImageIcon imageIcon = new ImageIcon(new ImageIcon(imgPath + "/sources/animals/PLAYER2/Leopard2.png").getImage().getScaledInstance(80, 60, Image.SCALE_DEFAULT));
                        label.setIcon(imageIcon);
                        label.addMouseListener(new MyMouseListener());
                        add(label);
                    }

                    break;
                }
                case 6: {
                    if (blocks[tileY][tileX].getA().getPly().getId() == 1) {
                        JLabel label = new JLabel();
                        ImageIcon imageIcon = new ImageIcon(new ImageIcon(imgPath + "/sources/animals/PLAYER1/Tiger.png").getImage().getScaledInstance(80, 60, Image.SCALE_DEFAULT));
                        label.setIcon(imageIcon);
                        label.addMouseListener(new MyMouseListener());
                        add(label);
                    } else {
                        JLabel label = new JLabel();
                        ImageIcon imageIcon = new ImageIcon(new ImageIcon(imgPath + "/sources/animals/PLAYER2/Tiger2.png").getImage().getScaledInstance(80, 60, Image.SCALE_DEFAULT));
                        label.setIcon(imageIcon);
                        label.addMouseListener(new MyMouseListener());
                        add(label);
                    }

                    break;
                }
                case 7: {
                    if (blocks[tileY][tileX].getA().getPly().getId() == 1) {
                        JLabel label = new JLabel();
                        ImageIcon imageIcon = new ImageIcon(new ImageIcon(imgPath + "/sources/animals/PLAYER1/Lion.png").getImage().getScaledInstance(80, 60, Image.SCALE_DEFAULT));
                        label.setIcon(imageIcon);
                        label.addMouseListener(new MyMouseListener());
                        add(label);
                    } else {
                        JLabel label = new JLabel();
                        ImageIcon imageIcon = new ImageIcon(new ImageIcon(imgPath + "/sources/animals/PLAYER2/Lion2.png").getImage().getScaledInstance(80, 60, Image.SCALE_DEFAULT));
                        label.setIcon(imageIcon);
                        label.addMouseListener(new MyMouseListener());
                        add(label);
                    }
                    break;
                }
                case 8: {
                    if (blocks[tileY][tileX].getA().getPly().getId() == 1) {
                        JLabel label = new JLabel();
                        ImageIcon imageIcon = new ImageIcon(new ImageIcon(imgPath + "/sources/animals/PLAYER1/Elephant.png").getImage().getScaledInstance(80, 60, Image.SCALE_DEFAULT));
                        label.setIcon(imageIcon);
                        label.addMouseListener(new MyMouseListener());
                        add(label);

                    } else {
                        JLabel label = new JLabel();
                        ImageIcon imageIcon = new ImageIcon(new ImageIcon(imgPath + "/sources/animals/PLAYER2/Elephant2.png").getImage().getScaledInstance(80, 60, Image.SCALE_DEFAULT));
                        label.setIcon(imageIcon);
                        label.addMouseListener(new MyMouseListener());
                        add(label);
                    }
                    break;
                }


            }


        }
        class MyMouseListener implements MouseListener{

            @Override
            public void mouseClicked(MouseEvent e) {




            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("mouseClicked");
                //JPanel panel = (JPanel)e.getSource();
                if(!isFrist) {
                    if(board.getBoard()[tileY][tileX].getA()!=null&&board.getBoard()[tileY][tileX].getA().getPly().getId()==turn.getId()){
                        System.out.println(tileY+","+tileX);
                        position[0] = new Position(tileY, tileX);
                        isFrist=true;
                    }
                }
                else{
                    System.out.println(tileY+","+tileX);
                    position[1] = new Position(tileY,tileX);
                    isFinished=true;
                    System.out.println("input finish");
                    isFrist=false;
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

        }
    }

    public Position[] getInputFromTable (Player player){
        return position;
    }

    public boolean isFrist() {
        return isFrist;
    }

    public void setFrist(boolean frist) {
        isFrist = frist;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }
}


