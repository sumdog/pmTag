package org.penguindreams.pmtag.db

import org.squeryl.{KeyedEntity, Session, SessionFactory, Schema}
import org.squeryl.adapters.H2Adapter
import org.squeryl.PrimitiveTypeMode._
import org.squeryl.dsl.CompositeKey2


class Database extends Schema {

  Class.forName("org.h2.Driver");

  SessionFactory.concreteFactory = Some(()=>
    Session.create(
    java.sql.DriverManager.getConnection("jdbc:h2:~/test"),
    new H2Adapter))

  val files = table[Files]

  val tags = table[Tags]

  val fileTags = manyToManyRelation(files,tags).via[FileTags]( (f,t,ft) => (ft.fileId === f.id , t.id === ft.tagId) )

  //def getTags(file : String) : Tags = from(files,tags) ((f,t) => where(f.name === file) select(f))

  def addFile(file: String, tags : Array[Long]) = {}

}

class Files (
  val id : Long,
  val name : String,
  val hash : String
) extends KeyedEntity[Long] {
  def this() = this(0,"","")
}

class FileTags (
  val fileId: Long,
  val tagId: Long
) extends KeyedEntity[CompositeKey2[Long,Long]] {
  def this() = this(0,0)
  def id = compositeKey(fileId,tagId)
}

class Tags(
  val id : Long,
  val name : String
) extends KeyedEntity[Long] {
  def this() = this(0,"")
}

