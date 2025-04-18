package rank;
public class WebExtended extends Web {
    public WebExtended() {
    }

    @Override
    protected void addSiteWithName(String name) {
        SiteExtended sitEx = new SiteExtended(name);
        addSite(sitEx);
    }

    @Override
    protected void distribute(Site site, double prize) {
        if (site instanceof SiteExtended newSite && newSite.isValid()) {
            super.distribute(site, prize);
        }
    }

    public void switchSiteWithName(String name) {
        for (Site site : sites) {
            if (site instanceof SiteExtended tempSite && tempSite.getName().equalsIgnoreCase(name)) {
                tempSite.setValid(!tempSite.isValid());
            }
        }
    }
}
