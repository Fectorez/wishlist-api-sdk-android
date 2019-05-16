package com.jeremie.testandroid.api;

import com.jeremie.testandroid.ApiConfig;
import com.jeremie.testandroid.model.PrizePool;

import org.json.JSONObject;

public class PrizePoolApi extends BaseApi<PrizePool> {

    public PrizePoolApi() {
        this.actionUrl = ApiConfig.BASE_URL + "/prizepools/";
    }

    @Override
    protected PrizePool createFromJson(JSONObject jsonObject) {
        return new PrizePool(jsonObject);
    }
}
