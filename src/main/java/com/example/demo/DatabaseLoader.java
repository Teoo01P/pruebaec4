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

		this.repositoryI.save(new Producto("lapicero","5.00"));
		this.repositoryI.save(new Producto("resaltador","4.00"));
		this.repositoryI.save(new Producto("borrador","5.00"));

		Producto tijera = new Producto("tijera","5.50");
		this.repositoryI.save(tijera);
		Producto cuaderno = new Producto("cuaderno","5.00");
		this.repositoryI.save(cuaderno);
		this.repositoryI.save(new Producto("colores","9.80"));


		Venta total = new Venta("zzzzz");
		this.repositoryB.save(total);

		this.repositoryN.save(new DetalleVenta(total, tijera));
		this.repositoryN.save(new DetalleVenta(total, cuaderno));
		

		

		


	}
}