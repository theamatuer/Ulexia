package carda.ulexia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Handler;

public class CardaView extends AppCompatActivity {


    private String user_input = null; //InsertView.user_input;
    private TextView cardText;
    public static String[] parsed_user_input = null; // InsertView.user_input.split("\\s+");
    private Button prev_btn;
    private Button next_btn;
    private Button incr_btn;
    private Button dcr_btn;
    private Button play_btn;
    private Integer index = 0;
    private float textSpacing;
    Handler handler;
    Boolean playMode = true;
    private int delay = 500; //delay in milliseconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);

        // get intent, text content
        Intent intent = getIntent();
        String rawinput = intent.getStringExtra("textcontent");
        parsed_user_input = rawinput.split("\\s+");


        cardText = (TextView) findViewById(R.id.cardText);
        cardText.setText(parsed_user_input[index]);
        textSpacing = cardText.getLetterSpacing();

        prev_btn = (Button) findViewById(R.id.prev);
        prev_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPrevCard();
            }
        });

        next_btn = (Button) findViewById(R.id.next);
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNextCard();
            }
        });

        incr_btn = (Button) findViewById(R.id.plusButton);
        incr_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickIncrease();
            }
        });

        dcr_btn = (Button) findViewById(R.id.minusButton);
        dcr_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickDecrease();
            }
        });

        handler = new Handler();
        play_btn = (Button) findViewById(R.id.playButton);
        play_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickPlay();
            }
        });


     }

    private Runnable runnableCode = new Runnable() {
        @Override
        public void run() {
            // Do something here on the main thread
            showNextCard() ;
            // Repeat this the same runnable code block again another 2 seconds
            // 'this' is referencing the Runnable object
            handler.postDelayed(this, delay);
        }
    };
    public void showPrevCard() {
        decrement();
        cardText.setText(parsed_user_input[index]);
    }

    public void showNextCard() {
        increment();
        cardText.setText(parsed_user_input[index]);
    }

    public void decrement() {
        if (index > 0) {
            index--;
        }
    }

    public void increment() {
        if (index < parsed_user_input.length-1) {
            index++;
        }
    }
    public void onClickIncrease(){
        textSpacing +=0.02;
        cardText.setLetterSpacing(textSpacing);
    }
    public void onClickDecrease(){
        if (textSpacing > 0.25) {
            textSpacing -= 0.02;
            cardText.setLetterSpacing(textSpacing);
        }
    }
    public void onClickPlay(){
        if (playMode){
            handler.post(runnableCode);
            playMode = false;
        } else{

            handler.removeCallbacks(runnableCode);
            playMode = true;
        }
    }

}
