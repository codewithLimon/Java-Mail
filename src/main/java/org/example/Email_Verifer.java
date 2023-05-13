package org.example;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Email_Verifer {
    private static final String API_KEY = "ZERO Bounce api key";
    private static final String VERIFY_API_URL = "https://api.zerobounce.net/v2/validate?api_key=" + API_KEY;


    public String check_mail(String mail) throws IOException {
        String verifyUrl = VERIFY_API_URL + "&email=" + mail;

            URL url = new URL(verifyUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            JSONObject jsonResponse = new JSONObject(response.toString());
            String status = jsonResponse.getString("status");

            ///
            System.out.println("" + status);

        return status;

    }



}
