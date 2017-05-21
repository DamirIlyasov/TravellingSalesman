import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static City[] listOfCities ;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("How many cities? :");
        int n = scanner.nextInt();
        Random random = new Random();
        listOfCities = new City[n];
        for (int i = 0; i < n; i++) {
            listOfCities[i] = new City("City"+i,random.nextDouble()*10,random.nextDouble()*10);
        }
        List<City> list = Arrays.asList(listOfCities);



        long flag = System.currentTimeMillis();
        RouteHelper.permute(list, 1);
        City.calculateAllDistancesToTheAllPoints(listOfCities);
        FullSearchMethod.doBruteForce(RouteHelper.listOfRoutes);
        System.out.println("Time spent: " + (System.currentTimeMillis() - flag)+" milliseconds");




        flag = System.currentTimeMillis();
        City.calculateAllDistancesToTheAllPoints(listOfCities);
        GreedyMethod.doHeuristicMethod(listOfCities);
        System.out.println("Time spent: " + (System.currentTimeMillis() - flag)+" milliseconds");




    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

}
