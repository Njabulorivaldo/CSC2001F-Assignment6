import java.util.*;
import Graphs.Graph;


class SimulatorOne {
	
   public static void main(String [] args) {
      int var = 0;
   
   	//ArrayList<String> shops = new ArrayList<String> ();
   	//ArrayList<String> clients = new ArrayList<String> ();
   	
      Graph graph = new Graph();
   	
      Scanner sc = new Scanner(System.in);
      String num = sc.nextLine();
   	
      int num_nodes = Integer.parseInt(num);
   	
      for (int i=0; i< num_nodes; i++) {
         String n = sc.nextLine();
         String[] nodes = n.split(" ");
      	
         String source = nodes[0];
         for (int a=1; a<nodes.length; a+=2) {
            graph.addEdge(source, nodes[a], Double.parseDouble(nodes[a+1]));
         }
      }
      String s = sc.nextLine();
      int num_shops = Integer.parseInt(s);
   	
      String shops_line = sc.nextLine();
      String[] shops_arr = shops_line.split(" ");
   	
   
   		
      String d = sc.nextLine();
      int num_clients = Integer.parseInt(d);
   	
      String clients_line = sc.nextLine();
      String[] clients_arr = clients_line.split(" ");
   	
   
   
      for(int i = 0; i<num_clients; i++) {
      
      
         double cost1 = Graph.INFINITY;
         String taxi = "";
         System.out.println("client " + clients_arr[i]);
      	//Getting the nearest taxi for client
         try{
            for (int a=0; a<num_shops; a++) {
            
               graph.dijkstra(shops_arr[a]);//Start at shop
            
               double c = graph.getCost(clients_arr[i]);
            //System.out.println("Cost is: "+c);
               if (c < cost1){
                  cost1 = c;
                  taxi = shops_arr[a];}
               
               else if (c == cost1) {
                  taxi += " "+shops_arr[a];
               }
            
            }
         
            String [] taxis = taxi.split(" ");
            for (String q: taxis) {
               System.out.println("taxi " + q);
               graph.dijkstra(q);	
               graph.printPath(clients_arr[i]);}
         } catch(Exception e) {System.out.println("cannot be helped");
            break;}
      	
      	
         double cost2 = Graph.INFINITY;
         String shop = "";
         int checker = 0;
         for (int b=0; b<num_shops; b++) {
         
            graph.dijkstra(clients_arr[i]);
         	//graph.printPath(shops_arr[b]);
            double z = graph.getCost(shops_arr[b]);
            if (z < cost2){
               cost2 = z;
               shop = shops_arr[b];}
            else if(z == cost2) {
               shop +=" "+shops_arr[b];
            }
            
            else if (z == cost2)
               checker++;
         }
         String[] shops = shop.split(" ");
         for (String y: shops) {
         	
            System.out.println("shop " + y);
         		
            graph.dijkstra(clients_arr[i]);
            graph.printShops(y);}
      	
      	
      	
      }
   	
   	
   }
		

				
}
	



