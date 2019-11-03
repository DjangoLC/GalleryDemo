package mobrsg.android.redsinergia.gallerydemo.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PhotoGallery {

    @SerializedName("id")
    @Expose
    var id: String? = null
    @SerializedName("created_at")
    @Expose
    var createdAt: String? = null
    @SerializedName("updated_at")
    @Expose
    var updatedAt: String? = null
    @SerializedName("width")
    @Expose
    var width: Int? = null
    @SerializedName("height")
    @Expose
    var height: Int? = null
    @SerializedName("color")
    @Expose
    var color: String? = null
    @SerializedName("downloads")
    @Expose
    var downloads: Int? = null
    @SerializedName("likes")
    @Expose
    var likes: Int? = null
    @SerializedName("liked_by_user")
    @Expose
    var likedByUser: Boolean? = null
    @SerializedName("urls")
    @Expose
    var urls: UrlsGallery? = null

    constructor() {}

    constructor(id: String, createdAt: String, updatedAt: String, width: Int?, height: Int?, color: String, downloads: Int?, likes: Int?, likedByUser: Boolean?, urls: UrlsGallery) {
        this.id = id
        this.createdAt = createdAt
        this.updatedAt = updatedAt
        this.width = width
        this.height = height
        this.color = color
        this.downloads = downloads
        this.likes = likes
        this.likedByUser = likedByUser
        this.urls = urls
    }
}
