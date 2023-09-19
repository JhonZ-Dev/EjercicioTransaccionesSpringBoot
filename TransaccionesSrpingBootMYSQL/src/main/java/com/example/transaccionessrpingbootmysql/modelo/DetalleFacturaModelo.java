package com.example.transaccionessrpingbootmysql.modelo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tbl_detalleFactura")
public class DetalleFacturaModelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_detalle;
    private String producto, cantidadProducto;
    private Double precioUnitario, precioTotal;
}
