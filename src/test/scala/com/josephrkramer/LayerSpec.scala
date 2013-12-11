package com.josephrkramer

import org.scalatest.FunSpec
import org.scalatest.matchers._
import akka.testkit.TestKit
import akka.actor.ActorRef
import akka.actor.ActorSystem
import akka.actor.Props
import akka.testkit.DefaultTimeout
import akka.testkit.ImplicitSender
import org.scalatest.BeforeAndAfterAll
import org.scalatest.WordSpec
import scala.concurrent.duration._

class LayerSpec extends TestKit(ActorSystem("LayerTest")) with DefaultTimeout with ImplicitSender
    with WordSpec with ShouldMatchers with BeforeAndAfterAll {

  override def afterAll {
    shutdown(system)
  }

  val neuronOne = system.actorOf(Props(classOf[Neuron], Weights(1.0, 1.0)))
  val neuronTwo = system.actorOf(Props(classOf[Neuron], Weights(1.0, 1.0)))
  val layerRef = system.actorOf(Props(classOf[Layer], List(neuronOne, neuronTwo)))

  "A Layer" should {
    "Respond with the Array of Neuron outputs" in {
      within(500 millis) {
        layerRef ! Inputs(0.0, 0.0)
        expectMsg(Inputs(0.5, 0.5))
      }
    }

  }
}
