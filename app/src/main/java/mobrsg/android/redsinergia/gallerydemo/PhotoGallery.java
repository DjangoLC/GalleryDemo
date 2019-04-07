package mobrsg.android.redsinergia.gallerydemo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PhotoGallery {

    /*
    * Esta clase es la que representa al Json que quieres parsear en android, con la notacion de gson
    * SerializedName indicas el nombre de la llave que viene en tu Json sino, entonces debes solo
    * nombar aqui a la variable exactamente igual al valor de la llave en el Json
    *
    * Como puede ver este en el objeto principal, dentro de el puedes tener mas objetos y debes seguir
    * las mismas reglas para que funcione bien, en caso de que un valor en tu objeto este nulo es
    * poque no esta bien la referencia en SerializedName, el nombre de la variable aqui es diferente
    * a la del Json o no esta dentro de la respuesta en tu Json, verificar bien eso
    *
    * */

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("width")
    @Expose
    private Integer width;
    @SerializedName("height")
    @Expose
    private Integer height;
    @SerializedName("color")
    @Expose
    private String color;
    @SerializedName("downloads")
    @Expose
    private Integer downloads;
    @SerializedName("likes")
    @Expose
    private Integer likes;
    @SerializedName("liked_by_user")
    @Expose
    private Boolean likedByUser;
    @SerializedName("urls")
    @Expose
    private UrlsGallery urls;

    public PhotoGallery() {
    }

    public PhotoGallery(String id, String createdAt, String updatedAt, Integer width, Integer height, String color, Integer downloads, Integer likes, Boolean likedByUser, UrlsGallery urls) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.width = width;
        this.height = height;
        this.color = color;
        this.downloads = downloads;
        this.likes = likes;
        this.likedByUser = likedByUser;
        this.urls = urls;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getDownloads() {
        return downloads;
    }

    public void setDownloads(Integer downloads) {
        this.downloads = downloads;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Boolean getLikedByUser() {
        return likedByUser;
    }

    public void setLikedByUser(Boolean likedByUser) {
        this.likedByUser = likedByUser;
    }

    public UrlsGallery getUrls() {
        return urls;
    }

    public void setUrls(UrlsGallery urls) {
        this.urls = urls;
    }
}
