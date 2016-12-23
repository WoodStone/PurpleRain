package no.vestein.purplerain.render

import com.badlogic.gdx.graphics.Camera
import com.badlogic.gdx.graphics.g2d.Batch
import no.vestein.purplerain.entities.Entity

import scala.collection.immutable.HashMap

class RenderRegistry {

  var renderRegistry: HashMap[Class[_ <: Entity], EntityRenderer[Entity]] = HashMap.empty

  def ++(entity: Entity): Unit = {
    renderRegistry += entity.getClass -> entity
  }

  def renderEntity(entity: Entity, camera: Camera, batch: Batch): Unit = {
    if (renderRegistry.contains(entity.getClass)) {
      val renderer: EntityRenderer[Entity] = renderRegistry(entity.getClass)
      renderer.renderEntity(entity, camera, batch)
    }
  }

}
