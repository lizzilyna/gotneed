package it.epicode.gotneed.utils;

import it.epicode.gotneed.models.Girl;
import it.epicode.gotneed.models.Help;
import it.epicode.gotneed.models.HelpType;

import java.util.Optional;

public class HelpConverter {


        public static Help convertToHelp(HelpType helpType, Optional<Girl>offeredBy, Optional<Girl>requestedBy) {
            // Esempio di conversione del nome dell'aiuto in un oggetto Help
            Help help = new Help();
            help.setType(helpType);
            offeredBy.ifPresent(help::setOfferedBy);
            requestedBy.ifPresent(help::setRequestedBy);

            return help;
        }
    }


