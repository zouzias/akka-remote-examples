package org.zouzias.akka.remote.examples.actors

import akka.actor.Actor
import com.typesafe.config.ConfigFactory


/**
  * Local actor that connects to remote actor
  */
class LocalActor extends Actor {

  val config = ConfigFactory.load("remote_application")

  val actorName = config.getString("akka.actor.name")
  val systemName = config.getString("akka.system.name")

  val host = config.getString("akka.remote.netty.tcp.hostname")
  val port = config.getString("akka.remote.netty.tcp.port")

  // create the remote actor
  val remote = context.actorSelection(s"akka.tcp://${systemName}@${host}:${port}/user/${actorName}")
  var counter = 0

  def receive = {
    case "START" =>
      remote ! s"Hello from the LocalActor"
    case msg: String =>
      println(s"LocalActor received message: '$msg'")
      println(s"Counter: ${counter}")
      if (counter < 5) {
        sender ! s"Hello back to you, ${this.actorName}"
        counter += 1
      }
      else{
        Thread.sleep(5000L)
        counter = 0
        sender ! s"Hello back to you again after 5s, ${this.actorName}"
      }
  }
}
