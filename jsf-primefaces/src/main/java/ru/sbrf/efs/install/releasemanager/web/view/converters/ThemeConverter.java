package ru.sbrf.efs.install.releasemanager.web.view.converters;

import ru.sbrf.efs.install.releasemanager.web.view.model.Theme;
import ru.sbrf.efs.install.releasemanager.web.view.service.ThemeService;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("themeConverter")
public class ThemeConverter implements Converter {

    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        System.out.println(value);
        if (value != null && value.trim().length() > 0) {
            try {
                ThemeService service = (ThemeService) fc.getExternalContext().getApplicationMap().get("themeService");
                return service.getThemes().get(Integer.parseInt(value));
            } catch (NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        } else {
            return null;
        }
    }

    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if (object != null) {
            return String.valueOf(((Theme) object).getId());
        } else {
            return null;
        }
    }
}
