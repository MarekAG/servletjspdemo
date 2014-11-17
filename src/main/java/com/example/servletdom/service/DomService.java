package com.example.servletdom.service;

import java.util.ArrayList;
import java.util.List;

import com.example.servletdom.domain.Dom;

public class DomService {

	private List<Dom> houses = new ArrayList<Dom>();

	public void add(Dom dom) {
		houses.add(new Dom(dom.getSize(), dom.getAddress(), dom.getNrOfDoors(),
				dom.getNrOfFloors(), dom.getColor(), dom.getAuthor(), dom.getYoc(), dom
						.getImageUrl()));
	}

	public List<Dom> showAll() {
		return houses;
	}

	public void remove(int i) {
		System.out.println(i);
		houses.remove(i);
	}

	public void removeAll() {
		houses.clear();
	}

}
