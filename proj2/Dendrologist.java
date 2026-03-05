import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Comparator;
import java.util.Scanner;

/**
 * A testbed for an augmented implementation of an AVL tree
 * @author William Duncan, Quentin Bordelon
 * @see AVLTreeAPI, AVLTreeException
 * <pre>
 * Date: 05/03/2026
 * CSC 3102 Programming Project # 2
 * Instructor: Dr. Duncan 
 * </pre>
 */
public class Dendrologist
{
    public static void main(String[] args) throws FileNotFoundException 
    {
        String usage = "Dendrologist <order-code> <command-file>\n";
        usage += "  <order-code>:\n";
        usage += "  0 ordered by increasing string length, primary key, and reverse lexicographical order, secondary key\n";
        usage += "  -1 for reverse lexicographical order\n";
        usage += "  1 for lexicographical order\n";
        usage += "  -2 ordered by decreasing string\n";
        usage += "  2 ordered by increasing string\n";
        usage += "  -3 ordered by decreasing string length, primary key, and reverse lexicographical order, secondary key\n";
        usage += "  3 ordered by increasing string length, primary key, and lexicographical order, secondary key\n";      

        if (args.length != 2)
        {
            System.out.println(usage);
            throw new IllegalArgumentException("There should be 2 command line arguments.");
        }

        int orderCode = Integer.parseInt(args[0]);
        String commandFile = args[1];
        Comparator<String> cmp = null;

        if (orderCode == 0) {
          cmp = (s1, s2) -> {
            if (s1.length() != s2.length()) {
              return Integer.compare(s1.length(), s2.length());
            }
            return s2.compareTo(s1);
          };
        } else if (orderCode == -1) {
          cmp = (s1, s2) -> s2.compareTo(s1);
        } else {
          System.out.println(usage);
          throw new IllegalArgumentException("Invalid order code");
        }


        AVLTree<String> Tree = new AVLTree<>(cmp);

        try {
          Scanner fileScan = new Scanner(new FileReader(commandFile));
          while (fileScan.hasNextLine()) {
            String line = fileScan.nextLine();
            String[] parts = line.split(" ");
            String command = parts[0];
            String arg = "";

            if (parts.length == 2) {
              arg = parts[1];
            }


            if (command.equals("insert")) {
              Tree.insert(arg);
              System.out.println("Inserted: " + arg);
            } else if (command.equals("delete")) {
              Tree.remove(arg);
              System.out.println("Deleted: " + arg);
            } else if (command.equals("traverse")) {
              if (arg.equals("-0")) {
                System.out.println("In-Order Traversal:");
                Tree.traverse(item -> {
                  System.out.println(item);
                  return null;
                });
              } else if (arg.equals("-1")) {
                System.out.println("Level-Order Traversal:");
                Tree.levelOrder(item -> {
                  System.out.println(item);
                  return null;
                });
              }
            } else if (command.equals("stats")) {
              System.out.println("Stats: size = " + Tree.size() +
                                  ", height = " + Tree.height() + 
                                  ", diameter = " + Tree.diameter() +
                                  ", complete? = " + Tree.isComplete() + 
                                  ", full? = " + Tree.isFull());
            }
          }
          fileScan.close();
        } catch (Exception e) {
          System.out.println(usage);
        }
    }   
}
