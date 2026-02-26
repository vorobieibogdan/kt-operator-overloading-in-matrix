package mate.academy

class Matrix(
    private val rows: Int,
    private val cols: Int
) {

    private val data: Array<IntArray> =
        Array(rows) { IntArray(cols) }

    operator fun get(
        row: Int,
        col: Int
    ): Int {
        return data[row][col]
    }

    operator fun set(
        row: Int,
        col: Int,
        value: Int
    ) {
        data[row][col] = value
    }

    operator fun plus(
        other: Matrix
    ): Matrix {

        validateDimensions(other)

        val result = Matrix(rows, cols)

        for (row in 0 until rows) {
            for (col in 0 until cols) {
                result[row, col] =
                    this[row, col] + other[row, col]
            }
        }

        return result
    }

    operator fun minus(
        other: Matrix
    ): Matrix {

        validateDimensions(other)

        val result = Matrix(rows, cols)

        for (row in 0 until rows) {
            for (col in 0 until cols) {
                result[row, col] =
                    this[row, col] - other[row, col]
            }
        }

        return result
    }

    private fun validateDimensions(
        other: Matrix
    ) {
        val sameRows = rows == other.rows
        val sameCols = cols == other.cols

        require(sameRows && sameCols) {
            "Matrices must have the same dimensions"
        }
    }

    override fun toString(): String {
        return data.joinToString(
            separator = "\n"
        ) { row ->
            row.joinToString(
                separator = " "
            )
        }
    }
}



