
package com.example.weather;

public class CitiesInfo {
    private String name, temp, currentCondition;

    CitiesInfo(String name, String temp, String currentCondition){
        this.name = name;
        this.temp = temp;
        this.currentCondition = currentCondition;
    }

    
    public String getTemp() {
        return temp;
    }

    
    public String getName() {
        return name;
    }

    
    public String getCurrentCondition() {
        return currentCondition;
    }
}
