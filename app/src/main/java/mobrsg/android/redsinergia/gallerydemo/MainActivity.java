package mobrsg.android.redsinergia.gallerydemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import mobrsg.android.redsinergia.gallerydemo.adapters.PhotoGalleryAdapter;
import mobrsg.android.redsinergia.gallerydemo.api.ApiCalls;
import mobrsg.android.redsinergia.gallerydemo.api.RetrofitAdapter;
import mobrsg.android.redsinergia.gallerydemo.models.PhotoGallery;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;


/*
 * Para mas info acerca de las libs usadas consulta
 * Retrofit https://square.github.io/retrofit
 * Gson https://github.com/google/gson
 * Picasso https://square.github.io/picasso/
 *
 * API usada para las imagenes https://unsplash.com/
 * Mi api esta en demoa asi que solo dejara 50 request por dia, registrate como dev en la pagina para
 * poder hacer mas, y cambia la KEY del proyecto por la tuya cuadno creees un proyecto en la pagina
 * tu KEY se llamara : Access Key
 *
 *
 * */

public class MainActivity extends AppCompatActivity {

    private ApiCalls apiPhotos;
    private PhotoGalleryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*
         * Para hacer las peticiones ocupar la interface que almacena los metodos a realizar y tambien
         * la instancia de retrofit, este se encargara de hacer lo necesario para realizarla y tambien
         * de darte los objetos para que accedas normalmente a ellos esto gracias a gson
         * */

        apiPhotos = new RetrofitAdapter().getInstance().create(ApiCalls.class);
        adapter = new PhotoGalleryAdapter();

        /*
         * Asignas adaptador y layoutManager al recycler
         * */
        RecyclerView recyclerView = findViewById(R.id.mRecyclerPhotos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        getPhotos();

    }


    private void getPhotos() {

        /*
         * Para hacer la llamada al api usamos unc Call de retrofit que ejecuta la operacion en
         * otro hilo y solo nos decuelve la respuesta o error por medio de esos 2 callbacks
         * */
        Call<List<PhotoGallery>> photos = apiPhotos.getPhotos(1, 15, "latest");

        photos.enqueue(new Callback<List<PhotoGallery>>() {
            @Override
            public void onResponse(Call<List<PhotoGallery>> call, Response<List<PhotoGallery>> response) {
                adapter.setPhotos(response.body());
                Log.e("Done", "value: " + response.body().size());
            }

            @Override
            public void onFailure(Call<List<PhotoGallery>> call, Throwable t) {
                Toast.makeText(MainActivity.this, R.string.error_message, Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });

    }
}
