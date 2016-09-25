package me.fornever.s592

object Application extends App {

    args match {
        case Array(filePath) => Processor.process(filePath)
        case _ => println("Usage: <file> to process the file")
    }
}
