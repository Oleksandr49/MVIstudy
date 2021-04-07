package mvi.mvistudy.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mvi.mvistudy.R
import mvi.mvistudy.view.fragments.listFragment.ListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction().let{
                it.replace(R.id.fragmentPlaceHolder, ListFragment())
                it.commit()
            }
        }
    }
}