package com.nhq.berry.chinesechessonline;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

public abstract class Character {
    String name;
    Bitmap bitmap;
    int locX;
    int locY;
    boolean isSelected;
    Board availableBoard;
    static Player1 player1;
    static Player2 player2;
    int player;
    boolean isSurvival;


    protected Character(String name, Bitmap bitmap, int player){
        this.name = name;
        this.bitmap = bitmap;
        this.player = player;
        this.availableBoard = new Board();
        this.player1 = new Player1();
        this.player2 = new Player2();
        this.locX = getLocX();
        this.locY = getLocY();
        this.isSurvival = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public int getLocX() {
        return locX;
    }



    public int getLocY() {
        return locY;
    }

    public void setLocXY(int locX, int locY) {
        for(int i=0; i<9;i++){
            for(int j=0; j<10; j++){
                this.availableBoard.Board[i][j]=false;
            }
        }
        this.locX = locX;
        this.locY = locY;
        if(this.player==1){
            player1.setBoardTrue(locX,locY);
        }
        else{
            player2.setBoardTrue(locX,locY);
        }

    }
    public void setLocXY(int locX, int locY, int preLocX, int preLocY, Character[] mGlobal) {
        for(int i=0; i<9;i++){
            for(int j=0; j<10; j++){
                this.availableBoard.Board[i][j]=false;
            }
        }
        this.locX = locX;
        this.locY = locY;
        if(this.player==1){
            player1.setBoardTrue(locX,locY);
            player1.setBoardFalse(preLocX,preLocY);
        }
        if(this.player==2){
            player2.setBoardTrue(locX,locY);
            player2.setBoardFalse(preLocX,preLocY);
        }
        for(int i=0; i<mGlobal.length;i++){
            mGlobal[i].defindAvailableSteps(player1,player2,locX,locY);
        }
    }

    public boolean isChecked(float x, float y, int []locationX, int []locationY){
        if((x>locationX[locX])&&(y>locationY[locY])&&(x<locationX[locX]+bitmap.getWidth())&&(y<locationY[locY]+bitmap.getHeight())){
            return true;
        }
        else return false;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public abstract Board defindAvailableSteps(Player1 player1Board, Player2 player2Board, int locX, int locY);

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public Board getAvailableBoard() {
        return availableBoard;
    }

    public void setAvailableBoard(Board availableBoard) {
        this.availableBoard = availableBoard;
    }
    public void setAvailableBoard(int locX, int locY) {
        this.availableBoard.setBoardTrue(locX,locY);
    }

    public void draw(Canvas canvas, Paint paint, int [] boardLocationX, int [] boardLocationY){
        canvas.drawBitmap(this.bitmap,boardLocationX[locX],boardLocationY[locY],paint);
    }

    public void moveCharacter(float x, float y, int [] locationX, int [] locationY, Character mGlobal, Character[] mBigGlobal) {
        for (int m = 0; m < 9; m++) {
            for (int n = 0; n < 10; n++) {
//                Log.d("Chess","m= "+m);
//                Log.d("Chess","m="+m+" n="+n+" available :"+mGlobal.availableBoard.getBoard()[m][n]);

                if(mGlobal.availableBoard.getBoard()[m][n]&&
                        (x>locationX[m])&&(y>locationY[n])&&
                        (x<locationX[m]+bitmap.getWidth())&&
                        (y<locationY[n]+bitmap.getHeight())){
//                    Log.d("Chess","m= "+m);
                    mGlobal.setLocXY(m,n,mGlobal.locX,mGlobal.locY, mBigGlobal);
                    if(mGlobal.player==1 && player2.Board[m][n]){
                        for(int h=0; h<mBigGlobal.length; h++){
                            if(mBigGlobal[h].locX == m && mBigGlobal[h].locY==n && mBigGlobal[h]!=mGlobal){
                                mBigGlobal[h].setDead();
                            }
                        }
                    }
                    if(mGlobal.player==2 && player1.Board[m][n]){
                        for(int h=0; h<mBigGlobal.length; h++){
                            if(mBigGlobal[h].locX == m && mBigGlobal[h].locY==n && mBigGlobal[h]!=mGlobal){
                                mBigGlobal[h].setDead();
                            }
                        }
                    }
                }
            }
        }

    }

    public boolean isSurvival() {
        return isSurvival;
    }

    public void setSurvival(boolean survival) {
        isSurvival = survival;
    }
    public void setDead() {
        isSurvival = false;
        if(this.player==1){
            player1.Board[this.locX][this.locY] = false;
        }
        if(this.player==2){
            player2.Board[this.locX][this.locY] = false;
        }

    }
}
