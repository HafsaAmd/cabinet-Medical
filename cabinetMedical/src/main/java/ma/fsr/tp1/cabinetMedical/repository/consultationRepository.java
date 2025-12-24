package ma.fsr.tp1.cabinetMedical.repository;

import ma.fsr.tp1.cabinetMedical.model.consultation;
import ma.fsr.tp1.cabinetMedical.model.rendezvous;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface consultationRepository extends JpaRepository<consultation,Long> {
    Optional<consultation> findByrendezvous(rendezvous rendezVous);
}