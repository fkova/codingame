import java.util.*;

class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // the total number of nodes in the level, including the gateways
        int L = in.nextInt(); // the number of links
        int E = in.nextInt(); // the number of exit gateways

        List<Link> links = new ArrayList();
        List<Integer> gws = new ArrayList();

        for (int i = 0; i < L; i++) {
            int N1 = in.nextInt(); // N1 and N2 defines a link between these nodes
            int N2 = in.nextInt();

            links.add(new Link(N1, N2));
        }

        for (int i = 0; i < E; i++) {
            int EI = in.nextInt(); // the index of a gateway node

            gws.add(EI);
        }

        // game loop
        while (true) {
            int SI = in.nextInt();
            boolean cut = false;

            for (int EIn : gws) {

                for (Link li : links) {

                    if ((li.n1 == SI || li.n2 == SI)
                            && (li.n1 == EIn) || li.n2 == EIn) {
                        System.out.println(li.toString());
                        cut = true;
                        links.remove(li);
                        break;
                    }
                }
            }

            for (Link li : links) {

                if (!cut) {
                    System.out.println(li.toString());
                    System.err.println("no gws cut");
                    links.remove(li);
                    break;
                }
            }
        }
    }
}

class Link {

    public int n1 = 0;
    public int n2 = 0;

    Link(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    @Override
    public String toString() {
        return n1 + " " + n2;
    }
}
