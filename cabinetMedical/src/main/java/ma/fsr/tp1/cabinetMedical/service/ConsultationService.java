package ma.fsr.tp1.cabinetMedical.service;

import lombok.AllArgsConstructor;
import ma.fsr.tp1.cabinetMedical.model.consultation;
import ma.fsr.tp1.cabinetMedical.model.rendezvous;
import ma.fsr.tp1.cabinetMedical.repository.consultationRepository;
import ma.fsr.tp1.cabinetMedical.repository.rendezvousRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConsultationService {

    private final consultationRepository consultationRepository;
    private final rendezvousRepository rendezvousRepository;


    public consultation saveConsultation(Long rendezvousId, String rapport) {

        Optional<rendezvous> rendezVousOpt = rendezvousRepository.findById(rendezvousId);
        if (rendezVousOpt.isEmpty()) {
            throw new IllegalArgumentException("Rendez-vous introuvable avec l'ID: " + rendezvousId);
        }

        Rendezvous rendezVous = rendezVousOpt.get();

        if (consultationRepository.findByrendezvous(rendezvous).isPresent()) {
            throw new IllegalStateException("Une consultation existe déjà pour ce rendez-vous");
        }

        if (rapport == null || rapport.trim().isEmpty()) {
            throw new IllegalArgumentException("Le rapport de consultation est obligatoire");
        }

        consultation consultation = new consultation();
        consultation.setDateConsultation(LocalDate.now());
        consultation.setRapport(rapport.trim());
        consultation.setRendezvous(rendezvous);

        rendezvous.setstatus("CONSULTE");
        rendezvousRepository.save(rendezVous);

        return consultationRepository.save(consultation);
    }

}