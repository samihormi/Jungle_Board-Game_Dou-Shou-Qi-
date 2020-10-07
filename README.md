# Jungle_Board-Game 鬥獸棋
Java implementation of the Chinese Board Game: Jungle or Dou Shou Qi (鬥獸棋)

# Overview
The Jungle gameboard represents a jungle terrain with dens, traps "set" around dens, and rivers. 
Each player controls eight game pieces representing different animals of various rank. 
Stronger-ranked animals can capture ("eat") animals of weaker or equal rank. 
The player who is first to maneuver any one of their pieces into the opponent's den(crown) wins the game. 
An alternative way to win is to capture all the opponent's pieces.

# Rules
* Movement
  * Player 1 starts by default. During his turn, a player must move. 
  * All pieces can move one square horizontally or vertically (not diagonally). 
  * A piece may not move into its own den. Animals of either side can move into and out of any trap square. 
  * There are special rules related to the water squares:
    * The rat is the only animal that may go onto a water square.
    * The lion and tiger can jump over a river horizontally or vertically. 
    * They jump from a square on one edge of the river to the next non-water square on the other side. 
    * If that square contains an enemy piece of equal or lower rank, the lion or tiger capture it as part of their jump.
    * A jumping move is blocked (not permitted) if a rat of either color currently occupies any of the intervening water squares.
* Capturing
  * Animals capture opponent pieces by "killing/eating" them (the attacking piece replaces the captured piece on its square; the captured piece is removed from the game). 
  * A piece can capture any enemy piece that has the same or lower rank, with the following exceptions:
  * The rat can "kill" (capture) an elephant, but only from a land square, not from a water square.
  * A rat in the water is invulnerable to capture by any piece on land. (Therefore a rat in the water can only be killed by another rat in the water.)
  * A piece that enters one of the opponent's trap squares is reduced in rank to 0. Thus the trapped piece may be captured by the defending side with any piece, regardless of rank. A trapped piece has its normal rank restored when it exits an opponent's trap square.
  

# Running the Game
To run the game, run "*Appication.java*" under Jungle/project/src/hk/edu/polyu/comp/comp2021/jungle/
![Image of WelcomeScreen](https://github.com/samihormi/Jungle_Board-Game_Dou-Shou-Qi-/blob/master/Jungle/project/src/hk/edu/polyu/comp/comp2021/jungle/view/sources/JungleGame_WelcomeScreen.png)
* You will be prompted to start a new game or load an existing one.

# Game interface
![Image of Game Board](https://github.com/samihormi/Jungle_Board-Game_Dou-Shou-Qi-/blob/master/Jungle/project/src/hk/edu/polyu/comp/comp2021/jungle/view/sources/JungleGame_Board.png)
* Player 1's animals are initialy located in the upper part of the board, while Player 2's animals are located in the lower part.
The dens of both players are represented by crowns.

# [Ref]
https://en.wikipedia.org/wiki/Jungle_(board_game)
