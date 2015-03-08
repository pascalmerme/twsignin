package fr.lafactoria;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
/**
 * This class echoes a string called from JavaScript.
 */
public class Twitter extends CordovaPlugin {
    private static final String TAG = "HobnobGeolocation";

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

        Context context = cordova.getActivity().getApplicationContext();

        if (action.equals("start")) {

            Log.d(TAG, "Start Twitter Plugin");

            return true;
        }

        return false;
    }
}