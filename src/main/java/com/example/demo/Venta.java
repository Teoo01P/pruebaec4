package com.example.demo;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Venta {

	private @Id @GeneratedValue Long id;
	private String total;

	private Venta() {}

	public Venta(String total) {
		this.total = total;
	}

	

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Venta venta = (Venta) o;
		return Objects.equals(id, venta.id) &&
			Objects.equals(total, venta.total);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id, total);
	}


	@Override
	public String toString() {
		return "Venta{" +
			"id=" + id +
			", total='" + total + '\'' +
			'}';
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	
}