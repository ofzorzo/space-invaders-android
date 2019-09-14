package com.mygdx.screens

import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Pixmap
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable
import com.badlogic.gdx.utils.viewport.ScreenViewport
import com.mygdx.game.SpaceInvadersGame
import com.mygdx.handlers.BackHandler
import com.mygdx.handlers.DoneHandler
import com.mygdx.handlers.RadioHandler
import com.mygdx.values.Constants
import com.mygdx.values.GameInfo

class SettingsScreen(game: SpaceInvadersGame) : SuperScreen(game) {

    private lateinit var bgTexture : Texture
    private lateinit var titleFont : BitmapFont
    private lateinit var optionsFont : BitmapFont
    private lateinit var doneButton : ImageButton
    //treats radio boxes as buttons
    private lateinit var accRadio : ImageButton
    private lateinit var vbutMovRadio : ImageButton
    private lateinit var targetTouchRadio : ImageButton
    private lateinit var screenTouchRadio : ImageButton
    private lateinit var vbutShootRadio : ImageButton
    private lateinit var settingsStage : Stage
    private lateinit var radioOnTextureRegDrawable : TextureRegionDrawable
    private lateinit var radioOffTextureRegDrawable : TextureRegionDrawable


    override fun show() {
        //BACKGROUND IMAGE
        val originalBG = Pixmap(Gdx.files.internal(Constants.BG_IMG_PATH))
        val scaledBG = Pixmap(GameInfo.GAME_WIDTH, GameInfo.GAME_HEIGHT, originalBG.format)
        scaledBG.drawPixmap(originalBG,
                0, 0, originalBG.width, originalBG.height,
                0, 0, scaledBG.width, scaledBG.height)
        this.bgTexture = Texture(scaledBG)
        //FONT
        this.titleFont = BitmapFont(Gdx.files.internal(Constants.FNT_FONT))
        this.titleFont.data.scaleX = 2.0f * Constants.HORIZ_SCALE_RATIO
        this.titleFont.data.scaleY = 2.0f * Constants.VERT_SCALE_RATIO
        this.optionsFont = BitmapFont(Gdx.files.internal(Constants.FNT_FONT))
        this.optionsFont.data.scaleX = 1.0f * Constants.HORIZ_SCALE_RATIO
        this.optionsFont.data.scaleY = 1.0f * Constants.VERT_SCALE_RATIO
        //DONE BUTTON
        val doneTexture = Texture(Constants.DONE_BUT)
        val doneTextureRegDrawable = TextureRegionDrawable(TextureRegion(doneTexture))
        this.doneButton = ImageButton(doneTextureRegDrawable)
        this.doneButton.addListener(DoneHandler(this.game))
        this.doneButton.setPosition(Constants.DONE_BUTTON_X, Constants.DONE_BUTTON_Y)
        this.doneButton.setSize(Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT)

        //RADIOS

        val radioOnTexture = Texture(Constants.RADIO_ON)
        this.radioOnTextureRegDrawable = TextureRegionDrawable(TextureRegion(radioOnTexture))
        val radioOffTexture = Texture(Constants.RADIO_OFF)
        this.radioOffTextureRegDrawable = TextureRegionDrawable(TextureRegion(radioOffTexture))
        if(GameInfo.MOVEMENT == Constants.ACC_ID) {
            this.accRadio = ImageButton(radioOnTextureRegDrawable, radioOnTextureRegDrawable)
            this.vbutMovRadio = ImageButton(radioOffTextureRegDrawable, radioOnTextureRegDrawable)
        }
        else{
            this.accRadio = ImageButton(radioOffTextureRegDrawable, radioOnTextureRegDrawable)
            this.vbutMovRadio = ImageButton(radioOnTextureRegDrawable, radioOnTextureRegDrawable)
        }
        when(GameInfo.SHOOT){
            Constants.TARGET_ID -> {
                this.targetTouchRadio = ImageButton(radioOnTextureRegDrawable, radioOnTextureRegDrawable)
                this.screenTouchRadio = ImageButton(radioOffTextureRegDrawable, radioOnTextureRegDrawable)
                this.vbutShootRadio = ImageButton(radioOffTextureRegDrawable, radioOnTextureRegDrawable)
            }
            Constants.SCREEN_ID -> {
                this.targetTouchRadio = ImageButton(radioOffTextureRegDrawable, radioOnTextureRegDrawable)
                this.screenTouchRadio = ImageButton(radioOnTextureRegDrawable, radioOnTextureRegDrawable)
                this.vbutShootRadio = ImageButton(radioOffTextureRegDrawable, radioOnTextureRegDrawable)
            }
            else -> {
                this.targetTouchRadio = ImageButton(radioOffTextureRegDrawable, radioOnTextureRegDrawable)
                this.screenTouchRadio = ImageButton(radioOffTextureRegDrawable, radioOnTextureRegDrawable)
                this.vbutShootRadio = ImageButton(radioOnTextureRegDrawable, radioOnTextureRegDrawable)
            }
        }

        this.accRadio.isChecked = true
        this.vbutMovRadio.isChecked = false
        this.targetTouchRadio.isChecked = true
        this.screenTouchRadio.isChecked = false
        this.vbutShootRadio.isChecked = false

        this.accRadio.addListener(RadioHandler(this, Constants.ACC_ID))
        this.vbutMovRadio.addListener(RadioHandler(this, Constants.VBUT_MOV_ID))
        this.targetTouchRadio.addListener(RadioHandler(this, Constants.TARGET_ID))
        this.screenTouchRadio.addListener(RadioHandler(this, Constants.SCREEN_ID))
        this.vbutShootRadio.addListener(RadioHandler(this, Constants.VBUT_SHOOT_ID))

        this.accRadio.setPosition(Constants.ACC_RADIO_X, Constants.ACC_MOV_TEXT_Y - 32.0f * Constants.VERT_SCALE_RATIO)
        this.vbutMovRadio.setPosition(Constants.VBUT_MOV_RADIO_X, Constants.VBUT_MOV_TEXT_Y- 32.0f * Constants.VERT_SCALE_RATIO)
        this.targetTouchRadio.setPosition(Constants.TARGET_RADIO_X, Constants.TARGET_TEXT_Y- 32.0f * Constants.VERT_SCALE_RATIO)
        this.screenTouchRadio.setPosition(Constants.SCREEN_RADIO_X, Constants.SCREEN_TEXT_Y- 32.0f * Constants.VERT_SCALE_RATIO)
        this.vbutShootRadio.setPosition(Constants.VBUT_SHOOT_RADIO_X, Constants.VBUT_SHOOT_TEXT_Y - 32.0f * Constants.VERT_SCALE_RATIO)

        this.accRadio.setSize(Constants.RADIO_WIDTH, Constants.RADIO_HEIGHT)
        this.vbutMovRadio.setSize(Constants.RADIO_WIDTH, Constants.RADIO_HEIGHT)
        this.targetTouchRadio.setSize(Constants.RADIO_WIDTH, Constants.RADIO_HEIGHT)
        this.screenTouchRadio.setSize(Constants.RADIO_WIDTH, Constants.RADIO_HEIGHT)
        this.vbutShootRadio.setSize(Constants.RADIO_WIDTH, Constants.RADIO_HEIGHT)

        this.settingsStage = Stage(ScreenViewport())
        this.settingsStage.addActor(this.doneButton)
        this.settingsStage.addActor(this.accRadio)
        this.settingsStage.addActor(this.vbutMovRadio)
        this.settingsStage.addActor(this.targetTouchRadio)
        this.settingsStage.addActor(this.screenTouchRadio)
        this.settingsStage.addActor(this.vbutShootRadio)

        Gdx.input.inputProcessor = this.settingsStage

    }



    override fun render(delta: Float) {
        Gdx.gl.glClearColor(1.0F,0.0F,0.0F,1.0F)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT) //Remove everything from the screen


        game.getSpriteBatch().begin() // needs to be called before draw
        game.getSpriteBatch().draw(bgTexture, 0.0F, 0.0F)
        this.titleFont.draw(game.getSpriteBatch(), Constants.SETTINGS_TEXT, Constants.SETTINGS_TEXT_X, Constants.SETTINGS_TEXT_Y)
        this.optionsFont.draw(game.getSpriteBatch(), Constants.MOVEMENT_TEXT, Constants.MOVEMENT_TEXT_X, Constants.MOVEMENT_TEXT_Y)
        this.optionsFont.draw(game.getSpriteBatch(), Constants.ACC_MOV_TEXT, Constants.ACC_MOV_TEXT_X, Constants.ACC_MOV_TEXT_Y)
        this.optionsFont.draw(game.getSpriteBatch(), Constants.VBUT_MOV_TEXT, Constants.VBUT_MOV_TEXT_X, Constants.VBUT_MOV_TEXT_Y)
        this.optionsFont.draw(game.getSpriteBatch(), Constants.SHOOT_TEXT, Constants.SHOOT_TEXT_X, Constants.SHOOT_TEXT_Y)
        this.optionsFont.draw(game.getSpriteBatch(), Constants.TARGET_TEXT, Constants.TARGET_TEXT_X, Constants.TARGET_TEXT_Y)
        this.optionsFont.draw(game.getSpriteBatch(), Constants.SCREEN_TEXT, Constants.SCREEN_TEXT_X, Constants.SCREEN_TEXT_Y)
        this.optionsFont.draw(game.getSpriteBatch(), Constants.VBUT_SHOOT_TEXT, Constants.VBUT_SHOOT_TEXT_X, Constants.VBUT_SHOOT_TEXT_Y)
        game.getSpriteBatch().end() // needs to be called after drawing
        this.settingsStage.act(Gdx.graphics.deltaTime)
        this.settingsStage.draw()

    }

    override fun hide() {
        Gdx.input.inputProcessor = null

    }

    override fun resume() {
        Gdx.input.inputProcessor = this.settingsStage

    }
    //togle an radio button checked
    fun toggleCheck(id:Int){
        when(id){
            Constants.ACC_ID ->{
                this.accRadio.style.imageUp = this.radioOnTextureRegDrawable
                this.vbutMovRadio.style.imageUp = this.radioOffTextureRegDrawable

            }
            Constants.VBUT_MOV_ID ->{
                this.accRadio.style.imageUp = this.radioOffTextureRegDrawable
                this.vbutMovRadio.style.imageUp = this.radioOnTextureRegDrawable

            }
            Constants.TARGET_ID->{
                this.targetTouchRadio.style.imageUp = this.radioOnTextureRegDrawable
                this.screenTouchRadio.style.imageUp = this.radioOffTextureRegDrawable
                this.vbutShootRadio.style.imageUp = this.radioOffTextureRegDrawable
            }
            Constants.SCREEN_ID->{
                this.targetTouchRadio.style.imageUp = this.radioOffTextureRegDrawable
                this.screenTouchRadio.style.imageUp = this.radioOnTextureRegDrawable
                this.vbutShootRadio.style.imageUp = this.radioOffTextureRegDrawable
            }
            Constants.VBUT_SHOOT_ID->{
                this.targetTouchRadio.style.imageUp = this.radioOffTextureRegDrawable
                this.screenTouchRadio.style.imageUp = this.radioOffTextureRegDrawable
                this.vbutShootRadio.style.imageUp = this.radioOnTextureRegDrawable

            }
        }

    }
}