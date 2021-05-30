package dev.fahd.springredis.service;

import dev.fahd.springredis.dto.EmployeeDTO;
import dev.fahd.springredis.entity.Employee;
import dev.fahd.springredis.exception.DataNotFoundException;
import dev.fahd.springredis.mapper.EmployeeMapper;
import dev.fahd.springredis.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmployeeService {
    
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;


    public EmployeeDTO create(EmployeeDTO employeeDTO) {
        employeeRepository.save(employeeMapper.toEntity(employeeDTO));
        return employeeDTO;
    }

    public EmployeeDTO getById(Long id) throws DataNotFoundException {
        Employee employee = employeeRepository.findById(id).orElseThrow(DataNotFoundException::new);
        return employeeMapper.toDto(employee);
    }

    public List<EmployeeDTO> getAll() {
        List<Employee> employees = employeeRepository.findAll();
        return employeeMapper.toDto(employees);
    }

    public EmployeeDTO update(Long id, EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.toEntity(employeeDTO);
        employee.setId(id);
        employeeRepository.save(employee);
        return employeeDTO;
    }

    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }
}
