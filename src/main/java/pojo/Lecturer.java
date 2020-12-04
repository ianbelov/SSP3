package pojo;

import javax.persistence.*;

@Entity
@Table(name = "lecturer")
public class Lecturer {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int lecturerID;

    @Column(name = "name")
    private String lecturerName;

    public Lecturer() {
    }

    public Lecturer(String lecturerName) {
        this.lecturerName = lecturerName;
    }

    public Lecturer(int lecturerID, String lecturerName) {
        this.lecturerID = lecturerID;
        this.lecturerName = lecturerName;
    }

    public int getLecturerID() {
        return lecturerID;
    }

    public void setLecturerID(int lecturerID) {
        this.lecturerID = lecturerID;
    }

    public String getLecturerName() {
        return lecturerName;
    }

    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
    }
}