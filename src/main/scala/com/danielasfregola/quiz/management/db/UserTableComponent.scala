package com.danielasfregola.quiz.management.db

import com.danielasfregola.quiz.management.entities.User
import slick.jdbc.JdbcProfile
import slick.lifted.ProvenShape

object UserTableComponent {
  type UserId = Int

  def apply(profile: JdbcProfile): UserTableComponent = new UserTableComponent(profile)

}

class UserTableComponent(val profile: JdbcProfile) {

  import UserTableComponent.UserId
  import profile.api._

  class UserTable(tag: Tag) extends Table[User](tag, Some("user_store"), "users") {
    def id: Rep[UserId] = column[UserId]("id", O.PrimaryKey)
    def nameUser: Rep[String] = column[String]("nameUser")
    def ageUser: Rep[String] = column[String]("ageUser")

    def * : ProvenShape[User] =
      (id, nameUser, ageUser) <> (User.tupled, User.unapply)

  }

  val userQuery: TableQuery[UserTable] = TableQuery[UserTable]

}