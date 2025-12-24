package ma.fsr.tp1.cabinetMedical.web;

import ma.fsr.tp1.cabinetMedical.model.rendezvous;
import ma.fsr.tp1.cabinetMedical.service.RendezVousService; // Utiliser le service
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/rdvs")
public class RdvController {

    @Autowired
    private RendezVousService rdvService; // Injection du Service

    @GetMapping
    public List<rendezvous> getAllRdvs() { // Type de retour correct
        return rdvService.listRendezVous(); // Appel de la méthode du Service [cite: 32]
    }

    @PostMapping
    public rendezvous createRdv(@RequestParam String date,
                                @RequestParam Long patientId,
                                @RequestParam Long medecinId) {
        // Comme votre service demande 3 paramètres séparés, on les passe ici
        java.time.LocalDate localDate = java.time.LocalDate.parse(date);
        return rdvService.createRendezVous(localDate, patientId, medecinId);
    }
}