package mobrsg.android.redsinergia.gallerydemo.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UrlsGallery {
    @SerializedName("raw")
    @Expose
    var raw: String? = null
    @SerializedName("full")
    @Expose
    var full: String? = null
    @SerializedName("regular")
    @Expose
    var regular: String? = null
    @SerializedName("small")
    @Expose
    var small: String? = null
    @SerializedName("thumb")
    @Expose
    var thumb: String? = null

    constructor() {}

    constructor(raw: String, full: String, regular: String, small: String, thumb: String) {
        this.raw = raw
        this.full = full
        this.regular = regular
        this.small = small
        this.thumb = thumb
    }
}
