package rank;

import java.util.*;

public class Web {

    private Set<Link> links;
    protected Set<Site> sites;
    private static final double THRESHOLD = 1.0E-5;
    private static Random alea = new Random(1);

    public Web() {
        links = new HashSet<>();
        sites = new HashSet<>();
    }

    protected void addSite(Site site) {
        sites.add(site);
    }

    protected void addSiteWithName(String name) {
        addSite(new Site(name));
    }

    public void addLink(String dataLink) {
        try {
            String[] split = dataLink.split("->");
            addSiteWithName(split[0]);
            addSiteWithName(split[1]);
            links.add(new Link(split[0], split[1]));
        } catch (RuntimeException e) {
            throw new IllegalArgumentException(dataLink + " no tiene el formato correcto");
        }
    }

    public Site getSite(String name) {
        Site res = null;
        boolean encontrado = false;
        Iterator<Site> it = sites.iterator();
        while ( ! encontrado && it.hasNext()) {
            res = it.next();
            encontrado = name.equalsIgnoreCase(res.getName());
        }
        if ( ! encontrado) {
            throw new NoSuchElementException("No such site "+ name);
        }
        return res;
    }

    public Set<String> getNames() {
        Set<String> names = new HashSet<>();
        for (Site site : sites) {
            names.add(site.getName());
        }
        return names;
    }

    private Set<Site> getSitesLinkedFrom(Site pagina) {
        Set<Site> linked = new HashSet<>();
        for (Link link : links) {
            Site org = getSite(link.getOrigin());
            if (org.equals(pagina))
                linked.add(getSite(link.getLinked()));
        }
        return linked;
    }

    protected void distribute(Site site, double prize) {
        if (THRESHOLD <= prize) {
            site.addRank(prize / 2);
            Set<Site> siteSet = getSitesLinkedFrom(site);
            for (Site site1 : siteSet) {
                distribute(site1, prize / (2*siteSet.size()));
            }
        }
    }

    public void click(String name) {
        try {
            for (Site site : sites) {
                if (site.getName().equalsIgnoreCase(name)) {
                    distribute(site, 1.0);
                }
            }
        } catch (RuntimeException e) {
        }
    }

    public void simulateClick(int numClick) {
        if (!sites.isEmpty()) {
            List<Site> siteList = new ArrayList<>(sites);
            for (int i = 0; i < numClick; i++) {
                int select = alea.nextInt(sites.size());
                Site siteSelected = siteList.get(select);
                click(siteSelected.getName());
            }
        }
    }

    public SortedSet<Site> getSitesByName() {
        return new TreeSet<>(sites);
    }

    public SortedSet<Site> getSitesByRank() {
        Comparator<Site> rankComp = Comparator.comparingDouble(Site::getRank).reversed();
        Comparator<Site> rankThenName = rankComp.thenComparing(Comparator.naturalOrder());
        SortedSet<Site> sortedSet = new TreeSet<>(rankThenName);
        sortedSet.addAll(sites);
        return sortedSet;
    }

    @Override
    public String toString() {
        return "Web(" + sites + ", " + links + ")";
    }
}