package com.example.transaccionessrpingbootmysql.servicio;

import com.example.transaccionessrpingbootmysql.modelo.DetalleFacturaModelo;
import com.example.transaccionessrpingbootmysql.modelo.FacturaModelo;
import com.example.transaccionessrpingbootmysql.repositorio.DetalleFacRepo;
import com.example.transaccionessrpingbootmysql.repositorio.FacturaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.MethodArgumentNotValidException;

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
    public void guardarFacturaV4(FacturaModelo facturaModelo) {
        try {
            guardarFacturaConRollback(facturaModelo);
        } catch (MethodArgumentNotValidException e) {
            // Manejar la excepción de validación
            // Por ejemplo, registrar el error, devolver un mensaje al usuario, etc.
        } catch (Exception e) {
            // Manejar otras excepciones
            // Por ejemplo, registrar el error, devolver un mensaje al usuario, etc.
        }
    }
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void guardarFacturaConRollback(FacturaModelo facturaModelo) throws MethodArgumentNotValidException {
        List<DetalleFacturaModelo> detalles = facturaModelo.getFacturaModelos();
        if (detalles != null) {
            for (DetalleFacturaModelo detalle : detalles) {
                detalle.setFacturaModelo(facturaModelo);
                detalleFacRepo.save(detalle);
            }
        }
        facturaRepo.save(facturaModelo);
    }
    @Transactional(rollbackFor = {MethodArgumentNotValidException.class, Exception.class})
    public void guardarFacturaV5(FacturaModelo facturaModelo) throws MethodArgumentNotValidException {
        List<DetalleFacturaModelo> detalles = facturaModelo.getFacturaModelos();
        if (detalles != null) {
            for (DetalleFacturaModelo detalle : detalles) {
                detalle.setFacturaModelo(facturaModelo);
                detalleFacRepo.save(detalle); // Guardar cada detalle
            }
        }
        facturaRepo.save(facturaModelo); // Guardar la factura (esto también guardará los detalles debido a la cascada definida en la relación)
    }

    @Transactional(rollbackFor = Exception.class)
    public void guardarFacturaV7(FacturaModelo facturaModelo) throws MethodArgumentNotValidException {
        guardarFacturaConRollbackV1(facturaModelo);
    }

    private void guardarFacturaConRollbackV1(FacturaModelo facturaModelo) throws MethodArgumentNotValidException {
        List<DetalleFacturaModelo> detalles = facturaModelo.getFacturaModelos();
        if (detalles != null) {
            for (DetalleFacturaModelo detalle : detalles) {
                detalle.setFacturaModelo(facturaModelo);
                detalleFacRepo.save(detalle); // Guardar cada detalle
            }
        }
        facturaRepo.save(facturaModelo); // Guardar la factura (esto también guardará los detalles debido a la cascada definida en la relación)
    }
    public void guardarFacturaV8(FacturaModelo facturaModelo) throws MethodArgumentNotValidException {
        for (DetalleFacturaModelo detalle : facturaModelo.getFacturaModelos()) {
            validarDetalleFacturaModelo(detalle);
            detalle.setFacturaModelo(facturaModelo);
            detalleFacRepo.save(detalle);
        }
        facturaRepo.save(facturaModelo);
    }
}
