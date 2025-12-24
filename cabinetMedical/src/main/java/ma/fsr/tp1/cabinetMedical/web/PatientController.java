package ma.fsr.tp1.cabinetMedical.web;

import ma.fsr.tp1.cabinetMedical.model.patient;
import ma.fsr.tp1.cabinetMedical.service.patientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients") // Préfixe pour tous les endpoints de ce contrôleur
public class PatientController {

    private final patientService patService;

    public PatientController(patientService patService) {
        this.patService = patService;
    }

    @GetMapping // Endpoint: GET /patients
    public List<patient> getAllPatients() {
        return patService.ListPatients(); // [cite: 19]
    }

    @PostMapping // Endpoint: POST /patients
    public patient createPatient(@RequestBody patient patient) {
        return patService.createPatient(patient); // [cite: 18]
    }
}