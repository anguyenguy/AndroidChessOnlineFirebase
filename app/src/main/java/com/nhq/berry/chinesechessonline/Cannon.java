package com.nhq.berry.chinesechessonline;

import android.graphics.Bitmap;

public class Cannon extends Character {
    protected Cannon(String name, Bitmap bitmap, int player) {
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

        // Firstly do to player 1
        if(this.player==1) {
            for (int i = 1; i < 9; i++) {
                if(locX-i>=0) {
                    if (!player1Board.getBoard()[locX-i][locY] && !player2Board.getBoard()[locX-i][locY]) {
                        availableBoard.setBoardTrue(locX-i,locY);
                    } else {
                        if (player1Board.getBoard()[locX-i][locY]||player2Board.getBoard()[locX-i][locY]) {
                            for(int j =i+1; j<10;j++){
                                if(locX-j>=0){
                                    if (player1Board.getBoard()[locX-j][locY]) {
                                        break;
                                    }
                                    if(player2Board.getBoard()[locX-j][locY]){
                                        availableBoard.setBoardTrue(locX-j,locY);
                                        break;
                                    }
                                }
                            }
                        }
                        break;

                    }
                }

            }
            for (int i = 1; i < 9; i++) {
                if(locX+i<9) {
                    if (!player1Board.getBoard()[locX+i][locY] && !player2Board.getBoard()[locX+i][locY]) {
                        availableBoard.setBoardTrue(locX+i,locY);
                    } else {

                        if (player1Board.getBoard()[locX+i][locY]||player2Board.getBoard()[locX+i][locY]) {
                            for(int j =i+1; j<10;j++){

                                if(locX+j<9){
                                    if (player1Board.getBoard()[locX+j][locY]) {
                                        break;
                                    }
                                    if(player2Board.getBoard()[locX+j][locY]){
                                        availableBoard.setBoardTrue(locX+j,locY);
                                        break;
                                    }
                                }
                            }
                        }
                        break;

                    }
                }

            }
            for (int i = 1; i < 10; i++) {
                if(locY-i>=0) {
                    if (!player1Board.getBoard()[locX][locY-i] && !player2Board.getBoard()[locX][locY-i]) {
                        availableBoard.setBoardTrue(locX,locY-i);
                    } else {

                        if (player1Board.getBoard()[locX][locY-i]||player2Board.getBoard()[locX][locY-i]) {
                            for(int j =i+1; j<10;j++){
                                if (locY - j >= 0) {
                                    if (player1Board.getBoard()[locX][locY - j]) {
                                        break;
                                    }
                                    if (player2Board.getBoard()[locX][locY - j]) {
                                        availableBoard.setBoardTrue(locX, locY - j);
                                        break;
                                    }
                                }

                            }
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
                        if (player1Board.getBoard()[locX][locY + i]||player2Board.getBoard()[locX][locY+i]) {
                            for(int j =i+1; j<10;j++){
                                if(locY+j<10){
                                    if (player1Board.getBoard()[locX][locY + j]) {
                                        break;
                                    }
                                    if(player2Board.getBoard()[locX][locY + j]){
                                        availableBoard.setBoardTrue(locX,locY+j);
                                        break;
                                    }
                                }
                            }
                        }
                        break;

                    }
                }

            }
        }

        if(this.player==2) {
            for (int i = 1; i < 9; i++) {
                if(locX-i>=0) {
                    if (!player1Board.getBoard()[locX-i][locY] && !player2Board.getBoard()[locX-i][locY]) {
                        availableBoard.setBoardTrue(locX-i,locY);
                    } else {

                        if (player1Board.getBoard()[locX-i][locY]||player2Board.getBoard()[locX-i][locY]) {
                            for(int j =i+1; j<10;j++){
                                if(locX-j>=0){
                                    if (player2Board.getBoard()[locX-j][locY]) {
                                        break;
                                    }
                                    if(player1Board.getBoard()[locX-j][locY]){
                                        availableBoard.setBoardTrue(locX-j,locY);
                                        break;
                                    }
                                }
                            }
                        }
                        break;

                    }
                }

            }
            for (int i = 1; i < 9; i++) {
                if(locX+i<9) {
                    if (!player1Board.getBoard()[locX+i][locY] && !player2Board.getBoard()[locX+i][locY]) {
                        availableBoard.setBoardTrue(locX+i,locY);
                    } else {

                        if (player1Board.getBoard()[locX+i][locY]||player2Board.getBoard()[locX+i][locY]) {
                            for(int j =i+1; j<10;j++){

                                if(locX+j<9){
                                    if (player2Board.getBoard()[locX+j][locY]) {
                                        break;
                                    }
                                    if(player1Board.getBoard()[locX+j][locY]){
                                        availableBoard.setBoardTrue(locX+j,locY);
                                        break;
                                    }
                                }
                            }
                        }
                        break;

                    }
                }

            }
            for (int i = 1; i < 10; i++) {
                if(locY-i>=0) {
                    if (!player1Board.getBoard()[locX][locY-i] && !player2Board.getBoard()[locX][locY-i]) {
                        availableBoard.setBoardTrue(locX,locY-i);
                    } else {

                        if (player1Board.getBoard()[locX][locY-i]||player2Board.getBoard()[locX][locY-i]) {
                            for(int j =i+1; j<10;j++){
                                if (locY - j >= 0) {
                                    if (player2Board.getBoard()[locX][locY - j]) {
                                        break;
                                    }
                                    if (player1Board.getBoard()[locX][locY - j]) {
                                        availableBoard.setBoardTrue(locX, locY - j);
                                        break;
                                    }
                                }

                            }
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

                        if (player1Board.getBoard()[locX][locY + i]||player2Board.getBoard()[locX][locY+i]) {
                            for(int j =i+1; j<10;j++){

                                if(locY+j<10){
                                    if (player2Board.getBoard()[locX][locY + j]) {
                                        break;
                                    }
                                    if(player1Board.getBoard()[locX][locY + j]){
                                        availableBoard.setBoardTrue(locX,locY+j);
                                        break;
                                    }
                                }
                            }
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
