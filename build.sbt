import sbt.Keys._

lazy val root = project.in(file("."))
  .settings(
    libraryDependencies ++= Seq(
      "org.typelevel" %% "cats-core" % "0.9.0",
      "org.scalameta" %% "scalameta" % "2.1.2"),
    name := "sbt-source-docs",
    organization := "com.threatstack",
    scalaVersion := "2.12.4",
    sbtPlugin := true,
    homepage := Some(url("https://github.com/threatstack/sbt-source-docs")),
    scmInfo := Some(ScmInfo(url("https://github.com/threatstack/sbt-source-docs"), "scm:git:git@github.com:threatstack/sbt-source-docs.git")),
    developers := List(Developer("rpless",
      "Ryan Plessner",
      "ryan.plessner@threatstack.com",
      url("https://twitter.com/ryan_plessner"))),
    licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0")),
    publishMavenStyle := true,
    publishArtifact := true,
    publishTo := {
      val nexus = "https://oss.sonatype.org/"
      if (isSnapshot.value)
        Some("snapshots" at nexus + "content/repositories/snapshots")
      else
        Some("releases"  at nexus + "service/local/staging/deploy/maven2")
    },
    publishArtifact in Test := false,
    scriptedLaunchOpts := scriptedLaunchOpts.value ++ Seq("-Dplugin.version=" + version.value))

credentials += Credentials("Sonatype Nexus Repository Manager",
  "oss.sonatype.org",
  sys.env("SONATYPE_USER"),
  sys.env("SONATYPE_PASSWORD")
)

lazy val docs = project.in(file("docs"))
  .enablePlugins(MicrositesPlugin)
  .settings(
    micrositeName := "sbt-source-docs",
    micrositeDescription := "A plugin to pull source code into docs.",
    micrositeAuthor := "Threat Stack, Inc",
    micrositeHighlightTheme := "atom-one-light",
    micrositeHomepage := "https://sbt-source-docs.github.io/threatstack/sbt-source-docs/",
    micrositeGithubOwner := "threatstack",
    micrositeGithubRepo := "sbt-source-docs",
    micrositeBaseUrl := "sbt-source-docs",
    ghpagesNoJekyll := false,
    micrositeGitterChannel :=  false,
    scalacOptions ~= { _.filterNot(Set("-Yno-predef", "-Xlint")) },
    git.remoteRepo := "git@github.com:threatstack/sbt-source-docs.git",
    includeFilter in makeSite := "*.html" | "*.css" | "*.png" | "*.jpg" | "*.gif" | "*.svg" | "*.js" | "*.swf" | "*.yml" | "*.md")
