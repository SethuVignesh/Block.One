package com.example.blockone.view

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NavUtils
import com.example.blockone.R
import com.example.blockone.model.pojo.Block
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_block_detail.*

class blockDetailActivity : AppCompatActivity() {
    lateinit var block: Block
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_block_detail)
        setSupportActionBar(detail_toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, block.rawResponse.toString(), Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if (savedInstanceState == null) {
            block = intent.getParcelableExtra<Block>(blockDetailFragment.ARG_ITEM_ID)
            val fragment = blockDetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(
                        blockDetailFragment.ARG_ITEM_ID,
                        block
                    )
                }
            }

            supportFragmentManager.beginTransaction()
                .add(R.id.block_detail_container, fragment)
                .commit()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem) =
        when (item.itemId) {
            android.R.id.home -> {

                NavUtils.navigateUpTo(this, Intent(this, blockListActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
}
