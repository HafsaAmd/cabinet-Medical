package ma.fsr.tp1.cabinetMedical.repository;

import ma.fsr.tp1.cabinetMedical.model.patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface patientRepository extends JpaRepository<patient, Long> {

}