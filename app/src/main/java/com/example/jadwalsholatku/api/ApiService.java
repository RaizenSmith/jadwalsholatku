package com.example.jadwalsholatku.api;

import com.example.jadwalsholatku.model.ModelJadwal;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("bandung.json")
    Call<ModelJadwal>getJadwal();
}
