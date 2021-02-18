
package com.example.weather;

public class CityLocations {

    private String lattitude, longitude, name;

    CityLocations(){}
    CityLocations(String name, String lattitude, String longitude){
       this.name = name;
       this.lattitude = lattitude;
       this.longitude = longitude;
    }

   
    public String getName(){
        return name;
    }

    
    public String getLattitude(){
        return lattitude;
    }

   
    public String getLongitude(){
        return longitude;
    }

}
