package com.mygdx.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Pixmap
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.mygdx.game.SpaceInvadersGame
import com.mygdx.values.Constants
import com.mygdx.values.GameInfo
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable
import com.badlogic.gdx.utils.viewport.ScreenViewport
import com.mygdx.game.EnemyHorde
import com.mygdx.game.PlayerSpaceship
import com.mygdx.handlers.InGameHandler
import com.mygdx.handlers.MoveVBHandler
import com.mygdx.handlers.PauseHandler
import com.mygdx.handlers.ShootVBHandler

class GameRunning(game: SpaceInvadersGame) : SuperScreen(game) {
    private lateinit var bgTexture : Texture
    private lateinit var spaceShipTexture : Texture
    private lateinit var shotsTexture : Texture
    private lateinit var enemyTexture : Texture
    private lateinit var font : BitmapFont
    private lateinit var playStage : Stage
    private lateinit var spaceShip: PlayerSpaceship
    private lateinit var aim : Pixmap
    private lateinit var enemyHorde: EnemyHorde
    private lateinit var pauseButton : ImageButton
    private lateinit var rightVB : ImageButton
    private lateinit var leftVB : ImageButton
    private lateinit var shootLeftVB : ImageButton
    private lateinit var shootRightVB : ImageButton
    private var currentScore: Int = 0
    private var initialized : Boolean = false
    private var endGame: Boolean = false
    private var elapsedTimeSinceEnd: Long = 0
    private var endTime: Long = 0
    private var vbut_move: Boolean = false
    private var vbut_shoot: Boolean = false


    override fun show(){

        if (!this.initialized)
            this.init()
        else
            this.resume()

    }

    //Executes only once, this cannot be done in the constructor because it may run only to show the screen
    //Separated from show method, because it may not be called when the user continue from pause
    fun init (){
        val originalBG = Pixmap(Gdx.files.internal(Constants.BG_IMG_PATH))
        val scaledBG = Pixmap(GameInfo.GAME_WIDTH, GameInfo.GAME_HEIGHT, originalBG.format)
        scaledBG.drawPixmap(originalBG,
                0, 0, originalBG.width, originalBG.height,
                0, 0, scaledBG.width, scaledBG.height)
        this.bgTexture = Texture(scaledBG)

        this.font = BitmapFont(Gdx.files.internal(Constants.FNT_FONT))
        this.font.data.scaleX = 1.0f * Constants.HORIZ_SCALE_RATIO
        this.font.data.scaleY = 1.0f * Constants.VERT_SCALE_RATIO

        this.spaceShipTexture = Texture(Pixmap(Gdx.files.internal(Constants.PLAYER_SPACESHIP)))
        this.shotsTexture = Texture(Pixmap(Gdx.files.internal(Constants.SHOTS_TEXTURE)))
        this.enemyTexture = Texture(Pixmap(Gdx.files.internal(Constants.ENEMY_TEXTURE)))

        //Initialized here to pass game, this is needed to change screens in game
        this.spaceShip = PlayerSpaceship(this.game)
        this.enemyHorde = EnemyHorde(this.spaceShip, this)



        //PLAY BUTTON
        val pauseTexture = Texture(Constants.PAUSE)
        val pauseTextureRegDrawable = TextureRegionDrawable(TextureRegion(pauseTexture))
        this.pauseButton = ImageButton(pauseTextureRegDrawable)
        this.pauseButton.addListener(PauseHandler(this.game))
        this.pauseButton.setPosition(Constants.PAUSE_X, Constants.PAUSE_Y)
        this.pauseButton.setSize(64f * Constants.HORIZ_SCALE_RATIO, 64f * Constants.VERT_SCALE_RATIO)

        val rightVBTexture = Texture(Constants.RIGHT_VB)
        val leftVBTexture = Texture(Constants.LEFT_VB)
        val rTextRegDrawable = TextureRegionDrawable (TextureRegion(rightVBTexture))
        val lTextRegDrawable = TextureRegionDrawable (TextureRegion(leftVBTexture))
        this.rightVB = ImageButton(rTextRegDrawable)
        this.leftVB = ImageButton(lTextRegDrawable)
        this.rightVB.addListener(MoveVBHandler(this.spaceShip, Constants.RIGHT))
        this.leftVB.addListener(MoveVBHandler(this.spaceShip, Constants.LEFT))
        this.rightVB.setPosition(Constants.RIGHT_VB_X, Constants.RIGHT_VB_Y)
        this.leftVB.setPosition(Constants.LEFT_VB_X, Constants.LEFT_VB_Y)
        this.rightVB.setSize(Constants.MOVE_VB_WIDTH, Constants.MOVE_VB_HEIGHT)
        this.leftVB.setSize(Constants.MOVE_VB_WIDTH, Constants.MOVE_VB_HEIGHT)

        val shootVBTexture = Texture(Constants.SHOOT_VB)
        val sVBTextureRegDrawable = TextureRegionDrawable (TextureRegion(shootVBTexture))
        this.shootLeftVB = ImageButton(sVBTextureRegDrawable)
        this.shootRightVB = ImageButton(sVBTextureRegDrawable)
        this.shootLeftVB.addListener(ShootVBHandler(this.spaceShip))
        this.shootRightVB.addListener(ShootVBHandler(this.spaceShip))
        this.shootLeftVB.setPosition(Constants.LEFT_SHOOT_VB_X, Constants.LEFT_SHOOT_VB_Y)
        this.shootRightVB.setPosition(Constants.RIGHT_SHOOT_VB_X, Constants.RIGHT_SHOOT_VB_Y)
        this.shootLeftVB.setSize(Constants.SHOOT_VB_WIDTH, Constants.SHOOT_VB_HEIGHT)
        this.shootRightVB.setSize(Constants.SHOOT_VB_WIDTH, Constants.SHOOT_VB_HEIGHT)

        this.playStage = Stage(ScreenViewport())
        this.playStage.addCaptureListener(InGameHandler(this.spaceShip, this.game))
        this.playStage.setKeyboardFocus(this.spaceShip)
        this.playStage.addActor(this.pauseButton)
        if(GameInfo.MOVEMENT == Constants.VBUT_MOV_ID){
            this.playStage.addActor(this.rightVB)
            this.playStage.addActor(this.leftVB)
            this.vbut_move = true
        }
        if(GameInfo.SHOOT == Constants.VBUT_SHOOT_ID){
            this.playStage.addActor(this.shootLeftVB)
            this.playStage.addActor(this.shootRightVB)
            this.vbut_shoot = true
        }




        //MUSIC
        this.initialized = true

        this.currentScore = 0
        //CURSOR
        this.aim = Pixmap(Gdx.files.internal(Constants.CURSOR))


    }


    override fun render(delta: Float) {
        Gdx.gl.glClearColor(1.0F,0.0F,0.0F,1.0F)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT) //Remove everything from the screen

        //antes de desenhar a nova cena checamos se no último desenho aconteceu alguma colisão ou fim de jogo
        if(this.enemyHorde.checkEndOfGame()) {
            if(this.endGame==true && this.elapsedTimeSinceEnd>1000) {
                this.endGame = false
                this.game.getScreenManager().updateScreen(Constants.GAME_OVER_ID)
            }
            else{
                if(this.endGame==false) {
                    this.endTime = System.currentTimeMillis()
                }
                this.endGame = true
                this.elapsedTimeSinceEnd = System.currentTimeMillis() - this.endTime
            }
        }
        this.enemyHorde.checkCollision()

        if(endGame==false) {
            //cria e move horda
            this.enemyHorde.createHordeIfNeeded()
            this.enemyHorde.moveHorde()

            //move nave do jogador
            this.spaceShip.move()

            //destrói tiros que saíram da tela e move os demais
            this.spaceShip.removeOutterShots()
            this.spaceShip.moveShots()
            when (GameInfo.MOVEMENT){
                Constants.ACC_ID -> this.spaceShip.accelerometerMove(Gdx.input.accelerometerY)

            }
        }

        game.getSpriteBatch().begin() // needs to be called before draw
        game.getSpriteBatch().draw(bgTexture, 0.0F, 0.0F)
        this.font.draw(game.getSpriteBatch(), this.currentScore.toString(), Constants.CURRENT_SCORE_X, Constants.CURRENT_SCORE_Y)
        this.font.draw(game.getSpriteBatch(), Constants.SCORE_TEXT, Constants.SCORE_TEXT_X, Constants.SCORE_TEXT_Y)
        this.font.draw(game.getSpriteBatch(), GameInfo.HIGHSCORE.toString(), Constants.HIGHSCORE_X, Constants.HIGHSCORE_Y)
        this.font.draw(game.getSpriteBatch(), Constants.HIGH_TEXT, Constants.HIGH_TEXT_X, Constants.HIGH_TEXT_Y)

        //desenha horda
        this.enemyHorde.draw(game, enemyTexture)

        //desenha nave e tiros
        this.spaceShip.draw(game, spaceShipTexture)

        //Movimento do acelerômetro




        game.getSpriteBatch().end() // needs to be called after drawing
        this.playStage.act(Gdx.graphics.deltaTime)
        this.playStage.draw()
    }

    fun getCurrentScore(): Int {
        return this.currentScore
    }

    fun setCurrentScore(newScore: Int): Int {
        this.currentScore = newScore
        GameInfo.CURRENT_SCORE = newScore // This value is used on Game over screen
        if(GameInfo.CURRENT_SCORE > GameInfo.HIGHSCORE)
            GameInfo.HIGHSCORE = GameInfo.CURRENT_SCORE
        return this.currentScore
    }

    override fun hide() {
        Gdx.input.inputProcessor = null
    }

    private fun updateActors(){
        if(GameInfo.MOVEMENT == Constants.VBUT_MOV_ID && !this.vbut_move){
            this.playStage.addActor(this.rightVB)
            this.playStage.addActor(this.leftVB)
            this.vbut_move = true
        }
        if(GameInfo.MOVEMENT == Constants.ACC_ID && this.vbut_move){
            this.playStage.clear()
            this.playStage.addCaptureListener(InGameHandler(this.spaceShip, this.game))
            this.playStage.setKeyboardFocus(this.spaceShip)
            this.playStage.addActor(this.pauseButton)
            this.vbut_move = false
            this.vbut_shoot = false
            updateActors() // chama de novo pois pode precisar adicionar os outros botões virtuais
        }
        if(GameInfo.SHOOT == Constants.VBUT_SHOOT_ID && ! this.vbut_shoot){
            this.playStage.addActor(this.shootRightVB)
            this.playStage.addActor(this.shootLeftVB)
            this.vbut_shoot = true
        }
        if(GameInfo.SHOOT != Constants.VBUT_SHOOT_ID && this.vbut_shoot){
            this.playStage.clear()
            this.playStage.addCaptureListener(InGameHandler(this.spaceShip, this.game))
            this.playStage.setKeyboardFocus(this.spaceShip)
            this.playStage.addActor(this.pauseButton)
            this.vbut_shoot = false
            this.vbut_move = false
            updateActors() // chama de novo pois pode precisar adicionar os outros botões virtuais
        }
    }
    override fun resume() {

        Gdx.input.inputProcessor = this.playStage
        updateActors()
    }

}