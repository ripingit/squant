package com.squant.cheetah

import java.util.concurrent.Executors

import akka.actor.ActorSystem
import com.squant.cheetah.datasource.DataBase

import scala.concurrent.ExecutionContext
import scala.concurrent.duration.Duration
import scala.concurrent.duration._

object MainEngine extends App{
  val actorSystem = ActorSystem("squant")

  implicit val ec = ExecutionContext.fromExecutor(Executors.newFixedThreadPool(10))

  val symbols = DataBase.symbols

  for(symbol <- symbols){
    actorSystem.scheduler.schedule(Duration.Zero,60 seconds, () => {
      println("hello " + symbol)
    })
  }
}