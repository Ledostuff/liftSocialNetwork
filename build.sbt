organization := "ru.martemyanov"

name := "liftSocialNetwork"

version := "0.1-SNAPSHOT"

scalaVersion := "2.11.1"

seq(webSettings:_*)

resolvers ++= Seq("snapshots"     at "http://oss.sonatype.org/content/repositories/snapshots",
                  "staging"       at "http://oss.sonatype.org/content/repositories/staging",
                  "releases"      at "http://oss.sonatype.org/content/repositories/releases"
                 )
resolvers += "ibiblio maven mirror" at "http://mirrors.ibiblio.org/maven2/"

port in container.Configuration := 9090

libraryDependencies ++= {
  val liftVersion = "2.6-RC1" // Put the current/latest lift version here
  Seq(
    "net.liftweb" %% "lift-webkit" % liftVersion % "compile->default",
    "net.liftweb" %% "lift-mapper" % liftVersion % "compile->default",
    "net.liftweb" %% "lift-wizard" % liftVersion % "compile->default")
}

libraryDependencies ++= Seq(
  "org.eclipse.jetty" % "jetty-webapp" % "8.0.4.v20111024" % "container", // For Jetty 8
  //"org.eclipse.jetty" % "jetty-webapp" % "7.3.0.v20110203" % "container", // For Jetty 7
  //"org.mortbay.jetty" % "jetty" % "6.1.22" % "jetty,test", // For Jetty 6, add scope test to make jetty avl. for tests
  "org.scala-tools.testing" % "specs_2.9.0" % "1.6.8" % "test", // For specs.org tests
  "junit" % "junit" % "4.8" % "test->default", // For JUnit 4 testing
  "javax.servlet" % "servlet-api" % "2.5" % "provided->default",
  "com.h2database" % "h2" % "1.2.138", // In-process database, useful for development systems
  "ch.qos.logback" % "logback-classic" % "0.9.26" % "compile->default" // Logging
)


//Use JRebel
//jettyScanDirs := Nil
scanDirectories in Compile := Nil