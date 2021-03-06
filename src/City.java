import java.util.LinkedHashMap;
import java.util.Map;


public class City {

    String name;
    double x;
    double y;

    Map<String, Double> distanceList;



    public City() {
        this.name = "";
        this.x = -1;
        this.y = -1;
        this.distanceList = new LinkedHashMap<String, Double>();
    }


    public City(String name, double x, double y) {
        super();
        this.name = name;
        this.x = x;
        this.y = y;
        this.distanceList = new LinkedHashMap<String, Double>();
    }

    double getDistanceToCity(String nameOfCity) {
        double distance = distanceList.get(nameOfCity);
        return distance;
    }


    @Override
    public String toString() {
        return "City [name=" + name + ", x=" + x + ", y=" + y + "]";
    }


    static void calculateAllDistancesToTheAllPoints(City[] listOfObjects) {
        for (int i = 0; i < listOfObjects.length; i++) {
            for (int j = 0; j < listOfObjects.length; j++) {
                if (i == j) {
                    listOfObjects[i].distanceList.put(null, (double) 0);
                    continue;
                }
                listOfObjects[i].distanceList.put(listOfObjects[j].name,
                        calculateEuklidesDistance(listOfObjects[i], listOfObjects[j]));
            }
        }
    }





    @Override
    public boolean equals(Object obj) {

        return this.equals((City) obj);

    }


    public boolean equals(City city) {
        if (this.name.equals(city.name)) {
            return true;
        }
        return false;
    }

    private static double calculateEuklidesDistance(City firstObject, City secondObject) {
        double sum = 0;
        sum += Math.pow((firstObject.x - secondObject.x), 2);
        sum += Math.pow((firstObject.y - secondObject.y), 2);
        Math.sqrt(sum);
        return Math.sqrt(sum);
    }
}
