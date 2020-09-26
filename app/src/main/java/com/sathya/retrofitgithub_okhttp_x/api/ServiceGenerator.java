package com.sathya.retrofitgithub_okhttp_x.api;

//import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    // users/{user}
    // https://api.github.com/users/sathyaBabu


    //     BASE URL                           tail
    // https://api.github.com/            users/sathyaBabu

   // https://github.com/sathyaBabu


// https://github.com/square/okhttp/wiki/Interceptors

    // Tail @GET methods
    // https://github.com/codepath/android_guides/wiki/Consuming-APIs-with-Retrofit


    // https://square.github.io/retrofit/

    // https://square.github.io/okhttp/3.x/okhttp/okhttp3/OkHttpClient.html

    // Phase II
//                        public static final String API_BASE_URL = "https://api.github.com/";
//
//                        private static HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//                        private static Interceptor logging                = interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
//
//
//                        private static OkHttpClient httpClient = new OkHttpClient.Builder()
//                                .readTimeout(500, TimeUnit.MILLISECONDS) // change to 50
//
//                                .addInterceptor(logging)
//
//                                .build();
//
//
//                        private static Retrofit.Builder builder =
//                                new Retrofit.Builder()
//                                        .baseUrl(API_BASE_URL)
//                                        .addConverterFactory(GsonConverterFactory.create());
//
//                        public static <S> S createService(Class<S> serviceClass) {
//                            Retrofit retrofit = builder.client(httpClient).build();
//                            return retrofit.create(serviceClass);
//                        }
//


    ///
    public static final String BASE_URL = "https://api.github.com/";
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

//        GitHubClient service = retrofit.create(GitHubClient.class);
        return retrofit;
    }



}
