package no.vestein.purplerain.screens

import com.badlogic.gdx.{Game, Screen}

/**
  * Created by Vestein Dahl
  * Date: 19.12.2016
  * Time: 15.47
  */
abstract class AbstractScreen(protected var game: Game) extends Screen {

  def render(deltaTime: Float)
  def resize(width: Int, height: Int)
  def show()
  def hide()
  def pause()

  def resume(): Unit = {

  }

  def dispose(): Unit = {

  }

}
