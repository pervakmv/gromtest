package lesson1;

import lesson9.Company;

import java.util.logging.SocketHandler;

public class FinancialCompany extends Company {
    public static void main(String[] args) {
        //Sys.out.println(this.code); code не доступний тому що не статичний
    }

    void demostrateProtectedModifier(){
        System.out.println(this.code);
        System.out.println(this.someField);
    }
}
