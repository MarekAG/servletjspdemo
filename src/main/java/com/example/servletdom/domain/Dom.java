package com.example.servletdom.domain;

public class Dom {

	private int size;
	private String address;
	private int nrOfDoors;
	private int nrOfFloors;
	private String color;
	private String author;
	private int yoc;
	private String imageUrl;

	public Dom() {
		super();
	}

	public Dom(int size, String address, int nrOfDoors, int nrOfFloors,
			String color, String author, int yoc, String imageUrl) {
		super();
		this.size = size;
		this.address = address;
		this.nrOfDoors = nrOfDoors;
		this.nrOfFloors = nrOfFloors;
		this.color = color;
		this.author = author;
		this.yoc = yoc;
		this.imageUrl = imageUrl;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getNrOfDoors() {
		return nrOfDoors;
	}

	public void setNrOfDoors(int nrOfDoors) {
		this.nrOfDoors = nrOfDoors;
	}

	public int getNrOfFloors() {
		return nrOfFloors;
	}

	public void setNrOfFloors(int nrOfFloors) {
		this.nrOfFloors = nrOfFloors;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYoc() {
		return yoc;
	}

	public void setYoc(int yoc) {
		this.yoc = yoc;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "<img src='" + this.getImageUrl()
				+ "' height='150' width='200'> Metraż (m<sup>2</sup>): "
				+ this.getSize() + " <br/>Adres: " + this.address
				+ " <br/>Ilość drzwi: " + this.nrOfDoors
				+ " <br/>Ilość pięter: " + this.nrOfFloors + " <br/>Kolor: "
				+ this.color + " <br/>Rok budowy: " + this.yoc
				+ " <br/>Autor: " + this.author;

	}

}