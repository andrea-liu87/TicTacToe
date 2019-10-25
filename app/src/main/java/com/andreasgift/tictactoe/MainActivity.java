package com.andreasgift.tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    // Player 1 = 0, Player 2 = 1
    int player = 0;
    int[] gameState = {2,2,2, 2,2,2, 2,2,2};
    Button endButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        endButton = (Button) findViewById(R.id.end_button);
        setUI();

    }

    //This method to trigger the image appear when palyer click the box
    public void dropIn(View view){

        ImageView view1 = (ImageView)view;
        int gamePosition = Integer.parseInt(view1.getTag().toString());
        if (gameState[gamePosition] == 2){
            gameState[gamePosition] = player;

            if(player == 0){
            view1.setImageResource(android.R.drawable.ic_delete);
                if(winningState(player,gameState)){
                    endButton.setVisibility(View.VISIBLE);
                    endButton.setText("Player 1 win!"+"\n"+"Play again?");}
            player = 1;
            } else {
            view1.setImageResource(android.R.drawable.presence_online);
                if(winningState(player,gameState)){
                    endButton.setVisibility(View.VISIBLE);
                    endButton.setText("Player 1 win!"+"\n"+"Play again?");}
            player = 0;
            }
        } else {
            endButton.setVisibility(View.VISIBLE);
            endButton.setText("It is a draw!"+"\n"+"Play again?");
        }
    }

    //This method to check the winning state
    private boolean winningState(int i, int[] game){
        boolean win = false;
                 if(game[0] == i && game[1] == i && game[2] == i){win = true;}
            else if(game[3] == i && game[4] == i && game[5] == i){win = true;}
            else if(game[6] == i && game[7] == i && game[8] == i){win = true;}
            else if(game[0] == i && game[3] == i && game[6] == i){win = true;}
            else if(game[1] == i && game[4] == i && game[7] == i){win = true;}
            else if(game[2] == i && game[5] == i && game[8] == i){win = true;}
            else if(game[0] == i && game[4] == i && game[8] == i){win = true;}
            else if(game[2] == i && game[4] == i && game[6] == i){win = true;}
        return win;
    }

    //This method will restart the game
    public void endButton (View view){
        for (int i = 0 ; i<gameState.length; i++){
            gameState[i]=2;
            ImageView imageView = (ImageView)findViewById(R.id.constraint_layout).findViewWithTag(String.valueOf(i)
            );
            imageView.setImageResource(0);
            endButton.setVisibility(View.INVISIBLE);
        }

    }

    //This method to set the UI fix with whatever screen size
    private void setUI(){
        int widthScreen = getWindowManager().getDefaultDisplay().getWidth();
        int imageViewSize = (widthScreen)/3 - 80;

        ImageView imageView0 = (ImageView) findViewById(R.id.imageview0);
        imageView0.getLayoutParams().width = imageViewSize;
        imageView0.getLayoutParams().height = imageViewSize;

        ImageView imageView1 = (ImageView) findViewById(R.id.imageview1);
        imageView1.getLayoutParams().width = imageViewSize;
        imageView1.getLayoutParams().height = imageViewSize;

        ImageView imageView2 = (ImageView) findViewById(R.id.imageview2);
        imageView2.getLayoutParams().width = imageViewSize;
        imageView2.getLayoutParams().height = imageViewSize;

        ImageView imageView3 = (ImageView) findViewById(R.id.imageview3);
        imageView3.getLayoutParams().width = imageViewSize;
        imageView3.getLayoutParams().height = imageViewSize;

        ImageView imageView4 = (ImageView) findViewById(R.id.imageview4);
        imageView4.getLayoutParams().width = imageViewSize;
        imageView4.getLayoutParams().height = imageViewSize;

        ImageView imageView5 = (ImageView) findViewById(R.id.imageview5);
        imageView5.getLayoutParams().width = imageViewSize;
        imageView5.getLayoutParams().height = imageViewSize;

        ImageView imageView6 = (ImageView) findViewById(R.id.imageview6);
        imageView6.getLayoutParams().width = imageViewSize;
        imageView6.getLayoutParams().height = imageViewSize;

        ImageView imageView7 = (ImageView) findViewById(R.id.imageview7);
        imageView7.getLayoutParams().width = imageViewSize;
        imageView7.getLayoutParams().height = imageViewSize;

        ImageView imageView8 = (ImageView) findViewById(R.id.imageview8);
        imageView8.getLayoutParams().width = imageViewSize;
        imageView8.getLayoutParams().height = imageViewSize;
    }
}
