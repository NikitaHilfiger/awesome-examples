package ru.sbrf.efs.install.releasemanager.web.view.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.sbrf.efs.install.releasemanager.web.model.ConfigurationElement;
import ru.sbrf.efs.install.releasemanager.web.service.ConfigurationElementService;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

@Component
public class ConfigurationElementConverter implements Converter {

    @Autowired
    private ConfigurationElementService configurationElementService;

    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        System.out.println("convert string value = [ " + value + " ] to object");
        if (value != null && value.trim().length() > 0) {
            try {
                return configurationElementService.getMockConfigurationElements().get(Integer.parseInt(value));
            } catch (NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        } else {
            return null;
        }
    }

    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        System.out.println("convert object value = [ " + object + " ] to string");
        if (object != null) {
            return ((ConfigurationElement) object).getId();
        } else {
            return null;
        }
    }
}
