name := "592.exe"

version := "0.0.0"

scalaVersion := "2.11.8"

mainClass in (Compile, run) := Some("me.fornever.s592.Application")

resourceGenerators in Compile <+= Def.task {
    IO.withTemporaryFile("s592", ".zip") { zip =>
        IO.download(new URL("https://www.fontsquirrel.com/fonts/download/roboto"), zip)
        val output = (resourceManaged in Compile).value / "fonts" / "roboto"
        IO.unzip(zip, output).toSeq
    }
}
