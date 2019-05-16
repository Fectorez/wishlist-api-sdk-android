package com.jeremie.testandroid;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.jeremie.testandroid.api.AuthenticationApi;
import com.jeremie.testandroid.api.BaseApi;
import com.jeremie.testandroid.api.CategoryApi;
import com.jeremie.testandroid.api.LoginResponse;
import com.jeremie.testandroid.api.UserApi;
import com.jeremie.testandroid.model.Category;
import com.jeremie.testandroid.model.Item;
import com.jeremie.testandroid.model.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    public static final String POST_TAG = "POST_TAG";
    private static String GET_TAG = "GET_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(GET_TAG, "salut");
                AuthenticationApi authApi = new AuthenticationApi();

                try {
                    LoginResponse res = authApi.login("toto2@yopmail.com", "toto");
                    Log.i(GET_TAG, "res login="+res);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }


                /*StringBuilder param = new StringBuilder();
                try {
                    param.append(URLEncoder.encode("name", "UTF-8"));
                    param.append("=");
                    param.append(URLEncoder.encode("popopopoopoppop", "UTF-8"));
                } catch(UnsupportedEncodingException e) {
                    e.printStackTrace();
                    return;
                }*/

                //Log.i(GET_TAG, "param.toString()="+param.toString());
                //HttpPostRequest request = new HttpPostRequest("/category", param.toString());
                //request.execute();

                //CategoryApi categoryApi = new CategoryApi();
                /*try {
                    List<Category> all = categoryApi.findAll();
                    for (Category category : all) {
                        Log.i("GET_TAG", "(ALL) category=" + category.toString());
                    }

                    Category cat1 = categoryApi.findById(1);
                    Log.i("GET_TAG", "cat1="+cat1);
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }*/

                /*Category category = new Category();
                category.name = "BbBbdfrtrg";
                try {
                    Category c = categoryApi.create(category);
                    Log.i(GET_TAG, "azazaz category stored = "+ c);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }*/

                /*Map<String, String> params = new HashMap<>();
                params.put("name", "jeuvideo");


                HttpPostRequest request = new HttpPostRequest();
                try {
                    String g = request.exec("/category", params).get();
                    Log.i(GET_TAG, "g="+g);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }*/

                /*HttpGetRequest request = new HttpGetRequest();
                try {
                    String g = request.exec("/user").get();
                    Log.i(GET_TAG, "g="+g);
                } catch ( ExecutionException e ) {
                    e.printStackTrace();
                    Log.i(GET_TAG, "exept ExecutionException");
                } catch ( InterruptedException e ) {
                    e.printStackTrace();
                    Log.i(GET_TAG, "exept InterruptedException");
                }*/
                //Log.i(GET_TAG, "result=" + request.getResult());

                //AsyncHttpClient client = new AsyncHttpClient();
                //client.post()
                //RequestParams params = new RequestParams();
                //params.put("name", "bbbbbbbbbbb");
                //params.put("rsz", "8");
                /*client.get(SERVER_URL + "/user", params, new JsonHttpResponseHandler() {
                    @Override
                    public void onPostProcessResponse(ResponseHandlerInterface instance, HttpResponse response) {
                        Log.i(GET_TAG, "post");
                        Log.i(GET_TAG, "reponse="+response);
                        super.onPostProcessResponse(instance, response);
                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                        Log.i(GET_TAG, "success array=" + response);
                        super.onSuccess(statusCode, headers, response);
                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        Log.i(GET_TAG, "success object=" + response);
                        super.onSuccess(statusCode, headers, response);
                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, String responseString) {
                        Log.i(GET_TAG, "success string=" + responseString);
                        super.onSuccess(statusCode, headers, responseString);
                    }

                    @Override
                    public void onFinish() {
                        Log.i(GET_TAG, "onFinish");
                        super.onFinish();
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                        Log.i(GET_TAG, "onFailure");
                        Log.i(GET_TAG, "errorResponse=" + errorResponse);
                        Log.i(GET_TAG, "headers=" + headers);
                        super.onFailure(statusCode, headers, throwable, errorResponse);
                    }
                });*/
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




    /*public class HttpGetRequest extends AsyncTask<Void, Void, String> {

        static final String REQUEST_METHOD = "GET";
        static final int READ_TIMEOUT = 15000;
        static final int CONNECTION_TIMEOUT = 15000;

        private String uri;

        public HttpGetRequest(String uri) {
            this.uri = uri;
        }

        @Override
        protected String doInBackground(Void... params){
            String result;
            String inputLine;

            try {
                // connect to the server
                URL myUrl = new URL(SERVER_URL + uri);
                HttpURLConnection connection =(HttpURLConnection) myUrl.openConnection();
                connection.setRequestMethod(REQUEST_METHOD);
                connection.setReadTimeout(READ_TIMEOUT);
                connection.setConnectTimeout(CONNECTION_TIMEOUT);
                //connection.connect();

                // get the string from the input stream
                InputStreamReader streamReader = new InputStreamReader(connection.getInputStream());
                BufferedReader reader = new BufferedReader(streamReader);
                StringBuilder stringBuilder = new StringBuilder();
                while((inputLine = reader.readLine()) != null){
                    stringBuilder.append(inputLine);
                }
                reader.close();
                streamReader.close();
                result = stringBuilder.toString();

            } catch(IOException e) {
                e.printStackTrace();
                result = "error";
            }

            return result;
        }

        protected void onPostExecute(String result){
            super.onPostExecute(result);
            Log.i(GET_TAG, result);
        }
    }





    public class HttpPostRequest extends AsyncTask<Void, Void, String> {

        static final String REQUEST_METHOD = "POST";
        static final int READ_TIMEOUT = 15000;
        static final int CONNECTION_TIMEOUT = 15000;

        private String uri;
        private String param;

        public HttpPostRequest(String uri, String param) {
            this.uri = uri;
            this.param = param;
        }

        @Override
        protected String doInBackground(Void... params){
            String result="resultinit";
            String inputLine;

            try {
                Log.i(POST_TAG,SERVER_URL + uri);
                URL url = new URL(SERVER_URL + uri);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod(REQUEST_METHOD);
                connection.setReadTimeout(READ_TIMEOUT);
                connection.setConnectTimeout(CONNECTION_TIMEOUT);
                connection.setDoOutput(true);
                connection.setDoInput(true);
                connection.setChunkedStreamingMode(0);

                OutputStream out = new BufferedOutputStream(connection.getOutputStream());
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
                writer.write(param);
                writer.flush();
                writer.close();
                out.close();

                //connection.connect();


                // get the string from the input stream
                InputStreamReader streamReader = new InputStreamReader(connection.getInputStream());
                BufferedReader reader = new BufferedReader(streamReader);
                StringBuilder stringBuilder = new StringBuilder();
                while((inputLine = reader.readLine()) != null){
                    stringBuilder.append(inputLine);
                }
                reader.close();
                streamReader.close();
                result = stringBuilder.toString();

                connection.disconnect();
            } catch(IOException e) {
                e.printStackTrace();
                result = "error";
            }

            return result;
        }

        protected void onPostExecute(String result){
            super.onPostExecute(result);
            Log.i(GET_TAG, result);
        }
    }*/
}
