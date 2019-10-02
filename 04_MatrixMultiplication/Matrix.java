public class Matrix {
    private float[] values;
    private int numRows;
    private int numCols;

    public Matrix(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;

        values = new float[numRows * numCols];
    }

    public float get(int row, int col) {
        return values[row * numCols + col];
    }

    public void set(int row, int col, float value) {
        values[row * numCols + col] = value;
    }

    public Matrix multiply(Matrix other) {
        // make sure the matrices are compatible
        if (this.numCols != other.numRows) {
            // not compatible
            throw new IllegalArgumentException("Cannot multiply a "+this.getNumRows()+"x"+this.getNumCols()+" matrix with a "+other.getNumRows()+"x"+other.getNumCols()+" matrix");
        }

        // create a new matrix for the result
        Matrix result = new Matrix(this.numRows, other.numCols);

        for (int r = 0; r < this.numRows; r++) {
            for (int c = 0; c < other.numCols; c++) {
                float value = 0.0f;
                for (int i = 0; i < this.numCols; i++) {
                    // count these!!!
                    value += this.get(r, i) * other.get(i, c);
                }
                result.set(r, c, value);
            }
        }

        return result;
    }
    public static void main(String[] args) {
        Matrix a = new Matrix(2, 3);
        a.set(0, 0, 1);
        a.set(0, 1, 2);
        a.set(0, 2, 3);
        a.set(1, 0, 4);
        a.set(1, 1, 5);
        a.set(1, 2, 6);
  
        System.out.println("A:");
        a.print();
  
        Matrix b = new Matrix(3, 2);
        b.set(0, 0, 7);
        b.set(0, 1, 8);
        b.set(1, 0, 9);
        b.set(1, 1, 10);
        b.set(2, 0, 11);
        b.set(2, 1, 12);
  
        System.out.println("B:");
        b.print();
  
        Matrix aTimesB = a.multiply(b);
        System.out.println("A x B:");
        aTimesB.print();
    }
}