package no.vestein.purplerain

import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.{Application, Game, Gdx}
import no.vestein.purplerain.assets.Assets
import no.vestein.purplerain.screens.MenuScreen

/**
  * Created by Vestein Dahl
  * Date: 19.12.2016
  * Time: 15.45
  */
object PurpleRain extends Game {

  override def create(): Unit = {
    Gdx.app.setLogLevel(Application.LOG_DEBUG)

    Assets.init(new AssetManager())

    setScreen(new MenuScreen(this))
  }

}
