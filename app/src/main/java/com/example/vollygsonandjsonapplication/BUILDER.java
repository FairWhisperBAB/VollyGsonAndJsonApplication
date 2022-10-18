package com.example.vollygsonandjsonapplication;

import android.app.Activity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BUILDER
{
    public static final List<MODEL> ITEMS = new ArrayList<>();
    public static final Map<String, MODEL> MODEL_MAP = new HashMap<>();

    public static boolean active = false;

    public void Builder()
        {

        }

    public void testAllThatJazz(Activity activity) {
        String url = activity.getString(R.string.TannerURL);;  // THAT should be in a strings.xml file!

        RequestQueue queue = Volley.newRequestQueue(activity);

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // NEXT, we need to use GSON to turn that JSON into a model
                        try {
                            JSONObject object = response.getJSONObject("record");
                            JSONArray array = object.getJSONArray("gameCompanies");

                            ITEMS.clear();
                            MODEL_MAP.clear();

                            for (int i = 0; i < array.length(); i++)
                            {
                                JSONObject gameCompany = array.getJSONObject(i);

                                String Json = String.valueOf(gameCompany);
                                Gson gson = new Gson();
                                MODEL model = gson.fromJson(Json, MODEL.class);

//                                String name = gameCompany.getString("name");
//                                String year = String.valueOf(gameCompany.getInt("year"));
//                                String recentConsole = gameCompany.getString("recentConsole");

//                                MODEL model = new MODEL(name, year, recentConsole);

                                ITEMS.add(model);
                                MODEL_MAP.put(model.getGameCompanyNameName(), model);
                            }
                                if (!active)
                                    activity.recreate();
                                active = true;

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // you should drop a breakpoint RIGHT HERE if you need to see the error coming back
                error.printStackTrace();
            }
        });

        queue.add(request);
    }
}