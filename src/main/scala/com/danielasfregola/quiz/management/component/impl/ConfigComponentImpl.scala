package com.danielasfregola.quiz.management.component.impl

import com.typesafe.config.{Config, ConfigFactory}
import com.danielasfregola.quiz.management.component.ConfigComponent

trait ConfigComponentImpl extends ConfigComponent {
  override val config: Config = ConfigFactory.load()
}
