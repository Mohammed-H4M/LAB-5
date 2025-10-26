import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private List<Student> students;
    private static final String FILE_NAME = "students.dat";
    
    public StudentManager() {
        students = new ArrayList<>();
        loadStudentsFromFile();
    }
    
    public void addStudent(Student student) {
        students.add(student);
        saveStudentsToFile();
    }
    
    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }
    
    public Student findStudentById(String studentId) {
        int id = Integer.parseInt(studentId);
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
    
    public List<Student> findStudentsByName(String name) {
        List<Student> foundStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.getFullName().toLowerCase().contains(name.toLowerCase())) {
                foundStudents.add(student);
            }
        }
        return foundStudents;
    }
    
    public boolean updateStudent(String studentId, Student updatedStudent) {
        int id = Integer.parseInt(studentId);
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.set(i, updatedStudent);
                saveStudentsToFile();
                return true;
            }
        }
        return false;
    }
    
    public boolean deleteStudent(String studentId) {
        int id = Integer.parseInt(studentId);
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.remove(i);
                saveStudentsToFile();
                return true;
            }
        }
        return false;
    }
    
    @SuppressWarnings("unchecked")
    private void loadStudentsFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            students = (List<Student>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No previous data found. Starting with empty list.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading students: " + e.getMessage());
        }
    }
    
    private void saveStudentsToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(students);
        } catch (IOException e) {
            System.out.println("Error saving students: " + e.getMessage());
        }
    }
}
