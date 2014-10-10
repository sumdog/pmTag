name := "pmTag"

version := "1.0"

scalaVersion := "2.10.3"

resolvers += "swt-repo" at "https://swt-repo.googlecode.com/svn/repo/"

libraryDependencies ++= Seq(
  "org.squeryl" %% "squeryl" % "0.9.5-6",
   "com.h2database" % "h2" % "1.4.180" ,
   "org.eclipse.jface" % "org.eclipse.jface" % "3.8.0.v20120521-2329"
)

libraryDependencies += {
  val os = (sys.props("os.name"), sys.props("os.arch")) match {
    case ("Linux", "amd64" | "x86_64") => "gtk.linux.x86_64"
    case ("Linux", _) => "gtk.linux.x86"
    case ("Mac OS X", "amd64" | "x86_64") => "cocoa.macosx.x86_64"
    case ("Mac OS X", _) => "cocoa.macosx.x86"
    case (os, "amd64") if os.startsWith("Windows") => "win32.win32.x86_64"
    case (os, _) if os.startsWith("Windows") => "win32.win32.x86"
    case (os, arch) => sys.error("Cannot obtain lib for OS '" + os + "' and architecture '" + arch + "'")
  }
  val artifact = "org.eclipse.swt." + os
  "org.eclipse.swt" % artifact % "3.8"
}

licenses := Seq("GPL-3.0" -> url("http://www.gnu.org/licenses/gpl-3.0.html"))

javaOptions := Seq("-XstartOnFirstThread", "-d64")



