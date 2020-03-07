package com.instagram.clone.gateway.configuration;

import com.instagram.clone.gateway.service.GatewayUserService;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by geonyeong.kim on 2020-03-08
 */
@Configuration
public class GatewayConfiguration {

    private static final int READ_TIMEOUT = 5;

    @Value("${instagram.clone.gateway.baseUrl}")
    private String baseUrl;

    @Bean
    public GatewayUserService gatewayUserService() {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(
                        new OkHttpClient.Builder()
                                .readTimeout(READ_TIMEOUT, TimeUnit.MINUTES)
                                .build())
                .build().create(GatewayUserService.class)
                ;
    }
}
