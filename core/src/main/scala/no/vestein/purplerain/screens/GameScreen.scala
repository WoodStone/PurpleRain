package no.vestein.purplerain.screens

import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.{Game, Gdx}
import no.vestein.purplerain.World
import no.vestein.purplerain.render.Renderer

class GameScreen(game: Game) extends AbstractScreen(game) {

  private val world: World = new World
  private val renderer: Renderer = new Renderer(world)
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

  override def show(): Unit = {
    Gdx.app.debug(getClass.getSimpleName, "Initializing...")
    world.init()
    renderer.init()
    Gdx.app.debug(getClass.getSimpleName, "Done.")
  }

  override def hide(): Unit = ???

  override def pause(): Unit = {
    paused = true
  }

  override def resume(): Unit = {
    paused = false
  }

  override def dispose(): Unit = ???

}
