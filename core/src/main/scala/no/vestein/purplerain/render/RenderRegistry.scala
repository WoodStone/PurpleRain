package no.vestein.purplerain.render

import com.badlogic.gdx.graphics.Camera
import com.badlogic.gdx.graphics.g2d.Batch
import no.vestein.purplerain.entities.Entity

import scala.collection.immutable.HashMap

class RenderRegistry {

  var renderRegistry: HashMap[Class[_ <: Entity[_]], EntityRenderer[Entity[_]]] = HashMap.empty

  def ++(entity: Entity[_]): Unit = {
    renderRegistry += entity.getClass -> entity
  }

  def renderEntity(entity: Entity[_], camera: Camera, batch: Batch): Unit = {
    if (renderRegistry.contains(entity.getClass)) {
      val renderer: EntityRenderer[_] = renderRegistry(entity.getClass)
      renderer.renderEntity(entity, camera, batch)
    }
  }

}
