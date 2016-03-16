package co.favorie.menu_world_cup.Preferences;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2016-02-02.
 */
public class ManagePreferences {

    private final String PREF_NAME = "co.favorie.menu_world_cup";

    public final static String STEP1_STATUS = "STEP1_STATUS";
    public final static String STEP2_STATUS = "STEP2_STATUS";
    public final static String STEP3_STATUS = "STEP3_STATUS";

    static Context mContext;

    public ManagePreferences(Context c) {
        mContext = c;
    }

    public void putValue(String key, int value) {
        SharedPreferences pref = mContext.getSharedPreferences(PREF_NAME, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.putInt(key, value);
        editor.commit();
    }

    public int getValue(String key, int default_value) {
        SharedPreferences pref = mContext.getSharedPreferences(PREF_NAME, Activity.MODE_PRIVATE);
        try {
            return pref.getInt(key, default_value);
        } catch (Exception e) {
            return default_value;
        }
    }

    public void resetAllPref() {
        SharedPreferences pref = mContext.getSharedPreferences(PREF_NAME, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.putInt(STEP1_STATUS, 0);
        editor.putInt(STEP2_STATUS, 0);
        editor.putInt(STEP3_STATUS, 0);
        editor.commit();
    }
}
