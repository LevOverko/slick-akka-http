package com.danielasfregola.quiz.management.services

import com.danielasfregola.quiz.management.db.UserTableComponent
import org.scalatest.{BeforeAndAfterAll, Suite}
import slick.jdbc.JdbcBackend.Database
import slick.jdbc.PostgresProfile

trait DatabaseSpec extends Suite with BeforeAndAfterAll {
  lazy val db = Database.forConfig("database.postgre")
  lazy val profile = new PostgresProfile {}
  lazy val userRepository: UserService = ExtendedUserRepository(db, profile)
  private val schemaName = "book_store"

  import profile.api._

  override def beforeAll(): Unit = {
    val table: UserTableComponent = userRepository.asInstanceOf[ExtendedUserRepository].getTable
    db.run {
      DBIO.seq(sqlu"CREATE SCHEMA IF NOT EXISTS #$schemaName", table.userQuery.schema.dropIfExists, table.userQuery.schema.create)
    }
  }
}
