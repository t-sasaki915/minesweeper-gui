ThisBuild / version := "1.0.0"
ThisBuild / developers := List(
  Developer("t-sasaki915", "Sasaki Touma", "netst915@gmail.com", url("https://st915.net"))
)

ThisBuild / scalaVersion := "3.2.1"

ThisBuild / semanticdbEnabled := true
ThisBuild / scalafixDependencies += "com.github.liancheng" %% "organize-imports" % "0.6.0"

lazy val root = (project in file("."))
  .settings(
    name := "minesweeper-swing",
    libraryDependencies ++= Seq(
      "org.typelevel" %% "cats-effect" % "3.5.0"
    )
  )
