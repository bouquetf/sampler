package org.jaalon;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyActivity extends Activity {
    List<MediaPlayer> mediaPlayers;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mediaPlayers = new ArrayList<MediaPlayer>(4);
        for (int i = 0; i <= 3; i ++) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            String path = "/storage/sdcard0/Documents/Sampler/B"+i+".mp3";
            try {
                mediaPlayer.setDataSource(path);
                mediaPlayer.prepare();
            } catch (IOException ignored) {
            }
            mediaPlayers.add(mediaPlayer);

        }

        setContentView(R.layout.main);

        findViewById(R.id.b1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readMP3(0);
            }
        });
        findViewById(R.id.b2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readMP3(1);
            }
        });
        findViewById(R.id.b3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readMP3(2);
            }
        });
        findViewById(R.id.b4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readMP3(3);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, Menu.NONE, "Associate songs");
        menu.add(0, 2, Menu.NONE, "Quit");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch(menuItem.getItemId()) {
            case 1:
                // TODO: reload files from a predefined directory
                break;
            case 2:
                finish();
                break;
        }
        return true;
    }

    @Override
    public void onPause() {
        finish();
    }

    private void readMP3(int buttonName) {
        MediaPlayer mediaPlayer = mediaPlayers.get(buttonName);
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        } else {
            mediaPlayer.start();
        }
    }

    //TODO: get which button has been clicked
    //TODO: if a music is currently reading:
    //TODO: - stop reading the music if the button is associated to it
    //TODO: - stop reading the music and start the one associated
}
