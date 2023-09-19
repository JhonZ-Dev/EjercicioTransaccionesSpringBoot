package com.example.transaccionessrpingbootmysql.controladores;

import com.example.transaccionessrpingbootmysql.servicio.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FacturaAndDetalle {
    @Autowired
    public FacturaService facturaService;

}
