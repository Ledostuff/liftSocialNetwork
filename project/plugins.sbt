//libraryDependencies <+= sbtVersion(v => "com.github.siasia" %% "xsbt-web-plugin" % "1.0.0")) // moved to repo1
addSbtPlugin("com.earldouglas" % "xsbt-web-plugin" % "0.9.0")
//addSbtPlugin("com.earldouglas" % "xsbt-web-plugin" % "1.0.0")

resolvers += Resolver.sonatypeRepo("snapshots")

addSbtPlugin("org.ensime" % "ensime-sbt" % "0.1.5-SNAPSHOT")
//addSbtPlugin("org.ensime" % "ensime-sbt-cmd" % "0.1.1")