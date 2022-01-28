package com.danielasfregola.quiz.management

import com.danielasfregola.quiz.management.component.impl._
import com.danielasfregola.quiz.management.resources.{HttpRoute, HttpRoutingService}
import com.danielasfregola.quiz.management.services.Logging
import com.danielasfregola.quiz.management.serializers.Serializers

object Main
  extends App
    with Logging
    with ConfigComponentImpl
    with ActorSystemComponentImpl
    with DatabaseComponentImpl
    with RepositoriesImpl
    with Serializers
    with HttpRoute
    with HttpRoutingService
    with RoutingComponentImpl