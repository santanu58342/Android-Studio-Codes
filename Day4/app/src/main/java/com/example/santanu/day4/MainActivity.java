package com.example.santanu.day4;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.view.View;
import android.widget.Toast;
import android.view.Menu;
public class MainActivity extends AppCompatActivity implements OnSeekBarChangeListener {
    SeekBar s1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        s1=(SeekBar)findViewById(R.id.seekBar1);
        s1.setOnSeekBarChangeListener(this);
    }
    public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
        Toast.makeText(getApplicationContext(), "seekbar progress: " + progress, Toast.LENGTH_SHORT).show();
    }
    public void onStartTrackingTouch(SeekBar seekBar) {
        Toast.makeText(getApplicationContext(), "seekbar touch started!", Toast.LENGTH_SHORT).show();
    }
    public void onStopTrackingTouch(SeekBar seekBar) {
        Toast.makeText(getApplicationContext(), "seekbar touch stopped!", Toast.LENGTH_SHORT).show();
    }
}