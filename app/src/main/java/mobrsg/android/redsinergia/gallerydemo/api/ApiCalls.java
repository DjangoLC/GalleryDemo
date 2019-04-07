package mobrsg.android.redsinergia.gallerydemo.api;

import java.util.List;

import mobrsg.android.redsinergia.gallerydemo.models.PhotoGallery;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiCalls {

    /*
    * En esta interfaz debes declarar los endpoints de tu API
    * si tiene param en el resquest los agregas como en el ejemplo
    *
    * */

    @GET("photos")
    Call<List<PhotoGallery>> getPhotos(@Query("page") Integer page, @Query("per_page") Integer perPage,
                                       @Query("order_by") String orderBy);

}
