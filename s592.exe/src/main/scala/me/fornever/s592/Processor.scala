package me.fornever.s592

import java.awt.image.BufferedImage
import java.io.File
import java.nio.file.Paths
import javax.imageio.ImageIO

import com.google.common.io.Files
import com.typesafe.config.{Config, ConfigFactory}

object Processor {

    def process(path: String): Unit = {
        print(s"$path -> ")

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
        canvas
    }

    private def getOutputFile(path: String): File = {
        val directory = Paths.get(path).getParent
        val outputFileName = Files.getNameWithoutExtension(path) + ".png"
        val outputPath = Paths.get(directory.toString, outputFileName)
        outputPath.toFile
    }
}
