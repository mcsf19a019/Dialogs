package com.example.dialogs;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);
        btn.setBackgroundColor(Color.RED);


    }

    public void showDialog(View view) {
        count++;
        if (count == 3) {
            AlertDialog.Builder builder2 = new AlertDialog.Builder(MainActivity.this);
            builder2.setTitle("Angry Button");
            builder2.setMessage("Don't you dare click again let me sleep");
            builder2.setCancelable(true);
            AlertDialog alertDialog2 = builder2.create();
            alertDialog2.show();
            count++;
        }
        else if(count > 2) {
            Toast.makeText(MainActivity.this, "I am sleeping go do your studies", Toast.LENGTH_LONG).show();
        }
        else if (count <= 1) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Angry Button");
            builder.setMessage("I told you don't Click Me");
            builder.setCancelable(false);

            builder.setPositiveButton("I said Close Me",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            count++;
                            Toast.makeText(MainActivity.this, "Don't Click Me Again", Toast.LENGTH_LONG).show();
                        }
                    });
            builder.setNegativeButton("Now Close Me",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            count++;
                            Toast.makeText(MainActivity.this, "Don't Click Me Again", Toast.LENGTH_LONG).show();
                        }
                    });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
    }
}