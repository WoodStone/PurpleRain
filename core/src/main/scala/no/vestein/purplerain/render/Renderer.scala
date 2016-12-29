package no.vestein.purplerain.render

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.{GL20, OrthographicCamera}
import com.badlogic.gdx.graphics.g2d.{Batch, SpriteBatch}
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.utils.Disposable
import no.vestein.purplerain.{Reference, World}

class Renderer(world: World) extends Disposable {

  private val shapeRenderer: ShapeRenderer = new ShapeRenderer()
  private val camera: OrthographicCamera = new OrthographicCamera(Reference.ViewportWidth, Reference.ViewportHeight)
  private val renderRegistry: RenderRegistry = new RenderRegistry
  private val batch: Batch = new SpriteBatch()

  def init(): Unit = {
    renderRegistry ++ new RainDropRender()
  }

  override def dispose(): Unit = ???

  def render(): Unit = {
    world.cameraHelper.applyTo(camera)

    for (entity <- world.getObjects) {
      renderRegistry.renderEntity(entity, camera, batch)
    }

//    renderDebugLines()
  }

  private def renderDebugLines(): Unit = {
    shapeRenderer.setProjectionMatrix(camera.combined)
    Gdx.gl.glEnable(GL20.GL_BLEND)
    Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA)

    shapeRenderer.begin(ShapeRenderer.ShapeType.Line)
    shapeRenderer.setColor(0.0f, 0.0f, 0.0f, 1.0f)
    shapeRenderer.line(-15.0f, 0.0f, 15.0f, 0.0f)
    shapeRenderer.line(0.0f, -15.0f, 0.0f, 15.0f)

    shapeRenderer.end()
    Gdx.gl.glDisable(GL20.GL_BLEND)
  }

  def resize(width: Int, height: Int): Unit = {
    //TODO implement resize method
  }

}
