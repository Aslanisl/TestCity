package ru.mail.aslanisl.test;

import android.app.Application;
import android.content.Context;

import ru.mail.aslanisl.test.di.component.AppComponent;
import ru.mail.aslanisl.test.di.component.DaggerAppComponent;

/**
 * Created by Ivan on 31.01.2018.
 */

public class App extends Application{

    private static AppComponent appComponent;

    private static App sInstance;

    public App() {
        appComponent = DaggerAppComponent.builder().build();
        sInstance = this;
    }

    public static Context getAppContext(){
        return sInstance.getApplicationContext();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }
}
