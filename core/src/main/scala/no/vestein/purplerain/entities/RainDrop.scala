package no.vestein.purplerain.entities

import com.badlogic.gdx.math.Vector2

case class RainDrop(x: Float, y: Float, fx: Float, fy: Float, size: Float) extends Entity[RainDrop] {

  def applyForce(): RainDrop = {
    //TODO
    RainDrop(x + fx, y + fy, fx, fy, size)
  }

  override def setPosition(x: Float, y: Float): RainDrop = {
    RainDrop(x, y, this.fx, this.fy, this.size)
  }

  override def setPosition(pos: Vector2): RainDrop = {
    this.setPosition(pos.x, pos.y)
  }

}

object RainDrop {
  def apply(pos: Vector2, force: Vector2, size: Float): RainDrop = RainDrop(pos.x, pos.y, force.x, force.y, size)
}
