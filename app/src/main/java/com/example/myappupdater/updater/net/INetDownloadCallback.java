package com.example.myappupdater.updater.net;

import java.io.File;

public interface INetDownloadCallback {
    void success(File apkFile);

    void process(int process);

    void failde(Throwable throwable);
}
