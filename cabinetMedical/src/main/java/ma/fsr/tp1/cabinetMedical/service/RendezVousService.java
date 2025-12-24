package ma.fsr.tp1.cabinetMedical.service;

import lombok.AllArgsConstructor;
import ma.fsr.tp1.cabinetMedical.model.medecin;
import ma.fsr.tp1.cabinetMedical.model.patient;
import ma.fsr.tp1.cabinetMedical.model.rendezvous;
import ma.fsr.tp1.cabinetMedical.repository.medecinRepository;
import ma.fsr.tp1.cabinetMedical.repository.patientRepository;
import ma.fsr.tp1.cabinetMedical.repository.rendezvousRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class RendezVousService {

    private final rendezvousRepository repo;
    private final patientRepository patientRepository;
    private final medecinRepository medecinRepository;

    public rendezvous createRendezVous(LocalDate dateRdv, Long patientId, Long medecinId) {
        if (dateRdv == null) {
            throw new IllegalArgumentException("La date du rendez-vous est obligatoire.");
        }
        if (patientId == null) {
            throw new IllegalArgumentException("L'ID du patient est obligatoire.");
        }
        if (medecinId == null) {
            throw new IllegalArgumentException("L'ID du médecin est obligatoire.");
        }

        patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new IllegalArgumentException("Patient avec l'ID " + patientId + " n'existe pas."));

        medecin medecin = medecinRepository.findById(medecinId)
                .orElseThrow(() -> new IllegalArgumentException("Médecin avec l'ID " + medecinId + " n'existe pas."));

        // Automatically set status to "EN_ATTENTE" for new appointments
        rendezvous rdv = new rendezvous(null, dateRdv, "EN_ATTENTE", patient, medecin);

        return repo.save(rdv);
    }

    public List<rendezvous> listRendezVous() { return repo.findAll(); }
}