package android.kalys.androidisaev.bridge.httpHandler;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;


public class HTTPHandler {

    private final String basicUrl = "http://9796364d.ngrok.io";
    private URL url;
    private HttpURLConnection urlConnection = null;
    private BufferedReader reader = null;
    private String resultJson = "";



    public String connect(String urlValue){
        try {
            url = new URL(basicUrl + urlValue);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");

            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();

            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;

            while((line = reader.readLine()) != null){
                buffer.append(line);
            }

            resultJson = buffer.toString();


        } catch (MalformedURLException e) {
            Log.e("MYLOG", "MalformedURLException: " + e.getMessage());
        } catch (ProtocolException e) {
            Log.e("MYLOG", "ProtocolException: " + e.getMessage());
        } catch (IOException e) {
            Log.e("MYLOG", "IOException: " + e.getMessage());
        } catch (Exception e) {
            Log.e("MYLOG", "Exception: " + e.getMessage());
        }

        return resultJson;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }
}