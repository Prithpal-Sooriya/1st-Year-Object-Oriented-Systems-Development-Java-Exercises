/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap33.examples.part33_7.listing33_10_11_12.code;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Prithpal Sooriya
 */
//implements Runnable, so can be used as a thread
//implements TicTacToeConstants so can use the constants
public class HandleASession implements Runnable, TicTacToeConstants {

    //variables that will be used
    //socket to communicate to player 1 and 2
    private Socket player1;
    private Socket player2;
    //DataInputStream and DataOutputStream to send and recieve data from player1/2
    private DataInputStream fromPlayer1;
    private DataInputStream fromPlayer2;
    private DataOutputStream toPlayer1;
    private DataOutputStream toPlayer2;
    //char[][] array for the tic-tac-toe board
    char[][] cell = new char[3][3];
    //boolean to check if the game has ended or not (starts at true)
    private boolean continueToPlay = true;

    //constructor
    public HandleASession(Socket player1, Socket player2) {
        this.player1 = player1;
        this.player2 = player2;

        //Initialise the cells
        for (int i = 0; i < cell.length; i++) {
            for (int j = 0; j < cell[i].length; j++) {
                cell[i][j] = ' ';
            }
        }
    }

    //override method from Runnable to run own code in thread
    @Override
    public void run() {
        //try catch for IOException for streams
        try {
            //create/initialise the Data input/output streams
            fromPlayer1 = new DataInputStream(player1.getInputStream());
            fromPlayer2 = new DataInputStream(player2.getInputStream());
            toPlayer1 = new DataOutputStream(player1.getOutputStream());
            toPlayer2 = new DataOutputStream(player2.getOutputStream());

            //write anything to player1 to tell them to start
            toPlayer1.writeInt(1);

            //continuously loop to serve players turn and report the game status to players
            while (true) {
                //recieve a move from player 1
                int row = fromPlayer1.readInt();
                int column = fromPlayer1.readInt();
                cell[row][column] = 'X';

                //check if player1 wins
                if (isWon('X')) {
                    //player1 has won, notify all players
                    toPlayer1.writeInt(PLAYER1_WON);
                    toPlayer2.writeInt(PLAYER1_WON);
                    sendMove(toPlayer2, row, column); //send the opponents move to the player
                    break; //break out of the WHILE loop
                } else if (isFull()) {
                    //the board is full so it is a draw
                    //notify all players that it is a draw
                    toPlayer1.writeInt(DRAW);
                    toPlayer2.writeInt(DRAW);
                    sendMove(toPlayer2, row, column); //send the opponents move to the player
                    break; //break out of the WHILE loop
                } else {
                    //no player has won so continue
                    //notify player2 to continue
                    toPlayer2.writeInt(CONTINUE);
                    sendMove(toPlayer2, row, column); //send the opponents move to the player
                }

                //PLAYER 2'S TURN
                //recieve a move from player2
                row = fromPlayer2.readInt();
                column = fromPlayer2.readInt();
                cell[row][column] = 'O';

                //check if player2 wins
                if (isWon('O')) {
                    //player2 has won, notify all players
                    toPlayer1.writeInt(PLAYER2_WON);
                    toPlayer2.writeInt(PLAYER2_WON);
                    sendMove(toPlayer1, row, column); //send the opponents move to the player
                    break; //break out of the WHILE loop
                } else if (isFull()) {
                    //the board is full so is draw
                    //notify all players of draw
                    toPlayer1.writeInt(DRAW);
                    toPlayer2.writeInt(DRAW);
                    sendMove(toPlayer1, row, column); //send the opponents move to the player
                    break; //break out of the WHILE loop
                } else {
                    //no one has won
                    //notify player1 to continue and take their turn
                    toPlayer1.writeInt(CONTINUE);
                    sendMove(toPlayer1, row, column); //send the opponents move to the player
                }
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    //method isWon
    //checks if the player (with the character given) has won or not
    //true if the player has won
    private boolean isWon(char playerToken) {
        //check all rows
        for (int i = 0; i < 3; i++) {
            if (cell[i][0] == playerToken && cell[i][1] == playerToken && cell[i][2] == playerToken) {
                //all rows are the same character, so player has won
                return true;
            }
        }
        
        //check all columns
        for(int i = 0; i < 3; i++){
            if(cell[0][i] == playerToken && cell[1][i] == playerToken && cell[2][i] == playerToken){
                //all columns are the same character so player has won
                return true;
            }
        }
        
        //check major diagonal, this diagonal --> "\"
        if(cell[0][0] == playerToken && cell[1][1] == playerToken && cell[2][2] == playerToken){
            //major diagonal are the same character so player has won
            return true;
        }
        
        //check subdiagonal, this diagonal --> "/"
        if(cell[0][2] == playerToken && cell[1][1] == playerToken && cell[2][0] == playerToken){
            //subdiagonal are the same character so player has won
            return true;
        }
        
        //after all those conditions, if none have been met then the player has not won
        return false;
    }

    //method isFull
    //checks if the board is full
    //true if the board is full
    private boolean isFull(){
        for(int i = 0; i < cell.length; i++){
            for(int j = 0; j < cell[i].length; j++){
                if(cell[i][j] == ' '){
                    //the board is not full
                    return false;
                }
            }
        }
        //after passing through the FOR loop, we know that the board is full
        return true;
    }
    
    //method sendMove
    //sends the move (from the DataOutputStream given) to the player
    //sends the row and column given
    //param1 = DataOutputStream --> used to send the row and column
    //param2 = int row --> row to send
    //param3 = int column --> column to send
    //THROWS IOException due to streams
    private void sendMove(DataOutputStream outputToPlayer, int row, int column) throws IOException {
        outputToPlayer.writeInt(row); //send row index to player
        outputToPlayer.writeInt(column); //send column index to player
    }
}
