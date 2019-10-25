package com.andreasgift.tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements View.OnTouchListener, TextView.OnEditorActionListener {

    // Widget object references
    EditText player1EditText;
    EditText player2EditText;

    TicTacToeLogic game = new TicTacToeLogic();


    Button endButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        player1EditText = findViewById(R.id.player1EditText);
        player2EditText = findViewById(R.id.player2EditText);
        endButton = findViewById(R.id.endButton);
    }

    //This method to trigger the image appear when palyer click the box
    public void dropIn(View view){

        ImageView clickedView = (ImageView)view;
        int gamePosition = Integer.parseInt(clickedView.getTag().toString());
        if (game.makeMove(gamePosition)) {
            if(game.getCurrentPlayer() == 0) {
            clickedView.setImageResource(android.R.drawable.ic_delete);
                if(game.winningState()){
                    endButton.setVisibility(View.VISIBLE);
                    endButton.setText("Player 1 win!"+"\n"+"Play again?");}
            } else {
            clickedView.setImageResource(android.R.drawable.presence_online);
                if(game.winningState()) {
                    endButton.setVisibility(View.VISIBLE);
                    endButton.setText("Player 2 win!"+"\n"+"Play again?");}
            }
        } else {
            endButton.setVisibility(View.VISIBLE);
            endButton.setText("It is a draw!"+"\n"+"Play again?");
        }
    }


    //This method will restart the game
    public void endButton (View view){
        for (int i = 0 ; i < game.getNumberOfSquares(); i++) {
            ImageView imageView =
                    (ImageView)findViewById(R.id.constraint_layout).findViewWithTag(String.valueOf(i));
            imageView.setImageResource(0);
            endButton.setVisibility(View.INVISIBLE);
        }
        game.newGame();
    }


    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        String playerName = "";
        if(i == EditorInfo.IME_ACTION_DONE || i == EditorInfo.IME_ACTION_UNSPECIFIED) {
            playerName = player1EditText.getText().toString();
            if (playerName != "")
                game.setPlayer1Name(playerName);

            playerName = player2EditText.getText().toString();
            if (playerName != "")
                game.setPlayer2Name(playerName);

        }
        return false;
    }
}
