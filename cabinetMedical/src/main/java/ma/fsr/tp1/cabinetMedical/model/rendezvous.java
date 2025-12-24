package ma.fsr.tp1.cabinetMedical.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime; // Pour Date + Heure

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class rendezvous {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateRdv;

    private String statut;

    @ManyToOne
    private patient patient;

    @ManyToOne
    private medecin medecin;

    @OneToOne(mappedBy = "rendezvous")
    private consultation consultation;
}