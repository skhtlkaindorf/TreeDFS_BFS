public class Node {
    private String name;
    private int salary;
    private int countDevices;
    private int id;
    private Node left;
    private Node middle;
    private Node right;
    private int level;


    public Node(String name, int id, int salary, int countDevices) {
        this.name = name;
        this.salary = salary;
        this.countDevices = countDevices;
        this.id = id;
        this.level = -1;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", countDevices=" + countDevices +
                ", id=" + id +
                ", level=" + (level == -1 ? "'Not defined yet'" : "Ebene: " + level) +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getCountDevices() {
        return countDevices;
    }

    public void setCountDevices(int countDevices) {
        this.countDevices = countDevices;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getMiddle() {
        return middle;
    }

    public void setMiddle(Node middle) {
        this.middle = middle;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
