package inc.firebok.com.music.activies;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import inc.firebok.com.music.R;


public class ReproPlay extends AppCompatActivity {


    Button play_pause;
    Button pre,next;
    MediaPlayer mp;
    SeekBar seekBar;
    TextView textView;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repro_play);


       play_pause =  findViewById(R.id.play_pause);
        play_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = new MediaPlayer();
                if(mp.isPlaying()){
                    mp.pause();
                    play_pause.setBackgroundResource(R.drawable.play);
                    Toast.makeText(ReproPlay.this, "Pause", Toast.LENGTH_SHORT).show();
                }
                else{
                    mp.start();
                    play_pause.setBackgroundResource(R.drawable.pause);
                    Toast.makeText(ReproPlay.this, "play", Toast.LENGTH_SHORT).show();
                }
            }
        });
        pre= findViewById(R.id.pre);
        pre.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View v){
                Toast.makeText(ReproPlay.this, "PRE", Toast.LENGTH_SHORT).show();
            }
        });
        next=findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ReproPlay.this, "NEXT", Toast.LENGTH_SHORT).show();
            }
        });
        seekBar=findViewById(R.id.seekbar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //textView.setText(seekBar.getAutofillValue());


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}
