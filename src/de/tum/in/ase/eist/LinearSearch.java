package de.tum.in.ase.eist;

import java.util.List;

public class LinearSearch implements SearchStrategy {
	@Override
	public String performSearch(List<PhoneBookEntry> phoneBook, String name) {
		for (PhoneBookEntry entity : phoneBook) {
			if (entity.getName().equals(name)) {
				return entity.getPhoneNumber();
			}
		}
		return null;
	}
}
