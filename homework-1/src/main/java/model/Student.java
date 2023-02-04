package model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String studentName;
    private String studentLastName;
    private String studentEmail;

    public Student (String studentName, String studentLastName, String studentEmail){
        this.studentName=studentName;
        this.studentLastName=studentLastName;
        this.studentEmail=studentEmail;
    }

    public Student(){
    }

    public String getStudentName(){return studentName;}

    public void setStudentName(String studentName){this.studentName=studentName;}

    public String getStudentLastName(){return studentLastName;}
    public void setStudentLastName(String studentLastName){this.studentLastName=studentLastName;}

    public String getStudentEmail(){return studentEmail;}
    public void setStudentEmail(String studentEmail){this.studentEmail=studentEmail;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(studentName, student.studentName) && Objects.equals(studentLastName, student.studentLastName) && Objects.equals(studentEmail, student.studentEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentName, studentLastName, studentEmail);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", studentLastName='" + studentLastName + '\'' +
                ", studentEmail='" + studentEmail + '\'' +
                '}';
    }
}
