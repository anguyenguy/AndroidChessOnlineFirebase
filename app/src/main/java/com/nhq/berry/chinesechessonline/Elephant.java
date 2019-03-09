package com.nhq.berry.chinesechessonline;

import android.graphics.Bitmap;

public class Elephant extends Character {
    protected Elephant(String name, Bitmap bitmap, int player) {
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
            if (locX-2>=0 && locY-2>=0 && !player1.Board[locX-2][locY-2] && !player1.Board[locX-1][locY-1] && !player2.Board[locX-1][locY-1])
                availableBoard.setBoardTrue(locX-2, locY-2);
            if (locX+2<9 && locY+2<10 && !player1.Board[locX+2][locY+2] && !player1.Board[locX+1][locY+1] && !player2.Board[locX+1][locY+1])
                availableBoard.setBoardTrue(locX+2, locY+2);
            if (locX-2>=0 && locY+2<10 && !player1.Board[locX-2][locY+2] && !player1.Board[locX-1][locY+1] && !player2.Board[locX-1][locY+1])
                availableBoard.setBoardTrue(locX-2, locY+2);
            if (locX+2<9 && locY-2>=0 && !player1.Board[locX+2][locY-2] && !player1.Board[locX+1][locY-1] && !player2.Board[locX+1][locY-1])
                availableBoard.setBoardTrue(locX+2, locY-2);
        }
        if(this.player==2) {
            if (locX-2>=0 && locY-2>=0 && !player2.Board[locX-2][locY-2] && !player1.Board[locX-1][locY-1] && !player2.Board[locX-1][locY-1])
                availableBoard.setBoardTrue(locX-2, locY-2);
            if (locX+2<9 && locY+2<10 && !player2.Board[locX+2][locY+2] && !player1.Board[locX+1][locY+1] && !player2.Board[locX+1][locY+1])
                availableBoard.setBoardTrue(locX+2, locY+2);
            if (locX-2>=0 && locY+2<10 && !player2.Board[locX-2][locY+2] && !player1.Board[locX-1][locY+1] && !player2.Board[locX-1][locY+1])
                availableBoard.setBoardTrue(locX-2, locY+2);
            if (locX+2<9 && locY-2>=0 && !player2.Board[locX+2][locY-2] && !player1.Board[locX+1][locY-1] && !player2.Board[locX+1][locY-1])
                availableBoard.setBoardTrue(locX+2, locY-2);
        }

        this.setAvailableBoard(availableBoard);
        return availableBoard;
    }
}
