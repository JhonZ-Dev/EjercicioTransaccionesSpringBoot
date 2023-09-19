package com.example.transaccionessrpingbootmysql.controladores;

import com.example.transaccionessrpingbootmysql.modelo.DetalleFacturaModelo;
import com.example.transaccionessrpingbootmysql.modelo.FacturaModelo;
import com.example.transaccionessrpingbootmysql.servicio.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FacturaAndDetalle {
    @Autowired
    public FacturaService facturaService;

    @PostMapping("/guardarFactura")
    public void guardarFactura(@RequestBody FacturaModelo facturaModelo) {
        List<DetalleFacturaModelo> detalles = facturaModelo.getFacturaModelos();
        facturaService.guardarFactura(facturaModelo, detalles);
    }

}
