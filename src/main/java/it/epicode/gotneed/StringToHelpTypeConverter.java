package it.epicode.gotneed;

import it.epicode.gotneed.models.HelpType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToHelpTypeConverter implements Converter<String, HelpType> {

    @Override
    public HelpType convert(String source) {
        try {
            return HelpType.valueOf(source.toUpperCase().replace(" ", "_"));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Valore non valido per il tipo di aiuto: " + source);
        }
    }
}