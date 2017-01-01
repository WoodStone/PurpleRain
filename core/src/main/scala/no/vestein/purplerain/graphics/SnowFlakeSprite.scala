package no.vestein.purplerain.graphics

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import no.vestein.purplerain.Reference

class SnowFlakeSprite(size: Float) extends Sprite(SnowFlakeSprite.texture) {
  val dWidth = 1.25f
  val dHeight = 1.50f
  setSize(dWidth * size, dHeight * size)
}

object SnowFlakeSprite {
  val texture: Texture = new Texture(Gdx.files.internal(Reference.snowFlake))
}