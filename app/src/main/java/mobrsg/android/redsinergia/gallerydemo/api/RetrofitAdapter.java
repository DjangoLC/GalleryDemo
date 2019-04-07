package mobrsg.android.redsinergia.gallerydemo.api;

import java.security.Key;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static mobrsg.android.redsinergia.gallerydemo.Constants.BASE_URL;
import static mobrsg.android.redsinergia.gallerydemo.Constants.KEY;

/*
 * Crea la instancia de retrofit para despues crear el request a la API
 * el addInterceptor sirve para agregar header a tu peticionen caso de que lo requiera como
 * en este caso se requiere un Authorization y loa asignamos aqui
 * tambien puedes agregar un timeout en esta parte
 * */

public class RetrofitAdapter {

    public Retrofit getInstance() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(chain -> {
                    Request request = chain.request();
                    request = request.newBuilder()
                            .addHeader("Authorization", "Client-ID " + KEY)
                            .build();
                    return chain.proceed(request);
                }).build();

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
