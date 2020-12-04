package pojo;

import javax.persistence.*;

@Entity
@Table(name = "class")
public class Class {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    private String className;
    @Column(name = "lecturer_id")
    private int lecturer_id;

    public Class() {
    }

    public Class(String className, Lecturer lecturer_id) {
        this.className = className;
        this.lecturer_id = lecturer_id.getLecturerID();
    }

    public Class(int id, String className, Lecturer lecturer_id) {
        this.id = id;
        this.className = className;
        this.lecturer_id = lecturer_id.getLecturerID();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getLecturer_id() {
        return lecturer_id;
    }

    public void setLecturer_id(Lecturer lecturer) {
        this.lecturer_id = lecturer.getLecturerID();
    }

}