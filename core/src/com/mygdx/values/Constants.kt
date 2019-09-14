package com.mygdx.values

import com.badlogic.gdx.Gdx

// The objective of this class is to hold values that will never change
/*As constantes do jogo que dependem da resolução do dispositivo serão
* normalizadas realizando um mapeamento entre coordenadas lógicas do jogo
* e coordenadas do dispositivo, dessa forma o jogo tem coordenadas lógicas:
* 1280x720 que serão mapeadas de modo uniforme para qualquer resolução
* de dispositivo
* */
object Constants {

    const val LOGIC_HEIGHT = 720f
    const val LOGIC_WIDTH = 1280f

    val DEVICE_WIDTH = Gdx.graphics.width.toFloat()
    val DEVICE_HEIGHT = Gdx.graphics.height.toFloat()
    val HORIZ_SCALE_RATIO = DEVICE_WIDTH / LOGIC_WIDTH
    val VERT_SCALE_RATIO = DEVICE_HEIGHT / LOGIC_HEIGHT
    val SPACESHIP_WIDTH = 98.0f * HORIZ_SCALE_RATIO
    val SPACESHIP_HEIGHT = 75.0f * VERT_SCALE_RATIO

    var SPACESHIP_INITIAL_X_POS = DEVICE_WIDTH/2 -(SPACESHIP_WIDTH/2)
    val SPACESHIP_INITIAL_Y_POS = 10.0f * VERT_SCALE_RATIO

    val HORDE_X = 75.0f * HORIZ_SCALE_RATIO
    var HORDE_Y = DEVICE_HEIGHT
    val SPACE_BETWEEN_LINES_OF_ENEMIES = 8.0f * VERT_SCALE_RATIO
    val SPACE_BETWEEN_COLUMNS_OF_ENEMIES = 50.0f * HORIZ_SCALE_RATIO

    val ENEMY_WIDTH = 50.0f * HORIZ_SCALE_RATIO
    val ENEMY_HEIGHT = 73.0f * VERT_SCALE_RATIO

    val MOVEMENT_SPEED = 7.0f * HORIZ_SCALE_RATIO// número de pixels com que a nave é movida a cada novo frame
    val SHOT_SPEED = 30.0f * VERT_SCALE_RATIO

    val SHOT_HEIGHT = 27f * VERT_SCALE_RATIO
    val SHOT_WIDTH = 8f * HORIZ_SCALE_RATIO

    val BUTTON_WIDTH : Float =  300.0F * HORIZ_SCALE_RATIO
    val BUTTON_HEIGHT : Float = 100.0F * VERT_SCALE_RATIO
    private val BUTTON_Y_MARGIN : Float = 40.0F * VERT_SCALE_RATIO

    val QUIT_BUTTON_X : Float = DEVICE_WIDTH/2 - 140F * HORIZ_SCALE_RATIO
    val QUIT_BUTTON_Y : Float = 2 * BUTTON_Y_MARGIN

    val SETTINGS_BUTTON_X : Float = QUIT_BUTTON_X
    val SETTINGS_BUTTON_Y : Float = (QUIT_BUTTON_Y + BUTTON_HEIGHT + BUTTON_Y_MARGIN)

    val DONE_BUTTON_X : Float = QUIT_BUTTON_X
    val DONE_BUTTON_Y : Float = 50.0F * VERT_SCALE_RATIO

    val PLAY_BUTTON_X : Float = QUIT_BUTTON_X
    val PLAY_BUTTON_Y : Float = (SETTINGS_BUTTON_Y + BUTTON_HEIGHT + BUTTON_Y_MARGIN)


    val CONTINUE_BUTTON_X: Float = PLAY_BUTTON_X
    val CONTINUE_BUTTON_Y: Float = PLAY_BUTTON_Y

    val GO_QUIT_BUTTON_X : Float = DEVICE_WIDTH/2 - 400f * HORIZ_SCALE_RATIO
    val GO_QUIT_BUTTON_Y : Float = 4* BUTTON_Y_MARGIN

    val AGAIN_BUTTON_X : Float =  (DEVICE_WIDTH - BUTTON_WIDTH - GO_QUIT_BUTTON_X)
    val AGAIN_BUTTON_Y : Float = GO_QUIT_BUTTON_Y

    val RADIO_WIDTH = 40.0f * HORIZ_SCALE_RATIO
    val RADIO_HEIGHT = 40.0f * VERT_SCALE_RATIO

    const val MAIN_MENU_ID = 0
    const val GAME_RUNNING_ID = 1
    const val PAUSE_ID = 2
    const val GAME_OVER_ID = 3
    const val SETTINGS_ID = 5

    // File paths

    private const val TEXTURES = "textures/"
    private const val BACKGROUND = TEXTURES + "background/"
    const val BG_IMG_PATH = BACKGROUND + "background.png"
    const val PLAYER_SPACESHIP = TEXTURES + "player2.png"
    const val SHOTS_TEXTURE = TEXTURES + "laser2.png"
    const val ENEMY_TEXTURE = TEXTURES + "enemySpaceship.png"

    private const val HUD = "hud/"
    const val PLAY_BUT = HUD + "Play.png"
    const val SETTINGS_BUT = HUD + "Settings.png"
    const val DONE_BUT = HUD + "Done.png"
    const val QUIT_BUT = HUD + "Quit.png"
    const val BACK_BUT = HUD + "Back.png"
    const val CONTINUE_BUT = HUD + "Continue.png"
    const val AGAIN_BUT = HUD + "Again.png"
    const val RADIO_ON = HUD + "radioOn.png"
    const val RADIO_OFF = HUD + "radioOff.png"
    const val PAUSE = HUD + "Pause.png"
    const val CURSOR = HUD + "aim.png"
    const val NORMAL_CURSOR = HUD + "normalCursor.png"
    const val RIGHT_VB = HUD + "rightVB.png"
    const val LEFT_VB = HUD + "leftVB.png"
    const val SHOOT_VB = HUD + "shootButton.png"
    private const val MUSIC = "music/"
    const val MAIN_MENU_MUSIC = MUSIC + "imperialMarch.mp3"
    const val SETTINGS_MUSIC = MUSIC + "imperialMarch.mp3"
    const val GAME_MUSIC = MUSIC + "starWarsMainTheme.mp3"
    const val PAUSE_MUSIC = MUSIC + "starWarsMainTheme.mp3"
    const val GAME_OVER_MUSIC = MUSIC + "evilMortyTheme.mp3"

    private const val SOUNDS = "sounds/"
    const val SHOT_SOUND = SOUNDS + "shotSound.mp3"
    const val EXPLOSION_SOUND = SOUNDS + "explosionSound.mp3"

    private const val UI = "ui/"
    private const val FONTS = UI + "fonts/"
    const val FNT_FONT = FONTS + "ken_vector.fnt"
    val PNG_FONT = FONTS + "ken_vector.png"


    const val HIGHSCORE_FILE = "highscore.txt"


    // Texts

    const val SETTINGS_TEXT = "SETTINGS"

    val SETTINGS_TEXT_X = DEVICE_WIDTH/2 - 150.0F * HORIZ_SCALE_RATIO
    val SETTINGS_TEXT_Y = DEVICE_HEIGHT - 150f * VERT_SCALE_RATIO

    const val MOVEMENT_TEXT = "Movement: "
    val MOVEMENT_TEXT_X = SETTINGS_TEXT_X + 100.0f * HORIZ_SCALE_RATIO
    val MOVEMENT_TEXT_Y = SETTINGS_TEXT_Y - 100.0f * VERT_SCALE_RATIO
    const val ACC_MOV_TEXT = "Accelerometer"
    val ACC_MOV_TEXT_X = MOVEMENT_TEXT_X + 10.0f * HORIZ_SCALE_RATIO
    val ACC_MOV_TEXT_Y = MOVEMENT_TEXT_Y - 50.0f * VERT_SCALE_RATIO
    val ACC_RADIO_X = ACC_MOV_TEXT_X - 50.0f * HORIZ_SCALE_RATIO
    const val VBUT_MOV_TEXT = "Virtual button"
    val VBUT_MOV_TEXT_X = ACC_MOV_TEXT_X
    val VBUT_MOV_TEXT_Y = ACC_MOV_TEXT_Y - 30.0f * VERT_SCALE_RATIO
    val VBUT_MOV_RADIO_X = ACC_RADIO_X
    const val SHOOT_TEXT = "Shoot: "
    val SHOOT_TEXT_X = MOVEMENT_TEXT_X
    val SHOOT_TEXT_Y = VBUT_MOV_TEXT_Y - 60.0f * VERT_SCALE_RATIO
    const val TARGET_TEXT = "Touch on target"
    val TARGET_TEXT_X = ACC_MOV_TEXT_X
    val TARGET_TEXT_Y = SHOOT_TEXT_Y - 50.0f * VERT_SCALE_RATIO
    val TARGET_RADIO_X = ACC_RADIO_X
    const val SCREEN_TEXT = "Touch on screen"
    val SCREEN_TEXT_X = ACC_MOV_TEXT_X
    val SCREEN_TEXT_Y = TARGET_TEXT_Y - 30.0f * VERT_SCALE_RATIO
    val SCREEN_RADIO_X = ACC_RADIO_X
    const val VBUT_SHOOT_TEXT = "Virtual button"
    val VBUT_SHOOT_TEXT_X = ACC_MOV_TEXT_X
    val VBUT_SHOOT_TEXT_Y = SCREEN_TEXT_Y - 30.0f * VERT_SCALE_RATIO
    val VBUT_SHOOT_RADIO_X = ACC_RADIO_X



    const val SCORE_TEXT = "SCORE: "
    val SCORE_TEXT_X = DEVICE_WIDTH/2 - 375.0F * HORIZ_SCALE_RATIO
    val SCORE_TEXT_Y = DEVICE_HEIGHT - 30.0f * VERT_SCALE_RATIO

    //RADIOS IDS
    const val ACC_ID = 0
    const val VBUT_MOV_ID = 1
    const val TARGET_ID = 2
    const val SCREEN_ID = 3
    const val VBUT_SHOOT_ID = 4

    val CURRENT_SCORE_X = DEVICE_WIDTH/2 - 245.0F * HORIZ_SCALE_RATIO
    val CURRENT_SCORE_Y = SCORE_TEXT_Y

    const val HIGH_TEXT = "HIGH: "
    val HIGH_TEXT_X = DEVICE_WIDTH/2 + 150.0F * HORIZ_SCALE_RATIO
    val HIGH_TEXT_Y = SCORE_TEXT_Y
    val HIGHSCORE_X = DEVICE_WIDTH/2 + 250.0F * HORIZ_SCALE_RATIO
    val HIGHSCORE_Y = SCORE_TEXT_Y

    val PAUSE_X = DEVICE_WIDTH - 96f * HORIZ_SCALE_RATIO
    val PAUSE_Y = DEVICE_HEIGHT - 96f * VERT_SCALE_RATIO

    const val PAUSE_TEXT = "PAUSE"
    val PAUSE_TEXT_X = DEVICE_WIDTH/2 - 100.0F * HORIZ_SCALE_RATIO
    val PAUSE_TEXT_Y = DEVICE_HEIGHT - 100.0F * VERT_SCALE_RATIO
    val PAUSE_X_SCALE = 2.0F * HORIZ_SCALE_RATIO
    val PAUSE_Y_SCALE = 2.0F * VERT_SCALE_RATIO

    const val MAIN_MENU_TEXT_1 = "SPACE"
    const val MAIN_MENU_TEXT_2 = "INVADERS"
    val MAIN_MENU_TEXT_1_X = DEVICE_WIDTH/2 - 150.0f * HORIZ_SCALE_RATIO
    val MAIN_MENU_TEXT_1_Y = 650.0F * VERT_SCALE_RATIO
    val MAIN_MENU_TEXT_2_X = DEVICE_WIDTH/2 - 225.0f * HORIZ_SCALE_RATIO
    val MAIN_MENU_TEXT_2_Y = MAIN_MENU_TEXT_1_Y - 100.0F * VERT_SCALE_RATIO

    val MAIN_MENU_X_SCALE = 3.0F * HORIZ_SCALE_RATIO
    val MAIN_MENU_Y_SCALE = 3.0F * VERT_SCALE_RATIO

    val GAME_OVER_X_SCALE = 5.0F * HORIZ_SCALE_RATIO
    val GAME_OVER_Y_SCALE = 5.0F * VERT_SCALE_RATIO

    const val GAME_OVER_TEXT = "GAME OVER"
    val GAME_OVER_TEXT_X = DEVICE_WIDTH/2 - 450f * HORIZ_SCALE_RATIO
    val GAME_OVER_TEXT_Y = DEVICE_HEIGHT - 100F * VERT_SCALE_RATIO

    val GO_SCORE_TEXT_X = GAME_OVER_TEXT_X + 100f * HORIZ_SCALE_RATIO
    val GO_SCORE_TEXT_Y = GAME_OVER_TEXT_Y - 250.0F * VERT_SCALE_RATIO
    val GO_SCORE_X_SCALE = 1.5F * HORIZ_SCALE_RATIO
    val GO_SCORE_Y_SCALE = 1.5F * VERT_SCALE_RATIO
    val GO_CURRENT_SCORE_X = GO_SCORE_TEXT_X + 200.0F * HORIZ_SCALE_RATIO
    val GO_CURRENT_SCORE_Y = GO_SCORE_TEXT_Y
    val GO_HIGH_TEXT_X = GO_CURRENT_SCORE_X + 300.0F * HORIZ_SCALE_RATIO
    val GO_HIGH_TEXT_Y = GO_SCORE_TEXT_Y
    val GO_HIGH_SCORE_X = GO_HIGH_TEXT_X + 150.0F * HORIZ_SCALE_RATIO
    val GO_HIGH_SCORE_Y = GO_SCORE_TEXT_Y

    val MOVE_VB_WIDTH = 125f * HORIZ_SCALE_RATIO
    val MOVE_VB_HEIGHT = 125f * HORIZ_SCALE_RATIO

    val CREDITS = "Por Felipe Zorzo Pereira e William Wilbert Vargas - 2018"
    val CREDITS_X = DEVICE_WIDTH/2 - 275f * HORIZ_SCALE_RATIO
    val CREDITS_Y = 15.0f * VERT_SCALE_RATIO
    val RECOVER_TIME: Int = 20

    val LANE_SIZE = 40f * VERT_SCALE_RATIO
    val LEFT: Int = 0
    val RIGHT: Int = 1
    val RIGHT_VB_X = DEVICE_WIDTH - MOVE_VB_WIDTH
    val RIGHT_VB_Y = 0f
    val LEFT_VB_X = 0f
    val LEFT_VB_Y = 0f
    val SHOOT_VB_WIDTH = 150f * HORIZ_SCALE_RATIO
    val SHOOT_VB_HEIGHT = 75f * VERT_SCALE_RATIO
    val LEFT_SHOOT_VB_X = LEFT_VB_X
    val LEFT_SHOOT_VB_Y = LEFT_VB_Y + MOVE_VB_HEIGHT + 30f * VERT_SCALE_RATIO
    val RIGHT_SHOOT_VB_X = DEVICE_WIDTH - SHOOT_VB_WIDTH
    val RIGHT_SHOOT_VB_Y = LEFT_SHOOT_VB_Y


}
