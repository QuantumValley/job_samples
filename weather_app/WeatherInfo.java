
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

    /**
     * @requires citiesInfo != null
     * @ensures return List<CitiesInfo>
     * @return
     */
    public ArrayList<CitiesInfo> getCitiesInfo(){
        return citiesInfo;
    }

    /**
     * @requires urlAPI has url value
     * @ensures that the lattitude and longitude is appended to the url
     * @param cRef
     * @return
     */
    private String appendLatLong(CityLocations cRef){
        String tempUrl = urlAPI;
        tempUrl+=cRef.getLattitude()+","+cRef.getLongitude();
        return tempUrl;
    }

    /**
     * @requires CityLocations array to be populated
     * @ensures that list is populated with temperture, weather conditions, and city name values
     */
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

    /**
     * @requires an empty list
     * @ensures that list is poplated with CityLocation values
     */
    private void buildCitiesList(){
       cities.add(new CityLocations("Clemson","34.683437","-82.837364"));
       cities.add(new CityLocations("Columbia","34.0007104","-81.0348144"));
       cities.add(new CityLocations("New York","40.730610","-73.935242"));
       cities.add(new CityLocations("Seattle","47.608013","-122.335167"));
    }
}
