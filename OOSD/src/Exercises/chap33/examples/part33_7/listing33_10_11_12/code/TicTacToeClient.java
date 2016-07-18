/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap33.examples.part33_7.listing33_10_11_12.code;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author Prithpal Sooriya
 */
//extend JApplet, so we can show a GUI (and passible implement on a web page
//implement Runnable, so can use as code for thread
//implement TicTacToeConstants to gain the constants
public class TicTacToeClient extends JApplet implements Runnable, TicTacToeConstants {

    //variables to use
    //indicate if the player has a turn
    private boolean myTurn = false;
    //the token for the player to use (not set yet as we dont know if this client is player 1 or 2)
    private char myToken = ' ';
    //other players token (not set yet as we dont know if this client is player 1 or 2)
    private char otherToken = ' ';

    private Cell[][] cell = new Cell[3][3]; //uses class called Cell, for GUI implimentation

    private JLabel labelTitle = new JLabel(); //JLabel for the title
    private JLabel labelStatus = new JLabel(); //JLabel for the status

    //ints for row and column for the selected move
    private int rowSelected;
    private int columnSelected;

    //Data Input/Output streams to the server
    private DataInputStream fromServer;
    private DataOutputStream toServer;

    //boolean for continue to play default value is true
    private boolean continueToPlay = true;

    //boolean for waiting for this clients turn
    private boolean waiting = true;

    //boolean to indicate if this is a standalone application
    private static boolean isStandAlone = false;

    //HostName or IP address of server
    private String host = "localhost";

    //override method from JApplet
    @Override
    public void init() {
        //pannel to hold cells
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3, 0, 0));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cell[i][j] = new Cell(i, j);
                panel.add(cell[i][j]);
                //panel.add(cell[i][j] = new Cell(i, j));
            }
        }

        //set properties for labels and boarders for JLabels and JPanels
        panel.setBorder(new LineBorder(Color.BLACK, 1));
        labelTitle.setHorizontalAlignment(JLabel.CENTER);
        labelTitle.setFont(new Font("SansSerif", Font.BOLD, 16));
        labelTitle.setBorder(new LineBorder(Color.BLACK, 1));
        labelTitle.setText(" ");
        labelStatus.setBorder(new LineBorder(Color.BLACK, 1));
        labelStatus.setText(" ");
        //place the labelTitle and labelStatus onto the applet
        add(labelTitle, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        add(labelStatus, BorderLayout.SOUTH);

        //call the connectToServer method
        connectToServer();
    }

    //method connectToServer()
    //creates a socket to port 8000 and localhost to connect to server
    private void connectToServer() {
        //try and catch IOException due to streams
        try {
            //create a socket to connect to server
            Socket socket;
            if (isStandAlone) {
                socket = new Socket(host, 8000); //is standalone, so connect to localhost
            } else {
                socket = new Socket(getCodeBase().getHost(), 8000); //not standalone, so connect to correct host
            }

            //cretae a DataInputStream to retrieve data from server
            fromServer = new DataInputStream(socket.getInputStream());

            //create a DataOutputStream to send data to the server
            toServer = new DataOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            System.err.println(ex);
        }

        //control the game on a seperate thread
        Thread thread = new Thread(this); //this class implements runnable so we can use "this" run method
        thread.start();
    }

    //override run() method from runnable
    //so we can add our own code into thread execution
    @Override
    public void run() {
        /*
        IMPORTANT:
        Throughout this code, look through the TicTacToeServer class and the HandleASession class
        This is to ensure each output from server is correctly read on client side
         */
        //try and catch any exception thrown
        try {
            //first this that server sends is if this client is player1 or player 2
            int player = fromServer.readInt();

            if (player == PLAYER1) { //is this client player1
                myToken = 'X';
                otherToken = 'O';
                labelTitle.setText("You are Player1 with Token 'X'"); //inform client is player 1
                labelStatus.setText("Waiting for Player2 to join"); //inform client to wait for player2

                //recieve startup notification from server (this is the random int sent)
                //REMEMBER: when using .readInt, code below is blocked and will wait till server sends Int
                fromServer.readInt(); //ignore whatever is read --> dont need it

                //if above has been read, this means second player has joined
                labelStatus.setText("Player2 has joined. You start first!");

                //player1 starts first, so set myTurn to true
                myTurn = true;
            } else if (player == PLAYER2) { //is this client player2
                myToken = 'O';
                otherToken = 'X';
                labelTitle.setText("You are Player2 with Token 'O'");
                labelStatus.setText("Waiting for player1 to move...");
                //do not need to read anything, as player 1 starts first
            }

            //continue to play loop (broken when DRAW or PLAYER1/2_Won
            while (continueToPlay) {
                //determain if client is player1 or player2
                if (player == PLAYER1) { //client is player1, so player1 move
                    waitForPlayerAction(); //wait for player1 to select move
                    sendMove(); //send the move to the server
                    recieveInfoFromServer(); //recieve if this client has (won||lost||draw) && player2 move to add
                } else if (player == PLAYER2) { //client is player2 so wait for player2 move
                    recieveInfoFromServer(); //recieve if this client has (won||lost||draw) && player1 move to add
                    waitForPlayerAction(); //wait for player2 to select move
                    sendMove(); //send the move to the server
                }
            }
        } catch (Exception ex) {
        }
    }

    //method waitForPlayerAction()
    //infinite while loop till the player select a cell
    //throws InterruptedException for when the thread is told to do something when it is sleeping
    //Exception is highly unlikely since the thread will not have any code in it anyways
    private void waitForPlayerAction() throws InterruptedException {
        while (waiting) {
            Thread.sleep(100);
        }
        //will break out of the loop, when player interacts with an open cell, and turns waiting to false
        waiting = true; //turn waiting back to true since we will need it when it is the players turn again
    }

    //method sendMove()
    //to the DataOutputStream to send the row and column of the selected
    //throws IOException, since we are dealing with streams
    private void sendMove() throws IOException {
        toServer.writeInt(rowSelected);
        toServer.writeInt(columnSelected);
    }

    //method recieveInfoFromServer
    //recieve the Game Status, and opponents move --> done by using the DataInputStream fromServer
    //throws IO exception since we are dealing with stream
    private void recieveInfoFromServer() throws IOException {
        //recieve the game status
        int status = fromServer.readInt();

        //check status to see who won, draw or continue
        if (status == PLAYER1_WON) { //player1 won
            continueToPlay = false; //end main while loop as game ended
            //check if player1 is this client
            if (myToken == 'X') {
                labelStatus.setText("You Won!!!");
            } else if (myToken == 'O') {
                labelStatus.setText("You Lost :(");
                recieveMove(); //recieve the other players move
            }
        } else if (status == PLAYER2_WON) { //player2 won
            continueToPlay = false; //end main while loop as game ended
            if (myToken == 'O') {
                labelStatus.setText("You Won!!!");
            } else if (myToken == 'X') {
                labelStatus.setText("You Lost :(");
                recieveMove(); //recieve other players move
            }
        } else if (status == DRAW) { //no winner, but end game
            continueToPlay = false; //end main while loop as game ended
            labelStatus.setText("END OF GAME: DRAW");

            //player1 starts, there is only 9 moves --> player1 ends game
            if (myToken == 'O') {
                recieveMove(); //recieve player 1's last move
            }
        } else { //game has not ended yet, continue
            recieveMove(); //recieve the opponents move
            labelStatus.setText("Your Turn"); //pront client it is their turn
            myTurn = true; //it is this clients turn
        }
    }

    //method recieveMove()
    //will return the opponents move and places it onto the GUI/Applet
    //throws IOException since we are dealing with input streams
    private void recieveMove() throws IOException {
        //get the other players move
        int row = fromServer.readInt();
        int column = fromServer.readInt();
        cell[row][column].setToken(otherToken);
    }

    //inner class for Cell
    //extends JPanel so can be used as a GUI element
    private class Cell extends JPanel {

        //variables to use
        private int row;
        private int column;
        private char token = ' ';

        //constructor
        public Cell(int row, int column) {
            this.row = row;
            this.column = column;
            setBorder(new LineBorder(Color.BLACK, 1)); //set cell boarder
            addMouseListener(new ClickListener()); //register our own mouse listener class
        }

        //method getToken()
        //returns the token
        public char getToken() {
            return token;
        }

        //method setToken(char token)
        //set a new char to the token
        public void setToken(char token) {
            this.token = token;
            repaint(); //repaint the token on JPanel as new token set
        }

        //override method to paint the token onto JPanel
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (token == 'X') { //paint X to JPanel
                /* params to draw line (line requires 2 points)
                param1 = x coord of point1
                param2 = y coord of point1
                param3 = x coord of point2
                param4 = y coord of point2
                 */
                g.drawLine(10, 10, getWidth() - 10, getHeight() - 10); //first line of cross "\"
                g.drawLine(getWidth() - 10, 10, 10, getHeight() - 10); //second line of cross "/"
            } else if (token == 'O') { //paint O to JPanel
                //getWidth/Height - 20 --> 20 as need diameter
                g.drawOval(10, 10, getWidth() - 20, getHeight() - 20);
            }

        }

        //inner inner class for clickListener
        //INNERCEPTION!!!
        //extends mouse adaptor so we can add own code to mouseClicked
        private class ClickListener extends MouseAdapter {

            //override method mouseClicked to add own code to
            @Override
            public void mouseClicked(MouseEvent me) {
                //check if the cell is not occupied (token == ' ')
                //AND check if it is the players turn
                if (token == ' ' && myTurn) {
                    //it is empty and is the players turn
                    setToken(myToken);
                    myTurn = false; //not the players turn anymore, end their turn
                    //set selected row and column
                    rowSelected = row;
                    columnSelected = column;
                    labelStatus.setText("Waiting for other players move");
                    waiting = false; //player just finished their turn, so done waiting
                    //^^ waiting = false is important as it will break out of while loop in waitForPlayerAction() method
                    //System.out.println("click");
                }
            }
        }
    }

    //finally!!! can call main method to run code
    public static void main(String[] args) {
        //create the Applet
        TicTacToeClient applet = new TicTacToeClient();
        //this is a standalone applet, so turn isStandAlone to true
        isStandAlone = true;
        if (args.length == 1) {
            applet.host = args[0]; //change the host to the argument of different host given
        }

        //invoke init and start methods of applet to initialise and start the applet
        applet.init();
        applet.start();

        //create a frame
        JFrame frame = new JFrame();

        //add the applet to the frame
        frame.add(applet);

        //set frame settings
        frame.setTitle("Tic-Tac-Toe: Client");
        frame.setSize(500, 500);
        //frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
