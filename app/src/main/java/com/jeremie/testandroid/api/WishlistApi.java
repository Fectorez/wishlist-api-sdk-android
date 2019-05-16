package com.jeremie.testandroid.api;

import com.jeremie.testandroid.ApiConfig;
import com.jeremie.testandroid.model.Wishlist;

import org.json.JSONObject;

public class WishlistApi extends BaseApi<Wishlist> {

    public WishlistApi() {
        this.actionUrl = ApiConfig.BASE_URL + "/wishlists/";
    }

    @Override
    protected Wishlist createFromJson(JSONObject jsonObject) {
        return new Wishlist(jsonObject);
    }
}
