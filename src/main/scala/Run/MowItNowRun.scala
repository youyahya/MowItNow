package Run

import TondeuseService.MowItNow

object MowItNowRun extends App {

  // Enter the file name to run the MowItNow service
  MowItNow.TondeuseRunner("instructions.txt")
  println("Thanks for using MowItNow service!®")

}

