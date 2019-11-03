package mobrsg.android.redsinergia.gallerydemo.view.main

import mobrsg.android.redsinergia.gallerydemo.api.PhotosWs
import mobrsg.android.redsinergia.gallerydemo.models.PhotoGallery

class PhotosRepository (private val photosWs: PhotosWs){

    suspend fun getPhotosWs(page: Int, queryPage: Int,orderBy: String) : List<PhotoGallery>{
        val headerMap = mutableMapOf<String,String>()
        headerMap.put("page",page.toString())
        headerMap.put("per_page",queryPage.toString())
        headerMap.put("order_by",orderBy)
        return photosWs.fetchPhotos(headerMap)
    }

}