package com.example.transaccionessrpingbootmysql.servicio;

import com.example.transaccionessrpingbootmysql.modelo.DetalleFacturaModelo;
import com.example.transaccionessrpingbootmysql.modelo.FacturaModelo;
import com.example.transaccionessrpingbootmysql.repositorio.DetalleFacRepo;
import com.example.transaccionessrpingbootmysql.repositorio.FacturaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FacturaService {

    @Autowired
    public FacturaRepo facturaRepo;
    @Autowired
    public DetalleFacRepo detalleFacRepo;

    @Transactional
    public void guardarFactura(FacturaModelo facturaModelo, List<DetalleFacturaModelo> detalles) {
        facturaModelo.setFacturaModelos(detalles); // Establecer la relación entre factura y detalles
        facturaRepo.save(facturaModelo); // Guardar la factura (esto también guardará los detalles debido a la cascada definida en la relación)

        // Asegurarse de establecer la relación entre cada detalle y la factura antes de guardar los detalles
        for (DetalleFacturaModelo detalle : detalles) {
            detalle.setFacturaModelo(facturaModelo);
            detalleFacRepo.save(detalle); // Guardar cada detalle
        }
    }

    @Transactional
    public void guardarFacturaV2(FacturaModelo facturaModelo, List<DetalleFacturaModelo> detalles) {
        facturaModelo.setFacturaModelos(detalles); // Establecer la relación entre factura y detalles
        facturaRepo.save(facturaModelo); // Guardar la factura (esto también guardará los detalles debido a la cascada definida en la relación)

        // Asegurarse de establecer la relación entre cada detalle y la factura antes de guardar los detalles
        for (DetalleFacturaModelo detalle : detalles) {
            detalle.setFacturaModelo(facturaModelo);
            detalleFacRepo.save(detalle); // Guardar cada detalle
        }
    }
    @Transactional
    public void guardarFacturaV3(FacturaModelo facturaModelo) {
        List<DetalleFacturaModelo> detalles = facturaModelo.getFacturaModelos();
        if (detalles != null) {
            for (DetalleFacturaModelo detalle : detalles) {
                detalle.setFacturaModelo(facturaModelo);
                detalleFacRepo.save(detalle);
            }
        }
        facturaRepo.save(facturaModelo);
    }
}
