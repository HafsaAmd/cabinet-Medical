package ma.fsr.tp1.cabinetMedical.service;

import lombok.AllArgsConstructor;
import ma.fsr.tp1.cabinetMedical.repository.patientRepository;
import ma.fsr.tp1.cabinetMedical.model.patient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class patientService {

    private final patientRepository repo;

    public patient createPatient(patient p) {

        if (p.getNom() == null || p.getNom().isBlank()) {
            throw new IllegalArgumentException("Le nom est obligatoire.");
        }

        if (p.getTelephone() != null && p.getTelephone().length() < 10) {
            throw new IllegalArgumentException("Telephone invalide");
        }

        return repo.save(p);
    }

    public List<patient> ListPatients() {
        return repo.findAll();
    }
}