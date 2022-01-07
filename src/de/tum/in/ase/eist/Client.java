package de.tum.in.ase.eist;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public final class Client {

	private static final int PHONEBOOK_MIN_SIZE = 5;
	private static final int PHONEBOOK_MAX_SIZE = 15;
	private static final int NUMBER_OF_SIMULATIONS = 10;
	private static final long PHONE_NUMBER_START_VALUE = 1000000;

	private Client() {
	}

	/**
	 * Main method.
	 * Add code to demonstrate your implementation here.
	 */
	public static void main(String[] args) {
		Context context = new Context();
		Policy policy = new Policy(context);
		for (int i = 0; i < NUMBER_OF_SIMULATIONS; i++) {
			context.setPhoneBook(createRandomPhoneBook());
			policy.configure();
			String nameToSearch = createNames(1).get(0);
			String phoneNumber = context.search(nameToSearch);
			System.out.println("Corresponding phone number for " + nameToSearch + ": " + phoneNumber);
		}
	}

	/**
	 * Generates list of {@link PhoneBookEntry} objects with random List size between 5 and 15.
	 * The list is with equal probability sorted or not.
	 */
	private static List<PhoneBookEntry> createRandomPhoneBook() {
		int listLength = randomIntegerWithin(PHONEBOOK_MIN_SIZE, PHONEBOOK_MAX_SIZE);

		List<PhoneBookEntry> phoneBook = createNames(listLength).stream()
        		.map(name -> new PhoneBookEntry(name, createRandomPhoneNumber())).collect(Collectors.toList());

		boolean sorted = randomIntegerWithin(0, 1) == 0;
		if (sorted) {
			phoneBook.sort(Comparator.comparing(PhoneBookEntry::getName));
		}
		return phoneBook;
	}

	/**
	 * creates pseudo-random int value within a range
	 *
	 * @param high upper bound of the range (included)
	 * @param low  lower bound of the range (included)
	 */
	private static int randomIntegerWithin(int low, int high) {
		return ThreadLocalRandom.current().nextInt(low, high + 1);
	}

	private static String createRandomPhoneNumber() {
		return String.valueOf(ThreadLocalRandom.current().nextLong(PHONE_NUMBER_START_VALUE, Long.MAX_VALUE));
	}

	private static List<String> createNames(int numberOfNames) {
		List<String> entryNames = new ArrayList<>();
		List<String> names = new ArrayList<>(List.of("Tom", "Bob", "Mary", "Lisa", "Anna", "Peter", "Stephan",
				"Philipp", "Nadine", "Jonas", "Jessica", "Johannes", "Christian", "Niclas", "Harry", "William",
				"Charles", "Mike", "Alan", "Ada"));
		for (int i = 0; i < numberOfNames; i++) {
			entryNames.add(names.remove(randomIntegerWithin(0, names.size() - 1)));
		}
		return entryNames;
	}
}
