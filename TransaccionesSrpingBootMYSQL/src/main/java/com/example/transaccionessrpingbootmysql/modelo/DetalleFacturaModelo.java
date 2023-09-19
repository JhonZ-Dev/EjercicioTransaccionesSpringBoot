package com.example.transaccionessrpingbootmysql.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_factura")
    private FacturaModelo facturaModelo;

}
