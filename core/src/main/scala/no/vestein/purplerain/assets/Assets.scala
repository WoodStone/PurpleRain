package no.vestein.purplerain.assets

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.assets.{AssetDescriptor, AssetErrorListener, AssetManager}
import com.badlogic.gdx.utils.Disposable

object Assets extends Disposable with AssetErrorListener {

  private var assetManager: AssetManager = _
  val TAG: String = getClass.getName
  var fonts: AssetFonts = _

  def init(assetManager: AssetManager) {
    this.assetManager = assetManager
    assetManager.setErrorListener(this)

    //TODO texture atlas
//    assetManager.load(Reference.TEXTURE_ATLAS_OBJECT, classOf[TextureAtlas])

    assetManager.finishLoading()
    Gdx.app.debug(TAG, "# of assets loaded: " + assetManager.getAssetNames.size)
    assetManager.getAssetNames.forEach(asset => {
      Gdx.app.debug(TAG, "asset: " + asset)
    })

    fonts = new AssetFonts
  }

  override def dispose(): Unit = {
    assetManager.dispose()
    fonts.sourceCodeRegularScaling.dispose()
  }

  override def error(asset: AssetDescriptor[_], throwable: Throwable): Unit = {
    Gdx.app.error(TAG, "Could not load asset '" + asset.fileName + "'", throwable)
  }
}
