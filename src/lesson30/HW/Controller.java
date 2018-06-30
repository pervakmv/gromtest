package lesson30.HW;

import java.util.*;


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

    public ArrayList<String> employeesByProject(String projectName) {//список сотрудников, работающих над заданным проектом
        ArrayList<String> resList = new ArrayList<>();

        Set<Employee> employeeList = employeeDAO.getAll();

        for (Employee element : employeeList) {
            Collection<Project> projectsList = element.getProjects();
            if (projectsList == null)
                break;
            for (Project project : projectsList) {
                if (project.getName().equals(projectName)) {
                    String firstNameAndLastName = element.getFirstName() + " " + element.getLastName();
                    resList.add(firstNameAndLastName);
                    break;
                }
            }

        }

        return resList;
    }


    public Collection<Employee> employeesByProject_C(String projectName) {//список сотрудников, работающих над заданным проектом
        Collection<Employee> resList = new TreeSet<>();

        Set<Employee> employeeList = employeeDAO.getAll();

        for (Employee element : employeeList) {

            Collection<Project> projectsList = element.getProjects();
            if (projectsList == null)
                break;
            for (Project project : projectsList) {
                if (project.getName().equals(projectName)) {
                    resList.add(element);
                    break;
                }
            }

        }

        return resList;
    }


    public Collection<Project> projectsByEmployee(Employee employee) {// список проектов, в которых участвует заданный сотрудник
        Collection<Project> projectsList = new TreeSet<>();

        for (Employee empl : employeeDAO.getAll()) {
            if (empl.equals(employee)) {
                projectsList = empl.getProjects();
            }
        }

        return projectsList;
    }

    public Collection<Employee> employeesByDepartmentWithoutProject(Department department) {
        Collection<Department> employeesList = new TreeSet<>();
        Collection<Employee> resEmployeeList = new TreeSet<>();

        for (Department dep : departmentDAO.getAll()) {
            if (dep.equals(department)) {
                Collection<Employee> employeeList = new TreeSet<>();
                employeeList = dep.getEmployees();
                for (Employee emp : employeeList) {
                    if (emp.getProjects() == null) {
                        resEmployeeList.add(emp);
                    }
                }
            }
        }
        return resEmployeeList;
    }

    public Collection<Employee> employeesWithoutProject() {//список сотрудников, не участвующих ни в одном проекте
        Collection<Employee> employeeList = new TreeSet<>();

        Collection<Firm> firmsList = new TreeSet<>();

        firmsList = firmDAO.getAll();
        for (Firm f : firmsList) {
            Collection<Department> departments = new TreeSet<>();
            departments = f.getDepartments();
            Collection<Employee> employees = new TreeSet<>();
            for (Department d : departments) {
                employees = employeesByDepartmentWithoutProject(d);
                employeeList.addAll(employees);
            }

        }
        return employeeList;
    }


    public Collection<Employee> employeesByTeamLead(Employee lead) {//список подчиненных для заданного руководителя (по всем проектам которыми он руководит)
        if (lead.getPosition() != Position.TEAM_LEAD)
            return null;
        Collection<Project> teamLeadProjects = new TreeSet<>();
        teamLeadProjects = lead.getProjects();
        Collection<Employee> employeeList = new TreeSet<>();
        for (Project pr : teamLeadProjects) {
            employeeList = employeesByProject_C(pr.getName());
            employeeList.addAll(employeeList);
        }
        employeeList.remove(lead);
        return employeeList;
    }

    public Set<Employee> teamByEmployee(Employee employee) {
        Collection<Employee> resList = new TreeSet<>();

        Collection<Project> projects = projectsByEmployee(employee);
        for (Project pr : projects) {
            String projectName = pr.getName();
            resList.addAll(employeesByProject_C(projectName));
        }
        return (Set)resList;
    }

    public Set<Employee> teamLeadsByEmployee(Employee employee) {//Список руководителей для заданного сотрудника (по всем проектам, в которых он участвует)
        Set<Employee> resList = new TreeSet<>();
        Set<Employee> tempList = new TreeSet<>();

        tempList = teamByEmployee(employee);
        for (Employee emp : tempList) {
            if (emp.getPosition() == Position.TEAM_LEAD) {
                resList.add(emp);
            }
        }

        return resList;
    }


    public Set<Employee> employeesByProjectEmployee(Employee employee) {//Список сотруднгиков, участвующих в тех же проектах что и заданный сотрудник
        Set<Employee> resList = new TreeSet<>();
        Set<Employee> tempList = new TreeSet<>();

        tempList = teamByEmployee(employee);
        for (Employee emp : tempList) {
            if (emp.getPosition() != Position.TEAM_LEAD) {
                resList.add(emp);
            }
        }

        return resList;
    }


    public Set<Project> projectsByCustomer(Customer customer) {//Список проектов выполняемых для данного заказчика
        Set<Project> resList = new TreeSet<>();

        for (Project prg : projectDAO.getAll()) {
            if (prg.getCustomer().equals(customer)) {
                resList.add(prg);
            }
        }
        return resList;

    }


    public Set<Employee> employeesByCustomerProjects(Customer customer) {//список сотрудников, участвующих в проектах, выполняемых для заданного заказчика
        Set<Employee> resList = new TreeSet<>();
        Set<Project> projects = new TreeSet<>();

        projects = projectsByCustomer(customer);
        for (Project prg : projects) {
            resList.addAll(employeesByProject_C(prg.getName()));
        }
        return resList;
    }


}







