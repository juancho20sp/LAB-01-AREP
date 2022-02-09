package edu.escuelaing.arep.concurrency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;


public class Robot implements Runnable {
    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String GET_URL = "https://lab-01-arep-back.herokuapp.com/api/v1/celsius?value=10";

    int id;
    Thread myThread;

    Robot(int id) {
        this.id = id;

        System.out.println("Creating robot: " + this.id);
        this.myThread = new Thread(this, "Robot");
    }

    @Override
    public void run() {
        URL obj = null;
        try {
            obj = new URL(GET_URL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        HttpURLConnection con = null;
        try {
            con = (HttpURLConnection) obj.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            con.setRequestMethod("GET");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }
        con.setRequestProperty("User-Agent", USER_AGENT);

        //The following invocation perform the connection implicitly before getting the code
        int responseCode = 0;
        try {
            responseCode = con.getResponseCode();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("GET Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = null;
            try {
                in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            String inputLine = null;
            StringBuffer response = new StringBuffer();

            while (true) {
                try {
                    if (!((inputLine = in.readLine()) != null)) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                response.append(inputLine);
            }

            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // print result
            System.out.println(response.toString());
        } else {
            System.out.println("GET request not worked");
        }
        System.out.println("GET DONE FROM ROBOT: " + this.id);
    }

    public void startThread() {
        this.myThread.start();
    }
}