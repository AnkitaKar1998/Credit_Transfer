package com.example.win8.credittransfer;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Win8 on 4/21/2018.
 */

@SuppressWarnings("serial")
public class Details
{
    String firstName;
    String lastName;
    int currentCredit;

    Details(String firstName,String lastName,int currentCredit)
    {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setCurrentCredit(currentCredit);
    }


    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public int getCurrentCredit()
    {
        return currentCredit;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void setCurrentCredit(int currentCredit)
    {
        this.currentCredit = currentCredit;
    }

}
