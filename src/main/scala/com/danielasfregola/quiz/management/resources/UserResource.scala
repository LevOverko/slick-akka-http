package com.danielasfregola.quiz.management.resources

import akka.http.scaladsl.server.Route
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._
import com.danielasfregola.quiz.management.entities.User
import com.danielasfregola.quiz.management.component.{ActorSystemComponent, Repositories}
import com.danielasfregola.quiz.management.services.UserService
import com.danielasfregola.quiz.management.services.UserService.UserNotFoundException
import com.danielasfregola.quiz.management.serializers.Serializers
trait UserResource {
  this: Repositories with HttpBaseService with ActorSystemComponent with Serializers =>

  registerRoute( pathPrefix("users") {
    concat(
      path(IntNumber) { bookId =>
        concat(
          get {
            handleResponse[User](userRepository.byId(bookId).map(_.getOrElse(throw UserNotFoundException(bookId))))
          },
          delete {
            handleResponse[String](userRepository.deleteBy(bookId).map(_ => s"Пользователь [id=$bookId] успешно удален"))
          }
        )
      },

    pathEndOrSingleSlash{
      concat(
        entity(as[User]){
          user =>
            concat(
              post {
                handleResponse[User](userRepository.add(user).map(_ => user), _ => StatusCodes.Created)
        },
              put {
                handleResponse[User](userRepository.update(user).map(_ => user))
              }
            )
        },
        get {
          parameters('limit ? 20, 'offset ? 0) { (limit, offset) =>
            handleResponse[Seq[User]](userRepository.all(limit, offset))
          }
      }
      )
    }
    )
    })
  }



