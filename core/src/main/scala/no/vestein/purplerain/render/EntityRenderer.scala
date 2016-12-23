package no.vestein.purplerain.render

import com.badlogic.gdx.graphics.Camera
import com.badlogic.gdx.graphics.g2d.Batch
import no.vestein.purplerain.entities.Entity

abstract class EntityRenderer[T <: Entity](val EntityClass: Class[T]) {

  def renderEntity(e: Entity, camera: Camera, batch: Batch)

}
