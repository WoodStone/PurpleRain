package no.vestein.purplerain

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.utils.Disposable
import no.vestein.purplerain.entities.{Entity, RainDrop}

import scala.annotation.tailrec

class World extends Disposable {

  val cameraHelper: CameraHelper = new CameraHelper()
  cameraHelper.setPosition(0.0f, 0.0f)
  cameraHelper.setZoom(1.0f)

  var drops: List[RainDrop] = _

  def init(): Unit = {
    Gdx.app.debug(getClass.getSimpleName, "Creating drops...")
    drops = createDrops(Nil, 1.0f, 40)
    drops = createDrops(drops, 0.75f, 80)
    drops = createDrops(drops, 0.50f, 160)
    drops = createDrops(drops, 0.25f, 320)

    @tailrec def createDrops(list: List[RainDrop], size: Float, n: Int): List[RainDrop] = {
      if (n == 0) return list

      val x: Float = Math.random().toFloat * 32.0f - 16.0f
      val y: Float = Math.random().toFloat * 32.0f - 16.0f
      val fx: Float = 0.0f
      val fy: Float = -(0.1f + (Math.random().toFloat * 0.1f))

      createDrops(RainDrop(x, y, fx, fy, size) :: list, size, n - 1)
    }

  }

  def getObjects: List[Entity[_]] = {
    drops
  }

  override def dispose(): Unit = ???

  def update(deltaTime: Float): Unit = {
    cameraHelper.update(deltaTime)

    drops = drops.map(drop => {
      val mod = Reference.ViewportWidth + Reference.ViewportWidth/4
      if (drop.position.y < -mod/2) {
        val x: Float = Math.random().toFloat * 32.0f - 16.0f
        drop.setPosition(x, drop.position.y + mod).applyForce()
      } else {
        drop.applyForce()
      }
    })
  }

}
