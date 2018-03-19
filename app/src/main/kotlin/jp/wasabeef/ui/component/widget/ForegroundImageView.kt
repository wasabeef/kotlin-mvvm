package jp.wasabeef.ui.component.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.os.Build
import android.support.v4.content.ContextCompat
import android.support.v7.widget.AppCompatImageView
import android.util.AttributeSet
import jp.wasabeef.R

/**
 * An ImageView which supports a foreground drawable.
 *
 * https://gist.github.com/JakeWharton/0a251d67649305d84e8a
 */
class ForegroundImageView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null) : AppCompatImageView(context, attrs) {

    private var innerForeground: Drawable? = null

    init {
        val typedArray = context.obtainStyledAttributes(attrs,
                R.styleable.ForegroundImageView)
        val foreground = typedArray
                .getDrawable(R.styleable.ForegroundImageView_android_foreground)
        if (foreground != null) {
            setForeground(foreground)
        }
        typedArray.recycle()
    }

    override fun jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState()
        if (innerForeground != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            innerForeground!!.jumpToCurrentState()
        }
    }

    override fun verifyDrawable(who: Drawable): Boolean {
        return super.verifyDrawable(who) || who === innerForeground
    }

    override fun drawableStateChanged() {
        super.drawableStateChanged()
        if (innerForeground != null && innerForeground!!.isStateful) {
            innerForeground!!.state = drawableState
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        if (innerForeground != null) {
            innerForeground!!.setBounds(0, 0, measuredWidth, measuredHeight)
            invalidate()
        }
    }

    override fun onSizeChanged(width: Int, height: Int, oldWidth: Int, oldHeight: Int) {
        super.onSizeChanged(width, height, oldWidth, oldHeight)
        if (innerForeground != null) {
            innerForeground!!.setBounds(0, 0, width, height)
            invalidate()
        }
    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)

        if (innerForeground != null) {
            innerForeground!!.draw(canvas)
        }
    }

    /**
     * Supply a drawable resource that is to be rendered on top of all of the child
     * views in the frame layout.
     *
     * @param drawableResId The drawable resource to be drawn on top of the children.
     */
    fun setForegroundResource(drawableResId: Int) {
        setForeground(ContextCompat.getDrawable(context, drawableResId))
    }

    /**
     * Supply a Drawable that is to be rendered on top of all of the child
     * views in the frame layout.
     *
     * @param drawable The Drawable to be drawn on top of the children.
     */
    override fun setForeground(drawable: Drawable?) {
        if (innerForeground === drawable) {
            return
        }
        if (innerForeground != null) {
            innerForeground!!.callback = null
            unscheduleDrawable(innerForeground)
        }

        innerForeground = drawable

        if (drawable != null) {
            drawable.callback = this
            if (drawable.isStateful) {
                drawable.state = drawableState
            }
        }
        requestLayout()
        invalidate()
    }
}
