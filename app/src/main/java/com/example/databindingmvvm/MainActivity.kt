package com.example.databindingmvvm
import android.app.ProgressDialog.show
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.databindingmvvm.databinding.ActivityMainBinding
import com.example.databindingmvvm.utils.toast
class MainActivity : AppCompatActivity() ,Authlistener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        val viewmodel = ViewModelProvider(this).get(Authviewmodel::class.java)
        binding.model=viewmodel
        viewmodel.authlisterner=this

    }

    override fun onstarted() {
        toast("login started")
       // ProgressBar.show()
    }

    override fun onsucess(loginresponse: LiveData<String>) {
        loginresponse.observe(this, Observer {
        //    ProgressBar.hide()
            toast(it)
        })

    }

    override fun onfailure(msg: String) {
        toast(msg)

    }
}