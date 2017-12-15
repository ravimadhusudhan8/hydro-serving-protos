lazy val currentAppVersion = util.Properties.propOrElse("appVersion", "0.0.1")

organization := "io.hydrosphere"
name := "serving-grpc-scala"
version := currentAppVersion

scalaVersion := "2.11.11"

publishMavenStyle := true

libraryDependencies ++= Seq(
  "com.trueaccord.scalapb" %% "scalapb-runtime" % com.trueaccord.scalapb.compiler.Version.scalapbVersion % "protobuf",
  "io.grpc" % "grpc-netty" % com.trueaccord.scalapb.compiler.Version.grpcJavaVersion,
  "com.trueaccord.scalapb" %% "scalapb-runtime-grpc" % com.trueaccord.scalapb.compiler.Version.scalapbVersion
)

PB.targets in Compile := Seq(
  scalapb.gen() -> (sourceManaged in Compile).value
)

publishArtifact in Test := false
pomIncludeRepository := { _ => false }
publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots/")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2/")
}
pomExtra := <url>https://github.com/Hydrospheredata/hydro-serving-protos</url>
  <licenses>
    <license>
      <name>Apache 2.0 License</name>
      <url>https://github.com/Hydrospheredata/hydro-serving-protos/blob/master/LICENSE</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>https://github.com/Hydrospheredata/hydro-serving-protos.git</url>
    <connection>https://github.com/Hydrospheredata/hydro-serving-protos.git</connection>
  </scm>
  <developers>
    <developer>
      <id>KineticCookie</id>
      <name>Bulat Luftin</name>
      <url>https://github.com/KineticCookie</url>
      <organization>Hydrosphere</organization>
      <organizationUrl>http://hydrosphere.io/</organizationUrl>
    </developer>
  </developers>

