package no.vestein.purplerain.entities

import com.badlogic.gdx.math.Vector2

case class RainDrop(position: Vector2, force: Vector2, size: Float) extends Entity[RainDrop] {

  def applyFunction(f: RainDrop => RainDrop): RainDrop = {
    f(this)
  }

  def applyForce(): RainDrop = {
    RainDrop(position.x + force.x, position.y + force.y * size * 2, force.x, force.y, size)
  }

  def setForce(force: Vector2): RainDrop = RainDrop(position, force, size)

  def setForce(fx: Float, fy: Float): RainDrop = setForce(new Vector2(fx, fy))

  def setPosition(pos: Vector2): RainDrop = RainDrop(pos, force, size)

  def setPosition(x: Float, y: Float): RainDrop = setPosition(new Vector2(x, y))

}

object RainDrop {
  def apply(x: Float, y: Float, fx: Float, fy: Float, size: Float): RainDrop =
    RainDrop(new Vector2(x, y), new Vector2(fx, fy), size)

}
