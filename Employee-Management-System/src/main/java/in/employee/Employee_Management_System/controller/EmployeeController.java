package in.employee.Employee_Management_System.controller;

import in.employee.Employee_Management_System.entity.Employee;
import in.employee.Employee_Management_System.service.EmployeeService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

//  1. Create Employee

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        Employee created = employeeService.saveEmployee(employee);
        return ResponseEntity.status(200).body(created);
    }

//    2. Read one

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id){
        Employee getEmployee = employeeService.findEmployee(id);

        if(getEmployee == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(getEmployee);
    }

    @GetMapping("")
    public ResponseEntity<List<Employee>> getAllEmployee() {
        List<Employee> allEmployee = employeeService.findAllEmployee();

        if(allEmployee.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(allEmployee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateStudent(@PathVariable Long id,
                                                    @RequestBody Employee employee){
        Employee updated = employeeService.toBeUpdated(id, employee);
        if(updated == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
        Boolean isDeleted = employeeService.toBeDeleted(id);
        if(!isDeleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Employee deleted");
    }



}
