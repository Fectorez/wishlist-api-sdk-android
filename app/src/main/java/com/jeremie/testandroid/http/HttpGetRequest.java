package com.jeremie.testandroid.http;

import android.os.AsyncTask;

public class HttpGetRequest extends HttpRequest {
    public static final String REQUEST_METHOD = "GET";

    @Override
    public String getRequestMethod() {
        return REQUEST_METHOD;
    }

    @Override
    protected String doInBackground(String... strings) {
        String result;
        String url = strings[0];

        try {
            initConnection(url);
            connection.connect();

            result = read();

        } catch(Exception e) {
            e.printStackTrace();
            result = "error";
        }

        return result;
    }

    public AsyncTask<String, Void, String> exec(String url) {
        return execute(url);
    }
}
