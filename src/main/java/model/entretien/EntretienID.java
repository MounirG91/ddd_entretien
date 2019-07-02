package model.entretien;

import common.sharedKernel.ValueObject;

import java.util.UUID;

public class EntretienID implements ValueObject {

    private String idEntretien;

    public EntretienID() {
        idEntretien = UUID.randomUUID().toString();
    }
}
