package lab2.lab2_2;

import java.util.Arrays;
import java.util.Optional;

class Faculty {
    String name;
    Student [] students;

    public Faculty(String name, Student[] students)
    {
        this.name = name;
        this.students = students;
    }

    public int countStudentsFromCity(String cityName)
    {
        return Arrays.stream(students).reduce(0, (n, s1) -> n + (s1.city.equals(cityName) ? 1 : 0), Integer::sum);
    }

    public Student getStudent(long index)
    {
        Optional<Student> student = Arrays.stream(students).filter(student1 -> student1.getIndex() == index).findFirst();
        if(student.isPresent())
        {
            return student.get();
        }
        return null;
    }

    public double getAverageNumberOfContacts()
    {
        return Arrays.stream(students).mapToInt(student -> student.getContactsCount()).sum() / (double) students.length;
    }

    public Student getStudentWithMostContacts()
    {
        int most = 0;
        for(int i = 1; i < students.length; i++)
        {
            if(students[i].getContactsCount() > students[most].getContactsCount())
            {
                most = i;
            }
            else if(students[i].getContactsCount() == students[most].getContactsCount())
            {
                most = students[i].getIndex() > students[most].getIndex() ? i : most;
            }
        }
        return students[most];
    }

    @Override
    public String toString() {
        return "{" +
                "\"fakultet\":\"" + name + '\"' +
                ", \"studenti\":" + Arrays.toString(students) +
                "}";
    }
}
