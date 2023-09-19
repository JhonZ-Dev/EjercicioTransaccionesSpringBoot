package com.example.transaccionessrpingbootmysql.servicio;

import com.example.transaccionessrpingbootmysql.repositorio.DetalleFacRepo;
import com.example.transaccionessrpingbootmysql.repositorio.FacturaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturaService {

    @Autowired
    public FacturaRepo facturaRepo;
    @Autowired
    public DetalleFacRepo detalleFacRepo;
}
