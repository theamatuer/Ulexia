package carda.ulexia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InsertView extends AppCompatActivity {

    private Button button;
    private TextView tv;
    public static String user_input = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_view);
        button = (Button) findViewById(R.id.button_start);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCardView();
            }
        });
    }

    public void saveUserInput() {
        tv = (TextView) findViewById(R.id.edit_text);
        user_input = tv.getText().toString();
    }

    public String getUserInput() {
        return user_input;
    }

    public void openCardView() {
        Intent intent = new Intent(this, CardView.class);
        saveUserInput();
        startActivity(intent);
    }
}
