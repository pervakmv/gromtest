package lesson9;

import lesson9.utils.Checker;

public class Demo {
    public static void main(String[] args) {
        Company company = new Company();
        //Sys.out.println(company.countryFounded);
        System.out.println(company.getName());

        //company.name = "IBM";

        Checker checker = new Checker();
        System.out.println(checker.checkCompanyName(company.getName()));
        //Sys.out.println(checker.companyNamesValidatedCount);
        System.out.println(company.code);


    }

}
