package rank;
public class Link {
    private String origin;
    private String linked;

    public Link(String org, String lnk) {
        origin = org;
        linked = lnk;
    }

    public String getOrigin() {
        return origin;
    }

    public String getLinked() {
        return linked;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Link lnk && origin.equalsIgnoreCase(lnk.origin) && linked.equalsIgnoreCase(lnk.linked);
    }

    @Override
    public int hashCode() {
        return origin.toUpperCase().hashCode() + linked.toUpperCase().hashCode();
    }

    @Override
    public String toString() {
        return origin + "->" + linked;
    }
}
