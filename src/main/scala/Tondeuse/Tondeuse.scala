package Tondeuse

/**
 * package Tondeuse
 * @param coordinates : (x,y) current coordinates
 * @param orientation : Current position ('N' / 'E' / 'W' / 'S')
 * @param max_coordinates: (x_boundary, y_boundary) coordinates of the boundary of the lawn
 */

class Tondeuse(var coordinates:(Int, Int),
               var orientation:Char,
               val max_coordinates:(Int, Int)) {

  private val orientation_names = Array("North", "East" , "West" , "South")
  /*
 * This function allows us to get the current position with the x and y coordinates and the orientation
  */
  def getPosition() = s"${coordinates._1 } ${coordinates._2} ${orientation}"

  /*
 * This function allows the mower to go forward if the given instruction is 'A' when the mower is still in
 * the lawn and does not go out of the borders of the lawn
  */
  private def moveForward(): Unit ={

    this.coordinates = this.orientation match {
      // The square directly in the north direction of the position (x, y) has coordinates (x, y+1)
      case 'N' if this.coordinates._2  <= this.max_coordinates._2 =>
        (this.coordinates._1, this.coordinates._2 + 1)

      // The square directly in the east direction of the position (x, y) has coordinates (x+1, y)
      case 'E' if this.coordinates._1  <= this.max_coordinates._1 =>
        (this.coordinates._1 + 1, this.coordinates._2)

      // The square directly in the west direction of the position (x, y) has coordinates (x-1, y)
      case 'W' if this.coordinates._1 - 1 >= 0 =>
        (this.coordinates._1 - 1, this.coordinates._2)

      // The square directly in the south direction of the position (x, y) has coordinates (x, y-1)
      case 'S' if this.coordinates._2 - 1 >= 0 =>
        (this.coordinates._1, this.coordinates._2 - 1)

      case _ => this.coordinates
    }
  }

  /**
   * Move the lawn mower according to the instruction
   * @param given instruction (D,G,A)
   */
  def moveTondeuse(instruction: Char): Unit = {
    instruction match {
      /*
      * These cases allow us to know what is the new orientation after a turn left / right instruction.
      * For example, if we are facing north and want to turn right, we will take the value 'E'
       */
      case 'D' => {
        orientation match {
          case 'N' => orientation = 'E'
          case 'E' => orientation = 'S'
          case 'W' => orientation = 'N'
          case 'S' => orientation = 'W'
        }
      }
      case 'G' => {
        orientation match {
          case 'N' => orientation = 'W'
          case 'E' => orientation = 'N'
          case 'W' => orientation = 'S'
          case 'S' => orientation = 'E'
        }
      }
      case 'A' => this.moveForward()

      case default => {
        println("Non-existing instruction, please pick one from (A,D,G)")
        sys.exit()
      }
    }
  }
}

