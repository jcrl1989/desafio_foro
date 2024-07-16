package com.aluracursos.foro.foroAlura.domain.consulta;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.aluracursos.foro.foroAlura.domain.consulta.foro.Foro;
import com.aluracursos.foro.foroAlura.domain.consulta.usuario.Usuario;

import java.time.LocalDateTime;

@Table(name = "consultas")
@Entity(name = "Consulta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "foro_id")
    private Foro foro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private LocalDateTime fecha;

    @Column(name = "motivo-cancelamiento")
    @Enumerated(EnumType.STRING)
    private MotivoCancel motivoCancel;

    public Consulta(Foro foro, Usuario usuario, LocalDateTime fecha) {
        this.foro=foro;
        this.usuario=usuario;
        this.fecha=fecha;
    }

    public Consulta(Foro foro, boolean usuario, LocalDateTime fecha) {

    }

    public void cancelar(MotivoCancel motivo) {this.motivoCancel=motivo;}

}
