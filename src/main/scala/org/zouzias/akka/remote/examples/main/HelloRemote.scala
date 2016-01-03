package org.zouzias.akka.remote.examples.main

import akka.actor.{ActorSystem, Props}
import com.typesafe.config.ConfigFactory
import org.zouzias.akka.remote.examples.actors.RemoteActor

object HelloRemote extends App  {

  val config = ConfigFactory.load("remote_application.conf")
  val system = ActorSystem("HelloRemoteSystem", config)
  val remoteActor = system.actorOf(Props[RemoteActor], name = "RemoteActor")
  remoteActor ! "The RemoteActor is alive"
}

