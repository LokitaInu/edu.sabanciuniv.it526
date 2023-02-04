package test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Student;

import java.util.ArrayList;
import java.util.List;

public class TestStudent {

    public static void main(String[] args){
        Student student1 = new Student("Betul", "Gulcam", "xyz@gmail.com");
        Student student2 = new Student("Zeynep", "Basarı", "abc@hotmail.com");
        Student student3 = new Student("Deniz", "Dora", "klm@gmail.com");

        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqlPU");
        EntityManager entityManager = emf.createEntityManager();

        saveStudents(studentList, entityManager);
        updateStudentEmail(entityManager, student3, "mss@gmail.com");

    }


    private static void updateStudentEmail(EntityManager entityManager, Student student3, String newEmail) {
        entityManager.getTransaction().begin();

        Student foundStudent = entityManager.createQuery("FROM Student s WHERE s.studentName = :strName", Student.class)
                .setParameter("strName", student3.getStudentName())
                .getSingleResult();
        foundStudent.setStudentEmail(newEmail);
        entityManager.merge(foundStudent);

        entityManager.getTransaction().commit();
        System.out.println("Student phone updated to : " + newEmail);
    }

    private static void saveStudents(List<Student> studentList, EntityManager entityManager) {
        for (Student student : studentList) {
            entityManager.getTransaction().begin();
            entityManager.persist(student);
            entityManager.getTransaction().commit();
        }
    }
}
