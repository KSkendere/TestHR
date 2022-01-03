package lv.hr.test.services;

import lv.hr.test.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    @NotNull Iterable<Employee> getAllEmployees();
   public Employee create(Employee employee);
  public  void update(Long Id ,Employee employee);
   public  void deleteEmployeeByID(Long Id);
  Employee fetchEmployeeByID(Long Id);

    Employee fetchEmployeeByIdNumber(String idNumber);

    Iterable<Employee> fetchEmployeeBySurname(String surname);

    @NotNull Iterable<Employee> sortAllEmployeesByName();
//
    Page<Employee> findAll(Pageable pageable);

    List<Employee> getAllEmployees2(int page, int size);

//    Iterable<Employee> getAllForage();

Iterable<Employee>findAllEmployeesWithPagination(int page, int size);

    Iterable<Employee> findAllEmployeesWithSorting(String field);

    Iterable<Employee>findAllEmployeesWithPaginationAndSorting(int page, int size, String field);

    @NotNull Iterable<Employee> sortAllEmployeesBySurname();
}


