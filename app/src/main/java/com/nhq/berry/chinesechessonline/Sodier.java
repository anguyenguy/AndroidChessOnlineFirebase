package com.nhq.berry.chinesechessonline;

import android.graphics.Bitmap;
import android.util.Log;

public class Sodier extends Character {

    int numberOfSteps;
    protected Sodier(String name, Bitmap bitmap, int player) {
        super(name, bitmap, player);
        numberOfSteps = 0;
    }

    @Override
    public Board defindAvailableSteps(Player1 player1Board, Player2 player2Board, int locX, int locY) {
        // To set this only go up 2 first steps

//        Log.d("Chess","Step :"+numberOfSteps);
        // To reset the available board
        for(int m=0; m<9; m++){
            for(int n=0; n<10; n++){
                availableBoard.setBoardFalse(m,n);

            }
        }

        if(this.player==1 && locY+1 < 10 && !player1.Board[locX][locY+1]) {

            availableBoard.setBoardTrue(locX, locY + 1);
        }
        if(this.player==2 && locY-1 >= 0 && !player2.Board[locX][locY-1]){
            availableBoard.setBoardTrue(locX,locY-1);
        }
        if(numberOfSteps>=2 ){
            if(this.player==1) {
                if (locX - 1 >= 0 && !player1.Board[locX-1][locY]) availableBoard.setBoardTrue(locX - 1, locY);
                if (locX + 1 < 9 && !player1.Board[locX+1][locY]) availableBoard.setBoardTrue(locX + 1, locY);
                if (locY - 1 >= 0 && this.player == 2 && !player1.Board[locX][locY-1]) availableBoard.setBoardTrue(locX, locY - 1);
                if (locY + 1 < 10 && this.player == 1 && !player1.Board[locX][locY+1]) availableBoard.setBoardTrue(locX, locY + 1);
            }
            if(this.player==2) {
                if (locX - 1 >= 0 && !player2.Board[locX-1][locY]) availableBoard.setBoardTrue(locX - 1, locY);
                if (locX + 1 < 9 && !player2.Board[locX+1][locY]) availableBoard.setBoardTrue(locX + 1, locY);
                if (locY - 1 >= 0 && this.player == 2 && !player2.Board[locX][locY-1]) availableBoard.setBoardTrue(locX, locY - 1);
                if (locY + 1 < 10 && this.player == 1 && !player2.Board[locX][locY+1]) availableBoard.setBoardTrue(locX, locY + 1);
            }

        }


        this.setAvailableBoard(availableBoard);
        return availableBoard;
    }
    public static void incressStep(Character character, Sodier sodier){
        if(character== sodier){
            sodier.numberOfSteps++;
        }
    }
}
