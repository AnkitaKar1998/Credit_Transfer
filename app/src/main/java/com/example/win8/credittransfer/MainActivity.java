package com.example.win8.credittransfer;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener
{
    DetailsAdapter detailsAdapter;
    SQLiteDatabase db;
    DatabaseAdapter myDb;
    ListView l;
    String[] days = {"Sun","Mon","Tues","Wed","Thurs","Fri","Sat"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("ankita","MainActivity onCreate() start");
        myDb = new DatabaseAdapter(this);
        l = (ListView)findViewById(R.id.list_view);
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,days);
        //l.setAdapter(adapter);
        Log.d("ankita","Inserting initial 10 entries");
        long id;
        id= myDb.insertInitialData("Urmi","Sharma","urmi@gmail.com",1000);
        if(id<0)
        {
            Message.message(this,"Not inserted 1");
        }
        else
        {
            Message.message(this,"Inserted 1");
        }

        id= myDb.insertInitialData("Ria","Pandey","ria@gmail.com",1000);
        if(id<0)
        {
            Message.message(this,"Not inserted 2");
        }
        else
        {
            Message.message(this,"Inserted 2");
        }

        id= myDb.insertInitialData("Juhi","Gianani","juhi@gmail.com",1000);
        if(id<0)
        {
            Message.message(this,"Not inserted 3");
        }
        else
        {
            Message.message(this,"Inserted 3");
        }

        id= myDb.insertInitialData("Pal","Karkera","pal@gmail.com",1000);
        if(id<0)
        {
            Message.message(this,"Not inserted 4");
        }
        else
        {
            Message.message(this,"Inserted 4");
        }

        id= myDb.insertInitialData("Kajal","Jain","urmi@gmail.com",1000);
        if(id<0)
        {
            Message.message(this,"Not inserted 5");
        }
        else
        {
            Message.message(this,"Inserted 5");
        }

        id= myDb.insertInitialData("Varsha","Hegde","varsha@gmail.com",1000);
        if(id<0)
        {
            Message.message(this,"Not inserted 6");
        }
        else
        {
            Message.message(this,"Inserted 6");
        }

        id= myDb.insertInitialData("Jessika","Merchant","jessika@gmail.com",1000);
        if(id<0)
        {
            Message.message(this,"Not inserted 7");
        }
        else
        {
            Message.message(this,"Inserted 7");
        }

        id= myDb.insertInitialData("Akshita","Dave","akshita@gmail.com",1000);
        if(id<0)
        {
            Message.message(this,"Not inserted 8");
        }
        else
        {
            Message.message(this,"Inserted 8");
        }

        id= myDb.insertInitialData("Sami","Mistry","sami@gmail.com",1000);
        if(id<0)
        {
            Message.message(this,"Not inserted 9");
        }
        else
        {
            Message.message(this,"Inserted 9");
        }

        id= myDb.insertInitialData("Ruhi","Gupta","ruhi@gmail.com",1000);
        if(id<0)
        {
            Message.message(this,"Not inserted 10");
        }
        else
        {
            Message.message(this,"Inserted 10");
        }

        detailsAdapter = new DetailsAdapter(this,R.layout.user_details_row);
        Cursor cursor = myDb.getInitialDetails();
        Log.d("ankita","DtabaseAdapter getInitialDetails called");
        String firstName, lastName;
        int currentCredit;
        while(cursor.moveToNext())
        {
            int indexFirstName = cursor.getColumnIndex(DatabaseAdapter.DatabaseHelper.COL_12);
            int indexLastName = cursor.getColumnIndex(DatabaseAdapter.DatabaseHelper.COL_13);
            int indexCurrentCredit = cursor.getColumnIndex(DatabaseAdapter.DatabaseHelper.COL_15);
            firstName = cursor.getString(indexFirstName);
            lastName = cursor.getString(indexLastName);
            currentCredit = cursor.getInt(indexCurrentCredit);
            Details details = new Details(firstName,lastName,currentCredit);
            detailsAdapter.add(details);
        }

        l.setAdapter(detailsAdapter);
        l.setOnItemClickListener(this);
        Log.d("ankita","MainActivity onCreate() end");
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
    {
        Log.d("ankita","onItemClick called");
        TextView t1,t2,t3;
        String fName, lName,c;
        int cr;
        t1 = (TextView)view.findViewById(R.id.text_first_name);
        t2 = (TextView)view.findViewById(R.id.text_last_name);
        t3 = (TextView)view.findViewById(R.id.text_credit);
        fName = t1.getText().toString();
        lName = t2.getText().toString();
        c = t3.getText().toString();
        cr = Integer.parseInt(c);
        //Details d = new Details(fName,lName,cr);
        Intent intent = new Intent(this,SecondActivity.class);
        intent.putExtra("fNmae",fName);
        intent.putExtra("lNmae",lName);
        intent.putExtra("cr",cr);
        startActivity(intent);
    }
}

