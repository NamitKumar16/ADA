package ADA;
public class TSP {

    int visited[] = new int[5];

    public static void doit(int N, int s) {

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int cities[] = new int[5];

        for(int i=0;i<cities.length;i++) {
            cities[i] = i+1;
        }

        int s = 1;

        int N = 4;

        int dist[] = new int[5];

        for(int i=0;i<dist.length;i++) {
            dist[i] = i;
        }

        doit(N,s);

    }

}