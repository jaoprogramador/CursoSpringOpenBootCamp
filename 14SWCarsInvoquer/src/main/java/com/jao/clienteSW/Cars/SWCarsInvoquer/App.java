package com.jao.clienteSW.Cars.SWCarsInvoquer;

/*import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;
import java.util.concurrent.TimeUnit;*/
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import java.io.IOException;
import java.util.concurrent.TimeUnit;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://one2springdeployjwtcars.onrender.com/api/cars")
                .method("GET", null) // Eliminar el cuerpo de la solicitud para las solicitudes GET
                .addHeader("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJwZXBlIiwiaWF0IjoxNzA5ODA1MzY0LCJleHAiOjE3MDk4OTE3NjR9.JSBcqC1DaW1EcXnNoE1OWD3fFQD1tlstB4etujz_ydCwsiauw8nJlOnZbHKM5HEruPDHpWL_RMDaO6Hk9DEm5w")
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                // Manejar la respuesta aquí
                System.out.println(response.body().string());
            } else {
                System.out.println("Error: " + response.code() + " " + response.message());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        //IA version
        //OkHttpClient client = new OkHttpClient().newBuilder().build();
        /*OkHttpClient client = new OkHttpClient().newBuilder()
        	    .connectTimeout(30, TimeUnit.SECONDS) // Establecer el tiempo de espera de conexión
        	    .readTimeout(30, TimeUnit.SECONDS) // Establecer el tiempo de espera de lectura
        	    .writeTimeout(30, TimeUnit.SECONDS) // Establecer el tiempo de espera de escritura
        	    .build();


        Request request = new Request.Builder()
                .url("https://one2springdeployjwtcars.onrender.com/api/cars")
                .method("GET", null)
                .addHeader("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJndWlndWkiLCJpYXQiOjE3MDk4MDMxMjAsImV4cCI6MTcwOTg4OTUyMH0.tvS-5AZO6IOTwJTeg8ODie4MZinLNwhQSr3VKF3Jlj2iW79NRMmT9ampQ5gPKkBwhrDL4Z_uQVoOHKFVsKwL6g")
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                // Manejar la respuesta aquí
                System.out.println(response.body().string());
            } else {
                System.out.println("Error: " + response.code() + " " + response.message());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /*OkHttpClient client = new OkHttpClient().newBuilder()
				  .build();
				MediaType mediaType = MediaType.parse("text/plain");
				RequestBody body = RequestBody.create(mediaType, "");
				Request request = new Request.Builder()
				  .url("https://one2springdeployjwtcars.onrender.com/api/cars")
				  .method("GET", body)
				  .addHeader("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJndWlndWkiLCJpYXQiOjE3MDk4MDMxMjAsImV4cCI6MTcwOTg4OTUyMH0.tvS-5AZO6IOTwJTeg8ODie4MZinLNwhQSr3VKF3Jlj2iW79NRMmT9ampQ5gPKkBwhrDL4Z_uQVoOHKFVsKwL6g")
				  .build();
				Response response = client.newCall(request).execute();*/
    }
}
