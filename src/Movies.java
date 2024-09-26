public class Movies implements Comparable<Movies> {
    private String title;
    private Integer year;
    private String distributor;
    private Long budget;
    private Long domOpen;
    private Long domSales;
    private Long intSales;
    private Long wwSales;
    private String runtime;
    private String license;

    public Movies() {
        title = "";
        year = 0;
        distributor = "";
        budget = 0L;
        domOpen = 0L;
        domSales = 0L;
        intSales = 0L;
        wwSales = 0L;
        runtime = "";
        license = "";
    }

    public Movies(String title, Integer year, String distributor, Long budget, Long domOpen, Long domSales,
                  Long intSales, Long wwSales, String runtime, String license) {
        this.title = title;
        this.year = year;
        this.distributor = distributor;
        this.budget = budget;
        this.domOpen = domOpen;
        this.domSales = domSales;
        this.intSales = intSales;
        this.wwSales = wwSales;
        this.runtime = runtime;
        this.license = license;
    }

    public String toString() {
        return "Title: " + title + ", Year: " + year + ", Distributor: " + distributor + ", Budget: " + budget +
                ", Domestic Opening: " + domOpen + ", Domestic Sales: " + domSales + ", International Sales: " +
                intSales + ", Worldwide Sales: " + wwSales + ", Runtime: " + runtime + ", License: " + license + "\n";
    }

    @Override
    public int compareTo(Movies obj) {
        return obj.wwSales.compareTo(this.wwSales);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }
    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDistributor() {
        return distributor;
    }
    public void setDistributor(String distributor) {
        this.distributor = distributor;
    }

    public Long getBudget() {
        return budget;
    }
    public void setBudget(Long budget) {
        this.budget = budget;
    }

    public Long getDomOpen() {
        return domOpen;
    }
    public void setDomOpen(Long domOpen) {
        this.domOpen = domOpen;
    }

    public Long getDomSales() {
        return domSales;
    }
    public void setDomSales(Long domSales) {
        this.domSales = domSales;
    }

    public Long getIntSales() {
        return intSales;
    }
    public void setIntSales(Long intSales) {
        this.intSales = intSales;
    }

    public Long getWwSales() {
        return wwSales;
    }
    public void setWwSales(Long wwSales) {
        this.wwSales = wwSales;
    }

    public String getRuntime() {
        return runtime;
    }
    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getLicense() {
        return license;
    }
    public void setLicense(String license) {
        this.license = license;
    }
}
