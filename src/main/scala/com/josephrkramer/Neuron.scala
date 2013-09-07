package com.josephrkramer

import akka.actor.Actor

case class Neuron(weights: Weights) extends Actor {
  def receive = {
    case inputs: Inputs => {
      val weightedSum = inputs.values.zip(weights.values).map( x => x._1 * x._2 ).sum
      sender ! Sigmoid(weightedSum)
    }
  }
}

case class Inputs(values: Array[Double])
object Inputs {
  def apply(values: Double*) = new Inputs(values.toArray)
}

case class Weights(values: Array[Double])
object Weights {
  def apply(values: Double*) = new Weights(values.toArray)
}
