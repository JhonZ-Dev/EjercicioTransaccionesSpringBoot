package com.example.transaccionessrpingbootmysql.repositorio;

import com.example.transaccionessrpingbootmysql.modelo.FacturaModelo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepo extends JpaRepository<FacturaModelo, Long> {
}
