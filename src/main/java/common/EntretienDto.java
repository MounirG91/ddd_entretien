package common;

public class EntretienDto {

    private CandidatDto candidatDto;

    private ConsultantRecruteurDto consultantRecruteurDto;

    private String status;

    public EntretienDto() {
    }

    public EntretienDto(CandidatDto candidatDto, ConsultantRecruteurDto consultantRecruteurDto, String status) {
        this.candidatDto = candidatDto;
        this.consultantRecruteurDto = consultantRecruteurDto;
        this.status = status;
    }

    public CandidatDto getCandidatDto() {
        return candidatDto;
    }

    public void setCandidatDto(CandidatDto candidatDto) {
        this.candidatDto = candidatDto;
    }

    public ConsultantRecruteurDto getConsultantRecruteurDto() {
        return consultantRecruteurDto;
    }

    public void setConsultantRecruteurDto(ConsultantRecruteurDto consultantRecruteurDto) {
        this.consultantRecruteurDto = consultantRecruteurDto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
