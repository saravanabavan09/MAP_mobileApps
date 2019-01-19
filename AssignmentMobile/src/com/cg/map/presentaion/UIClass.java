package com.cg.map.presentaion;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.map.exception.MAPException;
import com.cg.map.model.Mobile;
import com.cg.map.service.MapService;
import com.cg.map.service.MapServiceImpl;

public class UIClass {
	static Logger logger = Logger.getLogger(UIClass.class);

	public static void main(String[] args) {
		PropertyConfigurator.configure("resources/log4j.properties");
		Scanner scanner = null;
		int choice = 0;
		int result = 0;
		boolean choiceFlag = false;
		do {
			scanner = new Scanner(System.in);
			System.out.println("******** Mobile Purchase System **********");
			System.out.println("1. Inserting the customer name");
			System.out.println("2. View all the purchase history of all mobiles");
			System.out.println("3.  Delete the selected rows");
			System.out.println("4.  Search mobile based on price range");
			System.out.println("5. Exit");

			System.out.println("Enter your choice");
			try {
				choice = scanner.nextInt();
				choiceFlag = true;
				switch (choice) {
				case 1:
					scanner.nextLine();
					System.out.println("Enter CustomerName:");
					String CustomerName = scanner.nextLine();
					System.out.println("Enter the MailId:");
					String MailId = scanner.nextLine();
					System.out.println("Enter Mobile number:");
					String MobileNumber = scanner.next();
					System.out.println("Enter the MobileId:");
					int MobileId = scanner.nextInt();

					Mobile mobile = new Mobile();
					mobile.setCustomerName(CustomerName);
					mobile.setMailId(MailId);
					mobile.setMobileNumber(MobileNumber);
					mobile.setMobileId(MobileId);
					MapService service = new MapServiceImpl();

					try {
						boolean validateFlag = service.validateFields(mobile);
						if (validateFlag) {
							int PurchaseId = service.addCustomerDetails(mobile);
							System.out.println("successfully completed" + PurchaseId);
						}
					} catch (MAPException e) {
						
					}

					break;
				case 2:

					MapService service1 = new MapServiceImpl();
					logger.info("Before hitting the service layer");
					List<Mobile> list;
					try {
						list = service1.getMobiles();
						System.out.println("Mobile Details");
						for (Mobile lab : list) {

							System.out.println(lab.getMobileId() + "---" + lab.getPhoneName() + "---" + lab.getPrice()
									+ "---" + lab.getQuantity());
						}
					} catch (MAPException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					break;
				case 3:

					System.out.println("Enter the ID for deletion: ");
					int idForDelete = scanner.nextInt();

					MapService serviceDelete = new MapServiceImpl();
					try {

						result = serviceDelete.deleteDetails(idForDelete);
						System.out.println(result + " rows deleted");

					} catch (MAPException e) {

						System.out.println(e.getMessage());
					}

					break;
				case 4:
					System.out.println("Enter the minimum range");
					Double minprice = scanner.nextDouble();
					System.out.println("Enter the maximum range");
					Double maxprice = scanner.nextDouble();
					Mobile mobile2 = new Mobile();
					mobile2.setMinprice(minprice);
					mobile2.setMaxprice(maxprice);
					MapService serviceSearch = new MapServiceImpl();

					try {
						List<Mobile> list1 = serviceSearch.searchDetails(mobile2);
						for (Mobile mobile11 : list1) {
							System.out.println(mobile11.getMobileId() + "----" + mobile11.getPhoneName() + "----"
									+ mobile11.getPrice() + "----" + mobile11.getQuantity());

						}

					} catch (MAPException e) {
						logger.error(e.getMessage());
						System.out.println(e.getMessage());
					}

					break;
				case 5:
					System.exit(0);
					break;
				default:
					choiceFlag = false;
					System.out.println("input should be in the range of (1-4)");
					System.out.println("Enter your input again");
					break;
				}
			} catch (InputMismatchException e) {
				System.err.println("Enter only digits");
				System.out.println("Enter you input again");
			}

		} while (!choiceFlag);

		scanner.close();

	}
}
