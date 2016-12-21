package no.vestein.purplerain

import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.{Application, Game, Gdx}
import no.vestein.purplerain.assets.Assets
import no.vestein.purplerain.screens.MenuScreen

object PurpleRain extends Game {

  override def create(): Unit = {
    Gdx.app.setLogLevel(Application.LOG_DEBUG)

    Assets.init(new AssetManager())

    setScreen(new MenuScreen(this))
  }

}
