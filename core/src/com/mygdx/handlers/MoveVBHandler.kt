package com.mygdx.handlers

import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.InputListener
import com.mygdx.game.PlayerSpaceship
import com.mygdx.values.Constants

class MoveVBHandler(val spaceship: PlayerSpaceship, val dir: Int) : InputListener() {
    override fun touchDown(event: InputEvent?, x: Float, y: Float, pointer: Int, button: Int): Boolean {
        when(dir){
            Constants.RIGHT -> {spaceship.publicSetMoveRight(true)}
            Constants.LEFT -> {spaceship.publicSetMoveLeft(true)}
        }

        return true
    }

    override fun touchUp(event: InputEvent?, x: Float, y: Float, pointer: Int, button: Int) {
        when(dir){
            Constants.RIGHT -> {spaceship.publicSetMoveRight(false)}
            Constants.LEFT -> {spaceship.publicSetMoveLeft(false)}
        }
    }
}