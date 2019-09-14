package com.mygdx.handlers

import com.badlogic.gdx.Gdx
import com.mygdx.values.Constants
import com.mygdx.values.GameInfo
import java.io.File
import java.io.FileNotFoundException
import java.io.InputStream
import java.lang.RuntimeException

class HighScoreHandler{

    fun initHighScore(){
        GameInfo.HIGHSCORE = this.getHighScore()

    }
    //If nowhere else overload polymorphism can be used here introducing a fake HS

    private fun getHighScore() : Int{
        return try {
            Gdx.files.local(Constants.HIGHSCORE_FILE).readString().toInt()
        }catch (e: RuntimeException){
            0
        }
    }

    fun checkHighScore(){
        if(GameInfo.HIGHSCORE > this.getHighScore()){
            this.writeHighScore(GameInfo.HIGHSCORE)
        }
    }

    private fun writeHighScore(score : Int){
        Gdx.files.local(Constants.HIGHSCORE_FILE).writeString(score.toString(), false)

    }
}