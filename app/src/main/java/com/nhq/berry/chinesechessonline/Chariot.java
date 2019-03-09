package com.nhq.berry.chinesechessonline;

import android.graphics.Bitmap;
import android.util.Log;

public class Chariot extends Character{

    Player1 player1;
    Player2 player2;
    boolean isSelected;

    protected Chariot(String name, Bitmap bitmap, int player, Player1 player1, Player2 player2) {
        super(name, bitmap, player);
        this.player1 = player1;
        this.player2 = player2;
        this.isSelected = false;
        this.locX = getLocX();
        this.locY = getLocY();
    }


    @Override
    public Board defindAvailableSteps(Player1 player1Board, Player2 player2Board, int locX, int locY) {
//        Log.d("Chess","locX ="+this.locX);
//        Log.d("Chess","locY ="+this.locY);
        // To reset the available board
        for(int m=0; m<9; m++){
            for(int n=0; n<10; n++){
                availableBoard.setBoardFalse(m,n);
            }
        }

        // Firstly do to player 1
        if(this.player==1) {
            for (int i = 1; i < 9; i++) {
                if(locX-i>=0) {
                    if (!player1Board.getBoard()[locX - i][locY] && !player2Board.getBoard()[locX - i][locY]) {
                        availableBoard.setBoardTrue(locX-i,locY);
                    } else {
                        if (player2Board.getBoard()[locX - i][locY]) {
                            availableBoard.setBoardTrue(locX-i,locY);
                        }
                        break;
                    }
                }

            }
            for (int i = 1; i < 9; i++) {
                if(locX+i<9) {
                    if (!player1Board.getBoard()[locX + i][locY] && !player2Board.getBoard()[locX + i][locY]) {
                        availableBoard.setBoardTrue(locX+i,locY);
                    } else {
                        if (player2Board.getBoard()[locX + i][locY]) {
                            availableBoard.setBoardTrue(locX+i,locY);
                        }
                        break;
                    }
                }

            }
            for (int i = 1; i < 10; i++) {
                if(locY-i>=0) {
                    if (!player1Board.getBoard()[locX][locY - i] && !player2Board.getBoard()[locX][locY - i]) {
                        availableBoard.setBoardTrue(locX,locY-i);
                    } else {
                        if (player2Board.getBoard()[locX][locY - i]) {
                            availableBoard.setBoardTrue(locX,locY-i);
                        }
                        break;
                    }
                }

            }
            for (int i = 1; i < 10; i++) {
                if(locY+i<10) {
                    if (!player1Board.getBoard()[locX][locY + i] && !player2Board.getBoard()[locX][locY + i]) {
                        availableBoard.setBoardTrue(locX,locY+i);
                    } else {

                            if (player2Board.getBoard()[locX][locY + i]) {
                                availableBoard.setBoardTrue(locX,locY+i);
                            }
                        break;

                    }
                }

            }
        }

        if(this.player==2) {
            for (int i = 1; i < 9; i++) {
                if(locX-i>=0) {
                    if (!player1Board.getBoard()[locX - i][locY] && !player2Board.getBoard()[locX - i][locY]) {
                        availableBoard.getBoard()[locX - i][locY] = true;
                    } else {
                        if (player1Board.getBoard()[locX - i][locY]) {
                            availableBoard.getBoard()[locX - i][locY] = true;
                        }
                        break;
                    }
                }

            }
            for (int i = 1; i < 9; i++) {
                if(locX+i<9) {
                    if (!player1Board.getBoard()[locX + i][locY] && !player2Board.getBoard()[locX + i][locY]) {
                        availableBoard.getBoard()[locX + i][locY] = true;
                    } else {
                        if (player1Board.getBoard()[locX + i][locY]) {
                            availableBoard.getBoard()[locX + i][locY] = true;
                        }
                        break;
                    }
                }

            }
            for (int i = 1; i < 10; i++) {
                if(locY-i>=0) {
                    if (!player1Board.getBoard()[locX][locY - i] && !player2Board.getBoard()[locX][locY - i]) {
                        availableBoard.getBoard()[locX][locY - i] = true;
                    } else {
                        if (player1Board.getBoard()[locX][locY - i]) {
                            availableBoard.getBoard()[locX][locY - i ] = true;
                        }
                        break;
                    }
                }

            }
            for (int i = 1; i < 10; i++) {
                if(locY+i<10) {
                    if (!player1Board.getBoard()[locX][locY + i] && !player2Board.getBoard()[locX][locY + i]) {
                        availableBoard.getBoard()[locX][locY + i] = true;
                    } else {

                        if (player1Board.getBoard()[locX][locY + i]) {
                            availableBoard.getBoard()[locX][locY + i] = true;
                        }
                        break;

                    }
                }

            }
        }
        this.setAvailableBoard(availableBoard);
        return availableBoard;
    }


}
