
libraryDependencies += "org.scala-sbt" %% "scripted-plugin" % sbtVersion.value
resolvers ++= Seq(
  Classpaths.typesafeReleases,
  Classpaths.sbtPluginReleases,
  "jgit-repo" at "http://download.eclipse.org/jgit/maven",
  Resolver.url("scoverage-bintray", url("https://dl.bintray.com/sksamuel/sbt-plugins/"))(Resolver.ivyStylePatterns),
  Resolver.sonatypeRepo("snapshots")
)

addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.5.1")
addSbtPlugin("com.github.gseitz" % "sbt-release" % "1.0.8")
addSbtPlugin("com.47deg"  % "sbt-microsites" % "0.7.15")
addSbtPlugin("com.jsuereth" % "sbt-pgp" % "1.1.1")
addSbtPlugin("org.xerial.sbt" % "sbt-sonatype" % "2.3")
addSbtPlugin("com.jsuereth" % "sbt-pgp" % "1.1.1")
