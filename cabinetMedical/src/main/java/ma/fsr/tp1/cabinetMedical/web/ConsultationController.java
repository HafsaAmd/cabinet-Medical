package ma.fsr.tp1.cabinetMedical.web;

import ma.fsr.tp1.cabinetMedical.model.consultation;
import ma.fsr.tp1.cabinetMedical.repository.consultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultations")
public class ConsultationController {

    @Autowired
    private consultationRepository consultationRepository;

    @GetMapping
    public List<consultation> getAllConsultations() {
        return consultationRepository.findAll();
    }

    @PostMapping
    public consultation createConsultation(@RequestBody consultation consultation) {
        return consultationRepository.save(consultation);
    }
}