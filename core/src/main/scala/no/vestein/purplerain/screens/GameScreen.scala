package no.vestein.purplerain.screens

import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.{Game, Gdx}
import no.vestein.purplerain.{Renderer, World}

class GameScreen(game: Game) extends AbstractScreen(game) {

  private val world: World = new World
  private val renderer: Renderer = new Renderer
  private var paused: Boolean = false

  override def render(deltaTime: Float): Unit = {
    if (!paused) {
      world.update(deltaTime)
    }

    Gdx.gl.glClearColor(0xff/255.0f, 0xff/255.0f, 0xff/255.0f, 0xff/255.0f)
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

    renderer.render()
  }

  override def resize(width: Int, height: Int): Unit = {
    renderer.resize(width, height)
  }

  override def show(): Unit = ???

  override def hide(): Unit = ???

  override def pause(): Unit = ???

}
