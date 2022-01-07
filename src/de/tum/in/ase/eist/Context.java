package de.tum.in.ase.eist;
import java.util.List;

public class Context {
	private List<PhoneBookEntry> phoneBook;
	private SearchStrategy searchAlgorithm;
	
	public boolean isPhoneBookSorted() {
		List<String> names = phoneBook.stream().map(i -> i.getName()).sorted().toList();
		for (int i = 0; i < phoneBook.size(); i++) {
			if (!phoneBook.get(i).getName().equals(names.get(i))) return false;
		}
		return true;
	}
	
	public String search(String name) {
		return searchAlgorithm.performSearch(phoneBook, name);
	}
	
	public List<PhoneBookEntry> getPhoneBook() {
		return phoneBook;
	}
	
	public void setPhoneBook(List<PhoneBookEntry> phoneBook) {
		this.phoneBook = phoneBook;
	}
	
	public SearchStrategy getSearchAlgorithm() {
		return searchAlgorithm;
	}
	
	public void setSearchAlgorithm(SearchStrategy searchAlgorithm) {
		this.searchAlgorithm = searchAlgorithm;
	}
}
