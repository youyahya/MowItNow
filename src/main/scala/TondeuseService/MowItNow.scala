package TondeuseService

import io.Source.fromResource
import Tondeuse.Tondeuse

object MowItNow {
  /**
   * This service reads a file with all the instructions, moves mowers and prints final position
   * @param file_name
   * @return final position of each mower (tondeuse)
   */
  def TondeuseRunner(file_name : String): Unit ={

    try{
      var x_boundary = 0
      var y_boundary = 0

      // We take the first line to define the size and boundaries of the lawn (pelouse)
      for(line <- fromResource(s"$file_name").getLines.take(1)){
        val coordinateArray = line.split(" ")
        val limit = coordinateArray.map(_.toInt)
        assert(limit.forall(_ >= 0)) // Checks that there are no negative values in the coordinates

        x_boundary = coordinateArray(0).toInt
        y_boundary = coordinateArray(1).toInt
      }
      // We drop the first line and look at the rest of the file
      val fileLines = fromResource(s"$file_name").getLines.drop(1)
      var i = 1

      //Initialize the lawn mower
      val tondeuse = new Tondeuse((0,0),
        orientation = 'N',
        (x_boundary, y_boundary))

      for(line <- fileLines) {
        // Parse the input file to retrieve the all the odd lines and to convert them into Tondeuse objects
        if (i%2 !=0) {
          val coordinates_orientation = line.split(" ")
          // Get the mower coordinates
          tondeuse.coordinates = (coordinates_orientation(0).toInt, coordinates_orientation(1).toInt)
          // Get the mower orientation
          tondeuse.orientation = coordinates_orientation(2).charAt(0)
        }
        else {
          //Parse the input file to retrieve the all the even lines and to convert them into List of instructions
          val instructions = line.toList

          // Sequentially run the mowers and do the instructions
          instructions.foreach(tondeuse.moveTondeuse(_))

          //Get the final position
          val final_position = tondeuse.getPosition()
          println( s"Tondeuse ${i / 2} : ${final_position}")
        }
        i +=1
      }
    }
      catch{
        // This catch should be able to handle most format errors in the instructions file
        case nfe: NumberFormatException => println("File structure not valid.")
        case ast: AssertionError => println("Some numbers are negative or not valid")
        case ex: Exception => ex.printStackTrace()
        case ind: ArrayIndexOutOfBoundsException => println("Starting orientation not valid.")
      }
  }

}
