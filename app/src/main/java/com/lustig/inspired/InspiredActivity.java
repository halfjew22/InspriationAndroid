package com.lustig.inspired;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class InspiredActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        // Declare our view variables and assign them views from layout file
        Button bShowFact = (Button) findViewById(R.id.bShowFact);
        final TextView tvInspirationQuote = (TextView) findViewById(R.id.tvInspirationQuote);
        final RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rlBackground);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

                vibe.vibrate(15);

                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.blop);
                mp.start();

                Inspiration inspiration = new Inspiration();

                tvInspirationQuote.setText((inspiration.getQuote()));
                relativeLayout.setBackgroundColor(inspiration.getColor());
            }
        };

        bShowFact.setOnClickListener(listener);

        bShowFact.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                showToast("Long Click, do something cool with this.");
                return true;
            }
        });
    }

    public void showToast(String message) {

        Toast.makeText(
                getApplicationContext(),
                message,
                Toast.LENGTH_SHORT
        ).show();

    }
}
