package me.fornever.s592

import java.io.InputStream

object Application extends App {
  private val font: InputStream = getClass.getResourceAsStream("/fonts/roboto/Roboto-Black.ttf")
  println(font)
}
