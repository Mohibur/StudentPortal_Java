import java.util.*;


class Student {
    private int id;
    private String name;
    private String course;
    private int[] marks; 

    
    public Student(int id, String name, String course, int[] marks) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.marks = marks;
    }

   
    public int getId() { return id; }
    public String getName() { return name; }
    public String getCourse() { return course; }

    
    public int getTotalMarks() {
        int total = 0;
        for (int m : marks) total += m;
        return total;
    }

    
    public String getGrade() {
        double avg = getTotalMarks() / (double) marks.length;
        if (avg >= 90) return "A+";
        else if (avg >= 80) return "A";
        else if (avg >= 70) return "B";
        else if (avg >= 60) return "C";
        else return "D";
    }

    
    public void displayDetails() {
        System.out.println("\nStudent ID: " + id);
        System.out.println("Name      : " + name);
        System.out.println("Course    : " + course);
        System.out.println("Total Marks: " + getTotalMarks());
        System.out.println("Grade     : " + getGrade());
    }
}


class StudentPortal {
    private List<Student> students = new ArrayList<>();

   
    public void addStudent(Student s) {
        students.add(s);
        System.out.println("✅ Student added successfully!");
    }

    
    public void showAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }
        System.out.println("\n===== Student Details =====");
        for (Student s : students) {
            s.displayDetails();
        }
    }

    
    public void findStudentById(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                System.out.println("\nStudent found:");
                s.displayDetails();
                return;
            }
        }
        System.out.println("❌ Student with ID " + id + " not found.");
    }
}


public class StudentPortalApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentPortal portal = new StudentPortal();

        while (true) {
            System.out.println("\n--- Student Portal Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    int[] marks = new int[3];
                    for (int i = 0; i < 3; i++) {
                        System.out.print("Enter marks for subject " + (i + 1) + ": ");
                        marks[i] = sc.nextInt();
                    }
                    Student s = new Student(id, name, course, marks);
                    portal.addStudent(s);
                    break;

                case 2:
                    portal.showAllStudents();
                    break;

                case 3:
                    System.out.print("Enter Student ID to search: ");
                    int searchId = sc.nextInt();
                    portal.findStudentById(searchId);
                    break;

                case 4:
                    System.out.println("Exiting portal. Goodbye!");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
