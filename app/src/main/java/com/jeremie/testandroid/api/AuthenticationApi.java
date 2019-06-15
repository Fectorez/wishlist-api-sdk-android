package com.jeremie.testandroid.api;

import com.jeremie.testandroid.ApiConfig;
import com.jeremie.testandroid.http.HttpClient;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class AuthenticationApi {

    private HttpClient http = new HttpClient();

    public LoginResponse login(String email, String password) throws UnsupportedEncodingException, ExecutionException, InterruptedException, JSONException {
        Map<String, String> postData = new HashMap<>();
        postData.put("email", email);
        postData.put("password", password);

        String result = this.http.post(ApiConfig.LOGIN_URL, postData).get();

        JSONObject jsonObject = new JSONObject(result);
        return new LoginResponse(jsonObject);
    }
}