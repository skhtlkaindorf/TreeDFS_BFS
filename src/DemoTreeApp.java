import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DemoTreeApp {

    public static void main(String[] args) {

        Node root = buildTree();  // CEO

        System.out.println("root = " + root);
        System.out.println("root.getLeft() = " + root.getLeft());
        System.out.println("root.getRight() = " + root.getRight());

        //System.out.println("calculateSalary(root) = " + calculateSalaryStack(root));

        //System.out.println("calculateCountDevices(root) = " + calculateCountDevices(root));
        //System.out.println("calculateCountDevices(DEV) = " + calculateCountDevices(root.getLeft()));
     //   System.out.println("calculateSalary(SW) = " + calculateSalary(root.getLeft()));

        System.out.println("employeesInLevel(root, 1) = " + employeesInLevel(root, 1));
        System.out.println("employeesInLevel(root, 3) = " + employeesInLevel(root, 3));
        System.out.println("employeesInLevel(root, 4) = " + employeesInLevel(root, 4));
    }

    private static int calculateCountDevices(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        Node element = null;
        int countDevices = 0;
        while (!stack.isEmpty()) {
            element = stack.pop();
            countDevices += element.getCountDevices();

            System.out.println("element = " + element);

            if (element.getRight() != null)
                stack.push(element.getRight());
            if (element.getMiddle() != null)
                stack.push(element.getMiddle());
            if (element.getLeft() != null)
                stack.push(element.getLeft());
        }

        return countDevices;
    }

    private static void defineHierarchyLevel(Node element) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(element);
        element.setLevel(1);
        // TODO: Soll je Mitarbeiter die Ebene in der Hierarchie festlegen
        //element.setLevel(1);
        // CEO => 1
        // Abteilungsleiter => 2
        // Teamleiter => 3
        // usw.
        while (!queue.isEmpty()) {
            Node currentElement = queue.poll();

            System.out.println("currentElement = " + currentElement);

            if (currentElement.getLeft() != null) {
                currentElement.getLeft().setLevel(currentElement.getLevel() + 1);
                queue.add(currentElement.getLeft());
            }
            if (currentElement.getMiddle() != null) {
                currentElement.getMiddle().setLevel(currentElement.getLevel() + 1);
                queue.add(currentElement.getMiddle());
            }
            if (currentElement.getRight() != null) {
                currentElement.getRight().setLevel(currentElement.getLevel() + 1);
                queue.add(currentElement.getRight());
            }
        }
    }

    private static int employeesInLevel(Node element, int level){
        Queue<Node> queue = new LinkedList<>();
        queue.add(element);
        element.setLevel(1);
        int counter = 0;
        while (!queue.isEmpty()) {
            Node currentElement = queue.poll();

            if (currentElement.getLevel() == level) {
                counter++;
                continue;
            }

           // System.out.println("currentElement = " + currentElement);

            if (currentElement.getLeft() != null) {
                currentElement.getLeft().setLevel(currentElement.getLevel() + 1);
                queue.add(currentElement.getLeft());
            }
            if (currentElement.getMiddle() != null) {
                currentElement.getMiddle().setLevel(currentElement.getLevel() + 1);
                queue.add(currentElement.getMiddle());
            }
            if (currentElement.getRight() != null) {
                currentElement.getRight().setLevel(currentElement.getLevel() + 1);
                queue.add(currentElement.getRight());
            }
        }
        return counter;
    }

    private static int calculateSalary(Node element) {
        if (element == null)
            return 0;

        System.out.println("element.toString() = " + element.toString());
        
        return element.getSalary() +
                calculateSalary(element.getLeft()) +
                calculateSalary(element.getMiddle()) +
                 calculateSalary(element.getRight());
    }

    private static int calculateSalaryStack(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        Node element = null;
        int salary = 0;
        while (!stack.isEmpty()) {
            element = stack.pop();
            salary += element.getSalary();

            System.out.println("element = " + element);

            if (element.getRight() != null)
                stack.push(element.getRight());
            if (element.getMiddle() != null)
                stack.push(element.getMiddle());
            if (element.getLeft() != null)
                stack.push(element.getLeft());
        }


        return salary;

    }

    private static Node buildTree() {
        Node n1 = new Node("CEO", 1, 5000, 3);
        Node n2 = new Node("Abteilungsleiter Software-Development", 2, 4000, 3);
        Node n3 = new Node("Teamleiter SWT1", 3, 3900, 2);
        Node n4 = new Node("Senior Developer", 4, 3800, 2);
        Node n5 = new Node("Junior Developer", 5, 2600, 1);
        Node n6 = new Node("Teamleiter SWT2", 6, 3200, 2);
        Node n7 = new Node("Junior Developer", 7, 2600, 1);
        Node n8 = new Node("Junior Developer", 8, 2600, 1);
        Node n9 = new Node("Teamleiter SWT3", 9, 3900, 3);
        Node n10 = new Node("Senior Developer", 10, 3700, 2);
        Node n11 = new Node("Senior Developer", 11, 3500, 1);
        Node n12 = new Node("Abteilungsleiter Sales", 12, 4100, 3);
        Node n13 = new Node("Teamleiter ST1", 13, 3500, 2);
        Node n14 = new Node("Sales 1", 14, 3000, 2);
        Node n15 = new Node("Sales 2", 15, 2900, 1);
        Node n16 = new Node("Teamleiter ST2", 16, 3600, 2);
        Node n17 = new Node("Sales 1", 17, 2800, 1);
        Node n18 = new Node("Sales 2", 18, 2900, 2);

        n1.setLeft(n2);
        n1.setRight(n12);

        n2.setLeft(n3);
        n2.setMiddle(n6);
        n2.setRight(n9);

        n3.setLeft(n4);
        n3.setRight(n5);

        n6.setLeft(n7);
        n6.setRight(n8);

        n9.setLeft(n10);
        n9.setRight(n11);

        n12.setLeft(n13);
        n12.setRight(n16);

        n13.setLeft(n14);
        n13.setRight(n15);

        n16.setLeft(n17);
        n16.setRight(n18);

        return n1;
    }
}
