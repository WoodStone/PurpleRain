package no.vestein.purplerain.render

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Camera
import com.badlogic.gdx.graphics.g2d.Batch
import no.vestein.purplerain.entities.Entity

import scala.collection.immutable.HashMap

class RenderRegistry {

  type EntityRendererImpl = EntityRenderer[T] forSome {type T <: Entity[T]}
  var renderRegistry: HashMap[Class[_ <: Entity[_]], EntityRendererImpl] = HashMap.empty

  def ++(renderer: EntityRendererImpl): Unit = {
    renderRegistry += renderer.getEntityClass -> renderer
    Gdx.app.debug(getClass.getSimpleName, "Registered: " + renderer.getEntityClass.toString)
  }

  def renderEntity(entity: Entity[_], camera: Camera, batch: Batch): Unit = {
    if (renderRegistry.contains(entity.getClass)) {
      renderRegistry(entity.getClass).renderEntity(entity, camera, batch)
    }
  }

}
