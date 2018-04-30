package com.example.win8.credittransfer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Win8 on 4/20/2018.
 */

public class DatabaseAdapter
{
    DatabaseHelper helper;

    public  DatabaseAdapter(Context context)
    {
        helper = new DatabaseHelper(context);
    }

    public long insertInitialData(String firstName,String lastName,String email,int currentCredit)
    {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COL_12,firstName);
        contentValues.put(DatabaseHelper.COL_13,lastName);
        contentValues.put(DatabaseHelper.COL_14,email);
        contentValues.put(DatabaseHelper.COL_15,currentCredit);
        long id = db.insert(DatabaseHelper.TABLE1_NAME,null,contentValues);
        db.close();
        return  id;
    }

    /*public void insertInitialDataList(Context context)
    {
        long id;
        id= insertInitialData("Urmi","Sharma","urmi@gmail.com",1000);
        if(id<0)
        {
            Message.message(context,"Not inserted 1");
        }
        else
        {
            Message.message(context,"Inserted 1");
        }

        id= insertInitialData("Ria","Pandey","ria@gmail.com",1000);
        if(id<0)
        {
            Message.message(context,"Not inserted 2");
        }
        else
        {
            Message.message(context,"Inserted 2");
        }

        id= insertInitialData("Juhi","Gianani","juhi@gmail.com",1000);
        if(id<0)
        {
            Message.message(context,"Not inserted 3");
        }
        else
        {
            Message.message(context,"Inserted 3");
        }

        id= insertInitialData("Pal","Karkera","pal@gmail.com",1000);
        if(id<0)
        {
            Message.message(context,"Not inserted 4");
        }
        else
        {
            Message.message(context,"Inserted 4");
        }

        id= insertInitialData("Kajal","Jain","urmi@gmail.com",1000);
        if(id<0)
        {
            Message.message(context,"Not inserted 5");
        }
        else
        {
            Message.message(context,"Inserted 5");
        }

        id= insertInitialData("Varsha","Hegde","varsha@gmail.com",1000);
        if(id<0)
        {
            Message.message(context,"Not inserted 6");
        }
        else
        {
            Message.message(context,"Inserted 6");
        }

        id= insertInitialData("Jessika","Merchant","jessika@gmail.com",1000);
        if(id<0)
        {
            Message.message(context,"Not inserted 7");
        }
        else
        {
            Message.message(context,"Inserted 7");
        }

        id= insertInitialData("Akshita","Dave","akshita@gmail.com",1000);
        if(id<0)
        {
            Message.message(context,"Not inserted 8");
        }
        else
        {
            Message.message(context,"Inserted 8");
        }

        id= insertInitialData("Sami","Mistry","sami@gmail.com",1000);
        if(id<0)
        {
            Message.message(context,"Not inserted 9");
        }
        else
        {
            Message.message(context,"Inserted 9");
        }

        id= insertInitialData("Ruhi","Gupta","ruhi@gmail.com",1000);
        if(id<0)
        {
            Message.message(context,"Not inserted 10");
        }
        else
        {
            Message.message(context,"Inserted 10");
        }
    }*/

    public Cursor getInitialDetails()
    {
        SQLiteDatabase db = helper.getWritableDatabase();
        String[] columns = {DatabaseHelper.COL_12,DatabaseHelper.COL_13,DatabaseHelper.COL_15};
        Cursor cursor = db.query(DatabaseHelper.TABLE1_NAME,columns,null,null,null,null,null);
        return cursor;
    }

    public  Cursor getDetails(String fName,String lName)
    {
        SQLiteDatabase db = helper.getWritableDatabase();
        // query = "SELECT * FROM "+DatabaseHelper.TABLE1_NAME+" WHERE "+DatabaseHelper.COL_12+"="+fName+" AND "+DatabaseHelper.COL_13+"="+lName;
        Cursor cursor = db.rawQuery("SELECT * FROM "+DatabaseHelper.TABLE1_NAME+" WHERE "+DatabaseHelper.COL_12+"="+fName+" AND "+DatabaseHelper.COL_13+"="+lName,null);
        return  cursor;
    }

    static  class DatabaseHelper extends  SQLiteOpenHelper
    {
        public   static final String DATABASE_NAME = "CT";
        public    static final String TABLE1_NAME = "User";
        public    static final String TABLE2_NAME = "Transfer";

        public    static final String COL_11 = "User_ID";
        public    static final String COL_12 = "First_Name";
        public    static final String COL_13 = "Last_Name";
        public    static final String COL_14 = "Email";
        public    static final String COL_15 = "Current_Credit";

        public    static final String COL_21 = "Transfer_ID";
        public    static final String COL_22 = "S_User";
        public    static final String COL_23 = "D_User";
        public    static final String COL_24 = "Credit_Transfer";
        public    static  int version = 7;
        public static Context context;

        public DatabaseHelper(Context context)
        {
            super(context, DATABASE_NAME, null, 1);
            this.context = context;
            Message.message(context,"Constructor called");
        }

        @Override
        public void onCreate(SQLiteDatabase db)
        {
            Message.message(context,"onCreate called");
            db.execSQL("create table User (User_Id INTEGER PRIMARY KEY AUTOINCREMENT, First_Name TEXT, Last_Name TEXT, Email TEXT, Current_Credit INTEGER);");
            db.execSQL("create table Transfer (Transfer_Id INTEGER PRIMARY KEY AUTOINCREMENT, S_User TEXT, D_User TEXT, Credit_Transfer INTEGER);");
            DatabaseAdapter databaseAdapter = new DatabaseAdapter(context);
            Log.d("ankita","SQLiteOpenHelper onCreate() start");
            //databaseAdapter.insertInitialDataList(this);
            //Message.message(context,"insertInitialDataList called");

            /*long id;
            id= databaseAdapter.insertInitialData("Urmi","Sharma","urmi@gmail.com",1000);
            if(id<0)
            {
                Message.message(context,"Not inserted 1");
            }
            else
            {
                Message.message(context,"Inserted 1");
            }

            id= databaseAdapter.insertInitialData("Ria","Pandey","ria@gmail.com",1000);
            if(id<0)
            {
                Message.message(context,"Not inserted 2");
            }
            else
            {
                Message.message(context,"Inserted 2");
            }

            id= databaseAdapter.insertInitialData("Juhi","Gianani","juhi@gmail.com",1000);
            if(id<0)
            {
                Message.message(context,"Not inserted 3");
            }
            else
            {
                Message.message(context,"Inserted 3");
            }

            id= databaseAdapter.insertInitialData("Pal","Karkera","pal@gmail.com",1000);
            if(id<0)
            {
                Message.message(context,"Not inserted 4");
            }
            else
            {
                Message.message(context,"Inserted 4");
            }

            id= databaseAdapter.insertInitialData("Kajal","Jain","urmi@gmail.com",1000);
            if(id<0)
            {
                Message.message(context,"Not inserted 5");
            }
            else
            {
                Message.message(context,"Inserted 5");
            }

            id= databaseAdapter.insertInitialData("Varsha","Hegde","varsha@gmail.com",1000);
            if(id<0)
            {
                Message.message(context,"Not inserted 6");
            }
            else
            {
                Message.message(context,"Inserted 6");
            }

            id= databaseAdapter.insertInitialData("Jessika","Merchant","jessika@gmail.com",1000);
            if(id<0)
            {
                Message.message(context,"Not inserted 7");
            }
            else
            {
                Message.message(context,"Inserted 7");
            }

            id= databaseAdapter.insertInitialData("Akshita","Dave","akshita@gmail.com",1000);
            if(id<0)
            {
                Message.message(context,"Not inserted 8");
            }
            else
            {
                Message.message(context,"Inserted 8");
            }

            id= databaseAdapter.insertInitialData("Sami","Mistry","sami@gmail.com",1000);
            if(id<0)
            {
                Message.message(context,"Not inserted 9");
            }
            else
            {
                Message.message(context,"Inserted 9");
            }

            id= databaseAdapter.insertInitialData("Ruhi","Gupta","ruhi@gmail.com",1000);
            if(id<0)
            {
                Message.message(context,"Not inserted 10");
            }
            else
            {
                Message.message(context,"Inserted 10");
            }*/
            //Log.d("Error","DtabaseHelper onCreate()");
            Log.d("ankita","SQLiteOpenHelper onCreate() end");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
            Message.message(context,"onUpdate called");
            db.execSQL("DROP TABLE IF EXISTS User;");
            db.execSQL("DROP TABLE IF EXISTS Transfer;");
            onCreate(db);
        }

    }


}
