package com.example.myappupdater.updater.net;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpNetManager implements INetManager {

    private static OkHttpClient sOkHttpClient;
    private static Handler sHandler = new Handler(Looper.getMainLooper());

    static {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(15, TimeUnit.SECONDS);
        sOkHttpClient = builder.build();
    }

    @Override
    public void get(String url, final INetCallback callback) {
        Request.Builder builder = new Request.Builder();
        Request request = builder.url(url).get().build();
        Call call = sOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                sHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.failed(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try{
                    final String responseString = response.body().string();
                    Log.d("aaa", "response=" + response.code());
                    sHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.success(responseString);
                        }
                    });
                } catch (Throwable throwable) {
                    callback.failed(throwable);
                }
            }
        });
    }

    @Override
    public void download(String url, File file, INetDownloadCallback callback) {

    }
}
