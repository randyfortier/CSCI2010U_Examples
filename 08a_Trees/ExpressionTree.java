public class ExpressionTree {
   private interface ExpressionTreeNode {
      public float evaluate();
   }

   private class ValueNode implements ExpressionTreeNode {
      private float value;

      public ValueNode(float value) {
         this.value = value;
      }

      public float evaluate() {
         return value;
      }
   }

   private class ExpressionNode implements ExpressionTreeNode {
      private ExpressionTreeNode leftNode;
      private ExpressionTreeNode rightNode;
      private String operation;

      public ExpressionNode(ExpressionTreeNode leftNode, String operation, ExpressionTreeNode rightNode) {
         this.leftNode = leftNode;
         this.operation = operation;
         this.rightNode = rightNode;
      }

      public float evaluate() {
         if (operation.equals("+")) {
            return leftNode.evaluate() + rightNode.evaluate();
         } else if (operation.equals("-")) {
            return leftNode.evaluate() - rightNode.evaluate();
         } else if (operation.equals("*")) {
            return leftNode.evaluate() * rightNode.evaluate();
         } else if (operation.equals("/")) {
            return leftNode.evaluate() / rightNode.evaluate();
         }
         return 0.0f;
      }
   }

   public void runDemo() {

      ValueNode two = new ValueNode(2.0f);
      ValueNode three = new ValueNode(3.0f);
      ValueNode five = new ValueNode(5.0f);
      ValueNode sixteen = new ValueNode(16.0f);
      ValueNode four = new ValueNode(4.0f);

      // (2 + 3) = 5
      ExpressionNode twoPlusThree = new ExpressionNode(two, "+", three);

      // (16 / 4) = 4
      ExpressionNode sixteenOverFour = new ExpressionNode(sixteen, "/", four);

      // (5 * (16 / 4)) = 20
      ExpressionNode fiveTimes = new ExpressionNode(five, "*", sixteenOverFour);

      // (3 - (5 * (16 / 4))) = -17
      ExpressionNode threeMinus = new ExpressionNode(three, "-", fiveTimes);

      // (2 + 3) * (3 - (5 * (16 / 4))) = -85
      ExpressionNode fullExpression = new ExpressionNode(twoPlusThree, "*", threeMinus);

      System.out.println("(2 + 3)                        = " + twoPlusThree.evaluate());
      System.out.println("(16 / 4)                       = " + sixteenOverFour.evaluate());
      System.out.println("(5 * (16 / 4))                 = " + fiveTimes.evaluate());
      System.out.println("(3 - (5 * (16 / 4)))           = " + threeMinus.evaluate());
      System.out.println("(2 + 3) * (3 - (5 * (16 / 4))) = " + fullExpression.evaluate());
   }

   public static void main(String[] args) {
      ExpressionTree app = new ExpressionTree();
      app.runDemo();
   }
}
