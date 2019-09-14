package com.mygdx.values

import com.badlogic.gdx.Gdx


// The objectives of this class is hold values that may change during the game execution but are widespread through the
// system
object GameInfo {

    //initial dimension values
    var GAME_HEIGHT = Gdx.graphics.height
    var GAME_WIDTH = Gdx.graphics.width

    var CURRENT_WAVE:Int = 0
    var CURRENT_SCORE:Int = 0

    var HIGHSCORE : Int = 0

    var CURRENT_STATE = Constants.MAIN_MENU_ID
    var PREVIOUS_STATE = Constants.MAIN_MENU_ID

    //interarions


    var MOVEMENT = Constants.ACC_ID
    var SHOOT = Constants.TARGET_ID



}