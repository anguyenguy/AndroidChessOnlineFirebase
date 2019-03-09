package com.nhq.berry.chinesechessonline;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Second extends AppCompatActivity {

    ChessBoardView chessBoardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        chessBoardView = new ChessBoardView(this);
        setContentView(chessBoardView);
    }
}
