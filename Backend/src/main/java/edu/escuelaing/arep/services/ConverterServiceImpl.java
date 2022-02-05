package edu.escuelaing.arep.services;

import com.google.gson.JsonObject;

public class ConverterServiceImpl {
    ConverterService converterService;

    public ConverterServiceImpl() {
        this.converterService = new ConverterService();
    }

    /**
     * Verify if the value sent is actually a double number
     * @param value
     * @return True if its a double, false otherwise
     */
    public boolean isValueValid(String value){
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Convert a Celsius degrees measure to Fahrenheit degrees.
     * @param value A measure in Celsius degrees.
     * @return The JSON response.
     */
    public JsonObject celsiusToFahrenheit(double value){
        double res = this.converterService.celsiusToFahrenheit(value);

        // Create the Json Object
        JsonObject json = new JsonObject();

        json.addProperty("status", 200);
        json.addProperty("result", res);
        json.addProperty("units", "Fahrenheit");

        return json;
    }

    /**
     * Convert a Fahrenheit degrees measure to Celsius degrees.
     * @param value A measure in Fahrenheit degrees.
     * @return The JSON response.
     */
    public JsonObject fahrenheitToCelsius(double value){
        double res = this.converterService.fahrenheitToCelsius(value);

        // Create the Json Object
        JsonObject json = new JsonObject();

        json.addProperty("status", 200);
        json.addProperty("result", res);
        json.addProperty("units", "Celsius");

        return json;
    }
}
