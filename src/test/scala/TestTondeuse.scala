import Tondeuse.Tondeuse
import org.scalatest.FunSuite

class TestTondeuse extends FunSuite {
  test("Going forward from north should give North value 'N'") {
    val tondeuse = new Tondeuse((1,2) , 'N', (5,5))
    tondeuse.moveTondeuse('A')
    assert(tondeuse.orientation == 'N')
  }

  test("Rotating to the right from north should give east direction 'E") {
    val tondeuse = new Tondeuse((1,2) , 'N', (5,5))
    tondeuse.moveTondeuse('D')
    assert(tondeuse.orientation == 'E')
  }

  test("Rotating to the left from west should give south direction 'S") {
    val tondeuse = new Tondeuse((1,2) , 'W', (5,5))
    tondeuse.moveTondeuse('G')
    assert(tondeuse.orientation == 'S')
  }

  test("Rotating to the left from east should give north direction 'N") {
    val tondeuse = new Tondeuse((1,2) , 'E', (5,5))
    tondeuse.moveTondeuse('G')
    assert(tondeuse.orientation == 'N')
  }

  test("Rotating to the right from east should give south direction 'S") {
    val tondeuse = new Tondeuse((1,2) , 'E', (5,5))
    tondeuse.moveTondeuse('D')
    assert(tondeuse.orientation == 'S')
  }

  test("Assert instructions for the first mower") {
    val tondeuse = new Tondeuse((1,2) , 'N', (5,5))
    val instructions = List('G', 'A', 'G', 'A', 'G', 'A', 'G', 'A', 'A')
    instructions.foreach(tondeuse.moveTondeuse(_))
    assert(tondeuse.coordinates == (1,3))
    assert(tondeuse.orientation == 'N')
  }

  test("Assert instructions for the second mower") {
    val tondeuse = new Tondeuse((3,3) , 'E', (5,5))
    val instructions = List('A', 'A', 'D', 'A', 'A', 'D', 'A', 'D', 'D','A')
    instructions.foreach(tondeuse.moveTondeuse(_))
    assert(tondeuse.coordinates == (5,1))
    assert(tondeuse.orientation == 'E')
  }


}

