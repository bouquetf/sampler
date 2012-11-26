package org.jaalon;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MyActivity extends Activity {
    MediaPlayer mediaPlayer;
    int button;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mediaPlayer = new MediaPlayer();
        setContentView(R.layout.main);
        button = 0;

        findViewById(R.id.b1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button = 1;
            }
        });
        findViewById(R.id.b2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button = 2;
            }
        });
        findViewById(R.id.b3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button = 3;
            }
        });
        findViewById(R.id.b4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button = 4;
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, Menu.NONE, "Associate songs");
        menu.add(0, 2, Menu.NONE, "Button " + button);
        menu.add(0, 3, Menu.NONE, "Quitter");

        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.getItem(1).setTitle("Button "+ button);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch(menuItem.getItemId()) {
            case 1:
                // TODO: reload files from a predefined directory
                break;
            case 3:
                finish();
                break;
        }
        return true;
    }

    //TODO: get which button has been clicked
    //TODO: if a music is currently reading:
    //TODO: - stop reading the music if the button is associated to it
    //TODO: - stop reading the music and start the one associated
}
