package main.java.ccl_Laufwerk.service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;

import java.net.URL;
import java.net.HttpURLConnection;
import javax.net.ssl.HttpsURLConnection;

public class HttpService {

    public String anmeldung (String user, String pw) throws Exception{

        String url = "http://direct.lw-kunden.de/login.php?u="+user+"&p="+pw;

        URL obj = new URL(url);

        HttpURLConnection httpConnect = (HttpURLConnection) obj.openConnection();

        httpConnect.setRequestMethod("GET");

        int responseCode = httpConnect.getResponseCode();
        System.out.println("Sending URL-GET-Request to : " + url);
        System.out.println("Request-Code is: " + responseCode);

        BufferedReader br = new BufferedReader(new InputStreamReader(httpConnect.getInputStream()));

        String inputLine;

        StringBuffer response = new StringBuffer();

        while((inputLine = br.readLine()) != null){
            response.append(inputLine);
        }

        br.close();

        return response.toString();

    }

    public static void main(String[] args) throws Exception {
        HttpService hs = new HttpService();

        hs.anmeldung("KUNDE", "KD");
    }



}
