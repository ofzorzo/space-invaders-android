package com.mygdx.handlers

import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.InputListener
import com.mygdx.game.PlayerSpaceship
import com.mygdx.game.SpaceInvadersGame
import com.mygdx.values.Constants
import com.mygdx.values.GameInfo
import java.lang.Math.sqrt

class InGameHandler(val spaceShip: PlayerSpaceship, val game: SpaceInvadersGame) : InputListener() {

    private var previousX = Constants.SPACESHIP_INITIAL_X_POS
    private var previousY = Constants.SPACESHIP_INITIAL_Y_POS
    private var touches = 0
    private fun genTargetShoot(x: Float, y: Float){
        var speedX = (x - (Constants.SPACESHIP_WIDTH/2 + spaceShip.x - 7.0f * Constants.HORIZ_SCALE_RATIO))
        var speedY = (y - Constants.SPACESHIP_HEIGHT)
        val speed = sqrt((speedX*speedX + speedY*speedY).toDouble())
        speedX = Constants.SHOT_SPEED * (speedX / speed.toFloat())
        speedY = Constants.SHOT_SPEED * (speedY / speed.toFloat())
        this.spaceShip.createShot(speedX, speedY)
    }
    override fun touchDown(event: InputEvent?, x: Float, y: Float, pointer: Int, button: Int): Boolean {
        //somente gera tiro se o usuário não tiver clicado nos botões de mover
        if (!(GameInfo.MOVEMENT == Constants.VBUT_MOV_ID && (
                (Constants.RIGHT_VB_X <= x && Constants.RIGHT_VB_X + Constants.MOVE_VB_WIDTH >= x &&
                Constants.RIGHT_VB_Y <= y && Constants.RIGHT_VB_Y + Constants.MOVE_VB_HEIGHT >= y) ||
                (Constants.LEFT_VB_X <= x && Constants.LEFT_VB_X + Constants.MOVE_VB_WIDTH>= x &&
                Constants.LEFT_VB_Y <= y && Constants.LEFT_VB_Y + Constants.MOVE_VB_HEIGHT >= y)

                        ))){

            this.touches= this.touches + 1
            if (this.touches == 1){
                when(GameInfo.SHOOT){
                    Constants.TARGET_ID -> {
                        genTargetShoot(x, y)
                    }
                    Constants.SCREEN_ID ->{
                        this.spaceShip.createShot(0.0f, Constants.SHOT_SPEED)
                    }
                }
            }

        }




        return true
    }

    override fun touchUp(event: InputEvent?, x: Float, y: Float, pointer: Int, button: Int) {
        this.touches = this.touches - 1
        if (this.touches < 0 ) this.touches = 0
        super.touchUp(event, x, y, pointer, button)
    }
}