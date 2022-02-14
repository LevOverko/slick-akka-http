package com.danielasfregola.quiz.management.resources

import com.danielasfregola.quiz.management.component.{ActorSystemComponent, Repositories}
import com.danielasfregola.quiz.management.serializers.Serializers

trait HttpRoutingService extends HttpBaseService with UserResource {
  this: Repositories with ActorSystemComponent with Serializers with HttpRoute =>
}
