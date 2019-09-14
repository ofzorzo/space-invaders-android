package com.mygdx.game

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.math.Polygon
import com.mygdx.values.Constants


class EnemySpaceship : Spaceship{

    override var health: Int = 1
    override var vertices: FloatArray
    override var poly = Polygon()
    override var moveRight: Boolean = true
    override var moveLeft: Boolean = false
    private var hitted: Boolean = false
    private var recoverTime : Int = 0
    private var speed: Float = 10.0f * Constants.HORIZ_SCALE_RATIO
    private var changeLane: Boolean = false

    constructor(x: Float, y: Float, health: Int) : super(){
        this.vertices = floatArrayOf(
                x+15.0f * Constants.HORIZ_SCALE_RATIO, y+0.0f  * Constants.VERT_SCALE_RATIO,
                x+35.0f * Constants.HORIZ_SCALE_RATIO, y+0.0f  * Constants.VERT_SCALE_RATIO,
                x+49.0f * Constants.HORIZ_SCALE_RATIO, y+53.0f * Constants.VERT_SCALE_RATIO,
                x+32.0f * Constants.HORIZ_SCALE_RATIO, y+3.0f  * Constants.VERT_SCALE_RATIO,
                x+17.0f * Constants.HORIZ_SCALE_RATIO, y+3.0f  * Constants.VERT_SCALE_RATIO,
                x+0.0f  * Constants.HORIZ_SCALE_RATIO, y+53.0f * Constants.VERT_SCALE_RATIO
        )
        this.setPosition(x, y)
        this.health = health
        updateSpaceshipPoly()
    }

    override fun draw(game: SpaceInvadersGame, texture: Texture) {
        game.getSpriteBatch().draw(texture, this.x, this.y, Constants.ENEMY_WIDTH, Constants.ENEMY_HEIGHT)
    }

    override fun move() {
        moveRight(speed)
        moveLeft(-speed)
        changeLanes()
    }

    override fun moveLeft(deltaX: Float) {
        if(this.moveLeft) {
            this.setPosition(this.x + deltaX, this.y)
            for (j in 0 until this.vertices.size)
                if (j % 2 == 0) {
                    this.vertices[j] = this.vertices[j] + deltaX
                    this.updateSpaceshipPoly()
                }
        }
    }

    override fun moveRight(deltaX: Float) {
        if(this.moveRight) {
            this.setPosition(this.getX() + deltaX, this.getY())
            for (j in 0 until this.vertices.size) {
                if (j % 2 == 0) {
                    this.vertices[j] = this.vertices[j] + deltaX
                    this.updateSpaceshipPoly()
                }
            }
        }
    }

    private fun changeLanes(){
        if(this.changeLane) {
            this.setPosition(this.x, this.y - Constants.LANE_SIZE)
            for (j in 0 until this.vertices.size)
                if (j % 2 != 0) {
                    this.vertices[j] = this.vertices[j] - Constants.LANE_SIZE
                    this.updateSpaceshipPoly()
                }
        }
    }

    fun setSpeed(value: Float){
        this.speed = value
    }

    fun getSpeed(): Float{
        return this.speed
    }

    fun getChangeLane(): Boolean{
        return this.changeLane
    }

    fun setChangeLane(value: Boolean){
        this.changeLane = value
    }

    fun takeDamage() {
        this.hitted = true
        this.recoverTime = Constants.RECOVER_TIME
    }

    fun wasHit(): Boolean {
        return this.hitted

    }

    fun decreaseRecoverTime() {
        this.recoverTime -= 1
        if (this.recoverTime == 0)
            this.hitted = false
    }

    fun getRecoverTime() : Int{
        return this.recoverTime
    }
}