package project.android.mvppractice.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Preference {


    SharedPreferences sharedPreferences;

    public static String IS_LOGIN;


    public Preference(Context context) {
       sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }


   public boolean isLoggedIn(){
        return sharedPreferences.getBoolean(IS_LOGIN,false);


    }

   public void setLoggedIn(boolean isFirstTime){

       sharedPreferences.edit().putBoolean(IS_LOGIN,isFirstTime).apply();


    }
}
