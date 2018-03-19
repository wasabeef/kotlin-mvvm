package jp.wasabeef.ui.component.binding

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.request.RequestOptions
import jp.wasabeef.util.GlideApp

/**
 * Created by Wasabeef on 2017/10/24.
 */
object ImageBindingAdapters {
    @JvmStatic
    @BindingAdapter("image")
    fun loadImage(view: ImageView, imagePath: String) {
        GlideApp.with(view.context)
                .load(imagePath)
                .into(view)
    }

    @JvmStatic
    @BindingAdapter("circle_image")
    fun loadCircleImage(view: ImageView, imagePath: String) {
        GlideApp.with(view.context)
                .load(imagePath)
                .apply(RequestOptions.circleCropTransform())
                .into(view)
    }
}