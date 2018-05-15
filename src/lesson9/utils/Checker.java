package lesson9.utils;

public class Checker {
    //public - доступно с любой точки проекта
    //private - доступен внутри этого класса

    //default (package-private) елси ничего не стоит перед объявлением переменных, методов, объектов
    //protected  defautl + наследникам


    int companyNamesValidatedCount = 0;

    public boolean checkCompanyName(String companyName) {
        if (companyNamesValidatedCount > 10)
            return false;

        companyNamesValidatedCount++;
        return companyName != "Google" && companyName != "Amazon";
    }
}
