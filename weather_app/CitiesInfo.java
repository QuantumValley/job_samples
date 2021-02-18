
package com.example.weather;

public class CitiesInfo {
    private String name, temp, currentCondition;

    CitiesInfo(String name, String temp, String currentCondition){
        this.name = name;
        this.temp = temp;
        this.currentCondition = currentCondition;
    }

    /**
     * @requires temp is intialzed
     * @ensures temp is returned
     * @return
     */
    public String getTemp() {
        return temp;
    }

    /**
     * @requires name is intialzed
     * @ensures name is returned
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * @requires currentCondition is intialzed
     * @ensures currentCondition is returned
     * @return
     */
    public String getCurrentCondition() {
        return currentCondition;
    }
}
