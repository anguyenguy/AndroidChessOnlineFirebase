package com.nhq.berry.chinesechessonline;

import android.graphics.Bitmap;

public class King extends Character {
    protected King(String name, Bitmap bitmap, int player) {
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
            if (locX - 1 >= 0   && !player1.Board[locX-1][locY]) availableBoard.setBoardTrue(locX - 1, locY);
            if (locX + 1 < 9    && !player1.Board[locX+1][locY]) availableBoard.setBoardTrue(locX + 1, locY);
            if (locY - 1 >= 0   && !player1.Board[locX][locY-1]) availableBoard.setBoardTrue(locX, locY - 1);
            if (locY + 1 < 10   && !player1.Board[locX][locY+1]) availableBoard.setBoardTrue(locX, locY + 1);
        }
        if(this.player==2) {
            if (locX - 1 >= 0   && !player2.Board[locX-1][locY]) availableBoard.setBoardTrue(locX - 1, locY);
            if (locX + 1 < 9    && !player2.Board[locX+1][locY]) availableBoard.setBoardTrue(locX + 1, locY);
            if (locY - 1 >= 0   && !player2.Board[locX][locY-1]) availableBoard.setBoardTrue(locX, locY - 1);
            if (locY + 1 < 10   && !player2.Board[locX][locY+1]) availableBoard.setBoardTrue(locX, locY + 1);
        }


        this.setAvailableBoard(availableBoard);
        return availableBoard;
    }
}
