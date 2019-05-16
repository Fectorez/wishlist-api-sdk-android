package com.jeremie.testandroid.api;

import com.jeremie.testandroid.ApiConfig;
import com.jeremie.testandroid.model.Donation;

import org.json.JSONObject;

public class DonationApi extends BaseApi<Donation> {

    public DonationApi() {
        this.actionUrl = ApiConfig.BASE_URL + "/donations/";
    }

    @Override
    protected Donation createFromJson(JSONObject jsonObject) {
        return new Donation(jsonObject);
    }
}
