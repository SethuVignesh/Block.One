package com.example.blockone.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.example.blockone.R

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class SpalshScreen : AppCompatActivity() {


    private var mVisible: Boolean = false
    private lateinit var ivMarker: LottieAnimationView
    private lateinit var network: LottieAnimationView

    init {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide();
        setContentView(R.layout.activity_fullscreen)


        ivMarker = findViewById(R.id.start_btn)
        network = findViewById(R.id.network)
        ivMarker.setOnClickListener(View.OnClickListener {
            ivMarker.playAnimation()


        })
        ivMarker.addAnimatorUpdateListener { valueAnimator ->
            val progress = (valueAnimator.animatedValue as Float * 100).toInt()
            if (progress > 90) {
                network.playAnimation()
                ivMarker.setOnClickListener { null }
            }

        }
        network.addAnimatorUpdateListener { valueAnimator ->
            val progress = (valueAnimator.animatedValue as Float * 100).toInt()
            if (progress > 90) {
                startActivity(Intent(this, blockListActivity::class.java))
            }
        }

    }


    private fun hide() {

        supportActionBar?.hide()
        mVisible = false

    }

}
