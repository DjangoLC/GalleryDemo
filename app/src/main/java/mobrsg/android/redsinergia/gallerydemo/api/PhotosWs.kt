package mobrsg.android.redsinergia.gallerydemo.api

import mobrsg.android.redsinergia.gallerydemo.models.PhotoGallery
import retrofit2.http.GET
import retrofit2.http.HeaderMap

interface PhotosWs {

    @GET("photos")
    suspend fun fetchPhotos(@HeaderMap headerMap: Map<String,String>): List<PhotoGallery>

}