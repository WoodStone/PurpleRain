package no.vestein.purplerain.assets

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator
import no.vestein.purplerain.Reference

class AssetFonts {

  private val TAG: String = getClass.getName
  val sourceCodeRegularScaling: BitmapFont = scalingFont

  private def scalingFont: BitmapFont = {
    val scale: Float = 1.0f * Gdx.graphics.getWidth / Reference.ViewportWidthUI
    val generator: FreeTypeFontGenerator= new FreeTypeFontGenerator(Gdx.files.internal("SourceCodePro-Regular.ttf"))

    val parameter: FreeTypeFontGenerator.FreeTypeFontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter
    parameter.size = (24 * scale).asInstanceOf[Int]
    val font: BitmapFont = generator.generateFont(parameter)
    font.getData.setScale(1.0f / scale)
    font.getRegion.getTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear)
    font
  }

}
