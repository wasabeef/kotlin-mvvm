package jp.wasabeef.util

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.module.AppGlideModule
import okhttp3.OkHttpClient
import java.io.InputStream
import javax.inject.Inject

/**
 * Created by Wasabeef on 2017/10/24.
 */
@GlideModule
class GlideModule : AppGlideModule() {

    @Inject
    lateinit var okHttpClient: OkHttpClient

    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        registry.replace(GlideUrl::class.java, InputStream::class.java, OkHttpUrlLoader.Factory(okHttpClient))
        super.registerComponents(context, glide, registry)
    }

    override fun applyOptions(context: Context, builder: GlideBuilder) {
        AppInjection.of(context).inject(this)
        super.applyOptions(context, builder)
    }
}
