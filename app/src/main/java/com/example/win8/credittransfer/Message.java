package com.example.win8.credittransfer;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Win8 on 4/20/2018.
 */

public class Message
{
    public static void message(Context context,String message)
    {
        Toast.makeText(context, message,Toast.LENGTH_LONG).show();
    }
}

