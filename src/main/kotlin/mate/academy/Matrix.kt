package mate.academy

class Matrix(private val rows: Int, private val cols: Int) {

    private val data = Array(rows) { IntArray(cols) }

    init {
        require(rows >= 0 && cols >= 0) {
            "Matrix dimensions must be non-negative"
        }
    }

    private fun validateIndices(row: Int, col: Int) {
        require(row in 0 until rows && col in 0 until cols) {
            "Index [$row,$col] is out of bounds for matrix $rows x $cols"
        }
    }

    private fun validateSameSize(other: Matrix) {
        require(rows == other.rows && cols == other.cols) {
            "Matrices must have the same dimensions: " +
                    "$rows x $cols != ${other.rows} x ${other.cols}"
        }
    }

    operator fun get(row: Int, col: Int): Int {
        validateIndices(row, col)
        return data[row][col]
    }

    operator fun set(row: Int, col: Int, value: Int) {
        validateIndices(row, col)
        data[row][col] = value
    }

    operator fun plus(other: Matrix): Matrix {
        validateSameSize(other)

        val result = Matrix(rows, cols)
        for (r in 0 until rows) {
            for (c in 0 until cols) {
                result.data[r][c] = this.data[r][c] + other.data[r][c]
            }
        }
        return result
    }

    operator fun minus(other: Matrix): Matrix {
        validateSameSize(other)

        val result = Matrix(rows, cols)
        for (r in 0 until rows) {
            for (c in 0 until cols) {
                result.data[r][c] = this.data[r][c] - other.data[r][c]
            }
        }
        return result
    }

    override fun toString(): String =
        data.joinToString(separator = "\n") { row ->
            row.joinToString(" ")
        }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Matrix) return false
        if (rows != other.rows || cols != other.cols) return false

        for (r in 0 until rows) {
            if (!data[r].contentEquals(other.data[r])) return false
        }
        return true
    }

    override fun hashCode(): Int {
        var result = rows
        result = 31 * result + cols
        for (row in data) {
            result = 31 * result + row.contentHashCode()
        }
        return result
    }
}

