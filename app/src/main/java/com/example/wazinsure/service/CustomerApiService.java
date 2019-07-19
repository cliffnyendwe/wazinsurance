package com.example.wazinsure.service;

import com.example.wazinsure.model.CustomerResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CustomerApiService {
    @GET("api/customers")
    Call<CustomerResponse> getCustomerRecords();
}
