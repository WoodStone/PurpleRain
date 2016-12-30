package no.vestein.purplerain.screens

import com.badlogic.gdx.utils.Disposable
import com.badlogic.gdx.{Game, Screen}

abstract class AbstractScreen(protected var game: Game) extends Screen with Disposable {

  def render(deltaTime: Float)
  def resize(width: Int, height: Int)
  def show()
  def hide()
  def pause()
  def resume()
  def dispose()

}
