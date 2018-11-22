package carda.ulexia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CardView extends AppCompatActivity {


    private String user_input = InsertView.user_input;
    private TextView cardText;
    public static String[] parsed_user_input = InsertView.user_input.split("\\s+");
    private Button prev_btn;
    private Button next_btn;
    private Button incr_btn;
    private Button dcr_btn;
    private Integer index = 0;
    private float textSpacing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);

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


     }

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
        if (index < parsed_user_input.length) {
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
}
