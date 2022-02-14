ThisBuild / version := "0.1"
ThisBuild / scalaVersion := "2.13.7"

lazy val root = (project in file("."))
  .settings(
    name := "assessment-tests"
  )
  .aggregate(task1, task2)

lazy val task1 = (project in file("modules/CompressSequence"))
  .settings(
    assembly / assemblyJarName := "compress.jar",
    name := "assessment-tests-compress-sequence",
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.2.11" % "test",
      "org.scalatestplus" %% "scalacheck-1-15" % "3.2.9.0" % "test"
    )
  )

lazy val task2 = (project in file("modules/HighloadLog"))
  .settings(
    name := "assessment-tests-highload-log"
  )