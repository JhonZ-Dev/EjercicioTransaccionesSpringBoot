package com.example.transaccionessrpingbootmysql.repositorio;

import com.example.transaccionessrpingbootmysql.modelo.DetalleFacturaModelo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleFacRepo extends JpaRepository<DetalleFacturaModelo, Long> {

    
}
