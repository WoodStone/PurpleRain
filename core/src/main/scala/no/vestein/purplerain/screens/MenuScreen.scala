package no.vestein.purplerain.screens

import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.{Color, GL20, Pixmap, Texture}
import com.badlogic.gdx.scenes.scene2d.ui._
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent
import com.badlogic.gdx.scenes.scene2d.{Actor, Stage}
import com.badlogic.gdx.utils.viewport.StretchViewport
import com.badlogic.gdx.{Game, Gdx}
import no.vestein.purplerain.Reference
import no.vestein.purplerain.assets.Assets

class MenuScreen(game: Game) extends AbstractScreen(game) {
  private var stage: Stage = _
  private var imgLogo: Image = _
  private var btnPlay: TextButton = _

  private def rebuildStage() {
    val layerLogos: Table = buildLogosLayer()
    val layerButtons: Table = buildButtonsLayer()
    val stack: Stack = new Stack()

    stage.clear()
    stage.addActor(stack)
    stack.setSize(Reference.VIEWPORT_WIDTH_UI, Reference.VIEWPORT_HEIGHT_UI)
    stack.add(layerLogos)
    stack.add(layerButtons)
  }

  private def buildLogosLayer(): Table = {
    val layer: Table = new Table()
    //TODO make logo layer
    layer
  }

  private def buildButtonsLayer(): Table = {
    val layer: Table = new Table()
    layer.right().top()

    btnPlay = new TextButton("Start", createBasicSkin())
    btnPlay.setPosition(Gdx.graphics.getWidth / 2 - Gdx.graphics.getWidth / 8, Gdx.graphics.getHeight / 2)
    btnPlay.addListener(new ChangeListener {
      override def changed(event: ChangeEvent, actor: Actor): Unit = {
        game.setScreen(new GameScreen(game))
      }
    })
    layer.addActor(btnPlay)

    layer.debug()
    layer
  }

  private def createBasicSkin(): Skin = {
    val font: BitmapFont = Assets.fonts.sourceCodeRegularScaling
    val skin: Skin = new Skin()
    skin.add("default", font)

    val pixmap: Pixmap = new Pixmap(Gdx.graphics.getWidth / 4, Gdx.graphics.getHeight / 10, Pixmap.Format.RGB888)
    pixmap.setColor(Color.WHITE)
    pixmap.fill()
    skin.add("background", new Texture(pixmap))

    val textButtonStyle: TextButton.TextButtonStyle = new TextButton.TextButtonStyle()
    textButtonStyle.up = skin.newDrawable("background", new Color(0xe0e0e050))
    textButtonStyle.down = skin.newDrawable("background", Color.WHITE)
    textButtonStyle.checked = skin.newDrawable("background", Color.WHITE)
    textButtonStyle.over = skin.newDrawable("background", new Color(0xd0d0d050))
    textButtonStyle.font = skin.getFont("default")
    textButtonStyle.fontColor = Color.PINK
    skin.add("default", textButtonStyle)

    skin
  }

  override def render(deltaTime: Float): Unit = {
    Gdx.gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f)
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

    stage.act(deltaTime)
    stage.draw()
  }

  override def resize(width: Int, height: Int): Unit = {
    stage.getViewport.update(width, height, true)
  }

  override def show(): Unit = {
    stage = new Stage(new StretchViewport(Reference.VIEWPORT_WIDTH_UI, Reference.VIEWPORT_HEIGHT_UI))
    Gdx.input.setInputProcessor(stage)
    rebuildStage()
  }

  override def hide(): Unit = {
    stage.dispose()
  }

  override def pause(): Unit = {

  }
}
