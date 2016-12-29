package no.vestein.purplerain.graphics

import com.badlogic.gdx.graphics.Pixmap

class PixmapPR(width: Int, height: Int, format: Pixmap.Format)
  extends Pixmap(width, height, format) {

  def drawLine(x: Int, y: Int, x2: Int, y2: Int, size: Int) {
    for (i <- 1 to size) {
      drawLine(x - i, y - i, x2 - i, y2 - i)
      drawLine(x + i, y + i, x2 + i, y2 + i)
    }
    drawLine(x, y, x2, y2)
  }

  def drawRectangle(x: Int, y: Int, width: Int, height: Int, size: Int) {
    for (i <- 1 to size) {
      drawRectangle(x + i, y + i, width - i * 2, height - i * 2)
      drawRectangle(x - i, y - i, width + i * 2, height + i * 2)
    }
    drawRectangle(x, y, width, height)
  }

}