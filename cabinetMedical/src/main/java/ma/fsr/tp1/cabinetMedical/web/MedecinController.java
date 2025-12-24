package ma.fsr.tp1.cabinetMedical.web;

import ma.fsr.tp1.cabinetMedical.model.medecin;
import ma.fsr.tp1.cabinetMedical.service.medecinService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medecins")
public class MedecinController {

    private final medecinService medService;

    public MedecinController(medecinService medService) {
        this.medService = medService;
    }

    @GetMapping // Endpoint: GET /medecins
    public List<medecin> getAllmedecins() {
        return medService.listMedecins(); // [cite: 22]
    }

    @PostMapping // Endpoint: POST /medecins
    public medecin createMedecin(@RequestBody medecin medecin) {
        return medService.createMedecin(medecin); // [cite: 21]
    }
}