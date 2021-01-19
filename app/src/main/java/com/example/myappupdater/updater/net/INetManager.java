package com.example.myappupdater.updater.net;

import java.io.File;

public interface INetManager {

    void get(String url, INetCallback callback);

    void download(String url, File file, INetDownloadCallback callback);
}
