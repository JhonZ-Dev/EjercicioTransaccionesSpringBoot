package com.example.transaccionessrpingbootmysql.servicio;

import org.springframework.beans.factory.annotation.Autowired;

public class FacturaService {

    @Autowired
    public FacturaRepo facturaRepo;
    @Autowired
    public DetalleFacRepo detalleFacRepo;
}
