
package dto;

import entities.Employee;


public class EmployeeDTO {
    private String name;
    private String address;

    public EmployeeDTO(Employee employee) {
        this.name = employee.getName();
        this.address = employee.getAddress();
    }
}
