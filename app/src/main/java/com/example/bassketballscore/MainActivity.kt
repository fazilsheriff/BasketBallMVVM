package com.example.bassketballscore

import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.bassketballscore.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*


/*
*
* 1 Common method
* 2 Adding DataBinding
* 3 Adding LiveData
* 4  Addding ViewModel
* 5 Common Click
* 6 Add Git source code
*
*
*
* Doaubts
* 1 What is the use of viewmodel providers
* 2 Differencce between live data and mutable live database
* 3 Working mechanism of  Live data
* 4
* */
class MainActivity : AppCompatActivity() {
    private  lateinit var viewModel: MainActivityViewModel
    private  lateinit var dataBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Databinding - replacing the setcontent view
        dataBinding= DataBindingUtil.setContentView(this,R.layout.activity_main)
        //View model object is implemented
            viewModel=ViewModelProvider(this).get(MainActivityViewModel::class.java)
          //getting intial value and intialzing to live data
        var  teamAScore:LiveData<Int> = viewModel.fnGetTeamAScore()
        var teamBScore:LiveData<Int> = viewModel.fnGetTeamBScore()
        //Live Data observering the values
        teamAScore.observe(this, Observer {
            dataBinding.txtScoreA.setText(""+it)
        })
            teamBScore.observe(this, Observer {
                dataBinding.txtScoreB.setText(""+it)
        })
        dataBinding.btnAOnePlus.setOnClickListener(View.OnClickListener {
            viewModel.fnAddOne(1,"A")
        })
        dataBinding.btnAThreePlus.setOnClickListener(View.OnClickListener {
              viewModel.fnAddThree(3,"A")
        })
        dataBinding.btnBOnePlus.setOnClickListener(View.OnClickListener {
        viewModel.fnAddOne(1,"B")
        })
        dataBinding.btnBThreePlus.setOnClickListener(View.OnClickListener {
          viewModel.fnAddThree(3,"B")
        })

        dataBinding.btnRest.setOnClickListener(View.OnClickListener {
            viewModel.fnClearValues()
        })
    }
    }

