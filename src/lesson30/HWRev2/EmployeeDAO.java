package lesson30.HWRev2;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

public class EmployeeDAO {
    Set<Employee> employeesList = new TreeSet<>();


    public EmployeeDAO() {
    }

    public EmployeeDAO(Set<Employee> employeesList) {
        this.employeesList = employeesList;
    }

    public Set<Employee> getEmployeesList() {
        return employeesList;
    }

    public void save(Employee element) {
        employeesList.add(element);
    }


    public Set<Employee> employeesByProject(String projectName) {//список сотрудников, работающих над заданным проектом
        Set<Employee> resList = new TreeSet<>();
        for (Employee employee : employeesList) {
            if (employee.worksByProject(projectName)) {
                resList.add(employee);
            }
        }
        return resList;
    }


    public Set<Project> projectsByEmployee(Employee employee) {// список проектов, в которых участвует заданный сотрудник

        return employee.getProjects();
    }


    public Set<Employee> employeesWithoutProject() {//список сотрудников, не участвующих ни в одном проекте
        Set<Employee> resSet = new TreeSet<>();
        for (Employee employee : employeesList) {
            if (employee.getProjects() == null)
                resSet.add(employee);
        }
        return resSet;
    }


    public Set<Employee> employeesByTeamLead(Employee lead) {//список подчиненных для заданного руководителя (по всем проектам которыми он руководит)
        if (lead.getPosition() != Position.TEAM_LEAD)
            return null;
        Set<Project> teamLeadProjects = new TreeSet<>();
        teamLeadProjects = lead.getProjects();
        Set<Employee> employeeList = new TreeSet<>();
        for (Project pr : teamLeadProjects) {
            employeeList = employeesByProject(pr.getName());
            employeeList.addAll(employeeList);
        }
        employeeList.remove(lead);
        return employeeList;
    }


    public Set<Employee> teamByEmployee(Employee employee) {
        Set<Employee> resList = new TreeSet<>();

        Set<Project> projects = projectsByEmployee(employee);
        for (Project pr : projects) {
            String projectName = pr.getName();
            resList.addAll(employeesByProject(projectName));
        }
        return resList;
    }


    public Set<Employee> teamLeadsByEmployee(Employee employee) {//Список руководителей для заданного сотрудника (по всем проектам, в которых он участвует)
        Set<Employee> resList = new TreeSet<>();

        for (Employee emp : teamByEmployee(employee)) {
            if (emp.getPosition() == Position.TEAM_LEAD) {
                resList.add(emp);
            }
        }

        return resList;
    }


    public Set<Employee> employeesByProjectEmployee(Employee employee) {//Список сотруднгиков, участвующих в тех же проектах что и заданный сотрудник
        Set<Employee> resList = new TreeSet<>();

        for (Employee emp : teamByEmployee(employee)) {
            if (emp.getPosition() != Position.TEAM_LEAD) {
                resList.add(emp);
            }
        }

        return resList;
    }


    public Set<Employee> employeesByDepartmentWithoutProject(Department department) { //список сотрудников заданного департамента без проектов

        Set<Employee> resEmployeeList = new TreeSet<>();

        for (Employee emp : employeesWithoutProject()) {
            if (department.equals(emp.getDepartment())) {
                resEmployeeList.add(emp);
            }
        }
        return resEmployeeList;
    }


}
