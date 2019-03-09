package com.nhq.berry.chinesechessonline;

public class Board {
    boolean Board[][];
    public Board(){
        Board = new boolean[9][10];
        for(int i=0; i<9;i++){
            for(int j=0; j<10; j++){
                Board[i][j]=false;
            }
        }
    }

    public boolean[][] getBoard() {
        return Board;
    }

    public void setBoardTrue(int locX, int locY) {
        Board[locX][locY] = true;
    }
    public void setBoardFalse(int locX, int locY) {
        Board[locX][locY] = false;
    }
}
