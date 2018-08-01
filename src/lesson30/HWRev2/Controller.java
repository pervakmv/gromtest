package lesson30.HWRev2;

import java.util.Set;
import java.util.TreeSet;


public class Controller {
    private FirmDAO firmDAO = new FirmDAO();
    private EmployeeDAO employeeDAO = new EmployeeDAO();
    private DepartmentDAO departmentDAO = new DepartmentDAO();
    private ProjectDAO projectDAO = new ProjectDAO();
    private CustomerDAO customerDAO = new CustomerDAO();

    public Controller(FirmDAO firmDAO, EmployeeDAO employeeDAO, DepartmentDAO departmentDAO, ProjectDAO projectDAO, CustomerDAO customerDAO) {
        this.firmDAO = firmDAO;
        this.employeeDAO = employeeDAO;
        this.departmentDAO = departmentDAO;
        this.projectDAO = projectDAO;
        this.customerDAO = customerDAO;
    }


    public Set<Employee> employeesByProject(String projectName) {//список сотрудников, работающих над заданным проектом

        return employeeDAO.employeesByProject(projectName);
    }


    public Set<Project> projectsByEmployee(Employee employee) {// список проектов, в которых участвует заданный сотрудник

        return employeeDAO.projectsByEmployee(employee);
    }

    public Set<Employee> employeesByDepartmentWithoutProject(Department department) {

        return employeeDAO.employeesByDepartmentWithoutProject(department);
    }

    public Set<Employee> employeesWithoutProject() {//список сотрудников, не участвующих ни в одном проекте

        return employeeDAO.employeesWithoutProject();
    }


    public Set<Employee> employeesByTeamLead(Employee lead) {//список подчиненных для заданного руководителя (по всем проектам которыми он руководит)

        return employeeDAO.employeesByTeamLead(lead);
    }


    public Set<Employee> teamLeadsByEmployee(Employee employee) {//Список руководителей для заданного сотрудника (по всем проектам, в которых он участвует)

        return employeeDAO.teamLeadsByEmployee(employee);
    }


    public Set<Employee> employeesByProjectEmployee(Employee employee) {//Список сотруднгиков, участвующих в тех же проектах что и заданный сотрудник

        return employeeDAO.employeesByProjectEmployee(employee);
    }


    public Set<Project> projectsByCustomer(Customer customer) {//Список проектов выполняемых для данного заказчика

        return projectDAO.projectsByCustomer(customer);

    }


    public Set<Employee> employeesByCustomerProjects(Customer customer) {//список сотрудников, участвующих в проектах, выполняемых для заданного заказчика
        Set<Employee> resSet = new TreeSet<>();
        for (Project prg : projectsByCustomer(customer)) {
            resSet.addAll(employeeDAO.employeesByProject(prg.getName()));
        }
        return resSet;
    }

}







