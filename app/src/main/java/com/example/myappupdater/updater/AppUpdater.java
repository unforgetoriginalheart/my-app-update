package com.example.myappupdater.updater;

import com.example.myappupdater.updater.net.INetManager;
import com.example.myappupdater.updater.net.OkHttpNetManager;

public class AppUpdater {

    private static AppUpdater sInstance = new AppUpdater();

    //接口隔离具体实现
    private INetManager mNetManager = new OkHttpNetManager();

    public static AppUpdater getInstance() {
        return sInstance;
    }

    public INetManager getNetManager() {
        return mNetManager;
    }
}
