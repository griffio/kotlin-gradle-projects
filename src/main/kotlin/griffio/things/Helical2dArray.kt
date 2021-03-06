package griffio.things

import griffio.things.HelicalDirection.LEFT
import griffio.things.HelicalDirection.RIGHT
import griffio.things.HelicalDirection.DOWN
import griffio.things.HelicalDirection.UP

fun main(args: Array<String>) {
  helical2d()
}

enum class HelicalDirection {
  RIGHT,
  LEFT,
  UP,
  DOWN
}

fun helical2d() {

  val rc: Array<CharArray>
  rc = arrayOf(
      charArrayOf('A', 'B', 'C', 'D'),
      charArrayOf('L', 'M', 'N', 'E'),
      charArrayOf('K', 'P', 'O', 'F'),
      charArrayOf('J', 'I', 'H', 'G'))

  val lr = object {
    var left: Int = 0
    var right: Int = 0
  }

  val tb = object {
    var top: Int = 0
    var bottom: Int = 0
  }

  lr.right = rc.size - 1
  tb.bottom = rc[0].size - 1

  var direction = RIGHT

  while (lr.left <= lr.right && tb.top <= tb.bottom) {

    when (direction) {
      RIGHT -> {
        for (i in lr.left..lr.right) {
          println(rc[tb.top][i])
        }
        tb.top++
        direction = DOWN
      }
      DOWN -> {
        for (i in tb.top..tb.bottom) {
          println(rc[i][lr.right])
        }
        lr.right--
        direction = LEFT
      }
      LEFT -> {
        for (i in lr.right downTo lr.left) {
          println(rc[tb.bottom][i])
        }
        tb.bottom--
        direction = UP
      }
      UP -> {
        for (i in tb.bottom downTo tb.top) {
          println(rc[i][lr.left])
        }
        lr.left++
        direction = RIGHT
      }
    }
  }
}