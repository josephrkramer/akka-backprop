package com.josephrkramer

import akka.actor.Actor
import akka.actor.ActorRef

case class Layer(neurons: List[ActorRef]) extends Actor {
  def receive = {
    case inputs: Inputs => {
      val output = neurons.map(_ ? inputs)
      sender ! output
    }
  }
}
