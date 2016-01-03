package org.zouzias.akka.remote.examples.main

import akka.actor.{ActorSystem, Props}
import com.typesafe.config.ConfigFactory
import org.zouzias.akka.remote.examples.actors.LocalActor

object HelloClient extends App {

  val config = ConfigFactory.load("local_application.conf")

  implicit val system = ActorSystem("LocalSystem", config)
  val localActor = system.actorOf(Props[LocalActor], name = "LocalActor")  // the local actor
  localActor.!("START")                                                   // start the action

}

