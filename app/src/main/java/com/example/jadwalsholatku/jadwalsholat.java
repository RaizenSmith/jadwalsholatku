package com.example.jadwalsholatku;

import android.app.ProgressDialog;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jadwalsholatku.api.ApiService;
import com.example.jadwalsholatku.api.ApiUrl;
import com.example.jadwalsholatku.model.ModelJadwal;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class jadwalsholat extends AppCompatActivity {

    private TextView tv_lokasi_value, tv_subuh_value, tv_dzuhur_value,
            tv_ashar_value, tv_maghrib_value, tv_isya_value;
    private FloatingActionButton fab_refresh;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jadwalsholat);

        tv_lokasi_value = findViewById(R.id.tv_lokasi_value);
        tv_subuh_value = findViewById(R.id.tv_subuh_value);
        tv_dzuhur_value = findViewById(R.id.tv_dzuhur_value);
        tv_ashar_value = findViewById(R.id.tv_ashar_value);
        tv_maghrib_value = findViewById(R.id.tv_maghrib_value);
        tv_isya_value = findViewById(R.id.tv_isya_value);
        fab_refresh = findViewById(R.id.fab_refresh);

        getJadwal();

        fab_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getJadwal();
            }
        });
    }

    private void getJadwal(){

        progressDialog = new ProgressDialog(jadwalsholat.this);
        progressDialog.setMessage("Silahkan Tunggu ...");
        progressDialog.show();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiUrl.URL_ROOT_HTTP)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);
        Call<ModelJadwal> call = apiService.getJadwal();

        call.enqueue(new Callback<ModelJadwal>() {
            @Override
            public void onResponse(Call<ModelJadwal> call, Response<ModelJadwal> response) {

                progressDialog.dismiss();

                if (response.isSuccessful()){
                    tv_lokasi_value.setText(response.body().getCity()+"Bandung ,"+response.body().getItems().get(0).getDateFor());
                    tv_subuh_value.setText(response.body().getItems().get(0).getFajr());
                    tv_dzuhur_value.setText(response.body().getItems().get(0).getDhuhr());
                    tv_ashar_value.setText(response.body().getItems().get(0).getAsr());
                    tv_maghrib_value.setText(response.body().getItems().get(0).getMaghrib());
                    tv_isya_value.setText(response.body().getItems().get(0).getIsha());
                } else {

                }
            }

            @Override
            public void onFailure(Call<ModelJadwal> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(jadwalsholat.this, "Jaringan Tidak Ditemukan", Toast.LENGTH_SHORT).show();
            }
        });
    }
}