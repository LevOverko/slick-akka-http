package com.danielasfregola.quiz.management.services

import com.danielasfregola.quiz.management.db.UserTableComponent
import com.danielasfregola.quiz.management.db.UserTableComponent.UserId
import com.danielasfregola.quiz.management.entities.User
import Exceptions.NotFoundException
import slick.jdbc.JdbcBackend.Database
import slick.jdbc.JdbcProfile

import scala.concurrent.Future

trait UserServiceComponent {
  def add(book: User): Future[Int]
  def update(book: User): Future[Int]
  def deleteBy(bookId: Int): Future[Int]
  def byId(bookId: Int): Future[Option[User]]
  def all(limit: Int, offset: Int): Future[Seq[User]]
}

object UserService {

  def apply(db: Database, profile: JdbcProfile) =
    new UserService(db, profile)

  case class UserNotFoundException(id: UserId) extends NotFoundException(s"Пользователь [id=$id] не найден!")
}

class UserService(db: Database, profile: JdbcProfile) extends UserServiceComponent {

  protected val table: UserTableComponent = UserTableComponent(profile)

  import profile.api._
  import table.userQuery

  override def add(user: User): Future[Int] = db.run {
    userQuery += user
  }

  override def update(user: User): Future[Int] = db.run {
    userQuery.filter(_.id === user.id).map(b => (b.nameUser, b.ageUser)).update((user.nameUser, user.ageUser))
  }

  override def deleteBy(bookId: Int): Future[Int] = db.run {
    userQuery.filter(_.id === bookId).delete
  }

  override def byId(bookId: Int): Future[Option[User]] = db.run {
    userQuery.filter(_.id === bookId).result.headOption
  }

  override def all(limit: Int, offset: Int): Future[Seq[User]] = db.run {
    userQuery.drop(offset).take(limit).result
  }
}
