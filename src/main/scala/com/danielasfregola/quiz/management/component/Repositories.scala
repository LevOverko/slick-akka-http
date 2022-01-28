package com.danielasfregola.quiz.management.component

import com.danielasfregola.quiz.management.services.UserServiceComponent

trait Repositories {
  def userRepository: UserServiceComponent
}
