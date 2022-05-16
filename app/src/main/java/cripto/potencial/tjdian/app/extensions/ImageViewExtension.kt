package cripto.potencial.tjdian.app.extensions

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import cripto.potencial.tjdian.R

fun ImageView.loadUrl(url: String) {
    Glide.with(this.context)
        .load(url)
        .placeholder(R.drawable.ic_placeholder)
        .into(this)
}
fun Context.getDrawableFromUrl(
    url: String,
    imageUrlCallback: ImageUrlCallback? = null
) {
    Glide.with(this)
        .load(url)
        .addListener(object : RequestListener<Drawable> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                return false
            }

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: Target<Drawable>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                resource?.let { drawable ->
                    imageUrlCallback?.let {
                        it.imageLoaded(drawable)
                    }
                }
                return false
            }

        })
        .placeholder(R.drawable.ic_placeholder)
        .submit()
}
interface ImageUrlCallback {
    fun imageLoaded(image: Drawable)
}
