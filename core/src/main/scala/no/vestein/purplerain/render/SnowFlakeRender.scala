package no.vestein.purplerain.render

import com.badlogic.gdx.graphics.Camera
import com.badlogic.gdx.graphics.g2d.Batch
import no.vestein.purplerain.entities.{Entity, RainDrop}
import no.vestein.purplerain.graphics.SnowFlakeSprite

class SnowFlakeRender extends EntityRenderer[RainDrop](classOf[RainDrop]) {

  override def renderEntity(e: Entity[_], camera: Camera, batch: Batch): Unit = {
    val entity = e.asInstanceOf[RainDrop]
    val sprite = new SnowFlakeSprite(entity.size)
    sprite.setPosition(entity.position.x, entity.position.y)

    batch.setProjectionMatrix(camera.combined)
    batch.begin()
    sprite.draw(batch)
    batch.end()
  }

}
