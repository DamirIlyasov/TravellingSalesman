public class Route implements Comparable<Route> {

    private final City DEFAULT_CITY;
    City[] routeAsArray;
    private double distanceOfTheRoute = 0;


    public Route(City[] listOfCities) {
        DEFAULT_CITY = Main.listOfCities[0];

        routeAsArray = new City[listOfCities.length];
        routeAsArray[0] = DEFAULT_CITY;
        for (int i = 1; i < listOfCities.length; i++) {
            routeAsArray[i] = listOfCities[i];
        }

    }


    public void calcluateDistanceOfRoute() {
        City[] cityInRoute = routeAsArray;
        calculateDistance(cityInRoute);

    }

    private void calculateDistance(City[] cityInRoute) {
        for (int i = 0; i < (cityInRoute.length - 1); i++) {

            if (cityInRoute[i].distanceList.containsKey(cityInRoute[i + 1].name)) {
                distanceOfTheRoute += cityInRoute[i].getDistanceToCity(cityInRoute[i + 1].name);
            }
        }
        distanceOfTheRoute = Main.round(distanceOfTheRoute, 2);

    }


    public double getDistanceOfTheRoute() {
        return distanceOfTheRoute;
    }


    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < routeAsArray.length; i++) {
            result += routeAsArray[i] + "\n";
        }
        return "Route [" + result;//Arrays.toString(routeAsArray);
    }


    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return equals((Route) obj);
    }

    public boolean equals(Route route) {
        // TODO Auto-generated method stub
        return this.toString().equals(route.toString());
    }


    int getCity(int i) {
        return 0;
    }

    @Override
    public int compareTo(Route other) {
        int tmp = 0;

        int[] cities = new int[5];

        for (int i = 0; i < cities.length; i++) {
            if (cities[i] != other.getCity(i)) {
                tmp = 1;
                break;
            }
        }

        return tmp;
    }

}
