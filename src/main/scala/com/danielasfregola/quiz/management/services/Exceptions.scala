package com.danielasfregola.quiz.management.services

object Exceptions {
  class NotFoundException(message: String) extends NoSuchElementException(message)
}