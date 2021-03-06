package lv.hr.test.controllers;


import lv.hr.test.model.Employee;

import lv.hr.test.services.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/")//standard(api/v1) url endpoint used for apis
//@Api(value="", tags={"Employee service"})
//@Tag(name="Employee service", description = "Service for employee")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees/{id}")
    public Employee fetchEmployeeById(@PathVariable("id") Long Id){
        return employeeService.fetchEmployeeByID(Id);
    }





//get all Employees

//    @GetMapping("/employees/paging")
//    public ResponseEntity<List<Employee>> getAllEmployeesByPages(
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "10") int  size,
//            @RequestParam(defaultValue = "10")String sortBy)
//    {
//        List<Employee> employees = employeeService.getAllEmployees2(page, size);
//
//        Map<String, Object> response = new HashMap<>();
//        Page<Employee> pageEmployees;
//
//                pageEmployees = employeeService.findAll(Pageable.unpaged());
//            response.put("employees", employees);
//            response.put("currentPage", pageEmployees.getNumber());
//            response.put("totalItems", pageEmployees.getTotalElements());
//            response.put("totalPages", pageEmployees.getTotalPages());
//
//        return new ResponseEntity<List<Employee>>(employees, new HttpHeaders(), HttpStatus.OK);
//    }


//    @GetMapping("/employees/paging")
//    public ResponseEntity<Map<String, Object>> getAllEmployees2(
////            @RequestParam(required = false) String title,
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "6") int size)
//
//     {
//
////        try {
//            List<Employee> employees = new ArrayList<Employee>();
//            Pageable paging = PageRequest.of(page, size);
//
//            Page<Employee> pageEmployees;
////            if (title == null)
//                pageEmployees = employeeService.findAll(paging);
////            else
////                pageTuts = tutorialRepository.findByTitleContaining(title, paging);
//
//            employees = pageEmployees.getContent();
//
//            Map<String, Object> response = new HashMap<>();
//            response.put("employees", employees);
//            response.put("currentPage", pageEmployees.getNumber());
//            response.put("totalItems", pageEmployees.getTotalElements());
//            response.put("totalPages", pageEmployees.getTotalPages());
//
//            return new ResponseEntity<>(response, HttpStatus.OK);
////        } catch (Exception e) {
////            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
////        }
//    }
//@GetMapping("/employees/{field}")
//    public Iterable<Employee>  getAllEmployeesWithSort(@RequestParam (defaultValue = "id")String field){
//
//        return employeeService.findAllEmployeesWithSorting(field);
//    }
////
    @GetMapping("/employees/{page}/{size}")
    public Iterable<Employee>  getAllEmployeesWithPagination(@RequestParam (defaultValue = "0") int page,@RequestParam (defaultValue = "3") int size){

        return employeeService.findAllEmployeesWithPagination(page, size);
    }
//
//    @GetMapping("/employees/{page}/{size}/{field}")
//    public Iterable<Employee>  getAllEmployeesWithPaginationAndSorting(@RequestParam (defaultValue = "0") int page,
//                                                                       @RequestParam (defaultValue = "3") int size,
//                                                                       @RequestParam (defaultValue = "id")String field)
//    {
//
//        return employeeService.findAllEmployeesWithPaginationAndSorting(page, size, field);
//    }

    @GetMapping("/employees")
    public Iterable<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
    @GetMapping("/employees/sort-by-name")
    public Iterable<Employee> sortAllEmployeesByName() {
        return employeeService.sortAllEmployeesByName();
    }
    @GetMapping("/employees/sort-by-surname")
    public Iterable<Employee> sortAllEmployeesBySurname() {
        return employeeService.sortAllEmployeesBySurname();
    }

//  add new employee

    @PostMapping("/employees")
//    @ApiOperation("adding new employee to database")
    public void addNewEmployee(@RequestBody Employee employee) {
        employeeService.create(employee);
    }

    @PutMapping("/employees/{id}")
    public void updateEmployee(@PathVariable("id") Long Id, @RequestBody Employee employee) {
        employeeService.update(Id, employee);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployeeById(@PathVariable("id") Long Id) {
        employeeService.deleteEmployeeByID(Id);
    }

    @GetMapping("/employees/id-number/{id-number}")
    public Employee fetchEmployeeByIdNumber(@PathVariable ("id-number") String idNumber) {
        return employeeService.fetchEmployeeByIdNumber(idNumber);
    }
    @GetMapping("/employees/surname/{surname}")
    public Iterable<Employee> fetchEmployeeBySurname(@PathVariable ("surname") String surname){
        return employeeService.fetchEmployeeBySurname(surname);
    }



}
