package com.jeremie.testandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.jeremie.testandroid.api.AmazonApi;
import com.jeremie.testandroid.api.AuthenticationApi;
import com.jeremie.testandroid.api.CategoryApi;
import com.jeremie.testandroid.api.LoginResponse;
import com.jeremie.testandroid.api.WishlistApi;
import com.jeremie.testandroid.http.HttpClient;
import com.jeremie.testandroid.http.HttpGetRequest;
import com.jeremie.testandroid.model.Category;
import com.jeremie.testandroid.model.Wishlist;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import org.json.JSONException;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    private static String MAIN_ACTIVITY_TAG = "MAIN_ACTIVITY_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(MAIN_ACTIVITY_TAG, "Bouton cliqué");


                // Authentification

                /*AuthenticationApi authApi = new AuthenticationApi();

                try {
                    LoginResponse loginResponse = authApi.login("toto2@yopmail.com", "toto");
                    Log.i(MAIN_ACTIVITY_TAG, "Login effectué ; réponse = "+loginResponse);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }



                // findAll & findById

                CategoryApi categoryApi = new CategoryApi();

                try {
                    List<Category> allCategories = categoryApi.findAll();
                    Log.i(MAIN_ACTIVITY_TAG, "(findAll) All categories...");
                    for (Category category : allCategories) {
                        Log.i(MAIN_ACTIVITY_TAG, "(findAll) " + category.toString());
                    }

                    Category category1 = categoryApi.findById(1);
                    Log.i(MAIN_ACTIVITY_TAG, "(findById) Catégorie n°1 = " + category1);
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }



                // POST Category

                Category newCategory = new Category();
                newCategory.name = "Jardinage";

                try {
                    Category storedNewCategory = categoryApi.create(newCategory);
                    Log.i(MAIN_ACTIVITY_TAG, "Created new category = " + storedNewCategory);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }*/

                // AmazonApi (récupére titre produit)
                AmazonApi amazonApi = new AmazonApi();
                String title = null;
                try {
                    title = amazonApi.getItemTitleFromUrl("https://www.amazon.fr/Fire-TV-Stick-Basic-Edition/dp/B01ETRGE7M/ref=zg_bs_electronics_5?_encoding=UTF8&psc=1&refRID=ATGSGZ2EPYVG21NY3093");
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.i(MAIN_ACTIVITY_TAG, "title="+title);



                // PUT
                /*WishlistApi wishlistApi = new WishlistApi();
                try {
                    wishlistApi.addParticipant(1, 1);
                    Wishlist wishlist1 = wishlistApi.findById(1);
                    Log.i(MAIN_ACTIVITY_TAG, "(findById) Wishlist n°1 avec participant n°1 = " + wishlist1);
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }*/

            }
        });
    }
}
