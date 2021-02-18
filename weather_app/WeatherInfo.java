
package com.example.weather;
import android.content.Context;
import android.util.Log;
import com.android.volley.*;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class WeatherInfo {

    private ArrayList<CitiesInfo> citiesInfo = new ArrayList<CitiesInfo>();
    private String urlAPI = "key";
    private ArrayList<CityLocations> cities;
    private RequestQueue requestQueue;
    private Context context;

    WeatherInfo(Context context){
        cities = new ArrayList<CityLocations>();
        this.context = context;
        buildCitiesList();
        setCitiesInfo();
    }

    
    public ArrayList<CitiesInfo> getCitiesInfo(){
        return citiesInfo;
    }

   
    private String appendLatLong(CityLocations cRef){
        String tempUrl = urlAPI;
        tempUrl+=cRef.getLattitude()+","+cRef.getLongitude();
        return tempUrl;
    }

    
    private void setCitiesInfo(){
        String url;
        requestQueue = Volley.newRequestQueue(context);
        for (CityLocations c : cities){
            url = appendLatLong(c);
            final String cName = c.getName();
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                    (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                        @Override
                        public void onResponse(JSONObject response) {
                            try{
                                citiesInfo.add(new CitiesInfo(cName,
                                        response.getJSONObject("currently").getString("temperature"), response.getJSONObject("currently").getString("summary")));
                            }
                            catch (JSONException e){
                                System.out.println("Problem parsing JSON File.");
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.d("RESPONSE", "Response" + null);

                        }
                    });
            requestQueue.add(jsonObjectRequest);
        }
    }
}
