package com.amoy.common.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtil {

    public static String getHtml(String url) throws IOException {
        //生成URL对象
        URL page = new URL(url);

        HttpURLConnection conn = (HttpURLConnection) page.openConnection();
        conn.setRequestMethod("GET");

        int responseCode = conn.getResponseCode();

        StringBuilder result = new StringBuilder();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = conn.getInputStream();

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                result.append(line);
            }

            bufferedReader.close();
        }

        return result.toString();
    }
}
