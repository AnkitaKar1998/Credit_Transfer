package com.example.win8.credittransfer;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener
{
    TextView t1,t2,t3,t4,t5;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d("ankita","SecondActivity onCreate() start");
        Intent i = getIntent();
        //Details d = (Details)i.getSerializableExtra("User_Details");
        String fName = i.getExtras().getString("fName");
        String lName = i.getExtras().getString("lNmae");
        DatabaseAdapter databaseAdapter = new DatabaseAdapter(this);
        /*Cursor cursor = databaseAdapter.getDetails(fName,lName);
        Log.d("ankita","DatabaseAdapter getDetails called");
        int indexUserID = cursor.getColumnIndex(DatabaseAdapter.DatabaseHelper.COL_11);
        int indexFirstName = cursor.getColumnIndex(DatabaseAdapter.DatabaseHelper.COL_12);
        int indexLastName = cursor.getColumnIndex(DatabaseAdapter.DatabaseHelper.COL_13);
        int indexEmail = cursor.getColumnIndex(DatabaseAdapter.DatabaseHelper.COL_14);
        int indexCurrentCredit = cursor.getColumnIndex(DatabaseAdapter.DatabaseHelper.COL_15);
        int userID = cursor.getInt(indexUserID);
        String userid = ""+userID;
        String firstName = cursor.getString(indexFirstName);
        String lastName = cursor.getString(indexLastName);
        String email = cursor.getString(indexEmail);
        int currentCredit = cursor.getInt(indexCurrentCredit);
        String currentcredit = ""+currentCredit;
        t1 = (TextView)findViewById(R.id.t1);
        t2 = (TextView)findViewById(R.id.t2);
        t3 = (TextView)findViewById(R.id.t3);
        t4 = (TextView)findViewById(R.id.t4);
        t5 = (TextView)findViewById(R.id.t5);
        t1.setText(userid);
        t2.setText(firstName);
        t3.setText(lastName);
        t4.setText(email);
        t5.setText(currentcredit);*/
        b = (Button)findViewById(R.id.b);
        b.setOnClickListener(this);
        Log.d("ankita","SecondActivity onCreate() end");
    }

    @Override
    public void onClick(View view)
    {
        Intent intent = new Intent(this,ThirdActivity.class);
        startActivity(intent);
    }
}
