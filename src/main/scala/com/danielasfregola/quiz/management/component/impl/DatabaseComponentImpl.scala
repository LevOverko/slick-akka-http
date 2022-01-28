package com.danielasfregola.quiz.management.component.impl

import com.danielasfregola.quiz.management.component.DatabaseComponent
import slick.jdbc.JdbcBackend.Database
import slick.jdbc.PostgresProfile

trait DatabaseComponentImpl extends DatabaseComponent {
  override val db = Database.forConfig("database.postgre")
  override val profile = new PostgresProfile {}
}
