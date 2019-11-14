package com.example.diceroller;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int triedtime= 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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


    public void on_button_click(View view){
     int number = 0;
        EditText number_input=this.findViewById(R.id.EnterNumber);
        TextView tv = this.findViewById(R.id.numberTextView);
        TextView randomnumber = this.findViewById(R.id.RandomNumber);
        TextView userpoints = this.findViewById(R.id.UserPoints);

        String matches = number_input.getText().toString();
        if (matches.matches("")) {
            tv.setText("please input a number");
            return;
        }


        triedtime = triedtime + 1;
        Random r = new Random();
        number = r.nextInt(6)+1;
        randomnumber.setText("random number is "+Integer.toString(number));
        userpoints.setText("you tried "+triedtime+" times");
        String nextnumber = Integer.toString(number);
        if (matches == nextnumber) {
            tv.setText("congratulations");
        }
        else
        {
            tv.setText("sorry next time");
        }
    }
}
