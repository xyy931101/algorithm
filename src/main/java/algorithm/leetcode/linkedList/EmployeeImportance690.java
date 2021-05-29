package algorithm.leetcode.linkedList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 690. 员工的重要性
 * @Author: Xiongyy
 * @Date: 2021/5/1 23:04
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class EmployeeImportance690 {

    Map<Integer, Employee> employeeMap = new HashMap<>();

    public int getImportance(List<Employee> employees, int id) {
        if (employees == null || employees.size() == 0) {
            return 0;
        }
        for (Employee employee : employees) {
            employeeMap.put(employee.id, employee);
        }
        Employee employee = employeeMap.get(id);
        return process(employee);
    }

    private int process(Employee employee) {
        Integer value = employee.importance;
        if (employee.subordinates != null && employee.subordinates.size() > 0) {
            for (Integer childId :  employee.getSubordinates()) {
                if (employeeMap.get(childId) != null) {
                    value =  value + process(employeeMap.get(childId));
                }
            }
        }
        return value.intValue();
    }
}
