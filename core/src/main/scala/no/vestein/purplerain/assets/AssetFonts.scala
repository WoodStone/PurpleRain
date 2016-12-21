package no.vestein.purplerain.assets

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator
import no.vestein.purplerain.Reference

class AssetFonts {

  private val TAG: String = getClass.getName
  val sourceCodeRegularScaling: BitmapFont = loadScalingFont()

  private def loadScalingFont(): BitmapFont = {
    val SCALE: Float = 1.0f * Gdx.graphics.getWidth / Reference.VIEWPORT_WIDTH_UI
    val generator: FreeTypeFontGenerator= new FreeTypeFontGenerator(Gdx.files.internal("SourceCodePro-Regular.ttf"))

    val parameter: FreeTypeFontGenerator.FreeTypeFontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter
    parameter.size = (24 * SCALE).asInstanceOf[Int]
    val font: BitmapFont = generator.generateFont(parameter)
    font.getData.setScale(1.0f / SCALE)
    font.getRegion.getTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear)
    font
  }

}
