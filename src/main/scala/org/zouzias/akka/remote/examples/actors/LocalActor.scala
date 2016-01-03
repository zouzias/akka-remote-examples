package org.zouzias.akka.remote.examples.actors

import akka.actor.Actor

class LocalActor extends Actor {

  val actorName = "RemoteActor"
  val systemName = "HelloRemoteSystem"
  val host = "127.0.0.1"

  val port = "5150"

  // create the remote actor
  val remote = context.actorSelection(s"akka.tcp://${systemName}@${host}:${port}/user/${actorName}")
  var counter = 0

  def receive = {
    case "START" =>
      remote ! "Hello from the LocalActor"
    case msg: String =>
      println(s"LocalActor received message: '$msg'")
      if (counter < 5) {
        sender ! "Hello back to you"
        counter += 1
      }
  }
}

