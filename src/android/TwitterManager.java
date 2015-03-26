package fr.lafactoria;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;

import com.ionicframework.growr646562.CordovaApp;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import com.ionicframework.growr646562.R;
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
import android.view.ViewGroup;
import android.view.ViewManager;

/**
 * This class echoes a string called from JavaScript.
 */
public class TwitterManager extends CordovaPlugin {
    private static final String TAG = "LaFactoriaTwitter";
    private TwitterLoginButton loginButton;

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        Log.d(TAG, "Execute");

        if (action.equals("logout")) {
            Log.d(TAG, "Logout");

            final CordovaApp app = (CordovaApp) cordova.getActivity();
            app.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    app.setUpTwitterLogin();
                }
            });

            Twitter.getInstance();
            Twitter.logOut();

            Log.d(TAG, "Log out end");

            return true;
        }

        Log.d(TAG, "Execute end");
        // Twitter end

        return false;
    }
}