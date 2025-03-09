package combosdependentes.converters;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




import combosdependentes.entidades.Municipio;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author desenvolvimento
 */
@FacesConverter("municipioConverter")
public class MunicipioConverter implements Converter {

    private static Map<String, Municipio> mapa = new HashMap<String, Municipio>();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return mapa.get(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof Municipio) {
            Municipio m = (Municipio) value;
            mapa.put(String.valueOf(m.getIdMunicipio()), m);
            return String.valueOf(m.getIdMunicipio());
        } else {
            return "";
        }

    }

}
