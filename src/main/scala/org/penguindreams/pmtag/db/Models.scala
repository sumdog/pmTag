package org.penguindreams.pmtag.db

import org.squeryl.{Session, SessionFactory,Schema}
import org.squeryl.adapters.H2Adapter


object Database extends Schema {

  Class.forName("org.h2.Driver");

  SessionFactory.concreteFactory = Some(()=>
    Session.create(
    java.sql.DriverManager.getConnection("jdbc:h2:~/test"),
    new H2Adapter))

  val files = table[Files]

  val tags = table[Tags]



}

class Files(
  val id : Long,
  val name : String,
  val hash : String
) {
  def this() = this(0,"","")
}

class Tags(
  val id : Long,
  val name : String
) {
  def this() = this(0,"")
}

