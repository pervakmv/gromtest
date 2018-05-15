package lesson8.accounts.housework2;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {

        Date curDate = new Date();
        Course courses[] = new Course[3];
        Student student[] = new Student[3];

        courses[0] = new Course(curDate, "JavaCore", 180, "Andrey",student  );
        courses[1] = new Course(curDate, "JavaWeb", 180, "Andrey",student  );
        courses[2] = new Course(curDate, "JavaScript", 180, "Andrey",student  );


        student[0] = new Student("Mykola", "Pervak", 2, courses);
        student[1] = new Student("Slava", "Kononenko",  2, courses);
        student[2] = new Student("Serg", "Skoric", 2, courses);

        SpecialStudent specialStudent = createLowestChild();
        System.out.println(specialStudent.firstName);

        Student students = createHighestParent();
        System.out.println(students.firstName);
    }

    public static SpecialStudent createLowestChild(){
        Course courses[] = new Course[3];
        return new SpecialStudent("Nikolay", "Pervak", 2, courses,40,"pervakmv@elas.kiev.ua");
    }

    public static Student createHighestParent(){
        Course courses[] = new Course[3];
        return new Student("Slava", "Kononenko", 2, courses);
    }

}
