package ru.sbrf.efs.install.releasemanager.web.view;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.sbrf.efs.install.releasemanager.web.model.Release;
import ru.sbrf.efs.install.releasemanager.web.service.ReleaseService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Component
@Getter
@Setter
@ManagedBean(name = "filterView")
public class FilterView implements Serializable {

    @Autowired
    private ReleaseService service;

    private List<Release> releases;

    private List<Release> filteredReleases;

    private List<String> statuses = new ArrayList<String>() {{
       add("PROCEED");
       add("REJECTED");
       add("FAILED");
       add("INSTALLED");
    }};

    @PostConstruct
    public void init() {
        this.releases = service.getMockReleases();
    }

    public boolean filterByPrice(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim();
        if (filterText == null || filterText.equals("")) {
            return true;
        }

        if (value == null) {
            return false;
        }

        return ((Comparable) value).compareTo(Integer.valueOf(filterText)) > 0;
    }

/*    public List<String> getBrands() {
        return service.getBrands();
    }

    public List<String> getColors() {
        return service.getColors();
    }

    public Release getReleases() {
        return releases;
    }*/

    public void setService(ReleaseService service) {
        this.service = service;
    }
}