package lv.hr.test.services;

import lv.hr.test.model.Employee;

import javax.validation.constraints.NotNull;

public interface EmployeeService {

    @NotNull Iterable<Employee> getAllEmployees();
   public Employee create(Employee employee);
  public  void update(Long Id ,Employee employee);
   public  void deleteEmployeeByID(Long Id);

    Employee fetchEmployeeByIdNumber(String idNumber);

    Iterable<Employee> fetchEmployeeBySurname(String surname);
}
