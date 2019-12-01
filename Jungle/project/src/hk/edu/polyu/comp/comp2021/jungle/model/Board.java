package hk.edu.polyu.comp.comp2021.jungle.model;

public class Board {
    private Block[][] board = new Block[9][7];
    /**
     * Calling Board constructor initializes a board
     * Board initialization can be moved if necessary(for using animal objects)
     *
     * @param pl1 playerName1
     * @param pl2 playerName2
     * @return Nothing
     */
    public Board(String pl1, String pl2){
        Block[][] blocks = new Block[9][7];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 7; j++) {
                blocks[i][j] = new Block();
            }
        }
        Player player1 = new Player(pl1, 1);
        Player player2 = new Player(pl2, 2);
        Position p;
        Animal rat1, rat2, cat1, cat2, wolf1, wolf2, dog1, dog2,
                panther1, panther2, tiger1, tiger2, lion1, lion2,
                elephant1, elephant2;
        for (int i = 1; i <= 8; i++) { //loop for player2(top player)
            switch (i){
                case 1:{
                    p = new Position(2,0);
                    rat2 = new Animal(1, p, player2);
                    blocks[2][0].setA(rat2);
                    break;
                }
                case 2:{
                    p = new Position(1,5);
                    cat2 = new Animal(2, p, player2);
                    blocks[1][5].setA(cat2);
                    break;
                }
                case 3:{
                    p = new Position(2,4);
                    wolf2 = new Animal(3, p, player2);
                    blocks[2][4].setA(wolf2);
                    break;
                }
                case 4:{
                    p = new Position(1,1);
                    dog2 = new Animal(4, p, player2);
                    blocks[1][1].setA(dog2);
                    break;
                }
                case 5:{
                    p = new Position(2,2);
                    panther2 = new Animal(5, p, player2);
                    blocks[2][2].setA(panther2);
                    break;
                }
                case 6:{
                    p = new Position(0,6);
                    tiger2 = new Animal(6, p, player2);
                    blocks[0][6].setA(tiger2);
                    break;
                }
                case 7:{
                    p = new Position(0,0);
                    lion2 = new Animal(7, p, player2);
                    blocks[0][0].setA(lion2);
                    break;
                }
                case 8:{
                    p = new Position(2,6);
                    elephant2 = new Animal(8, p, player2);
                    blocks[2][6].setA(elephant2);
                    break;
                }
            }
        }
        for (int i = 1; i <= 8; i++) { //loop for player1(bottom player)
            switch (i){
                case 1:{
                    p = new Position(6,6);
                    rat1 = new Animal(i, p, player1);
                    blocks[6][6].setA(rat1);
                    break;
                }
                case 2:{
                    p = new Position(7,1);
                    cat1 = new Animal(i, p, player1);
                    blocks[7][1].setA(cat1);
                    break;
                }
                case 3:{
                    p = new Position(6,2);
                    wolf1 = new Animal(i, p, player1);
                    blocks[6][2].setA(wolf1);
                    break;
                }
                case 4:{
                    p = new Position(7,5);
                    dog1 = new Animal(i, p, player1);
                    blocks[7][5].setA(dog1);
                    break;
                }
                case 5:{
                    p = new Position(6,4);
                    panther1 = new Animal(i, p, player1);
                    blocks[6][4].setA(panther1);
                    break;
                }
                case 6:{
                    p = new Position(8,0);
                    tiger1 = new Animal(i, p, player1);
                    blocks[8][0].setA(tiger1);
                    break;
                }
                case 7:{
                    p = new Position(8,6);
                    lion1 = new Animal(i, p, player1);
                    blocks[8][6].setA(lion1);
                    break;
                }
                case 8:{
                    p = new Position(6,0);
                    elephant1 = new Animal(i, p, player1);
                    blocks[6][0].setA(elephant1);
                    break;
                }
            }
        }
        //setting up the rivers
        for (int i = 3; i <= 5; i++) {
            for (int j = 1; j <= 2; j++) {
                blocks[i][j].setBlockType(1);
            }
        }
        for (int i = 3; i <= 5; i++) {
            for (int j = 4; j <= 5; j++) {
                blocks[i][j].setBlockType(1);
            }
        }
        //setting up the traps and goals
        blocks[0][2].setBlockType(2);
        blocks[0][4].setBlockType(2);
        blocks[1][3].setBlockType(2);
        blocks[7][3].setBlockType(2);
        blocks[8][2].setBlockType(2);
        blocks[8][4].setBlockType(2);

        blocks[0][3].setBlockType(3);
        blocks[0][3].setPlayer(player2); //set player on goal block
        blocks[8][3].setBlockType(3);
        blocks[8][3].setPlayer(player1);

        setBoard(blocks);
        //print();
    }

    public Block[][] getBoard() {
        return board;
    }

    public void setBoard(Block[][] board){
        this.board=board;
    }

    /**
     * print is simply used for printing either animal ranks or field types
     * (just for testing)
     */
    public void print(){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 7; j++) {
                if(board[i][j].getA() == null){
                    System.out.print("0");
                }
                else{
                    System.out.print(board[i][j].getA().getRank());
                }
                //System.out.print(board[i][j].getBlockType());
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
}
