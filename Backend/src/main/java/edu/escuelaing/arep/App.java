package edu.escuelaing.arep;
import com.google.gson.JsonObject;

import edu.escuelaing.arep.services.ConverterServiceImpl;
import edu.escuelaing.arep.utils.Errors;
import spark.Filter;

import static spark.Spark.*;


public class App 
{
    public static void main( String[] args ) {
        final ConverterServiceImpl converterServiceImpl = new ConverterServiceImpl();
        final Errors errors = new Errors();

        // Set the port
        port(getPort());

        // Allow CORS
        options("/*",
                (request, response) -> {
                    String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
                    if (accessControlRequestHeaders != null) {
                        response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
                    }

                    String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
                    if (accessControlRequestMethod != null) {
                        response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
                    }

                    return "OK";
                });

        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));

        path("/api/v1", () -> {
            path("/celsius", () -> {
                get("", (req, res) -> {
                    res.type("application/json");
                    String value = req.queryParams("value");

                    if(value != null && converterServiceImpl.isValueValid(value)) {
                        return converterServiceImpl.celsiusToFahrenheit(Double.parseDouble(value));
                    } else {
                        JsonObject error = errors.formatError();
                        error.addProperty("value", value);

                        return error;
                    }
                });
            });
            path("/fahrenheit", () -> {
                get("", (req, res) -> {
                    res.type("application/json");
                    String value = req.queryParams("value");

                    if(value != null && converterServiceImpl.isValueValid(value)) {
                        return converterServiceImpl.fahrenheitToCelsius(Double.parseDouble(value));
                    } else {
                        JsonObject error = errors.formatError();
                        error.addProperty("value", value);

                        return error;
                    }
                });
            });
        });
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set
    }
}
