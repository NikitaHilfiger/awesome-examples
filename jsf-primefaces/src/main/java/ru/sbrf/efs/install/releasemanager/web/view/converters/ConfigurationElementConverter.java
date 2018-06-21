package ru.sbrf.efs.install.releasemanager.web.view.converters;

import ru.sbrf.efs.install.releasemanager.web.model.ConfigurationElement;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = ConfigurationElement.class)
public class ConfigurationElementConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return null;
    }
}
