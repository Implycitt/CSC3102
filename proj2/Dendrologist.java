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

        AVLTree<String> Tree = new AVLTree<String>();
        String orderCode = args[0];
        String commandFile = args[1];
        String arg;
        Comparator<Node> cmp;

        try {
          Scanner fileScan = new Scanner(new FileReader(commandFile));
          while (fileScan.hasNextLine()) {
            String line = fileScan.nextLine();
            String[] parts = line.split(" ");
            String command = parts[0];

            if (parts.length == 2) {
              arg = parts[1];
            }

            switch (orderCode) {
                case "-0":
                    cmp = new Comparator<Node>() {
                        public int compare(Node a, Node b) {
                          return a.data.compareTo(b.data);
                        }
                    };
                    break;
                case "-1":
                    cmp = new Comparator<Node>() {
                        public int compare(Node a, Node b) {
                          return (a.data.compareTo(b.data)).reversed();
                        }
                    };
                    break;
            }

            if (command.equals("insert")) {
              Tree.insert(arg);
              System.out.println("Inserted: " + arg);
            } else if (command.equals("delete")) {
              Tree.remove(arg);
              System.out.println("Deleted: " + arg);
            } else if (command.equals("traverse")) {
              Tree.traverse(cmp);
            }
          }
        } catch (Exception e) {
          System.out.println(usage);
        }
    }   
}
