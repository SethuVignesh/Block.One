package com.example.blockone.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.airbnb.lottie.LottieAnimationView
import com.androidisland.vita.VitaOwner
import com.androidisland.vita.vita
import com.example.blockone.R
import com.example.blockone.viewmodel.BlockListViewModel

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class SpalshScreen : AppCompatActivity() {


    private var mVisible: Boolean = false
    private lateinit var ivMarker: LottieAnimationView
    private lateinit var network: LottieAnimationView
    lateinit var blockListViewModel: BlockListViewModel

    init {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide();
        setContentView(R.layout.activity_fullscreen)
        blockListViewModel = vita.with(VitaOwner.None).getViewModel<BlockListViewModel>()

        ivMarker = findViewById(R.id.start_btn)
        network = findViewById(R.id.network)
        ivMarker.setOnClickListener(View.OnClickListener {
            ivMarker.playAnimation()
            blockListViewModel.getHeadBlockVM()


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

            }
        }

        blockListViewModel.headBlock.observe(this, Observer {
            blockListViewModel.getBlockList(it.headBlockId)
        })

        blockListViewModel.blockList.observe(this, Observer {
            var intent = Intent(this, blockListActivity::class.java)
//            intent.putParcelableArrayListExtra(blockListActivity.BLOCKS, it)
            startActivity(intent)
        })

    }


    private fun hide() {

        supportActionBar?.hide()
        mVisible = false

    }

}
