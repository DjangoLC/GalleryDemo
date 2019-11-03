package mobrsg.android.redsinergia.gallerydemo.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import com.squareup.picasso.Picasso
import androidx.recyclerview.widget.RecyclerView
import mobrsg.android.redsinergia.gallerydemo.R
import mobrsg.android.redsinergia.gallerydemo.models.PhotoGallery

class PhotoGalleryAdapter : RecyclerView.Adapter<PhotoGalleryAdapter.GalleryViewHolder>() {

    private var photos: List<PhotoGallery>? = null

    fun setPhotos(photos: List<PhotoGallery>) {
        this.photos = photos
        notifyDataSetChanged()
    }

    class GalleryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val image: ImageView

        init {

            image = itemView.findViewById(R.id.img_preview)
        }

        fun bind(photoGallery: PhotoGallery) {
            Picasso.get()
                    .load(photoGallery.urls!!.regular)
                    .placeholder(R.drawable.ic_image_black_24dp)
                    .into(image)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row_image, parent, false)
        return GalleryViewHolder(v)
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        holder.bind(photos!![position])
    }


    override fun getItemCount(): Int {
        return if (photos != null) photos!!.size else 0
    }


}
