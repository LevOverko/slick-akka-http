package com.danielasfregola.quiz.management.services

import com.danielasfregola.quiz.management.db.UserTableComponent
import slick.jdbc.JdbcBackend.Database
import slick.jdbc.JdbcProfile

object ExtendedUserRepository {

  def apply(db: Database, profile: JdbcProfile) =
    new ExtendedUserRepository(db, profile)
}

class ExtendedUserRepository(db: Database, profile: JdbcProfile) extends UserService(db, profile) {
  def getTable: UserTableComponent = table
}
