package cs6440.backend;

import android.util.Base64;
import android.util.Log;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Twilio2 {
    //    if (android.os.Build.VERSION.SDK_INT > 9) {
//        StrictMode.setThreadPolicy( new StrictMode.ThreadPolicy.Builder().permitAll().build() );
//    }
    final String ACCOUNT_SID="ACd0b18eaeeabb5e61e9af97b050147d23";
    final String AUTH_TOKEN = "d9af2c6fe1ce9e8dcadd23c95ea1e575";

    public void sendMsg( String message, String phone){
        OkHttpClient client = new OkHttpClient();
        String url = "https://api.twilio.com/2010-04-01/Accounts/"+ACCOUNT_SID+"/SMS/Messages";
        String base64EncodedCredentials = "Basic " + Base64.encodeToString((ACCOUNT_SID + ":" + AUTH_TOKEN).getBytes(), Base64.NO_WRAP);

        String from = "8508207837";
        String to = phone;

        RequestBody body = new FormBody.Builder()
                .add("From", from)
                .add("To", to)
                .add("Body", message)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .header("Authorization", base64EncodedCredentials)
                .build();
        try {
            Response response = client.newCall(request).execute();
            //Log.d(TAG, "sendSms: "+ response.body().string());
        } catch (IOException e) { e.printStackTrace(); }

    }
}
