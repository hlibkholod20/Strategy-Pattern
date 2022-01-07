package de.tum.in.ase.eist;

import java.util.List;

public class BinarySearch implements SearchStrategy {
	@Override
	public String performSearch(List<PhoneBookEntry> phoneBook, String name) {
		int l = 0; 
		int r = phoneBook.size() - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
 
            int res = name.compareTo(phoneBook.get(m).getName());
 
            // Check if x is present at mid
            if (res == 0)
                return phoneBook.get(m).getPhoneNumber();
 
            // If x greater, ignore left half
            if (res > 0)
                l = m + 1;
 
            // If x is smaller, ignore right half
            else
                r = m - 1;
        }
 
        return null;
	}
}
