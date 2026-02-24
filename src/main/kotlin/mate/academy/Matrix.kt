package mate.academy

class Matrix(private val rows: Int, private val cols: Int) {

    private val data = Array(rows) { IntArray(cols) }

    operator fun get(row: Int, col: Int): Int = data[row][col]

    operator fun set(row: Int, col: Int, value: Int) {
        data[row][col] = value
    }

    private fun validateSameSize(other: Matrix) {
        require(rows == other.rows && cols == other.cols) {
            "Matrices must have the same dimensions"
        }
    }

    operator fun plus(other: Matrix): Matrix {
        validateSameSize(other)

        val result = Matrix(rows, cols)
        for (r in 0 until rows) {
            for (c in 0 until cols) {
                result[r, c] = this[r, c] + other[r, c]
            }
        }
        return result
    }

    operator fun minus(other: Matrix): Matrix {
        validateSameSize(other)

        val result = Matrix(rows, cols)
        for (r in 0 until rows) {
            for (c in 0 until cols) {
                result[r, c] = this[r, c] - other[r, c]
            }
        }
        return result
    }

    override fun toString(): String =
        data.joinToString(separator = "\n") { row ->
            row.joinToString(" ")
        }
}


