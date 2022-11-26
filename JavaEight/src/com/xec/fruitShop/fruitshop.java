package com.xec.fruitShop;


public class fruitshop {
    public static void main(String[] args) throws InterruptedException {

        FruitBuilder fruitBuilder = new FruitBuilder();
        fruitBuilder.addNewFruit("banana", 15, "imran", "kabir");

        /*System.out.println("-----strategy pattern---start");
        boolean isSuccess = shop.displayAvailableFruits(a -> true);
        System.out.println("displayAvailableFruits price is 15");
        shop.displayAvailableFruits(a -> a == 15); // shop.displayFruitsByPrice(4);
        System.out.println("displayAvailableFruits price is greater than 4");
        shop.displayAvailableFruits(a -> a >= 40); // shop.displayFruitsByPriceMoreThen(4);
        System.out.println("-----strategy pattern---end");*/

        fruitBuilder.displayFruitsByPrice(15);
        fruitBuilder.displayFruitsByPriceMoreThen(15);
        fruitBuilder.displayAveragePriceByFruit("banana");

        fruitBuilder.displayAveragePriceforAvailableFruits();
        fruitBuilder.displayCheaperFruit();
        fruitBuilder.displayCostlyFruit();
        fruitBuilder.displayMaxPriceOfEachFruit();
        fruitBuilder.displayTotalNumberOfFruitsByName();


        fruitBuilder.displayFruitsByPriceCategory(3);
        fruitBuilder.displayAllVendors();
        fruitBuilder.displayAllVendorsAndFruits();
        fruitBuilder.displayAllVendorsByFruit("apple");
        fruitBuilder.displayAllFruitsAndVendorsByFruit("apple");
        fruitBuilder.displayAllFruitsByVendor("Imran");

        fruitBuilder.displayAllPricesOfSelectedFruit("apple");
        fruitBuilder.displayChepestPrice("apple");
        fruitBuilder.displayCAveragePrice("apple");



        fruitBuilder.sortAllFruitsByPrice();
        fruitBuilder.sortAllFruitsByPricebyMax();
        fruitBuilder.sortAllFruitsByIncreasingFruitName();
        fruitBuilder.getminFruit();
        fruitBuilder.getmaxFruit();
        fruitBuilder.printAllFruitNamesByConvertingToArray();
        int quantity=101;
        fruitBuilder.getAllFruitQuantityLessThan(quantity);
        fruitBuilder.displayAllFruitsByVendorRedesign("imran");

        fruitBuilder.printFruits(fruitBuilder.getFruits(),f->f.getPrice()>100);
        //

        fruitBuilder.displayTotalNumberOfFruitsByName();

    }



    static void recalculatePrice(FruitBuilder fruitBuilder) throws InterruptedException {

        System.out.println(fruitBuilder.getPrices());

    }
}





