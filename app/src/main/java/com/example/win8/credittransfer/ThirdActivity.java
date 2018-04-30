package com.example.win8.credittransfer;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener
{
    Spinner spinner;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Log.d("ankita","ThirdActivity onCreate() start");
        spinner = (Spinner)findViewById(R.id.spinner);
        b = (Button)findViewById(R.id.transfer_button);
        b.setOnClickListener(this);
        Log.d("ankita","ThirdActivity onCreate() end");
    }


    @Override
    public void onClick(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Credit Transferred Successfully");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                Intent intent = new Intent(ThirdActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }
}
