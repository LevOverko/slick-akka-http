package com.danielasfregola.quiz.management.component.impl

import com.danielasfregola.quiz.management.component.{ActorSystemComponent, DatabaseComponent, Repositories}
import com.danielasfregola.quiz.management.services.{UserService, UserServiceComponent}
import com.danielasfregola.quiz.management.services.Logging

trait RepositoriesImpl extends Repositories {
  this: DatabaseComponent with Logging with ActorSystemComponent =>

  override val userRepository: UserServiceComponent = UserService(db, profile)
}