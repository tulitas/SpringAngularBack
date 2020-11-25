package backend.model;

import javax.persistence.*;

@Entity
@Table(name = "employeePositions")
public class EmployeePosition implements java.io.Serializable{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "position")
    private String position;

    @Column(name = "employeeId")
    private long employeeId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "EmployeePosition{" +
                "id=" + id +
                ", position='" + position + '\'' +
                ", employeeId=" + employeeId +
                '}';
    }
}
