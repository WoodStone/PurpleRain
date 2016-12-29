package no.vestein.purplerain

import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.math.{MathUtils, Vector2}


class CameraHelper {
  private val MaxZoomIn: Float = 0.25f
  private val MaxZoomOut: Float = 10.0f
  private val position: Vector2 = new Vector2()
  private var zoom: Float = 1.0f
  private var target: Sprite = _

  def update(deltaTime: Float) {
    if (!hasTarget) return
    position.x = target.getX + target.getOriginX
    position.y = target.getY + target.getOriginY
  }

  def setPosition(x: Float, y: Float) {
    this.position.set(x, y)
  }

  def getPosition: Vector2 = position

  def addZoom(amount: Float) {
    setZoom(zoom + amount)
  }

  def setZoom(zoom: Float) {
    this.zoom = MathUtils.clamp(zoom, MaxZoomIn, MaxZoomOut)
  }

  def getZoom: Float = zoom

  def setTarget(target: Sprite) {
    this.target = target
  }

  def getTarget: Sprite = target

  def hasTarget: Boolean = target != null

  def hasTarget(target: Sprite): Boolean = hasTarget && this.target == target

  def applyTo(camera: OrthographicCamera) {
    camera.position.x = position.x
    camera.position.y = position.y
    camera.zoom = zoom
    camera.update()
  }
}
