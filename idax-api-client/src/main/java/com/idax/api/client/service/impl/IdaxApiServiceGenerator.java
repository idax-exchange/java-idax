package com.idax.api.client.service.impl;

import com.idax.api.client.exception.IdaxApiError;
import com.idax.api.client.exception.IdaxApiException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import org.apache.commons.lang3.StringUtils;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.concurrent.TimeUnit;


/**
 * @program: IdaxApiServiceGenerator
 * @description: IdaxApiServiceGenerator
 * @author: zhuWei (ynzhuwei888@126.com)
 * @create: 2019/03/5 17:10
 */
public class IdaxApiServiceGenerator {

    public static final OkHttpClient sharedClient = new OkHttpClient.Builder()
            .connectTimeout(2000, TimeUnit.SECONDS)
            .pingInterval(200, TimeUnit.SECONDS)
            .readTimeout(2000, TimeUnit.SECONDS)
            .build();

    private static final Converter.Factory converterFactory = JacksonConverterFactory.create();

    @SuppressWarnings("unchecked")
    private static final Converter<ResponseBody, IdaxApiError> errorBodyConverter =
            (Converter<ResponseBody, IdaxApiError>) converterFactory.responseBodyConverter(
                    IdaxApiError.class, new Annotation[0], null);


    /**
     * Execute a REST call and block until the response is received.
     */
    public static <T> T executeSync(Call<T> call) {
        try {
            Response<T> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                IdaxApiError apiError = getIdaxApiError(response);
                throw new IdaxApiException(apiError);
            }
        } catch (IOException e) {
            throw new IdaxApiException(e);
        }
    }

    public static String execute(String url) {
        Request request = new Request.Builder()
                .url(url)
                .build();
        try {
            okhttp3.Response response = sharedClient.newCall(request).execute();
            if (response.isSuccessful()) {
                return String.valueOf(response.body().string());
            } else {
                //  IdaxApiError apiError = getIdaxApiError(response);
                //throw new IdaxApiException(apiError);
            }
        } catch (IOException e) {
            throw new IdaxApiException(e);
        }
        return StringUtils.EMPTY;
    }


    /**
     * Extracts and converts the response error body into an object.
     */
    public static IdaxApiError getIdaxApiError(Response<?> response) throws IOException, IdaxApiException {
        return errorBodyConverter.convert(response.errorBody());
    }

    /**
     * Returns the shared OkHttpClient instance.
     */
    public static OkHttpClient getSharedClient() {
        return sharedClient;
    }
}