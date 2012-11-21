package streams

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class StringParserTerrainSuite extends FunSuite {

  trait Tester extends GameDef with Solver with StringParserTerrain {
    val level =
      """ST
          |o-
          |oo""".stripMargin
    val terrainTest = Vector(Vector('S', 'T'), Vector('o', '-'), Vector('o', 'o'));
    val fnToTest = terrainFunction(terrainTest)
  }

  test("positive pos") {
    new Tester {
      assert(!fnToTest(Pos(-1, 0)))
      assert(!fnToTest(Pos(0, -1)))
    }
  }
  
  test("outside range") {
    new Tester {
      assert(!fnToTest(Pos(5,0)))
      assert(!fnToTest(Pos(0,5)))
    }
  }
  
  test("valid char"){
    new Tester {
      assert(fnToTest(Pos(0,0)))
      assert(!fnToTest(Pos(1,1)))
    }
  }
  
  test("got startPoint"){
    new Tester {
      assert(findChar('S',terrainTest) === Pos(0,0))
    }
  }

}