package lv.hr.test.repositories;

import lv.hr.test.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    public Employee findByIdNumber(String idNumber);

    public Iterable<Employee> findBySurname(String surname);

}
