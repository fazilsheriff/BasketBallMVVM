package com.example.bassketballscore
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
class MainActivityViewModel:ViewModel() {
    var teamAScore = 0
    var teamBScore = 0

    private var teamALiveData= MutableLiveData<Int>()
    private var teamBLiveData= MutableLiveData<Int>()

    fun fnGetTeamAScore():MutableLiveData<Int>{
        teamALiveData.value=teamAScore
        return teamALiveData
    }
    fun fnGetTeamBScore():MutableLiveData<Int>{
        teamBLiveData.value=teamBScore
        return teamBLiveData
    }
    fun fnAddOne(number: Int, team: String): MutableLiveData<Int> {
        if (team.equals("A")) {
            teamAScore = teamAScore + 1
            teamALiveData.value=teamAScore
            return teamALiveData
        }
        else if (team.equals("B"))
        {
            teamBScore=teamBScore+1
            teamBLiveData.value=teamBScore
            return teamBLiveData
        }
            return teamBLiveData
    }
    fun fnAddThree(number: Int, team: String): MutableLiveData<Int> {
        if (team.equals("A")) {
            teamAScore = teamAScore + 3
            teamALiveData.value=teamAScore
            return teamALiveData
        }
        else if (team.equals("B"))
        {
            teamBScore=teamBScore+3
            teamBLiveData.value=teamBScore
            return teamBLiveData
        }
        return teamBLiveData
    }

    fun fnClearValues(){
        teamAScore=0
        teamBScore=0
        teamALiveData.value=teamAScore
        teamBLiveData.value=teamBScore
    }

}