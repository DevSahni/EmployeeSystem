package com.emp.EmpSystem.service;

import com.emp.EmpSystem.entity.Employee;
import com.emp.EmpSystem.repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Empservice {

    @Autowired
    private EmpRepo repo;

    public void addEmp(Employee e) {
        repo.save(e);
    }

    public List<Employee> getAllEmp() {
        return repo.findAll();
    }

    // Edit by user, update value logic
    public Employee getEmpById(int id) {
        Optional<Employee> e = repo.findById(id);
        return e.orElse(null);
    }

    // Delete method service
    public void deleteEmp(int id) {
        repo.deleteById(id);
    }
}
