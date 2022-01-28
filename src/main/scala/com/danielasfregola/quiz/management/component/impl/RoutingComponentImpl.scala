package com.danielasfregola.quiz.management.component.impl

import akka.http.scaladsl.Http
import com.danielasfregola.quiz.management.component.{ActorSystemComponent, ConfigComponent, Repositories, RoutingComponent}
import com.danielasfregola.quiz.management.resources.HttpRoute

trait RoutingComponentImpl extends RoutingComponent {
  this: ConfigComponent with ActorSystemComponent with Repositories with HttpRoute =>

  private val host = config.getString("application.host")
  private val port = config.getInt("application.port")

  Http().newServerAt(host, port).bind(route)
}
