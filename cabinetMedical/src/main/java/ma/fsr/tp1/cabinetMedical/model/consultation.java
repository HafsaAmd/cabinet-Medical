package ma.fsr.tp1.cabinetMedical.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateConsultation;
    private String rapport;

    @OneToOne
    @JoinColumn(name = "rendez_vous_id")
    private rendezvous rendezvous;
}