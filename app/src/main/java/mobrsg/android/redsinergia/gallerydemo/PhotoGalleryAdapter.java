package mobrsg.android.redsinergia.gallerydemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


/*
* Para implementar un recyclerView ocupar 2 clases la primera el adapatdor que debe extender de
* RecyclerView.Adapter y la segunda de RecyclerView.ViewHolder en esta manejas el layout de tu view
* */

public class PhotoGalleryAdapter extends RecyclerView.Adapter<PhotoGalleryAdapter.GalleryViewHolder> {

    /*
    * Listado de fotos
    * */
    private List<PhotoGallery> photos;

    public PhotoGalleryAdapter() {

    }

    /*
    * Asigna una lista de fotos al adaptador, despues de hacer un cambio en el debes llamar al metodo
    * correspondiente en este caso es notifyDataSetChanged()
    * */
    public void setPhotos(List<PhotoGallery> photos) {
        this.photos = photos;
        notifyDataSetChanged();
    }


    /*
    * Enlazas las vistas de la view con el code y haces el bind de los mismos
    * */
    class GalleryViewHolder extends RecyclerView.ViewHolder {

        private ImageView image;

        public GalleryViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.img_preview);
        }

        /*
        * Bind de photoGallery solo obtiene la url y la setea al view con picasso
        * */
        public void bind(PhotoGallery photoGallery) {
            Picasso.get()
                    .load(photoGallery.getUrls().getRegular())
                    .placeholder(R.drawable.ic_image_black_24dp)
                    .into(image);
        }
    }


    /*
    * Aqui se crea la view para la cantidad de ellas que se puedan visualizar en la pantalla
    * */
    @NonNull
    @Override
    public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_image, parent, false);
        return new GalleryViewHolder(v);
    }

    /*
    * Por cada view nueva llama al bind del holder para setear los datos
    * */
    @Override
    public void onBindViewHolder(@NonNull GalleryViewHolder holder, int position) {
        holder.bind(photos.get(position));
    }


    @Override
    public int getItemCount() {
        return photos != null ? photos.size() : 0;
    }


}
