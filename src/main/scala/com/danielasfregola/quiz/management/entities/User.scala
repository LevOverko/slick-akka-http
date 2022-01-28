package com.danielasfregola.quiz.management.entities

import  com.danielasfregola.quiz.management.db.UserTableComponent.UserId

case class User(id: UserId, nameUser: String, ageUser: String)

