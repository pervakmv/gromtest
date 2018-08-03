package Eratosfen;

public class Element {
    private int firstNumber;
    private int secondNumber;
    private long prodact;

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public void setProdact(long prodact) {
        this.prodact = prodact;
    }

    public Element(int firstNumber, int secondNumber, long prodact) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.prodact = prodact;
    }

    public Element() {
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public long getProdact() {
        return prodact;
    }

    @Override
    public String toString() {
        return "Element{" +
                "firstNumber=" + firstNumber +
                ", secondNumber=" + secondNumber +
                ", prodact=" + prodact +
                '}';
    }
}
