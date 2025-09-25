package com.sv.stayGo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sv.stayGo.model.Hospedaje;
import java.util.List;

@Repository
public interface HospedajeRepository extends JpaRepository<Hospedaje, Long> {
    List<Hospedaje> findTop4ByOrderByFechaPublicacionDesc();
    // Busca hospedajes cuyo destino contenga cierto texto (ej: "San Salvador")
    List<Hospedaje> findTop3ByDestinoIgnoreCaseContainingOrderByFechaPublicacionDesc(String destino);

}
