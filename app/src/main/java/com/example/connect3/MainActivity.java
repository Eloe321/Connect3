package com.example.connect3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button[][] buttons;
    Boolean[][] chekz;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StartProgram();
    }
    private void StartProgram(){
        TextView player = new TextView(R.id.PlayingPlayer);
        player.setBackgroundColor(Color.parseColor("#000000"));
        buttons = new Button[5][5];
        chekz = new Boolean[5][5];
        int ctr = 1;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                String buttonID = "button" + Integer.toString(ctr++);
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = ((Button) findViewById(resID));
                chekz[i][j] = false;
                if(i != 0){
                    buttons[i][j].setEnabled(false);
                }

            }

        }

        for(int k = 0; k<5;k++){
            int K = k;
            buttons[0][K].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for(int i = 4; i>=0;i--){

                        if(!chekz[i][K]){
                            if(i == 0) {
                                buttons[0][K].setEnabled(false);
                            }
                            buttons[i][K].setBackgroundColor(Color.parseColor("#81A094"));
                            chekz[i][K] = true;
                            break;
                        }

                    }
                }
            });
        }



    }

}