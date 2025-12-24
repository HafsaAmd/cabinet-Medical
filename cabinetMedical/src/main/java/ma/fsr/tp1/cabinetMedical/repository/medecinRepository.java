package ma.fsr.tp1.cabinetMedical.repository;

import ma.fsr.tp1.cabinetMedical.model.medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface medecinRepository extends JpaRepository<medecin,Long> {
}