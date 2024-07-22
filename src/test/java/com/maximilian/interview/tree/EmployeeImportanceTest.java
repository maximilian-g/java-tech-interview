package com.maximilian.interview.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class EmployeeImportanceTest {

    @Test
    void getImportance() {
        List<EmployeeImportance.Employee> employeeList = new LinkedList<>();
        EmployeeImportance.Employee emp1 = new EmployeeImportance.Employee();
        emp1.id = 1;
        emp1.importance = 5;
        emp1.subordinates = Arrays.asList(2, 3);
        EmployeeImportance.Employee emp2 = new EmployeeImportance.Employee();
        emp2.id = 2;
        emp2.importance = 3;
        emp2.subordinates = new ArrayList<>();
        EmployeeImportance.Employee emp3 = new EmployeeImportance.Employee();
        emp3.id = 3;
        emp3.importance = 3;
        emp3.subordinates = new ArrayList<>();
        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);

        int expected = 11;
        Assertions.assertEquals(expected, EmployeeImportance.getImportance(employeeList, 1));
        expected = 3;
        Assertions.assertEquals(expected, EmployeeImportance.getImportance(employeeList, 2));
        Assertions.assertEquals(expected, EmployeeImportance.getImportance(employeeList, 3));
    }

}