package ru.sbrf.efs.install.releasemanager.web.view.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.sbrf.efs.install.releasemanager.web.view.model.Theme;
import ru.sbrf.efs.install.releasemanager.web.view.service.ThemeService;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

@Component
public class ThemeConverter implements Converter {

    @Autowired
    private ThemeService themeService;

    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        System.out.println("convert string value = [ " + value + " ] to object");
        if (value != null && value.trim().length() > 0) {
            try {
                return themeService.getThemes().get(Integer.parseInt(value));

            } catch (NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        } else {
            return null;
        }
    }

    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        System.out.println("theme convert object value [ " + object + " ] to string");
        if (object != null) {
            return String.valueOf(((Theme) object).getId());
        } else {
            return null;
        }
    }
}
