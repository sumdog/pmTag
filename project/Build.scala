import sbt._

object PMTagBuild extends Build {

  lazy val root = Project("root", file(".")) dependsOn(scalaSwtBuilder)
  lazy val scalaSwtBuilder = RootProject(uri("https://github.com/marad/scala-swt-builder"))

}