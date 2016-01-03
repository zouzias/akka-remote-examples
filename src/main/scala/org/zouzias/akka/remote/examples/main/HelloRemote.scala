package org.zouzias.akka.remote.examples.main

import akka.actor.{ActorSystem, Props}
import com.typesafe.config.ConfigFactory
import org.zouzias.akka.remote.examples.actors.RemoteActor

object HelloRemote extends App  {

  val config = ConfigFactory.load("remote_application.conf")
  val actorName = config.getString("akka.actor.name")

  // Create an actor system to host the remote actor
  val system = ActorSystem(config.getString("akka.system.name"), config)

  // Define the remote actor
  val remoteActor = system.actorOf(Props[RemoteActor], name = actorName)

  // Send an init message to the remote actor
  remoteActor ! s"The RemoteActor [${actorName}] is alive"
}

