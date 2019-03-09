package com.nhq.berry.chinesechessonline;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class ChessBoardView extends View {

    Handler handler;
    Runnable runnable;
    Bitmap chessBoard, chessMans, king1, king2, advisor1, advisor2, elephant1, elephant2;
    Bitmap horse1, horse2, chariot1, chariot2, cannon1, cannon2, sodier1, sodier2;
    int UPDATE_MILLIS = 40;
    Display display;
    int dWidth, dHeight;
    Point point;
    int [] boardLocationX;
    int [] boardLocationY;
    int dWidthOfBoard, dHeightOfBoard, leftOfBoard,topOfBoard;
    int DIS_BITMAP;

    // Characters in classes
    Chariot cChariot11, cChariot12, cChariot21, cChariot22;
    Cannon cCannon11, cCannon12, cCannon21, cCannon22;
    Sodier sSodier11, sSodier12, sSodier13,sSodier14,sSodier15,sSodier21,sSodier22,sSodier23,sSodier24,sSodier25;
    King kKing1, kKing2;
    Horse hHorse11, hHorse12,hHorse21,hHorse22;
    Elephant eElephant11, eElephant12, eElephant21, eElephant22;
    Advisor aAvisor11, aAvisor12, aAvisor21, aAvisor22;
    Character[] mGlobal;


    public ChessBoardView(Context context) {
        super(context);
        // This is custom view
        // Handler uses to keep delay the runnable
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                invalidate();
            }
        };


        //Getting bitmaps
        DIS_BITMAP = (int)pxTodp(315);
        chessBoard = BitmapFactory.decodeResource(context.getResources(),
                R.drawable.chessboard);
        chessMans = BitmapFactory.decodeResource(context.getResources(),
                R.drawable.chessman);
        king1      = Bitmap.createBitmap(chessMans, 0*DIS_BITMAP,DIS_BITMAP,DIS_BITMAP,DIS_BITMAP);
        king2      = Bitmap.createBitmap(chessMans, 7*DIS_BITMAP,DIS_BITMAP,DIS_BITMAP,DIS_BITMAP);
        advisor1   = Bitmap.createBitmap(chessMans, 1*DIS_BITMAP,DIS_BITMAP,DIS_BITMAP,DIS_BITMAP);
        advisor2   = Bitmap.createBitmap(chessMans, 8*DIS_BITMAP,DIS_BITMAP,DIS_BITMAP,DIS_BITMAP);
        elephant1  = Bitmap.createBitmap(chessMans, 2*DIS_BITMAP,DIS_BITMAP,DIS_BITMAP,DIS_BITMAP);
        elephant2  = Bitmap.createBitmap(chessMans, 9*DIS_BITMAP,DIS_BITMAP,DIS_BITMAP,DIS_BITMAP);
        horse1     = Bitmap.createBitmap(chessMans, 3*DIS_BITMAP,DIS_BITMAP,DIS_BITMAP,DIS_BITMAP);
        horse2     = Bitmap.createBitmap(chessMans, 10*DIS_BITMAP,DIS_BITMAP,DIS_BITMAP,DIS_BITMAP);
        chariot1   = Bitmap.createBitmap(chessMans, 4*DIS_BITMAP,DIS_BITMAP,DIS_BITMAP,DIS_BITMAP);
        chariot2   = Bitmap.createBitmap(chessMans, 11*DIS_BITMAP,DIS_BITMAP,DIS_BITMAP,DIS_BITMAP);
        cannon1    = Bitmap.createBitmap(chessMans, 5*DIS_BITMAP,DIS_BITMAP,DIS_BITMAP,DIS_BITMAP);
        cannon2    = Bitmap.createBitmap(chessMans, 12*DIS_BITMAP,DIS_BITMAP,DIS_BITMAP,DIS_BITMAP);
        sodier1    = Bitmap.createBitmap(chessMans, 6*DIS_BITMAP,DIS_BITMAP,DIS_BITMAP,DIS_BITMAP);
        sodier2    = Bitmap.createBitmap(chessMans, 13*DIS_BITMAP,DIS_BITMAP,DIS_BITMAP,DIS_BITMAP);


        //Getting the size of display
        display = ((Activity)getContext()).getWindowManager().getDefaultDisplay();
        point = new Point();
        display.getSize(point);
        dWidth = point.x;
        dHeight = point.y;

        //Feature for the Board
        dWidthOfBoard = chessBoard.getWidth();
        dHeightOfBoard = chessBoard.getHeight();
        leftOfBoard = (dWidth-dWidthOfBoard)/2;
        topOfBoard = 100;
        int distanceOfASquare = pxTodp(320);

        //Creating Location on the Board that help we draw easily when know the location in integer numbers!
        boardLocationX = new int[9];
        boardLocationY = new int[10];
        int ramForLocationX = leftOfBoard;
        for(int i=0; i< boardLocationX.length; i++){
            boardLocationX[i]= ramForLocationX;
            ramForLocationX +=distanceOfASquare;
        }

        int ramForLocationY = topOfBoard;
        for(int i=0; i< boardLocationY.length; i++){
            boardLocationY[i]= ramForLocationY;
            ramForLocationY +=distanceOfASquare;
        }
        //Declare mGlobal
        mGlobal = new Character[32];


        // Declare characters that with ability to move and  beat other
        mGlobal[0] = cChariot11 = new Chariot("chariot11", chariot1,1);
        mGlobal[1] = cChariot12 = new Chariot("chariot12", chariot1,1,Character.player1,Character.player2);
        mGlobal[2] = cChariot21 = new Chariot("chariot21", chariot2,2,Character.player1,Character.player2);
        mGlobal[3] = cChariot22 = new Chariot("chariot22", chariot2,2,Character.player1,Character.player2);
        mGlobal[4] = cCannon11  = new Cannon("cannon11",cannon1,1);
        mGlobal[5] = cCannon12  = new Cannon("cannon12",cannon1,1);
        mGlobal[6] = cCannon21  = new Cannon("cannon21",cannon2,2);
        mGlobal[7] = cCannon22  = new Cannon("cannon22",cannon2,2);
        mGlobal[8] = sSodier11  = new Sodier("sodier11",sodier1,1);
        mGlobal[9] = sSodier12  = new Sodier("sodier12",sodier1,1);
        mGlobal[10] = sSodier13  = new Sodier("sodier13",sodier1,1);
        mGlobal[11] = sSodier14  = new Sodier("sodier14",sodier1,1);
        mGlobal[12] = sSodier15  = new Sodier("sodier15",sodier1,1);
        mGlobal[13] = sSodier21  = new Sodier("sodier21",sodier2,2);
        mGlobal[14] = sSodier22  = new Sodier("sodier22",sodier2,2);
        mGlobal[15] = sSodier23  = new Sodier("sodier23",sodier2,2);
        mGlobal[16] = sSodier24  = new Sodier("sodier24",sodier2,2);
        mGlobal[17] = sSodier25  = new Sodier("sodier25",sodier2,2);
        mGlobal[18] = kKing1  = new King("king1",king1,1);
        mGlobal[19] = kKing2  = new King("king2",king2,2);
        mGlobal[20] = hHorse11  = new Horse("horse11",horse1,1);
        mGlobal[21] = hHorse12  = new Horse("horse12",horse1,1);
        mGlobal[22] = hHorse21  = new Horse("horse21",horse2,2);
        mGlobal[23] = hHorse22  = new Horse("horse22",horse2,2);
        mGlobal[24] = eElephant11 = new Elephant("elephant11",elephant1,1);
        mGlobal[25] = eElephant12 = new Elephant("elephant12",elephant1,1);
        mGlobal[26] = eElephant21 = new Elephant("elephant21",elephant2,2);
        mGlobal[27] = eElephant22 = new Elephant("elephant22",elephant2,2);
        mGlobal[28] = aAvisor11 = new Advisor("advisor11", advisor1,1);
        mGlobal[29] = aAvisor12 = new Advisor("advisor12", advisor1,1);
        mGlobal[30] = aAvisor21 = new Advisor("advisor21", advisor2,2);
        mGlobal[31] = aAvisor22 = new Advisor("advisor22", advisor2,2);


        // Declare location for characters and show it true on player board
        startGame();


    }



    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // We'll draw the view here
        Paint paint = new Paint();
        canvas.drawPaint(paint);

        // Set time to delay
        handler.postDelayed(runnable,UPDATE_MILLIS);

        // Draw a chessboard
        canvas.drawBitmap(chessBoard, leftOfBoard, topOfBoard, paint);


        // Draw chessmans
//        Log.d("Chess",""+cChariot11.getLocX());
        for(int i=0; i<mGlobal.length; i++) {
            if(mGlobal[i].isSurvival) {
                mGlobal[i].draw(canvas, paint, boardLocationX, boardLocationY);
            }

        }

        // Draw to know the current selected chessman and the available next steps of the selected chessman
        for(int i=0; i<mGlobal.length; i++){
            if(mGlobal[i].isSelected){
                paint.setColor(getResources().getColor(R.color.colorSelected));
                paint.setAlpha(150);
                int size = mGlobal[i].getBitmap().getHeight()/2;
                canvas.drawCircle(boardLocationX[mGlobal[i].getLocX()]+size,boardLocationY[mGlobal[i].getLocY()]+size,size,paint);

                for(int m=0; m<9; m++){
                    for(int n=0; n<10; n++){
                        if(mGlobal[i].defindAvailableSteps(Character.player1,Character.player2, mGlobal[i].getLocX(),  mGlobal[i].getLocY()).Board[m][n]){
//                            Log.d("Chess","m= "+m+" n="+n);
//                            Log.d("Chess","i= "+i);
                            paint.setColor(getResources().getColor(R.color.colorAccent));
                            paint.setAlpha(180);
                            canvas.drawCircle(boardLocationX[m]+size,boardLocationY[n]+size,size/2,paint);
                        }
                    }
                }
            }
        }
    }


    public static int pxTodp(int px) {
        return (int) (px / Resources.getSystem().getDisplayMetrics().density);
    }


    @Override
    public boolean onTouchEvent(MotionEvent e) {
        // MotionEvent reports input details from the touch screen
        // and other input controls. In this case, you are only
        // interested in events where the touch position changed.
        float x = e.getX();
        float y = e.getY();

        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:{

                // To move the character
                for(int i=0; i<mGlobal.length; i++){
                    if(mGlobal[i].isSelected&& mGlobal[i].isSurvival){
                        Log.d("Chess", "Move character");
                        mGlobal[i].moveCharacter(x,y,boardLocationX,boardLocationY, mGlobal[i],mGlobal);

                        // To do to support sodier class
                        Sodier.incressStep(mGlobal[i], sSodier11);
                        Sodier.incressStep(mGlobal[i], sSodier12);
                        Sodier.incressStep(mGlobal[i], sSodier13);
                        Sodier.incressStep(mGlobal[i], sSodier14);
                        Sodier.incressStep(mGlobal[i], sSodier15);
                        Sodier.incressStep(mGlobal[i], sSodier21);
                        Sodier.incressStep(mGlobal[i], sSodier22);
                        Sodier.incressStep(mGlobal[i], sSodier23);
                        Sodier.incressStep(mGlobal[i], sSodier24);
                        Sodier.incressStep(mGlobal[i], sSodier25);
                    }
                }

                // To check and uncheck
                for(int i=0; i<mGlobal.length; i++){
                    if(mGlobal[i].isChecked(x,y,boardLocationX,boardLocationY)&& mGlobal[i].isSurvival){
                        mGlobal[i].defindAvailableSteps(Character.player1,Character.player2,mGlobal[i].locX,mGlobal[i].locY);
                        if(mGlobal[i].isSelected){
                            mGlobal[i].setSelected(false);
                        }
                        else{
                            for(int j=0; j<mGlobal.length; j++){
                                mGlobal[j].setSelected(false);
                            }
                            mGlobal[i].setSelected(true);
                        }
//                        Log.d("Chess",""+mGlobal[i].isSelected);
                    }

                }
            }
        }
        return true;
    }

    public void startGame(){
        cChariot11.setLocXY(0,0);
        cChariot12.setLocXY(8,0);
        cChariot21.setLocXY(0,9);
        cChariot22.setLocXY(8,9);
        cCannon11.setLocXY(1,2);
        cCannon12.setLocXY(7,2);
        cCannon21.setLocXY(1,7);
        cCannon22.setLocXY(7,7);
        sSodier11.setLocXY(0,3);
        sSodier12.setLocXY(2,3);
        sSodier13.setLocXY(4,3);
        sSodier14.setLocXY(6,3);
        sSodier15.setLocXY(8,3);
        sSodier21.setLocXY(0,6);
        sSodier22.setLocXY(2,6);
        sSodier23.setLocXY(4,6);
        sSodier24.setLocXY(6,6);
        sSodier25.setLocXY(8,6);
        kKing1.setLocXY(4,0);
        kKing2.setLocXY(4,9);
        hHorse11.setLocXY(1,0);
        hHorse12.setLocXY(7,0);
        hHorse21.setLocXY(1,9);
        hHorse22.setLocXY(7,9);
        eElephant11.setLocXY(2,0);
        eElephant12.setLocXY(6,0);
        eElephant21.setLocXY(2,9);
        eElephant22.setLocXY(6,9);
        aAvisor11.setLocXY(3,0);
        aAvisor12.setLocXY(5,0);
        aAvisor21.setLocXY(3,9);
        aAvisor22.setLocXY(5,9);

    }

}