
public class Student extends Person {
    int id;
    int semester;

    Student(String name, int age, int id, int semester) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.semester = semester;
    }

    void showInfo() {
        System.out.println(id);
        System.out.println(semester);
        showAge();
        System.out.println(name);
    }

    public static void main(String args[]) {
        Student std = new Student("Lamim", 22, 13, 2);
        std.showInfo();
    }
}
