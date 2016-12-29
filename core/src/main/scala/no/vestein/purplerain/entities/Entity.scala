package no.vestein.purplerain.entities

import com.badlogic.gdx.math.Vector2

trait Entity[T] {

  def setPosition(x: Float, y: Float): T
  def setPosition(pos: Vector2): T

}
