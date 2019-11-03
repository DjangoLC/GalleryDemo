package mobrsg.android.redsinergia.gallerydemo.view.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import mobrsg.android.redsinergia.gallerydemo.models.PhotoGallery

class MainActivityViewModel(val photosRepository: PhotosRepository): ViewModel() {

    fun getPhotos(page:Int,queryPage: Int,orderBy: String): LiveData<List<PhotoGallery>> {
            return liveData (Dispatchers.IO){
                val response = photosRepository.getPhotosWs(page, queryPage, orderBy)
                emit(response)
            }
    }

}