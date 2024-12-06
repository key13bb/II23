package rank;

import java.util.Locale;

public class Site implements Comparable<Site> {
    private String name;
    private double rank;

    public Site(String name) {
        this.name = name;
        rank = 0;
    }

    public String getName() {
        return name;
    }

    public double getRank() {
        return rank;
    }

    public void addRank(double r) {
        rank += r;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Site site &&
            name.equalsIgnoreCase(site.name);
    }

    @Override
    public int hashCode() {
        return name.toUpperCase().hashCode();
    }

    @Override
    public int compareTo(Site site) {
        return name.compareToIgnoreCase(site.name);
    }

    @Override
    public String toString() {
        return String.format(Locale.UK, "%s(%.5f)", name, rank);
    }
}
