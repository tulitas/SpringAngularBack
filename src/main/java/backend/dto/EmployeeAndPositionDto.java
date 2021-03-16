package backend.dto;

public class EmployeeAndPositionDto {
    private String empFirstName;
    private String empLastName;
    private String empEmail;
    private String empPosition;

    public EmployeeAndPositionDto(String empFirstName, String empLastName, String empEmail, String empPosition ){
        this.empFirstName = empFirstName;
        this.empLastName = empLastName;
        this.empEmail = empEmail;
        this.empPosition = empPosition;
    }

    public String getEmpFirstName() {
        return empFirstName;
    }

    public void setEmpFirstName(String empFirstName) {
        this.empFirstName = empFirstName;
    }

    public String getEmpLastName() {
        return empLastName;
    }

    public void setEmpLastName(String empLastName) {
        this.empLastName = empLastName;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getEmpPosition() {
        return empPosition;
    }

    public void setEmpPosition(String empPosition) {
        this.empPosition = empPosition;
    }

    @Override
    public String toString() {
        return "EmployeeAndPositionDto{" +
                "empFirstName='" + empFirstName + '\'' +
                ", empLastName='" + empLastName + '\'' +
                ", empEmail='" + empEmail + '\'' +
                ", empPosition='" + empPosition + '\'' +
                '}';
    }
}
