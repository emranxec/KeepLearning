package com.xec.fruitShop;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static com.xec.testLazyProxy.proxyPatternJava8;
import static java.util.stream.Collectors.*;

public class FruitBuilder {
    String shopName;
    static final int DEFAULT_QUANTITY = 100;
    List<Fruit> fruits;

    Function<Fruit,String> priceAndQuantity=(c)->
            "price =" + c.getPrice() + " quantity =" +c.getQuantity();

    BiFunction<Integer, List<Integer>, List<Integer>> calc;

    BiFunction<Integer, List<Integer>, List<Integer>> fruitDiscount =
            (discount, Prices) -> Prices.stream().map(fruitPrice -> fruitPrice - discount).collect(toList());

    BiFunction<Integer, List<Integer>, List<Integer>> addTax =
            (tax, Prices) -> Prices.stream().map(fruitPrice -> fruitPrice + tax).collect(toList());

    public FruitBuilder() {
        proxyPatternJava8(this);
        initFruits();
    }

    public List<Fruit> getFruits() {
        return fruits;
    }

    public void setFruits(List<Fruit> fruits) {
        this.fruits = fruits;
    }

    public List<Fruit> initFruits() {
        fruits = new ArrayList<>();

        Fruit kashmiri = new Fruit("apple", 50, getFruitVendors("Imran", "Kabir"), DEFAULT_QUANTITY);
        Fruit orange = new Fruit("orange", 40, getFruitVendors("Imran"), DEFAULT_QUANTITY);
        Fruit simla = new Fruit("apple", 80, getFruitVendors("salman"), DEFAULT_QUANTITY);
        Fruit karnataka = new Fruit("apple", 100, getFruitVendors("Imran"), DEFAULT_QUANTITY);
        Fruit orange1 = new Fruit("orange", 50, getFruitVendors("balvir"), DEFAULT_QUANTITY);
        Fruit maha = new Fruit("apple", 120, getFruitVendors("kamal"), DEFAULT_QUANTITY);
        Fruit grapes = new Fruit("grapes", 70, getFruitVendors("balvir"), DEFAULT_QUANTITY);
        Fruit grapes1 = new Fruit("grapes", 80, getFruitVendors("balvir"), DEFAULT_QUANTITY);


        fruits.add(kashmiri);
        fruits.add(orange);
        fruits.add(simla);
        fruits.add(karnataka);
        fruits.add(orange1);
        fruits.add(maha);
        fruits.add(grapes);
        fruits.add(grapes1);

        printFruits(fruits,(f)->f.name!=null);
        return fruits;
    }

    private List<FruitVendors> getFruitVendors(String... vendors) {
        List<FruitVendors> appleVendorList = new ArrayList<>();
        for (String vendor : vendors) {
            FruitVendors appleVendor = new FruitVendors(vendor);
            appleVendorList.add(appleVendor);
        }
        return appleVendorList;
    }

    void addNewFruit(String name, int price, String... vendors) throws InterruptedException {
        System.out.println("-----------");
        System.out.println("adding new fruit :"+ name);
        if (fruits.isEmpty()) {
            System.out.println("No fruits available");
            fruits = new ArrayList<Fruit>();
        }
        Fruit newFruit = new Fruit(name, price, getFruitVendors(vendors), DEFAULT_QUANTITY);
        fruits.add(newFruit);
        System.out.println("new fruit added : " + newFruit.getName() + " price is " + newFruit.getPrice());
        System.out.println(priceAndQuantity.apply(newFruit));
        //displayAvailableFruits(a -> true);
        proxyPatternJava8(this);
    }

    public boolean displayAvailableFruits(Predicate<Integer> selector) throws InterruptedException {
        //Thread.sleep(5000);
        System.out.println("they called me simply");

        System.out.println("-----------------------");
        System.out.println("displayAvailableFruits---start");
        System.out.println("groupingBy,maapping,filtering");

        System.out.println(fruits.stream().collect((groupingBy((Fruit::getName), mapping((Fruit::getPrice), filtering(selector, toList()))))));

        /* System.out.println(fruits.stream().collect((groupingBy((Fruit::getName), mapping((Fruit::getPrice), toList())))));*/

        Map<String, Set<List<FruitVendors>>> displayFruits = fruits.stream().collect(groupingBy(Fruit::getName, mapping(Fruit::getVendors, toSet())));

        displayFruits.forEach((fruit, vender) -> {
            System.out.println(fruit);
            vender.stream().flatMap(v -> v.stream())
                    .forEach(System.out::println);
            System.out.println();
        });
        System.out.println("displayAvailableFruits---end");

        return true;
    }


    public List<Integer> getPrices() throws InterruptedException {
        return fruits.stream().collect(mapping((Fruit::getPrice), toList()));
    }


    public void displayFruitsByPriceCategory(int price) {
        System.out.println("-------------------------------");
        System.out.println("displayFruitsByPriceCategory--start");
        System.out.println("partitioningBy");
        System.out.println(fruits.stream().collect(mapping(Fruit::getPrice, partitioningBy(a -> a >= price))));
        System.out.println("displayFruitsByPriceCategory-ends");

    }

    public void displayCostlyFruit() {
        System.out.println("-------------------------------");
        System.out.println("displayCostlyFruit-start");
        System.out.println("collectingAndThen");
        fruits.stream()
                .collect(
                     groupingBy((Fruit::getName),
                        collectingAndThen(
                                maxBy(Comparator.comparing(Fruit::getPrice)),
                                ob -> ob.map(Fruit::getPrice))));
        System.out.println("displayCostlyFruit-- ends");

    }

    public void displayCheaperFruit() {
        System.out.println("-------------------------------");
        System.out.println("displayCheaperFruit--start");
        System.out.println("groupingBy,collectingAndThen,minBy,ob.map");
        System.out.println(fruits.stream().collect((groupingBy((Fruit::getName), collectingAndThen(minBy(Comparator.comparing(Fruit::getPrice)), ob -> ob.map(Fruit::getPrice))))));
        System.out.println("displayCheaperFruit-ends");
    }

    public void displayAveragePriceforAvailableFruits() {
        System.out.println("-------------------------------");
        System.out.println("displayAveragePriceforAvailableFruits--start");
        System.out.println("groupingBy,averagingInt");
        System.out.println(fruits.stream().collect((groupingBy((Fruit::getName), averagingInt(Fruit::getPrice)))));
        System.out.println("displayAveragePriceforAvailableFruits-ends");
    }

    public void displayAveragePriceByFruit(String fruit) {

        System.out.println("-------------------------------");
        System.out.println("displayAveragePriceByFruit--start");
        System.out.println("groupingBy,averagingInt");
        System.out.println(fruits.stream().collect(filtering(a -> a.getName().equals(fruit), (groupingBy((Fruit::getName), averagingInt(Fruit::getPrice))))));
        System.out.println("partition by fruit");
        System.out.println(fruits.stream().collect(mapping(Fruit::getName, partitioningBy(a -> a.toLowerCase().contains(fruit)))));
        System.out.println("displayAveragePriceByFruit-ends");
    }

    public void displayFruitsByPrice(int price) {

        System.out.println("-------------------------------");
        System.out.println("displayFruitsByPrice--start");
        System.out.println("groupingBy,averagingInt");
        System.out.println(fruits.stream().collect(filtering(a -> a.price == price, (groupingBy((Fruit::getName), mapping((Fruit::getPrice), toList()))))));
        System.out.println("---------------2nd way----------------");
        printFruits(fruits,fruit -> fruit.getPrice()==price);
        System.out.println("displayFruitsByPrice-ends");

    }

    public void displayFruitsByPriceMoreThen(int price) {

        System.out.println("-------------------------------");
        System.out.println("displayFruitsByPriceMoreThen--start");
        System.out.println("groupingBy,mapping,filtering");
        System.out.println(fruits.stream().collect(groupingBy((Fruit::getName), mapping((Fruit::getPrice), filtering(myPrice -> myPrice > price, toList())))));
        System.out.println("------------2nd approach-------------------");
        fruits.stream().collect(groupingBy((Fruit::getName), mapping((Fruit::getPrice), filtering((myPrice -> myPrice > price), collectingAndThen(toList(), Objects::toString)))))
                .forEach((f, p) -> System.out.println("fruit name: " + f + " with Price:" + p));
        System.out.println("---------------3rd way----------------");
        printFruits(fruits,fruit -> fruit.getPrice()>=price);
        System.out.println("displayFruitsByPriceMoreThen-ends");

    }

    public void displayAllVendors() {
        System.out.println("-------------------------------");
        System.out.println("displayAllVendors--start");
        System.out.println("flatMap");
        System.out.println(fruits.stream().flatMap(fruit -> fruit.getVendors().stream()).collect(toList()));
        System.out.println("------------2nd approach-------------------");
        System.out.println(fruits.stream().collect(flatMapping(f -> f.getVendors().stream(), toList())));
        System.out.println("displayAllVendors-ends");
    }

    public void displayAllVendorsAndFruits() {
        System.out.println("-------------------------------");
        System.out.println("displayAllVendorsAndFruits--start");
        System.out.println("groupingBy,flatMapping,mapping");
        System.out.println(
                fruits.stream().
                        collect(
                                groupingBy(Fruit::getName,
                                        flatMapping(fruit -> fruit.getVendors().stream(),
                                                mapping(FruitVendors::getVendorName,
                                                        toSet())))));
        System.out.println("------------2nd approach(no flat mapping)-------------------");
        System.out.println(
                fruits.stream()
                        .collect(
                                groupingBy(Fruit::getName,
                                        mapping(fruit -> fruit.getVendors(),
                                                toSet()))));


        System.out.println("displayAllVendorsAndFruits-ends");
    }


    public void displayAllVendorsByFruit(String selected) {
        System.out.println("---------------------------");

        System.out.println("displayAllVendorsByFruit-------");
        System.out.println("filter,flatMap,map");

        System.out.println(fruits
                .stream()
                .filter(fruit -> fruit.getName().equals(selected))
                .flatMap(fruit -> fruit.getVendors().stream())
                .map(fruitVendors -> fruitVendors.getVendorName())
                .collect(toSet()));


        System.out.println("displayAllVendorsByFruit-------ends");
    }

    public void displayAllFruitsAndVendorsByFruit(String selected) {
        System.out.println("-------------------------------");
        System.out.println("displayAllFruitsAndVendorsByFruit--start");
        System.out.println("groupingBy,flatMapping,mapping");
        System.out.println(fruits.stream().
                filter(fruit -> fruit.getName().equals(selected))
                .collect(
                        groupingBy(Fruit::getName,
                                flatMapping(fruit -> fruit.getVendors().stream(),
                                        mapping(FruitVendors::getVendorName,
                                                toSet())))));
        System.out.println("------------2nd approach-------------------");
        fruits
                .stream()
                .collect(filtering(fruit -> fruit.getName().equals(selected),
                        groupingBy(Fruit::getName,
                                flatMapping(fruit -> fruit.getVendors().stream(),
                                        mapping(fruitVendors -> fruitVendors.getVendorName(),
                                                toSet())))))
                .forEach((f, v) -> System.out.println("Fruit :" + f + " & vendors :" + v));


        System.out.println("displayAllFruitsAndVendorsByFruit--end");

    }

    public void displayAllFruitsByVendor(String vendor) {
        System.out.println("------------------------------");
        System.out.println("displayAllFruitsByVendor--start");
        System.out.println("groupingBy,collectingAndThen,mapping");
        System.out.println(fruits.stream()
                .collect(
                        groupingBy(Fruit::getName,
                                collectingAndThen(flatMapping(fruit -> fruit.getVendors().stream(),
                                        mapping(FruitVendors::getVendorName,
                                                toSet())), ob -> ob.contains(vendor)))));
        System.out.println("------------2nd approach-------------------");




        System.out.println("displayAllFruitsByVendor--end");

    }

    public void displayAllFruitsByVendorRedesign(String vendor) {
        System.out.println("------------------------------");
        System.out.println("displayAllFruitsByVendorRedesign--start");
        System.out.println("groupingBy,flatMapping,mapping,ob->");

        fruits.stream().collect(groupingBy(Fruit::getName, collectingAndThen(
                flatMapping(fruit -> fruit.getVendors().stream(), mapping(
                        FruitVendors::getVendorName, toSet())), ob -> ob.contains("imran"))));


        System.out.println("displayAllFruitsByVendorRedesign--end");


    }


    public void displayAllPricesOfSelectedFruit(String apple) {
        System.out.println("------------------------------");
        System.out.println("displayAllPricesOfSelectedFruit---start");
        System.out.println("filter,map");
        System.out.println(fruits.stream().filter(fruit -> fruit.getName().contains(apple)).map(Fruit::getPrice).collect(toList()));
        System.out.println("displayAllPricesOfSelectedFruit---end");

    }

    public void displayChepestPrice(String apple) {
        System.out.println("------------------------------");
        System.out.println("displayChepestPrice---start");
        System.out.println("filtering,minBy");
        System.out.println(fruits.stream().collect(filtering(fruit -> fruit.getName().contains(apple), minBy(Comparator.comparing(Fruit::getPrice)))));
        System.out.println("displayChepestPrice---end");
    }

    public void displayCAveragePrice(String apple) {
        System.out.println("------------------------------");
        System.out.println("displayCAveragePrice---start");
        System.out.println("filtering,averagingInt");
        System.out.println(fruits.stream().collect(filtering(fruit -> fruit.getName().contains(apple), averagingInt(Fruit::getPrice))));
        System.out.println("displayCAveragePrice---end");
    }

    public void sortAllFruitsByPrice() {
        System.out.println("------------------------------");
        System.out.println("sortAllFruitsByPrice---start");
        System.out.println("sorted");
        List<Fruit> fruitList = fruits.stream().sorted(Comparator.comparingInt(Fruit::getPrice)).collect(toList());
        System.out.println(fruitList);
        System.out.println("sortAllFruitsByPrice---end");
    }

    public void sortAllFruitsByPricebyMax() {
        System.out.println("------------------------------");
        System.out.println("sortAllFruitsByPricebyMax---start");
        System.out.println("sorted");
        List<Fruit> fruitList = fruits.stream().sorted((i1, i2) -> Integer.compare(i2.getPrice(), i1.getPrice())).collect(toList());
        System.out.println(fruitList);
        System.out.println("sortAllFruitsByPricebyMax---end");
    }

    public void sortAllFruitsByIncreasingFruitName() {
        System.out.println("-----------------------");
        System.out.println("sortAllFruitsByIncreasingFruitName---start");
        System.out.println("sorted");
        List<Fruit> fruitList = fruits.stream().sorted((i1, i2) -> Integer.compare(i2.getName().length(), i1.getName().length())).collect(toList());
        System.out.println(fruitList);
        System.out.println("sortAllFruitsByIncreasingFruitName---end");
    }

    public void getminFruit() {
        System.out.println("-----------------------");
        System.out.println("getminFruit---start");
        System.out.println("min");
        Fruit fruit = fruits.stream().min(Comparator.comparingInt(Fruit::getPrice)).get();
        System.out.println(fruit);
        System.out.println("getminFruit---end");
    }

    public void getmaxFruit() {
        System.out.println("-----------------------");
        System.out.println("getmaxFruit---start");
        System.out.println("max");
        Fruit fruit = fruits.stream().max(Comparator.comparingInt(Fruit::getPrice)).get();
        System.out.println(fruit);
        System.out.println("getmaxFruit---end");
    }

    public void printAllFruitNamesByConvertingToArray() {
        System.out.println("-----------------------");
        System.out.println("getArrayOnJavaStream---start");
        System.out.println("map,toArray");
        String[] fruits = this.fruits.stream().map(Fruit::getName).distinct().toArray(String[]::new);
        Stream.of(fruits).forEach(System.out::println);
        System.out.println("getArrayOnJavaStream---end");
    }

    public void getAllFruitQuantityLessThan(int quantity) {
        System.out.println("-----------------------");
        System.out.println("getAllFruitQuantityLessThan---start");
        System.out.println("allMatch,anyMatch,noneMatch,filter");
        if (fruits.stream().allMatch(f -> f.getQuantity() > 0) &&
                fruits.stream().anyMatch(f -> f.getQuantity() < quantity) &&
                fruits.stream().noneMatch(f -> f.getPrice() == 0)) {
            List<Fruit> fruitList = fruits.stream().filter(f -> f.getQuantity() < quantity).collect(toList());
            Stream.of(fruitList).forEach(System.out::println);
        }
        System.out.println("getAllFruitQuantityLessThan---end");

    }

    public void displayMaxPriceOfEachFruit() {
        System.out.println("-----------------------");
        System.out.println("displayMaxPriceOfEachFruit---start");
        System.out.println("groupingBy,collectingAndThen,maxBy,ob.map");

        System.out.println(fruits.stream().collect((
                groupingBy((Fruit::getName),
                        collectingAndThen(
                                maxBy(Comparator.comparing(Fruit::getPrice)),
                                ob -> ob.map(Fruit::getPrice))))));
        System.out.println("displayMaxPriceOfEachFruit---end");
    }

    public void printFruits(List<Fruit> fruits,FruitCondition<Fruit> condition){
        System.out.println("-----------------------");
        System.out.println("-----------------------");
        System.out.println("printFruits---start");

        for(Fruit f:fruits){
            if(condition.test(f)){
                f.printFruit();
            }
        }
        System.out.println("printFruits---ends");

    }

    public void displayTotalNumberOfFruitsByName() {
        System.out.println("-----------------------");
        System.out.println("displayTotalNumberOfFruitsByName---start");
        System.out.println("groupingBy,counting");

        System.out.println(fruits.stream().collect((
                groupingBy((Fruit::getName),
                                counting()))));
        System.out.println("displayTotalNumberOfFruitsByName---end");
    }

}


