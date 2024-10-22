package com.example.internaciondomiciliaria.data.remote;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.security.GeneralSecurityException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    public static final String URLBASE= "https://67146b62690bf212c7615f92.mockapi.io/";
    private static ApiClient apiClient;

    public static ApiClient getApi(){
        Gson gson= new GsonBuilder().setLenient().create();
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(new ErrorInterceptor())
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URLBASE)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();

        apiClient= retrofit.create(ApiClient.class);
        return apiClient;
    }
    public static void guardarToken(Context context, String token){
        SharedPreferences sp= context.getSharedPreferences("token.xml", 0);
        SharedPreferences.Editor editor= sp.edit();
        editor.putString("token", token);
        editor.commit();
    }

    public static String leerToken(Context context){
        SharedPreferences sp= context.getSharedPreferences("token.xml", 0);
        return sp.getString("token", "");
    }

    public static void borrarToken(Context context){
        SharedPreferences sp= context.getSharedPreferences("token.xml",0);
        SharedPreferences.Editor editor= sp.edit();
        editor.putString("token","");
        editor.commit();
    }
}
class ErrorInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());
        if (!response.isSuccessful()) {
            // Manejar el error aquí (puedes lanzar una excepción o devolver un objeto de error)
            throw new IOException("Error: " + response.code());
        }
        return response;
    }
}