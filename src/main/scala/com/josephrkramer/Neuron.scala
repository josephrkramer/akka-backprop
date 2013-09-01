package com.josephrkramer

import akka.actor.Actor

case class Neuron(weights: Array[Double]) extends Actor {
  def receive = {
    case inputs: Array[Double] => {
      val weightedSum = inputs.zip(weights).map( x => x._1 * x._2 ).sum
      sender ! Sigmoid(weightedSum)
    }
  }
}
