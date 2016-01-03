package org.zouzias.akka.remote.examples.actors

import akka.actor.Actor

/**
  * Remote actor
  */
class RemoteActor extends Actor {
  def receive = {
    case msg: String =>
      println(s"RemoteActor received message '$msg'")
      sender ! s"Hello from the RemoteActor"
  }
}