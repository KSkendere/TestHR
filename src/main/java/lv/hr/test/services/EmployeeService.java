package lv.hr.test.services;

import lv.hr.test.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.validation.constraints.NotNull;
import java.util.Optional;

public interface EmployeeService {

    @NotNull Iterable<Employee> getAllEmployees();
   public Employee create(Employee employee);
  public  void update(Long Id ,Employee employee);
   public  void deleteEmployeeByID(Long Id);
  public  Employee fetchEmployeeByID(Long Id);

    Employee fetchEmployeeByIdNumber(String idNumber);

    Iterable<Employee> fetchEmployeeBySurname(String surname);

    @NotNull Iterable<Employee> sortAllEmployeesByName();

    Page<Employee> findAll(Pageable paging);

//    Iterable<Employee> getAllForage();
}
