package no.vestein.purplerain.render

import com.badlogic.gdx.graphics.Camera
import com.badlogic.gdx.graphics.g2d.Batch
import no.vestein.purplerain.entities.Entity

abstract class EntityRenderer[T <: Entity[T]](entityClass: Class[_ <: Entity[T]]) {

  def renderEntity(e: Entity[_], camera: Camera, batch: Batch)

  def getEntityClass: Class[_ <: Entity[T]] = {
    entityClass
  }

}
