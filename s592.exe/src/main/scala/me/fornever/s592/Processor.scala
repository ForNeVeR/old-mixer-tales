package me.fornever.s592

import java.awt._
import java.awt.image.BufferedImage
import java.io.File
import java.nio.file.Paths
import javax.imageio.ImageIO

import com.google.common.io.Files
import com.typesafe.config.{Config, ConfigFactory}

import scala.collection.JavaConversions._

object Processor {

    val graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment
    val font = {
        val fontStream = getClass.getResourceAsStream("/fonts/roboto/Roboto-Regular.ttf")
        Font.createFont(Font.TRUETYPE_FONT, fontStream)
    }

    graphicsEnvironment.registerFont(font)

    def process(path: String): Unit = {
        scala.Predef.print(s"$path -> ")

        val config = ConfigFactory.parseFile(new File(path))
        val image = generateImage(config)
        val outputFile = getOutputFile(path)
        if (!ImageIO.write(image, "png", outputFile)) {
            throw new Exception("Cannot find PNG writer")
        }

        println(outputFile.getAbsolutePath + ": ok")
    }

    private def generateImage(config: Config): BufferedImage = {
        val width = config.getInt("width")
        val height = config.getInt("height")
        val canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB)
        val graphics = canvas.getGraphics.asInstanceOf[Graphics2D]
        graphics.setRenderingHint(
            RenderingHints.KEY_TEXT_ANTIALIASING,
            RenderingHints.VALUE_TEXT_ANTIALIAS_ON)

        config.getConfigList("texts").foreach(text => drawText(text, graphics))

        canvas
    }

    private def drawText(text: Config, graphics: Graphics): Unit = {
        val Seq(x, y) = text.getIntList("coords").toSeq
        val string = text.getString("text")

        graphics.setFont(font.deriveFont(14f))
        graphics.setColor(Color.BLACK)

        if (text.hasPath("width")) {
            // Center if width is defined:
            val width = text.getInt("width")
            val textWidth = graphics.getFontMetrics.stringWidth(string)
            graphics.drawString(string, x + (width - textWidth) / 2, y)
        } else {
            graphics.drawString(string, x, y)
        }
    }

    private def getOutputFile(path: String): File = {
        val directory = Paths.get(path).getParent
        val outputFileName = Files.getNameWithoutExtension(path) + ".png"
        val outputPath = Paths.get(directory.toString, outputFileName)
        outputPath.toFile
    }
}
