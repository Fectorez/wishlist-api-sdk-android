package com.jeremie.testandroid.api;

import com.jeremie.testandroid.ApiConfig;
import com.jeremie.testandroid.model.Category;

import org.json.JSONObject;

public class CategoryApi extends BaseApi<Category> {

    public CategoryApi() {
        this.actionUrl = ApiConfig.BASE_URL + "/categories/";
    }

    @Override
    protected Category createFromJson(JSONObject jsonObject) {
        return new Category(jsonObject);
    }
}
