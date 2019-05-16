package com.jeremie.testandroid.api;

import com.jeremie.testandroid.ApiConfig;
import com.jeremie.testandroid.model.User;

import org.json.JSONObject;

public class UserApi extends BaseApi<User> {

    public UserApi() {
        this.actionUrl = ApiConfig.BASE_URL + "/users/";
    }

    @Override
    protected User createFromJson(JSONObject jsonObject) {
        return new User(jsonObject);
    }
}
