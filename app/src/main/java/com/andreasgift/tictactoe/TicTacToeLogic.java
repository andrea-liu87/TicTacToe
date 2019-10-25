package com.andreasgift.tictactoe;

public class TicTacToeLogic {

    /********* Instance variables ***********/
    
    private String player1Name;
    private String player2Name;

    // Player 1 = 0, Player 2 = 1
    private int currentPlayer = 0;
    private int[] gameState = {2,2,2, 2,2,2, 2,2,2};

    //getters and setters

    public void setPlayer1Name(String player1Name) {
        this.player1Name = player1Name;
    }

    public void setPlayer2Name(String player2Name) {
        this.player2Name = player2Name;
    }

    public String getPlayer1Name() {
        return player1Name;
    }

    public String getPlayer2Name() {
        return player2Name;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public int getNumberOfSquares() {
        return gameState.length;
    }

    /********** Game-play logic *********/

    public boolean makeMove(int position) {
        if (gameState[position] == 2) {
            gameState[position] = currentPlayer;
            currentPlayer = (currentPlayer == 0) ? 1 : 0;
            return true;
        }
        return false;
    }
    
    public boolean winningState() {
        boolean win = false;
        if(gameState[0] == currentPlayer && gameState[1] == currentPlayer && gameState[2] == currentPlayer){win= true;}
        else if(gameState[3] == currentPlayer && gameState[4] == currentPlayer && gameState[5] == currentPlayer){win = true;}
        else if(gameState[6] == currentPlayer && gameState[7] == currentPlayer && gameState[8] == currentPlayer){win= true;}
        else if(gameState[0] == currentPlayer && gameState[3] == currentPlayer && gameState[6] == currentPlayer){win= true;}
        else if(gameState[1] == currentPlayer && gameState[4] == currentPlayer && gameState[7] == currentPlayer){win= true;}
        else if(gameState[2] == currentPlayer && gameState[5] == currentPlayer && gameState[8] == currentPlayer){win= true;}
        else if(gameState[0] == currentPlayer && gameState[4] == currentPlayer && gameState[8] == currentPlayer){win= true;}
        else if(gameState[2] == currentPlayer && gameState[4] == currentPlayer && gameState[6] == currentPlayer){win= true;}
        return win;
    }

    public void newGame() {
        for (int i = 0 ; i<gameState.length; i++)
            gameState[i] = 2;
    }

}
