package programs.utilClasses;

import java.util.Objects;

public class Department {

        private String departmentName;

        private Integer noOfEmployees;

        public Department(String departmentName, Integer noOfEmployees) {
            this.departmentName = departmentName;
            this.noOfEmployees = noOfEmployees;
        }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getNoOfEmployees() {
        return noOfEmployees;
    }

    public void setNoOfEmployees(Integer noOfEmployees) {
        this.noOfEmployees = noOfEmployees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department that)) return false;
        return departmentName.equals(that.departmentName) && noOfEmployees.equals(that.noOfEmployees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentName, noOfEmployees);
    }
}
