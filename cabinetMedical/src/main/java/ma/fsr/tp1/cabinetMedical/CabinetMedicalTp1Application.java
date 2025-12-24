package ma.fsr.tp1.cabinetMedical;

import ma.fsr.tp1.cabinetMedical.model.patient;
import ma.fsr.tp1.cabinetMedical.model.medecin;
import ma.fsr.tp1.cabinetMedical.service.patientService;
import ma.fsr.tp1.cabinetMedical.service.medecinService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class CabinetMedicalTp1Application {

    public static void main(String[] args) {
        SpringApplication.run(CabinetMedicalTp1Application.class, args);
    }

    @Bean
    CommandLineRunner start(patientService patService, medecinService medService) {
        return args -> {
            // Insertion de patients
            patService.createPatient(new patient(null, "Omar Alami", LocalDate.of(1990, 5, 15), "M", "0661223344", null));
            patService.createPatient(new patient(null, "Sara Idrisi", LocalDate.of(1995, 10, 20), "F", "0661556677", null));

            // Insertion de médecins [cite: 21]
            medService.createMedecin(new medecin(null, "Dr. Amrani", "Cardiologie", "amrani@email.com", null));
            medService.createMedecin(new medecin(null, "Dr. Bennani", "Généraliste", "bennani@email.com", null));

            System.out.println("Base de données initialisée avec succès !");
        };
    }
}