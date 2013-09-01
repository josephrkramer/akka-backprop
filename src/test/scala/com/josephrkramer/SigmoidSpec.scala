package com.josephrkramer

import org.scalatest.FunSpec
import org.scalatest.matchers._

class SigmoidSpec extends FunSpec with ShouldMatchers {
  describe("A sigmoid") {
    it("should equal 0.5 for input of 0") {
      assert(Sigmoid(0) === 0.5)
    }

    it("should equal 1 for sufficiently high value") {
      assert(Sigmoid(100) === 1)
    }
  }
}
