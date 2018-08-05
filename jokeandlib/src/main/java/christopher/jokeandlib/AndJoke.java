package christopher.jokeandlib;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class AndJoke extends AppCompatActivity {

    TextView displayJoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_and_joke);

        displayJoke = (TextView) findViewById(R.id.punch_line);

//get joke from intent
        String jokeFromJokeActivity = null;
        //get intent
        Intent intent = getIntent();
        jokeFromJokeActivity = intent.getStringExtra(getString(R.string.passJoke));

        //update textview with extra from intent

        if (jokeFromJokeActivity == null) {
            displayJoke.setText("Derp, no joke found.");
        } else {
            displayJoke.setText(jokeFromJokeActivity);
        }

    }
}
