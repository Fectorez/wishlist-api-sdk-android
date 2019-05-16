package com.jeremie.testandroid.api;

import com.jeremie.testandroid.ApiConfig;
import com.jeremie.testandroid.model.Item;

import org.json.JSONObject;

public class ItemApi extends BaseApi<Item> {
    public ItemApi() {
        this.actionUrl = ApiConfig.BASE_URL + "/items/";
    }

    @Override
    protected Item createFromJson(JSONObject jsonObject) {
        return new Item(jsonObject);
    }
}
