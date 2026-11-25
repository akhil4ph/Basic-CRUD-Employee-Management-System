package in.employee.Employee_Management_System.service;

import in.employee.Employee_Management_System.Repository.EmployeeRepository;
import in.employee.Employee_Management_System.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService (EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }

    public Employee saveEmployee(Employee employee){
        Employee EmployeeToSave = employeeRepository.save(employee);
        return EmployeeToSave;
    }

    //    2. Read one

    public Employee findEmployee(Long id){
       Optional<Employee> oneEmployee = employeeRepository.findById(id);

       if(oneEmployee.isPresent()){
           return oneEmployee.get();
       }
       return null;
    }

    public List<Employee> findAllEmployee(){
        List<Employee> allEmployee = employeeRepository.findAll();

        return allEmployee;
    }

    public Employee toBeUpdated(Long id, Employee employee){
        Optional<Employee> existingEmployee = employeeRepository.findById(id);

        if(existingEmployee.isEmpty()) {
            return null;
        }

        Employee employeeToSave = existingEmployee.get();


        employeeToSave.setAge(employee.getAge());
        employeeToSave.setDesignation(employee.getDesignation());
        employeeToSave.setEmail(employee.getEmail());
        employeeToSave.setName(employee.getName());
        employeeToSave.setSalary(employee.getSalary());

        return employeeRepository.save(employeeToSave);
    }

    public Boolean toBeDeleted(Long id){
        Boolean isEmployee = employeeRepository.existsById(id);
        if(!isEmployee){
            return false;
        }
        employeeRepository.deleteById(id);
        return true;
    }
}
