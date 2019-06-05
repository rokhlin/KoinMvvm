package com.selfapps.koinmvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.selfapps.koinmvvm.R
import com.selfapps.koinmvvm.vm.MainActivityViewModel
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    // lazy inject on Object into property
    val viewModel: MainActivityViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        // or directly get any instance
//        val viewModel : MainActivityViewModel = get()
    }
}
