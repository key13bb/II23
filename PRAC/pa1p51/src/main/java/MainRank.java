import rank.Site;
import rank.Web;

public class MainRank {
    public static void main(String[] args) {
        String[] enlaces = {"I->C",
			"J->C",
			"A->C",
			"A->D",
			"B->C",
			"B->F",
			"D->F",
			"E->B",
			"E->H",
			"F->G",
			"F->H",
			"G->E",
			"G->H"};

        Web web = new Web();
        for (String arc: enlaces) {
            web.addLink(arc);
		}
        System.out.println(web);
        web.simulateClick(4000);
        System.out.println("Paginas ordenadas alfabeticamente");
        System.out.println(web.getSitesByName());
        System.out.println("Paginas ordenadas por rank");
        System.out.println(web.getSitesByRank());
        /*
		Site site = new Site("sitio");
		site.addRank(1.12345);
		System.out.println(site);*/
    }

}
