package cripto.potencial.tjdian.app.presentation

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.annotation.UiThread
import cripto.potencial.tjdian.R

class LoadingView(context: Context, attrs: AttributeSet?) :
    FrameLayout(context, attrs) {

    private val MIN_SHOW_TIME_MS = 500
    private val MIN_DELAY_MS = 500
    private var mStartTime: Long = -1
    private var mPostedHide = false
    private var mPostedShow = false
    private var mDismissed = false


    private val mDelayedHide = Runnable {
        mPostedHide = false
        mStartTime = -1
        visibility = GONE
    }

    private val mDelayedShow = Runnable {
        mPostedShow = false
        if (!mDismissed) {
            mStartTime = System.currentTimeMillis()
            visibility = VISIBLE
        }
    }

    init {
        inflateView()
    }

    private fun inflateView() {
        LayoutInflater.from(context).inflate(R.layout.view_progress_indicator, this)
    }


    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        removeCallbacks()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        removeCallbacks()
    }

    private fun removeCallbacks() {
        removeCallbacks(mDelayedHide)
        removeCallbacks(mDelayedShow)
    }

    fun hide() {
        post { hideOnUiThread() }
    }

    @UiThread
    private fun hideOnUiThread() {
        mDismissed = true
        removeCallbacks(mDelayedShow)
        mPostedShow = false
        val diff = System.currentTimeMillis() - mStartTime
        if (diff >= MIN_SHOW_TIME_MS || mStartTime == -1L) {
            visibility = GONE
        } else {
            if (!mPostedHide) {
                postDelayed(mDelayedHide, MIN_SHOW_TIME_MS - diff)
                mPostedHide = true
            }
        }
    }

    fun show() {
        post { showOnUiThread() }
    }

    @UiThread
    private fun showOnUiThread() {
        mStartTime = -1
        mDismissed = false
        removeCallbacks(mDelayedHide)
        mPostedHide = false
        if (!mPostedShow) {
            postDelayed(mDelayedShow, MIN_DELAY_MS.toLong())
            mPostedShow = true
        }
    }
}