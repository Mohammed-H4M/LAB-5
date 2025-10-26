public class Student {
    private int id;
    private String fullName;
    private int age;
    private String gender;
    private String department;
    private double gpa;

    // Default Constructor
    public Student() {}

    
    public Student(int id, String fullName, int age, String gender, String department, double gpa) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.gpa = gpa;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }

    public double getGpa() {
        return gpa;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Invalid age. It must be positive.");
        }
    }

    public void setGender(String gender) {
        if (gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female")) {
            this.gender = gender;
        } else {
            System.out.println("Invalid gender. Please enter Male or Female.");
        }
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setGpa(double gpa) {
        if (gpa >= 0.0 && gpa <= 4.0) {
            this.gpa = gpa;
        } else {
            System.out.println("Invalid GPA. It must be between 0.0 and 4.0.");
        }
    }

    // toString method to display student information
    @Override
    public String toString() {
        return "Student ID: " + id +
               ", Name: " + fullName +
               ", Age: " + age +
               ", Gender: " + gender +
               ", Department: " + department +
               ", GPA: " + gpa;
    }
}
