package fr.lafactoria;

import android.os.Bundle;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import io.fabric.sdk.android.Fabric;
import org.apache.cordova.*;

import android.content.Intent;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;
import com.twitter.sdk.android.core.TwitterAuthToken;

import android.util.Log;
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

        Context context = cordova.getActivity().getApplicationContext();

        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));

        if (action.equals("logout")) {

           TwitterSession session = Twitter.getSessionManager().getActiveSession();
           session.logout();

           loadUrl("file:///android_asset/www/login.html");

            final View nativeControls  = LayoutInflater.from(this).inflate(R.layout.main, null);
            this.root.addView(nativeControls, 1);

            loginButton = (TwitterLoginButton) findViewById(R.id.twitter_login_button);
            loginButton.setCallback(new Callback<TwitterSession>() {
                @Override
                public void success(Result<TwitterSession> result) {
                    // Do something with result, which provides a TwitterSession for making API calls
                    Log.d(TAG, "Success");
                    ((ViewManager) nativeControls.getParent()).removeView(nativeControls);
                    TwitterSession newSession = Twitter.getSessionManager().getActiveSession();
                    launchApp(newSession);
                }
                @Override
                public void failure(TwitterException exception) {
                    // Do something on failure
                    Log.d(TAG, "Failure");
                }
            });
            return true;
        }

        // Twitter end

        return false;
    }
}