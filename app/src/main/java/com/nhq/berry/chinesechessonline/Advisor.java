package com.nhq.berry.chinesechessonline;

import android.graphics.Bitmap;

public class Advisor extends Character {
    protected Advisor(String name, Bitmap bitmap, int player) {
        super(name, bitmap, player);
    }

    @Override
    public Board defindAvailableSteps(Player1 player1Board, Player2 player2Board, int locX, int locY) {
        // To reset the available board
        for(int m=0; m<9; m++){
            for(int n=0; n<10; n++){
                availableBoard.setBoardFalse(m,n);

            }
        }
        // Defind Available Steps
        if(this.player==1) {
            if (locX-1>2 && locY-1>=0 && !player1.Board[locX-1][locY-1]) availableBoard.setBoardTrue(locX-1,locY-1);
            if (locX+1<6  && locY+1<3 && !player1.Board[locX+1][locY+1]) availableBoard.setBoardTrue(locX+1,locY+1);
            if (locX-1>2 && locY+1<3 && !player1.Board[locX-1][locY+1]) availableBoard.setBoardTrue(locX-1,locY+1);
            if (locX+1<6  && locY-1>=0 && !player1.Board[locX+1][locY-1]) availableBoard.setBoardTrue(locX+1,locY-1);
        }
        if(this.player==2) {
            if (locX-1>2 && locY-1>=7 && !player2.Board[locX-1][locY-1]) availableBoard.setBoardTrue(locX-1,locY-1);
            if (locX+1<6  && locY+1<10 && !player2.Board[locX+1][locY+1]) availableBoard.setBoardTrue(locX+1,locY+1);
            if (locX-1>2 && locY+1<10 && !player2.Board[locX-1][locY+1]) availableBoard.setBoardTrue(locX-1,locY+1);
            if (locX+1<6  && locY-1>=7 && !player2.Board[locX+1][locY-1]) availableBoard.setBoardTrue(locX+1,locY-1);
        }
        this.setAvailableBoard(availableBoard);
        return availableBoard;
    }
}
