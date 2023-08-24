package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "detalleVentas", path = "detalleVentas")
public interface DetalleVentaRepository extends CrudRepository<DetalleVenta, Long> {
    
}
