package com.example.transaccionessrpingbootmysql.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Data
@Table(name = "tbl_factura")
public class FacturaModelo {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id_factura;
    private String num_factura;
    private String fech_facura;
    private String nombreCliente;
}
