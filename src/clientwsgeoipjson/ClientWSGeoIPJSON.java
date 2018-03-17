/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientwsgeoipjson;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author entrar
 */
public class ClientWSGeoIPJSON {

    public static void main(String[] args) throws IOException, JSONException {
        System.out.println(getUrlJson());
        jsonTransform();
    }
    
    private static String getUrlJson() throws IOException {
        URL url = new URL("http://services.groupkt.com/country/get/iso2code/IN");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        InputStreamReader input = new InputStreamReader(connection.getInputStream());
        try (BufferedReader reader = new BufferedReader(input)){
            String line,result = "";
            while((line = reader.readLine()) != null) {
                result += line;
            }
            return result;
        }
    }
    
    private static void jsonTransform() throws JSONException, IOException {
        JSONObject jo = new JSONObject(getUrlJson());
        JSONObject res = jo.getJSONObject("RestResponse").getJSONObject("result");
        String result = res.toString();
        System.out.println(result);
        
        Gson gson = new Gson();
        Country country = (Country) gson.fromJson(result, Country.class);
        System.out.println(country.getName());
        System.out.println(country.getAlpha2_code());
        System.out.println(country.getAlpha3_code());
    }
}
