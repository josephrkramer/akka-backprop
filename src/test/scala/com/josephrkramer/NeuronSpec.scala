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

class NeuronSpec extends TestKit(ActorSystem("NeuronTest")) with DefaultTimeout with ImplicitSender
    with WordSpec with ShouldMatchers with BeforeAndAfterAll {

  override def afterAll {
    shutdown(system)
  }

  val neuronRef = system.actorOf(Props(classOf[Neuron], Weights(1.0, 1.0)))

  "A Neuron" should {
    "Respond with the weighted sum" in {
      within(500 millis) {
        neuronRef ! Inputs(0.0, 0.0)
        expectMsg(0.5)
      }
    }
  }
}
