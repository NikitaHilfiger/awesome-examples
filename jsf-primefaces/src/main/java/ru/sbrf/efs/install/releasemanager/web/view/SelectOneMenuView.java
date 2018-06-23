package ru.sbrf.efs.install.releasemanager.web.view;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.sbrf.efs.install.releasemanager.web.view.model.Theme;
import ru.sbrf.efs.install.releasemanager.web.view.service.ThemeService;

import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Getter
@Setter
public class SelectOneMenuView {

    private String configurationElement;

    private String release;
    private List<SelectItem> releases;

    private String city;
    private Map<String, String> cities = new HashMap<String, String>();

    private Theme theme;
    private List<Theme> themes;

    private String option;
    private List<String> options;

    @Autowired
    private ThemeService service;

    @PostConstruct
    public void init() {
        //releases
        SelectItemGroup g1 = new SelectItemGroup("German releases");
        g1.setSelectItems(new SelectItem[]{new SelectItem("BMW", "BMW"), new SelectItem("Mercedes", "Mercedes"), new SelectItem("Volkswagen", "Volkswagen")});

        SelectItemGroup g2 = new SelectItemGroup("American releases");
        g2.setSelectItems(new SelectItem[]{new SelectItem("Chrysler", "Chrysler"), new SelectItem("GM", "GM"), new SelectItem("Ford", "Ford")});

        releases = new ArrayList<SelectItem>();
        releases.add(g1);
        releases.add(g2);

        //cities
        cities = new HashMap<String, String>();
        cities.put("New York", "New York");
        cities.put("London", "London");
        cities.put("Paris", "Paris");
        cities.put("Barcelona", "Barcelona");
        cities.put("Istanbul", "Istanbul");
        cities.put("Berlin", "Berlin");

        //themes
        themes = service.getThemes();

        //options
        options = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            options.add("Option " + i);
        }
    }

    public String getConfigurationElement() {
        return configurationElement;
    }

    public void setConfigurationElement(String configurationElement) {
        System.out.println("setter called:" + configurationElement);
        System.out.println(this.toString());
        this.configurationElement = configurationElement;
    }

    public Boolean checkSelected() {
        System.out.println("checkSelected = " + configurationElement);
        System.out.println("is not null" + this.configurationElement != null);
        return this.configurationElement != null;
    }

    public void meth() {
        System.out.println("meth called");
        System.out.println(this.toString());
    }

}
