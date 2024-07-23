package com.maximilian.interview.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/employee-importance/description/">Link to a task</a>
 * You have a data structure of employee information, including the employee's unique ID,
 * importance value, and direct subordinates' IDs.
 * <p>
 * You are given an array of employees "employees" where:
 * <p>
 * employees[i].id is the ID of the ith employee.
 * employees[i].importance is the importance value of the ith employee.
 * employees[i].subordinates is a list of the IDs of the direct subordinates of the ith employee.
 * Given an integer id that represents an employee's ID, return the total importance
 * value of this employee and all their direct and indirect subordinates.
 * <p>
 * Constraints:
 * <p>
 * 1 <= employees.length <= 2000
 * 1 <= employees[i].id <= 2000
 * All employees[i].id are unique.
 * -100 <= employees[i].importance <= 100
 * One employee has at most one direct leader and may have several subordinates.
 * The IDs in employees[i].subordinates are valid IDs.
 */
public class EmployeeImportance {

    public static int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> employeeMap = new HashMap<>();
        for (Employee employee : employees) {
            employeeMap.put(employee.id, employee);
        }
        Employee currentEmployee = employeeMap.get(id);
        return currentEmployee.importance +
                calculateImportance(employeeMap, currentEmployee.subordinates);
    }

    private static int calculateImportance(Map<Integer, Employee> employeeMap, List<Integer> ids) {
        if (ids.isEmpty()) {
            return 0;
        }
        int result = 0;
        List<Integer> newIds = new LinkedList<>();
        for (int id : ids) {
            Employee employee = employeeMap.get(id);
            result += employee.importance;
            newIds.addAll(employee.subordinates);
        }
        return result + calculateImportance(employeeMap, newIds);
    }

    public static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

}
