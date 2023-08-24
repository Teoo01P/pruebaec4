package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

	private final ProductoRepository repositoryI;
	private final VentaRepository repositoryB;
	private final DetalleVentaRepository repositoryN;

	@Autowired
	public DatabaseLoader(
		ProductoRepository repositoryI,
		VentaRepository repositoryB,
		DetalleVentaRepository repositoryN
		) {
		this.repositoryI = repositoryI;
		this.repositoryB = repositoryB;
		this.repositoryN = repositoryN;
	}

	@Override
	public void run(String... strings) throws Exception {

		this.repositoryI.save(new Producto("Primor", "12.00"));
		this.repositoryI.save(new Producto("Gloria","4.20"));
		this.repositoryI.save(new Producto("Costeño","5.00"));

		Producto cafetal = new Producto("Cafetal","8.50");
		this.repositoryI.save(cafetal);
		Producto manty = new Producto("Manty","5.00");
		this.repositoryI.save(manty);
		this.repositoryI.save(new Producto("Azucar","3.80"));


		Venta total = new Venta("zzzzz");
		this.repositoryB.save(total);

		this.repositoryN.save(new DetalleVenta(total, cafetal));
		this.repositoryN.save(new DetalleVenta(total, manty));
		

		

		


	}
}