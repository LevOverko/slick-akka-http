package com.danielasfregola.quiz.management.resources

import akka.http.scaladsl.server.Route

trait HttpRoute {
  def route: Route
}
