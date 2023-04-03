package com.example.demo_meet;

import static android.view.KeyEvent.ACTION_DOWN;
import static android.view.MotionEvent.ACTION_MOVE;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

        ImageView img1;
         private float downx,downy,movex,movey,disx,disy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img1=(ImageView)findViewById(R.id.img1);
        img1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:
                        downx = event.getX();
                        downy = event.getY();
                        break;

                    case MotionEvent.ACTION_MOVE:
                        movex = event.getX();
                        movey = event.getY();

                        disx = movex - downx;
                        disy = movey - downy;
                        img1.setX(img1.getX() + disx);
                        img1.setY(img1.getY() + disy);
                        break;

                }
                        return true;
            }
        });
    }
}