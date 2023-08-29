import java.util.Scanner;

public class Email {

    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternativeEmail;
    private String companySuffix = "company.co.uk";

    // Constructor to receive first and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        //Call a method asking for the department - return the department
        this.department = setDepartment();

        //Call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is " + this.password);

        //Combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
    }

    // Ask for the department
    private String setDepartment() {
        System.out.print("New worker: " + firstName + ". Department Codes: \n1 for Finance\n2 for Marketing\n3 Sales\n0 for none\nEnter department code: ");
        Scanner in = new Scanner(System.in);
        int deptChoice = in.nextInt();
        if (deptChoice == 1) {return "finance";}
        else if (deptChoice == 2) {return "marketing";}
        else if (deptChoice == 3) {return "sales";}
        else { return ""; }
    }

    //Generate a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@£$%^&*()";
        char[] password = new char[length];
        for (int i=0; i<length; i++) {
            int randomValue = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(randomValue);
        }
        return new String(password);
    };

    // Set mailbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    // Set alternative email
    public void setAlternativeEmail(String altEmail) {
        this.alternativeEmail = altEmail;
    }

    public String getAlternativeEmail() {
        return alternativeEmail;
    }

    // Change password
    public void changePassword(String password) {
        this.password = password;
    }

    public String getPassword(String password) {
        return password;
    }

    public String showInformation() {
        return "DISPLAY NAME: " + firstName + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
     }

}
