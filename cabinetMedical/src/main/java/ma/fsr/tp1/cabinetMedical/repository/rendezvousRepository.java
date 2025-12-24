package ma.fsr.tp1.cabinetMedical.repository;

import ma.fsr.tp1.cabinetMedical.model.medecin;
import ma.fsr.tp1.cabinetMedical.model.rendezvous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface rendezvousRepository extends JpaRepository<rendezvous,Long> {
}