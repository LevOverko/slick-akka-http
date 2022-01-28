import sbt._

object Version {
  val akka = "2.6.18"
  val slick = "3.3.3"
  val slf4j = "2.6.18"
  val postgres = "42.3.1"
  val akkaHttp = "10.2.7"
  val json4s = "4.0.3"
  val akkaHttpJson4s = "1.39.2"
  val logbackClassic = "1.2.10"
  val scalaTest = "3.2.10"
}

object Library {
  val akkaActor = "com.typesafe.akka"      %% "akka-actor"       % Version.akka
  val slf4j = "com.typesafe.akka"          %% "akka-slf4j"       % Version.slf4j
  val akkaStream = "com.typesafe.akka"     %% "akka-stream"      % Version.akka
  val slick = "com.typesafe.slick"         %% "slick"            % Version.slick
  val slickHikariCP = "com.typesafe.slick" %% "slick-hikaricp"   % Version.slick
  val postgresql = "org.postgresql"         % "postgresql"       % Version.postgres
  val akkaHttp = "com.typesafe.akka"       %% "akka-http"        % Version.akkaHttp
  val json4sNative = "org.json4s"          %% "json4s-native"    % Version.json4s
  val json4sExt = "org.json4s"             %% "json4s-ext"       % Version.json4s
  val json4sJackson = "org.json4s"         %% "json4s-jackson"   % Version.json4s
  val akkaHttpJson4s = "de.heikoseeberger" %% "akka-http-json4s" % Version.akkaHttpJson4s
  val logbackClassic = "ch.qos.logback"     % "logback-classic"  % Version.logbackClassic
  val scalaTest = "org.scalatest"          %% "scalatest"        % Version.scalaTest % Test
}

object Dependencies {

  import Library._

  val depends = Seq(
    akkaActor,
    slf4j,
    akkaStream,
    slick,
    slickHikariCP,
    postgresql,
    akkaHttp,
    json4sNative,
    json4sExt,
    json4sJackson,
    akkaHttpJson4s,
    logbackClassic,
    scalaTest
  )

}
