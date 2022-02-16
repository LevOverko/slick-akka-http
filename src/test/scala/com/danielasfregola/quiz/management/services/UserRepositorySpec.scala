package com.danielasfregola.quiz.management.services

import com.danielasfregola.quiz.management.entities.User
import org.scalatest.freespec.AsyncFreeSpec
import org.scalatest.matchers.should.Matchers

class UserRepositorySpec extends AsyncFreeSpec with DatabaseSpec with Matchers {

  "UserRepositorySpec" - {
    val user = User(1, "Lev", "19")
    val updatedUser = user.copy(nameUser = "updated name", ageUser = "updated age")

    "пользователь создан" in {
      userRepository.add(user).map { result =>
        result shouldEqual 1
      }
    }

    "пользователь получен" in {
      userRepository.byId(user.id).map { result =>
        result.isDefined shouldEqual true
        result.get shouldEqual user
      }
    }

    "изменение пользователя" in {
      userRepository.update(updatedUser).map { result =>
        result shouldEqual 1
      }
    }

    "получен измененный пользователь" in {
      userRepository.byId(user.id).map { result =>
        result.isDefined shouldEqual true
        result.get shouldEqual updatedUser
      }
    }

    "удаление пользователя" in {
      userRepository.deleteBy(user.id).map { result =>
        result shouldEqual 1
      }
    }

    "не получен удаленный пользователь" in {
      userRepository.byId(user.id).map { result =>
        result shouldEqual None
      }
    }
  }
}