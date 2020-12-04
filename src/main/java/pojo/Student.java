package pojo;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    private String studentName;
    @Column(name = "class_id")
    private int class_id;

    public Student() {
    }

    public Student(String studentName, Class class_id) {
        this.studentName = studentName;
        this.class_id = class_id.getId();
    }

    public Student(int id, String studentName, Class class_id) {
        this.id = id;
        this.studentName = studentName;
        this.class_id = class_id.getId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(Class class_id) {
        this.class_id = class_id.getId();
    }

}