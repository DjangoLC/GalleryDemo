package mobrsg.android.redsinergia.gallerydemo.api

import mobrsg.android.redsinergia.gallerydemo.Constants.BASE_URL
import mobrsg.android.redsinergia.gallerydemo.Constants.KEY
import okhttp3.Interceptor.Companion.invoke
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient

class RetrofitAdapter {

    fun getInstance(): Retrofit {

        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .addInterceptor(invoke {
                    var request = it.request()
                    request = request.newBuilder()
                            .addHeader("Authorization", "Client-ID $KEY")
                            .build()
                    it.proceed(request)
                })
                .build()

        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

}