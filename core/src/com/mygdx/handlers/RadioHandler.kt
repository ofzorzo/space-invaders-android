package com.mygdx.handlers

import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.InputListener
import com.mygdx.screens.SettingsScreen
import com.mygdx.values.Constants
import com.mygdx.values.GameInfo

class RadioHandler(val settings: SettingsScreen, private val id: Int): InputListener(){

    override fun touchDown(event: InputEvent?, x: Float, y: Float, pointer: Int, button: Int): Boolean {
        this.settings.toggleCheck(this.id)
        when(this.id){
            Constants.ACC_ID -> {
                GameInfo.MOVEMENT = Constants.ACC_ID
            }
            Constants.VBUT_MOV_ID -> {
                GameInfo.MOVEMENT = Constants.VBUT_MOV_ID
            }
            Constants.TARGET_ID ->{
                GameInfo.SHOOT = Constants.TARGET_ID
            }
            Constants.SCREEN_ID -> {
                GameInfo.SHOOT = Constants.SCREEN_ID
            }
            Constants.VBUT_SHOOT_ID->{
                GameInfo.SHOOT = Constants.VBUT_SHOOT_ID
            }

        }
        return true
    }
}