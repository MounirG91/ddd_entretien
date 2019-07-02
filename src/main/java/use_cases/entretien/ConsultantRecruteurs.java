package use_cases.entretien;

import common.ConsultantRecruteurDto;

import java.util.Date;
import java.util.List;

public interface ConsultantRecruteurs {


    public List<ConsultantRecruteurDto> consultantsDisponibles(Date dateJourDonne);
}
