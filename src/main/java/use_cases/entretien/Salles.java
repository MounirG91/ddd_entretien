package use_cases.entretien;

import common.SalleDto;

import java.util.Date;
import java.util.List;
import java.util.Map;


public interface Salles {

    public List<SalleDto> sallesDisponibles(Date dateDisponibilte);
}
