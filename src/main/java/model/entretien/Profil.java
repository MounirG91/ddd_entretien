package model.entretien;

import common.sharedKernel.ValueObject;

import java.util.List;

class Profil implements ValueObject {

 private List<String> competences;

 private int nombreAnneeExperience;

 private List<String> softSkills;

 Profil(List<String> competences, int nombreAnneeExperience, List<String> softSkills) {
  this.competences = competences;
  this.nombreAnneeExperience = nombreAnneeExperience;
  this.softSkills = softSkills;
 }

 public List<String> getCompetences() {
  return competences;
 }

 public int getNombreAnneeExperience() {
  return nombreAnneeExperience;
 }

 public List<String> getSoftSkills() {
  return softSkills;
 }
}
