package com.mygdx.handlers

import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.InputListener
import com.mygdx.game.PlayerSpaceship
import com.mygdx.values.Constants

class ShootVBHandler(val spaceship: PlayerSpaceship) : InputListener() {
    override fun touchDown(event: InputEvent?, x: Float, y: Float, pointer: Int, button: Int): Boolean {
        spaceship.createShot(0.0f, Constants.SHOT_SPEED)
        return true
    }
}