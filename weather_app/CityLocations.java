
package com.example.weather;

public class CityLocations {

    private String lattitude, longitude, name;

    CityLocations(){}
    CityLocations(String name, String lattitude, String longitude){
       this.name = name;
       this.lattitude = lattitude;
       this.longitude = longitude;
    }

    /**
     * @requires name is intialized
     * @ensures returns name
     * @return
     */
    public String getName(){
        return name;
    }

    /**
     * @requires lattitude is intialized
     * @ensures returns lattitude
     * @return
     */
    public String getLattitude(){
        return lattitude;
    }

    /**
     * @requires longitude is intialized
     * @ensures returns Longitude
     * @return
     */
    public String getLongitude(){
        return longitude;
    }

}
