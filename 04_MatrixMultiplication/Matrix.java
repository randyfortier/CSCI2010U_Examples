public class Matrix {
   private float[] values;
   private int numRows;
   private int numCols;

   public Matrix(int numRows, int numCols) {
      // remember the matrix's size
      this.numRows = numRows;
      this.numCols = numCols;

      // initialize space for the matrix elements
      values = new float[numRows * numCols];
   }

   public float get(int row, int col) {
      return values[row * this.numCols + col];
   }

   public void set(int row, int col, float value) {
      values[row * this.numCols + col] = value;
   }

   public int getNumRows() { return numRows; }
   public int getNumCols() { return numCols; }

   public Matrix multiply(Matrix other) {
      // check to make sure the matrices are compatible
      if (this.getNumCols() != other.getNumRows()) {
         throw new IllegalArgumentException("Cannot multiply a "+this.getNumRows()+"x"+this.getNumCols()+" matrix with a "+other.getNumRows()+"x"+other.getNumCols()+" matrix");
      }

      Matrix result = new Matrix(this.getNumRows(), other.getNumCols());
      for (int r = 0; r < this.getNumRows(); r++) {
         for (int c = 0; c < other.getNumCols(); c++) {
            float value = 0.0f;
            for (int i = 0; i < this.getNumCols(); i++) {
               // multiply the rth row, ith column in the first matrix with the ith row, cth column in the second
               value += this.get(r, i) * other.get(i, c);
            }
            result.set(r, c, value);
         }
      }

      return result;
   }

   public void print() {
      for (int r = 0; r < this.getNumRows(); r++) {
         for (int c = 0; c < this.getNumCols(); c++) {
            System.out.print(this.get(r, c) + " ");
         }

         System.out.println("");
      }
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
