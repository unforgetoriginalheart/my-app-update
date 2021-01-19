package com.example.myappupdater.updater.net;

public interface INetCallback {

    void success(String response);

    void failed(Throwable throwable);
}
