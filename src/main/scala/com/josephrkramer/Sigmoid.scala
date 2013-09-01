package com.josephrkramer

import scala.math._

object Sigmoid {
  def apply(value: Double): Double = {
    1d / (1d + exp(-value))
  }
}
