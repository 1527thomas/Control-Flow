import java.util.Scanner;

public class Scholarship {

	private static int studentAge;
	private static boolean stateResidency;
	private static boolean partTimeJob;
	private static boolean stateTax;
	private static boolean volunteer;

	static boolean isWithinAge(int age) {
		if (age < 18) {
			return false;
		} else if (age > 24) {
			return false;
		}
		return true;
	}

	static boolean question(String response) {
		if (response.equals("no")) {
			return false;
		} else if (response.equals("yes")) {
			return true;
		}
		throw new IllegalArgumentException("Invalid Response");
	}

	static int ineligible() {
		return 0;
	}

	static int eligible() {
		return 1;
	}

	static void dean() {
		sop("Dean for consideration");
		return;
	}

	private static void sop(String stmt) {
		System.out.println(stmt);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		sop("Please enter your age: ");
		while (scan.hasNext()) {
			int age = scan.nextInt();
			// A
			if (isWithinAge(age)) {
				// B
				sop("Have you lived in California the past 2 years? Enter yes or no");
				String residency = scan.next();
				if (question(residency)) {
					// C
					sop("Have you worked part time for at least 6 months in the relevant field of study?");
					String job = scan.next();
					if (question(job)) {
						// F
						sop("Is your household income less than $5000 annually?");
						String income = scan.next();
						if (question(income)) {
							dean();
						} else {
							eligible();
						}
					} else {
						// E
						sop("Have you volunteered for a cause and are you able to show proof of it?");
						String volunteer = scan.next();
						if (question(volunteer)) {
							sop("Is your household income less than $5000 annually?");
							String income = scan.next();
							if (question(income)) {
								dean();
							} else {
								eligible();
							}
						} else {
							ineligible();
						}
					}
				} else {
					// D
					sop("Have your parent's paid the California State Tax for at least 1 year? Enter yes or no");
					String tax = scan.next();
					if (question(tax)) {
						// C
						sop("Have you worked part time for at least 6 months in the relevant field of study?");
						String job = scan.next();
						if (question(job)) {
							// F
							sop("Is your household income less than $5000 annually?");
							String income = scan.next();
							if (question(income)) {
								dean();
							} else {
								eligible();
							}
						}
					} else {
						ineligible();
					}
				}
			} else {
				ineligible();
			}
		}

	}
}
