// Author: Danhong Li
// Date:   Nov 15,2020
// Describe: Implememt Object Serialization

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

class Info implements Serializable {
	String name, email_address, DOB, phone_num;

	public Info() {
		super();
	}

	public Info(String name, String email_address, String phone_num, String DOB) {
		this.name = name;
		this.email_address = email_address;
		this.phone_num = phone_num;
		this.DOB = DOB;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail_address() {
		return email_address;
	}

	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}

	public String getPhone_num() {
		return phone_num;
	}

	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String DOB) {
		this.DOB = DOB;
	}

	@Override
	public String toString() {
		return "Info [Name= " + name + ",  Phone Number= " + phone_num
				+ ", Date of birth= " + DOB + ", Email Address= "
				+ email_address + "]";
	}

}

public class Serialization {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int choice = 0;
		Info i = new Info();
		do {

			System.out.println("\n1. Add information into the file");
			System.out
					.println("2. Retrieve information from a file and display them");
			System.out.println("3. Exit");
			System.out.print("Enter your choice: ");
			choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.print("Enter the name: ");
				i.name = scan.next();
				System.out.print("Enter the phone number: ");
				i.phone_num = scan.next();
				System.out.print("Enter the Date of birth (mm/dd/yy): ");
				i.DOB = scan.next();
				System.out.print("Enter the Email : ");
				i.email_address = scan.next();

				try {
					writeToFile(i);
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				try {
					readFile();

				} catch (ClassNotFoundException | IOException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				System.out.println("Exiting the application");
				System.exit(0);
			default:
				System.out
						.println("Incorrect input! Please re-enter choice from the menu");

			}
		} while (choice != 3);

	}

	public static void writeToFile(Info i) throws IOException {
		File file = new File("Information.bin");
		if (file.exists()) {
			boolean isexist = true;
			FileOutputStream fo = new FileOutputStream(file, true);
			ObjectOutputStream output_obj = new ObjectOutputStream(fo);

			long pos = 0;
			if (isexist) {
				pos = fo.getChannel().position() - 4;
				fo.getChannel().truncate(pos);
			}
			output_obj.writeObject(i);
		} else {
			file.createNewFile();
			FileOutputStream fo = new FileOutputStream(file);
			ObjectOutputStream output_obj = new ObjectOutputStream(fo);
			output_obj.writeObject(i);
		}
	}

	public static void readFile() throws IOException, ClassNotFoundException {
		File file = new File("Information.bin");
		if (file.exists()) {
			ObjectInputStream input_obj;
			try {
				FileInputStream fn = new FileInputStream(file);
				input_obj = new ObjectInputStream(fn);
				// make sure have content inside
				while (fn.available() > 0) {
					// read information
					Info i = (Info) input_obj.readObject();
					System.out.println(i);
				}
				input_obj.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
