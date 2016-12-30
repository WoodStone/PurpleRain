package no.vestein.purplerain.graphics

import com.badlogic.gdx.graphics.{Pixmap, Texture}
import com.badlogic.gdx.graphics.g2d.Sprite

class RainDropSprite(size: Float) extends Sprite(RainDropSprite.texture) {
  val dWidth = 0.125f
  val dHeight = 2.5f
  setSize(dWidth * size, dHeight * size)
  //TODO set origin if it is necessary
}

private object RainDropSprite {
  val width: Int = 1
  val height: Int = 10
  val texture: Texture = new Texture(pixmap, true)

  private def pixmap: PixmapPR = {
    val pixmap: PixmapPR = new PixmapPR(width, height, com.badlogic.gdx.graphics.Pixmap.Format.RGBA8888)
    Pixmap.setBlending(Pixmap.Blending.None)
    pixmap.setColor(0x8A/255.0f, 0x2B/255.0f, 0xE2/255.0f, 0xff/255.0f)
    pixmap.fillRectangle(0, 0, width, height)
    pixmap
  }

}
