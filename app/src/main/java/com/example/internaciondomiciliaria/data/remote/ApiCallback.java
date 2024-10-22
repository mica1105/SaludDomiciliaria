package com.example.internaciondomiciliaria.data.remote;

public interface ApiCallback <T> {
    void onSuccess(T response);
    void onError(Throwable error);

}
