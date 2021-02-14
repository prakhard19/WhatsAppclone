package com.example.whatsappclone;

import android.app.Application;

import com.parse.Parse;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("CcVUsZYa6BeDeiFiefjIcfD6SGXRLFgpeZoFD2XI")
                // if defined
                .clientKey("mD8XkxdEilWys6TYkSY1U2LAFTf3I6CHQsc1jPfE")
                .server("https://parseapi.back4app.com/")
                .build()
        );
    }
}
