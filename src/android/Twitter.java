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

import android.content.Intent;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

/**
 * This class echoes a string called from JavaScript.
 */
public class Twitter extends CordovaPlugin {
    private static final String TAG = "LaFactoriaTwitter";

    private TwitterLoginButton loginButton;

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

        Context context = cordova.getActivity().getApplicationContext();

        if (action.equals("start")) {

            Log.d(TAG, "Start Twitter Plugin");

            // Twitter start
            Log.d(TAG, "Step 1");
            loginButton = (TwitterLoginButton) findViewById(R.id.twitter_login_button);
            Log.d(TAG, "Step 2");
            loginButton.setCallback(new Callback<TwitterSession>() {
                @Override
                public void success(Result<TwitterSession> result) {
                    // Do something with result, which provides a TwitterSession for making API calls
                    Log.d(TAG, "Success");
                }

                @Override
                public void failure(TwitterException exception) {
                    // Do something on failure
                    Log.d(TAG, "Error");
                }
            });
            Log.d(TAG, "Step 3");

            return true;
        }

        // Twitter end

        return false;
    }

    //Twitter result
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        loginButton.onActivityResult(requestCode, resultCode, data);
    }
}