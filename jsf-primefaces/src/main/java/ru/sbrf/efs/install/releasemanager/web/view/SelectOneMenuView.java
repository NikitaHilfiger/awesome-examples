package ru.sbrf.efs.install.releasemanager.web.view;

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
public class SelectOneMenuView {

    private String configurationElement;

    private String car;
    private List<SelectItem> cars;

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
        //cars
        SelectItemGroup g1 = new SelectItemGroup("German Cars");
        g1.setSelectItems(new SelectItem[]{new SelectItem("BMW", "BMW"), new SelectItem("Mercedes", "Mercedes"), new SelectItem("Volkswagen", "Volkswagen")});

        SelectItemGroup g2 = new SelectItemGroup("American Cars");
        g2.setSelectItems(new SelectItem[]{new SelectItem("Chrysler", "Chrysler"), new SelectItem("GM", "GM"), new SelectItem("Ford", "Ford")});

        cars = new ArrayList<SelectItem>();
        cars.add(g1);
        cars.add(g2);

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

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public List<SelectItem> getCars() {
        return cars;
    }

    public Map<String, String> getCities() {
        return cities;
    }

    public List<Theme> getThemes() {
        return themes;
    }

    public void setService(ThemeService service) {
        this.service = service;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
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
