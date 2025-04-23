package model;

public class simpleGood implements Good{
    protected String name = "";
    protected float price = 0;
    protected float meanRate = 0;
    protected int rateCount = 0;

    protected simpleGood() {};

    @Override
    public void rate(int rate) {
        rateCount++;
        meanRate = (float) (rateCount - 1) / rateCount * meanRate + (float) rate / rateCount;
    }

    @Override
    public float getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void showOptions() {
        System.out.println("1. add to cart");
        System.out.println("2. rate");
        System.out.println("0. return back");
    }

    @Override
    public String toString() {
        return name + "\n" + "  Price: " + price + "\n" + "  Rate: " + meanRate;
    }
}
