package com.example.fabian.seekbartest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SeekBar sb1;
    private SeekBar sb2;
    private TextView tvSb1;
    private TextView tvSb2;
    private TextView tvSb3;
    private RangeSeekBar<Integer> rangeSeekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        sb1 = (SeekBar) findViewById( R.id.seekBar1 );
        sb2 = (SeekBar) findViewById( R.id.seekBar2 );
        tvSb1 = (TextView) findViewById( R.id.tv_seek_bar_1 );
        tvSb2 = (TextView) findViewById( R.id.tv_seek_bar_2 );
        tvSb3 = (TextView) findViewById( R.id.tv_seek_bar_3 );
        LinearLayout ll = (LinearLayout) findViewById( R.id.rl );
        rangeSeekBar = new RangeSeekBar<>( 0, 200, getApplicationContext() );
        rangeSeekBar.setTextView( tvSb3 );
        ll.addView( rangeSeekBar );

        sb1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChanged = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChanged = progress;
                tvSb1.setText( String.valueOf( progressChanged ) );

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText( MainActivity.this, "seek bar progress:"+progressChanged,
                        Toast.LENGTH_SHORT).show();
            }
        });

        sb2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChanged = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChanged = progress;
                tvSb2.setText( String.valueOf( progressChanged ) );
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText( MainActivity.this, "seek bar progress:"+progressChanged,
                        Toast.LENGTH_SHORT).show();
            }
        });

        rangeSeekBar.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Integer>() {
            @Override
            public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar, Integer minValue, Integer maxValue) {
                tvSb3.setText( minValue + " - " + maxValue );

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
