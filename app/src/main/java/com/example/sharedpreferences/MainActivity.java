package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int count = 0;
    Button count_btn;
    TextView tv;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        count_btn = (Button) findViewById(R.id.button);
        tv = (TextView) findViewById(R.id.textView);
        et = (EditText) findViewById(R.id.et);
    }

    public void count_plus(View view) {
        count++;
        tv.setText("" + count);
    }

    public void reset(View view) {
        count = 0;
        tv.setText(""+0);

    }

    public void save_data(View view) {

        if(et.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(),"enter your name", Toast.LENGTH_SHORT);

        }
        else{
            SharedPreferences settings=getSharedPreferences("name_score",MODE_PRIVATE);
            SharedPreferences.Editor editor=settings.edit();
            editor.putString("name",(et.getText().toString()));
            editor.putInt("count",(count));
            editor.commit();

        }


    }


}