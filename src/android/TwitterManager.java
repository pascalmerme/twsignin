package fr.lafactoria;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.apache.cordova.CordovaActivity;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import io.fabric.sdk.android.Fabric;

import android.content.Intent;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;
import com.twitter.sdk.android.core.TwitterAuthToken;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewManager;

/**
 * This class echoes a string called from JavaScript.
 */
public class TwitterManager extends CordovaPlugin {
    private static final String TAG = "LaFactoriaTwitter";

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

        CordovaActivity activity = cordova.getActivity();
        Context context = activity.getApplicationContext();

        // TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        // Fabric.with(this, new Twitter(authConfig));

        if (action.equals("logout")) {

            Twitter.getInstance();
            Twitter.logOut();

            return true;
        }

        // Twitter end

        return false;
    }
}