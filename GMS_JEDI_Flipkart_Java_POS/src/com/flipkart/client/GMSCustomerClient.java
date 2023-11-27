/**
 * 
 */
package com.flipkart.client;
import com.flipkart.business.*;
import com.flipkart.bean.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * 
 */
public class GMSCustomerClient {

	CustomerBusinessInterface customerBusiness = new CustomerBusiness();

	PaymentBusinessInterface paymentBusiness = new PaymentBusiness();
	GymOwnerBusinessInterface gymOwnerBusiness = new GymOwnerBusiness();
	UserBusinessInterface userBusiness = new UserBusiness();
	
	Customer customer = new Customer();
	User user = new User();
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public void customerRegistration(Scanner sc) {
		System.out.println("Enter your name: ");
		customer.setName(sc.next());
		System.out.println("Enter your mobile: ");
		customer.setPhone(sc.nextLong());
		System.out.println("Enter your email: ");
		customer.setEmail(sc.next());
		System.out.println("Enter your address: ");
		customer.setAddress(sc.next());
		System.out.println("Enter your password: ");
		String password = sc.next();
		
		user.setPassword(password);
		user.setEmail(customer.getEmail());
		user.setRoleId(3);
		userBusiness.registerUser(user);
		userBusiness.registerCustomer(customer);
	}
	
	


	public void bookSlot(Scanner sc,String customerEmail) {
		System.out.println("Enter Gym ID:");
		int gymCentreId = sc.nextInt();
		System.out.println("Enter Slot ID:");
		int slotId = sc.nextInt();

//		LocalDateTime currentTime = LocalDateTime.now();
//		DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//		String formattedDate = currentTime.format(myFormat);
		System.out.println("Enter the date in DD-MM-YYYY format:");
		String date = sc.next();
		customerBusiness.bookSlot(gymCentreId,slotId,date,customerEmail);
		System.out.println("Enter Card number:");
		Long cardNumber = sc.nextLong();
		System.out.println("Enter CVV:");
		int cvv = sc.nextInt();
		System.out.println("Redirecting to payment gateway .....");
		paymentBusiness.makePayment(cardNumber, customerEmail);
		System.out.println("Slot Booked");

	}
	
	public void cancelBookedSlot(Scanner sc,String customerEmail)
	{
		List<BookedSlot> registeredBookings = customerBusiness.viewAllBookings(customerEmail);
		System.out.println("Enter the BookedSlotId");
		int id = sc.nextInt();
		for(int i=0;i<registeredBookings.size();i++)
		{
			BookedSlot obj = registeredBookings.get(i);
			if(obj.getId() == id)
				customerBusiness.cancelSlot(id, customerEmail);
		}
	}
	
	public void viewAllBookedSlots(String customerEmail) {
		List<BookedSlot> bookedSlots= customerBusiness.viewAllBookings(customerEmail);
//		System.out.printf("%-15s\t", "ID");
//		System.out.printf("%-15s\t", bs.getSlotId());
//		System.out.printf("%-15s\t", bs.getGymCenterId());
//		System.out.printf("%-15s\t", bs.getDate());
//		System.out.printf("%-15s\t", bs.getCustomerEmail());
		System.out.printf("%-15s\t","Id");
		System.out.printf("%-15s\t","Slot Id");
		System.out.printf("%-15s\t","GymCenterID");
		System.out.printf("%-15s\t","Date");
		System.out.printf("%-15s\t","Customer Email");
		System.out.println();
		for(BookedSlot bs: bookedSlots) {
			System.out.printf("%-15s\t", bs.getId());
			System.out.printf("%-15s\t", bs.getSlotId());
			System.out.printf("%-15s\t", bs.getGymCenterId());
			System.out.printf("%-15s\t", bs.getDate());
			System.out.printf("%-15s\t", bs.getCustomerEmail());
			System.out.println();
		}
	}
	
	public void viewCatalog() {
		List<GymCenter> allApprovedGyms = customerBusiness.viewAllGymCentres();
		System.out.printf("%-15s\t","Id");
		System.out.printf("%-15s\t","Location");
		System.out.printf("%-15s\t","No of Seats");
		System.out.println();
		for(GymCenter gym: allApprovedGyms) {
			System.out.printf("%-15s\t", gym.getId());
			System.out.printf("%-15s\t", gym.getLocation());
			System.out.printf("%-15s\t", gym.getNoOfSeats());
			System.out.printf("%-15s\t", "Yes");
			System.out.println("Listing all available slots");
			List<Slot> allAvilableSlots = gymOwnerBusiness.viewAllSlots(gym.getId());
			System.out.printf("%-15s\t","Id");
			System.out.printf("%-15s\t","Time");
			System.out.println();
			for(Slot slot: allAvilableSlots) {
				System.out.printf("%-15s\t", slot.getId());
				System.out.printf("%-15s\t", slot.getTime());
				System.out.println();
			}
			System.out.println("-----------------------------");
		}
		System.out.println("-----------------------------");
	}
	
	public void customerPage(Scanner sc, String customerEmail) throws Exception{
		
		while(true) {
			System.out.println(ANSI_YELLOW + "------------------------------ \n 1. Book slot \n 2. Cancel Booked slot \n 3. View all booked Slots \n 4. View catalog \n 5. Exit \n ------------------------------ \n Enter your choice: " + ANSI_RESET);
//			System.out.println("------------------------------");
//			System.out.println("1. Book slot");
//			System.out.println("2. Cancel Booked slot");
//			System.out.println("3. View all booked Slots");
//			System.out.println("4. View catalog");
//			System.out.println("5. Exit");
//			System.out.println("------------------------------");
//			System.out.print("Enter your choice: ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				bookSlot(sc,customerEmail);
				break;
			case 2:
				cancelBookedSlot(sc,customerEmail);
				break;
			case 3:
				viewAllBookedSlots(customerEmail);
				break;
			case 4:
				viewCatalog();
				break;
			case 5:
				GMSApplicationClient.mainPage();
				break;
			default:
				System.out.println(ANSI_RED + "Incorrect Choice" + ANSI_RESET);
//				System.out.println("Incorrect choice");
			}
		}	
		
	}

}
