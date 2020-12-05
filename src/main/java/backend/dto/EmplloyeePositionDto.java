package backend.dto;

class EmployeePositionDto {
    private String emplPosition;
    private String emplFirstName;
    private String emplLastName;
    private String emplEmail;

    public EmployeePositionDto(String emplPosition, String emplFirstName, String emplLastName, String emplEmail){
        this.emplPosition = emplPosition;
        this.emplFirstName = emplFirstName;
        this.emplLastName = emplLastName;
        this.emplEmail = emplEmail;
    }

    public String getEmplPosition() {
        return emplPosition;
    }

    public void setEmplPosition(String emplPosition) {
        this.emplPosition = emplPosition;
    }

    public String getEmplFirstName() {
        return emplFirstName;
    }

    public void setEmplFirstName(String emplFirstName) {
        this.emplFirstName = emplFirstName;
    }

    public String getEmplLastName() {
        return emplLastName;
    }

    public void setEmplLastName(String emplLastName) {
        this.emplLastName = emplLastName;
    }

    public String getEmplEmail() {
        return emplEmail;
    }

    public void setEmplEmail(String emplEmail) {
        this.emplEmail = emplEmail;
    }

    @Override
    public String toString() {
        return "EmployeePositionDto{" +
                "emplPosition='" + emplPosition + '\'' +
                ", emplFirstName='" + emplFirstName + '\'' +
                ", emplLastName='" + emplLastName + '\'' +
                ", emplEmail='" + emplEmail + '\'' +
                '}';
    }
}
