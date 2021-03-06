package backend.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "employeePositions")
public class EmployeePosition implements java.io.Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
    private long id;

    @Column(name = "position")
    private String position;

    @OneToMany(targetEntity = Employee.class,
            mappedBy = "id",
            orphanRemoval = false,
            fetch = FetchType.LAZY)
    private Set<Employee> employees;

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

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


    @Override
    public String toString() {
        return "EmployeePosition{" +
                "id=" + id +
                ", position='" + position + '\'' +
                ", employees=" + employees +
                '}';
    }
}
