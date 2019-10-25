package edu.andreasgift.tictactoe;


public class TicTacToeLogic {

    /********* Instance variables ***********/

    private String playerOName;
    private String playerXName;

    // Initialize to player O
    private XO currentPlayer = XO.O;
    
    // Initialize the array so each square is empty
    private XO[] gameState = {XO.Empty, XO.Empty, XO.Empty, 
            XO.Empty, XO.Empty, XO.Empty, 
            XO.Empty, XO.Empty, XO.Empty};

    // Setters

    public void setPlayerOName(String playerOName) {
        this.playerOName = playerOName;
    }

    public void setPlayerXName(String playerXName) {
        this.playerXName = playerXName;
    }

    // Getters

    public XO getCurrentPlayer() {
        return currentPlayer;
    }

    public int getNumberOfSquares() {
        return gameState.length;
    }

    public XO[] getGameState() {
        return gameState;
}


    /********** Game-play logic *********/

    public String getCurrentPlayerName() {
        return currentPlayer == XO.O ? playerOName : playerXName;
    }

    public boolean makeMove(int position) {
        // Make sure the squre is empty
        if (gameState[position] == XO.Empty) {
            // Mark the square with an X or O
            gameState[position] = currentPlayer;
            // Switch players
            currentPlayer = (currentPlayer == XO.O) ? XO.X : XO.O;
            return true;
        }
        // The square wasn't empty
        return false;
    }
    
    public boolean winningState() {
        boolean win = false;
        // Check for each of the eight possible winning sets of X's or O's
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
        // Reset the squares to all be empty
        for (int i = 0 ; i<gameState.length; i++)
            gameState[i] = XO.Empty;
        // Set the first player to O
        // TODO: Make this random so O doesn't always start
        currentPlayer = XO.O;
    }

}
