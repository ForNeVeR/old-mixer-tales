name := "592.exe"

version := "0.0.0"

libraryDependencies ++= Seq(
    "com.typesafe" % "config" % "1.3.1",
    "com.google.guava" % "guava" % "19.0"
)

scalaVersion := "2.11.8"

mainClass in (Compile, run) := Some("me.fornever.s592.Application")

resourceGenerators in Compile <+= Def.task {
    val output = (resourceManaged in Compile).value / "fonts" / "roboto"
    if (!output.exists() || output.list().length == 0) {
        println("Downloading Roboto font...")
        IO.withTemporaryFile("s592", ".zip") { zip =>
            IO.download(new URL("https://www.fontsquirrel.com/fonts/download/roboto"), zip)
            IO.unzip(zip, output).toSeq
        }
    } else {
        println("Roboto font seems to be loaded")
        Seq()
    }
}
