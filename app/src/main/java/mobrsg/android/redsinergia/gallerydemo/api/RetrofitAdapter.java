package mobrsg.android.redsinergia.gallerydemo.api;

import java.security.Key;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/*
 * Crea la instancia de retrofit para despues crear el request a la API
 * el addInterceptor sirve para agregar header a tu peticionen caso de que lo requiera como
 * en este caso se requiere un Authorization y loa asignamos aqui
 * tambien puedes agregar un timeout en esta parte
 * */

public class RetrofitAdapter {

    private final String KEY = "ccbb1f20d6361b9583465f467321aaab680c3c97b5d7d24b07cf974fb21107cd";
    private String BASE_URL = "https://api.unsplash.com/";

    private  Retrofit retrofit;
    private  OkHttpClient client;

    public Retrofit getInstance() {
        client = new OkHttpClient.Builder()
                .addInterceptor(chain -> {
                    Request request = chain.request();
                    request = request.newBuilder()
                            .addHeader("Authorization", "Client-ID " + KEY)
                            .build();
                    return chain.proceed(request);
                })
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

}
