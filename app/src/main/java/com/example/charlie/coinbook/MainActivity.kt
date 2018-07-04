package com.example.charlie.coinbook

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.app.Dialog
import android.content.DialogInterface
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.*
import android.view.animation.AccelerateInterpolator
import androidx.navigation.findNavController
import com.example.charlie.coinbook.ui.BottomNavigationDrawerFragment
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_host.*
import kotlinx.android.synthetic.main.add_transaction_dialog.view.*
import javax.inject.Inject


class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var dispatchingAndroidInjector : DispatchingAndroidInjector<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_host)

        setSupportActionBar(bottom_bar)

        val navController = findNavController(R.id.main_navigation_fragment)
        //NavigationUI.setupActionBarWithNavController(this, navController)
        fab.setOnClickListener {
            showDiag()
        }


    }

    private fun showDiag() {

        val dialogView = View.inflate(this, R.layout.add_transaction_dialog, null)
        val dialog = Dialog(this, R.style.MyAlertDialogStyle)

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(dialogView)

        dialogView.close_btn.setOnClickListener {
            revealShow(dialogView, false, dialog)
        }

        dialog.setOnShowListener { revealShow(dialogView, true, null) }

        dialog.setOnKeyListener(DialogInterface.OnKeyListener { _, i, _ ->
            if (i == KeyEvent.KEYCODE_BACK) {

                revealShow(dialogView, false, dialog)
                return@OnKeyListener true
            }

            false
        })

        dialog.window.setBackgroundDrawable(ColorDrawable(android.graphics.Color.TRANSPARENT))
        dialog.show()

    }

    private fun revealShow(dialogView: View, b: Boolean, dialog: Dialog?) {

        val w = dialogView.add_transaction_dialog.width.toDouble()
        val h = dialogView.add_transaction_dialog.height.toDouble()

        val endRadius = Math.sqrt(w * w + h * h)

        val cx = (fab.x.toInt() + fab.width / 2)
        val cy = (fab.y.toInt() + fab.height / 2)

        if (b) {
            val revealAnimator = ViewAnimationUtils.createCircularReveal(dialogView.add_transaction_dialog, cx, cy, 0f, endRadius.toFloat())

            dialogView.add_transaction_dialog.visibility = View.VISIBLE
            revealAnimator.duration = 350
            revealAnimator.interpolator = AccelerateInterpolator()
            revealAnimator.start()

        } else {

            val anim = ViewAnimationUtils.createCircularReveal(dialogView.add_transaction_dialog, cx, cy, endRadius.toFloat(), 0f)

            anim.addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    super.onAnimationEnd(animation)
                    dialog?.dismiss()
                    dialogView.add_transaction_dialog.visibility = View.INVISIBLE

                }
            })
            anim.duration = 350
            anim.start()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.bottom_bar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {
            android.R.id.home -> {
                val bottomNavigationDrawerFragment = BottomNavigationDrawerFragment()
                bottomNavigationDrawerFragment.show(supportFragmentManager, bottomNavigationDrawerFragment.mTag)
            }
        }

        return true
    }

    override fun supportFragmentInjector() = dispatchingAndroidInjector

}
