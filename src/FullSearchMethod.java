import java.util.List;

public class FullSearchMethod {


	static void doBruteForce(List<Route> listOfRoutes){

		Route minRoute = null;
		double minLenghtOfRoute = Double.MAX_VALUE;
		double tmpMinLengthOfRoute;
		int cost = 0;

		for(int i = 0 ; i < listOfRoutes.size(); i++){

			RouteHelper.listOfRoutes.get(i).calcluateDistanceOfRoute();

			tmpMinLengthOfRoute = RouteHelper.listOfRoutes.get(i).getDistanceOfTheRoute();
			if(minLenghtOfRoute > tmpMinLengthOfRoute){
				minRoute = RouteHelper.listOfRoutes.get(i);
				minLenghtOfRoute = tmpMinLengthOfRoute;

			}
			cost++;
		}


			System.out.println("=============Full search=============");
		System.out.println("Shortest route: \n"+minRoute);


	}
}
