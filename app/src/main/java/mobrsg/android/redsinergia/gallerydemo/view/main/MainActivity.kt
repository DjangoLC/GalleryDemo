package mobrsg.android.redsinergia.gallerydemo.view.main

import android.os.Bundle
import android.util.Log

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import mobrsg.android.redsinergia.gallerydemo.R
import mobrsg.android.redsinergia.gallerydemo.adapters.PhotoGalleryAdapter
import mobrsg.android.redsinergia.gallerydemo.api.PhotosWs
import mobrsg.android.redsinergia.gallerydemo.api.RetrofitAdapter

class MainActivity : AppCompatActivity() {

    private var photosAdapter: PhotoGalleryAdapter? = null

    private var mainActivityViewModel: MainActivityViewModel? = null
    private var factory: MainViewModelFactory? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofitAdapter = RetrofitAdapter().getInstance()
        val photosWs = retrofitAdapter.create(PhotosWs::class.java)
        val photosRepository = PhotosRepository(photosWs)
        factory = MainViewModelFactory(photosRepository)
        mainActivityViewModel = ViewModelProviders.of(this, factory).get(MainActivityViewModel::class.java)

        photosAdapter = PhotoGalleryAdapter()

        findViewById<RecyclerView>(R.id.mRecyclerPhotos).apply {
            layoutManager = LinearLayoutManager(context)
            this.adapter = photosAdapter

        }

        getPhotosFromApi()

    }


    private fun getPhotosFromApi() {
        mainActivityViewModel!!.getPhotos(1, 15, "latest").observe(this, Observer{ photoGalleries ->
            photosAdapter!!.setPhotos(photoGalleries)
            Log.e("Done", "value: " + photoGalleries.size)
        })
    }


}
