package cripto.potencial.tjdian.features.cryptocurrency.app.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import cripto.potencial.tjdian.R

fun ImageView.loadUrl(url: String) {
    Glide.with(this.context)
        .load(url)
        .placeholder(R.drawable.ic_placeholder)
        .into(this)
}