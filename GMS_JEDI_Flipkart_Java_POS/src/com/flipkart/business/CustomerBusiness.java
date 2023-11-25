/**
 *
 */
package com.flipkart.business;
import com.flipkart.bean.Customer;
import com.flipkart.bean.GymCenter;
import com.flipkart.bean.Slot;
import com.flipkart.bean.BookedSlot;
import java.util.*;

/**
 *
 */
public class CustomerBusiness implements CustomerBusinessInterface {
	CustomerDao customerDao = new CustomerDaoImpl();
	List<BookedSlot> bookedSlotList=new ArrayList<>();
	public CustomerBusiness() {
		BookedSlot ob1=new BookedSlot();
		ob1.setGymCenterId(1);
		ob1.setSlotId(1);
		ob1.setUserId(2);
		ob1.setDate("1 Dec 2023");
		ob1.setUserEmail("asmi@flipfit");

		BookedSlot ob2=new BookedSlot();
		ob2.setGymCenterId(2);
		ob2.setSlotId(2);
		ob2.setUserId(1);
		ob2.setDate("2 Dec 2023");
		ob2.setUserEmail("arav@flipfit");

		bookedSlotList.add(ob1);
		bookedSlotList.add(ob2);
	}



	public Customer getCustomerDetails(String customerEmail) {
		return new Customer();
	}

	public List<GymCenter> viewAllGymCentres() {
		return new ArrayList<GymCenter>();
	}

	public List<Slot> viewAllSlots(int GymCenterId){
		System.out.println("Listing all Slots in  GymCenter");
		return new ArrayList<Slot>();
	}
	public boolean bookSlot(int gymCenterId,int slotId,String date,String customerEmail) {
		BookedSlot b = isAlreadyBooked(slotId,customerEmail,date);
		if(b != null) {
			cancelSlot(b.getId(),customerEmail);

		}
		System.out.println("Slot booked");
		return true;
	}


	public BookedSlot isAlreadyBooked(int slotId,String customerEmail,String date) {
		List<BookedSlot> bookedSlots = viewAllBookings(customerEmail);
		for(BookedSlot bst : bookedSlots){
			if(bst.getDate().equals(date) && bst.getSlotId()== slotId){
				return bst;
			}
		}
		return null;
	}


	public void cancelSlot(int bookingId,String customerEmail) {
		System.out.println("Cancelling Slot");
		customerDao.cancelSlot(bookingId , customerEmail);
	}

	public List<BookedSlot> viewAllBookings(String email) {
		System.out.println("Listing all booked slots of customer");

		List<BookedSlot> bookedSlots=new ArrayList<>();

		for(BookedSlot bs:bookedSlotList) {
			if (bs.getCustomerEmail().equals(email)) {

				bookedSlots.add(bs);
			}
		}
		return bookedSlots;
	}

}
