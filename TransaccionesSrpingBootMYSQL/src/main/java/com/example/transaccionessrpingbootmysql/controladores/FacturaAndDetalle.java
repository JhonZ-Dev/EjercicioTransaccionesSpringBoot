package com.example.transaccionessrpingbootmysql.controladores;

import com.example.transaccionessrpingbootmysql.modelo.DetalleFacturaModelo;
import com.example.transaccionessrpingbootmysql.modelo.FacturaModelo;
import com.example.transaccionessrpingbootmysql.servicio.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

    @PostMapping("/guardar")
    public void guardarFactura(@RequestBody FacturaModelo facturaModelo, @RequestBody List<DetalleFacturaModelo> detalles) {
        facturaService.guardarFacturaV2(facturaModelo, detalles);
    }

    @PostMapping("/guardar/facturas")
    public void guardarFacturaV3(@RequestBody FacturaModelo facturaModelo) {
        facturaService.guardarFacturaV3(facturaModelo);
    }
    @PostMapping("/guardar/facturas/v4")
    public void guardarFacturaV4(@RequestBody FacturaModelo facturaModelo) {
        facturaService.guardarFacturaV4(facturaModelo);
    }

    @PostMapping("/guardar/facturas/v5")
    public void guardarFacturaV5(@RequestBody FacturaModelo facturaModelo) throws MethodArgumentNotValidException {
        facturaService.guardarFacturaV5(facturaModelo);
    }

    @PostMapping("/guardar/facturas/v6")
    public void guardarFacturaV6( @RequestBody FacturaModelo facturaModelo) throws MethodArgumentNotValidException {
        facturaService.guardarFacturaV7(facturaModelo);
    }

    @PostMapping("/guardar/facturas/v7")
    public void guardarFacturaV7(@RequestBody FacturaModelo facturaModelo) throws MethodArgumentNotValidException {
        facturaService.guardarFacturaV8(facturaModelo);
    }


}
