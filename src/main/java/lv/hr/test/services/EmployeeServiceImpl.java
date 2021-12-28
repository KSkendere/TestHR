package lv.hr.test.services;

import lv.hr.test.model.Employee;
import lv.hr.test.repositories.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Iterable<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void update(Long Id, Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployeeByID(Long Id) {
        employeeRepository.deleteById(Id);

    }

    @Override
    public Employee fetchEmployeeByID(Long Id) {
        return employeeRepository.findById(Id).get();

    }

    @Override
    public Employee fetchEmployeeByIdNumber(String idNumber) {
        return employeeRepository.findByIdNumber(idNumber);
    }

    @Override
    public Iterable<Employee> fetchEmployeeBySurname(String surname) {
        return employeeRepository.findBySurname(surname);
    }

    @Override
    public Iterable<Employee> sortAllEmployeesByName() {
        return employeeRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    @Override
    public Page<Employee> findAll (Pageable pageable){
        return employeeRepository.findAll(pageable);
    }

//    @Override
//    public Iterable<Employee> getAllForage() {
//        return employeeRepository.findAll(Pageable paegable);
//    }
}

