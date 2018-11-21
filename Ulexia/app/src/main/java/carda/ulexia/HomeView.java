package carda.ulexia;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import com.tomer.fadingtextview.FadingTextView;

public class HomeView extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_view);

        // initialize fading text view properties
        FadingTextView fadingTextView=(FadingTextView)findViewById(R.id.fade);
        fadingTextView.setTimeout(1, FadingTextView.SECONDS);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInsertView();
            }
        });
    }

    public void openInsertView() {
        Intent intent = new Intent(this, InsertView.class);
        startActivity(intent);
    }
}
