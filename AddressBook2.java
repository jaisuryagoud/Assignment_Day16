import java.util.Scanner;
class Book{
    Scanner s = new Scanner(System.in);
    //Nested class for each entry
    class Entry{
        private String first;
        private String last;
        private String address;
        private String email;
		  private String city;
		  private String state;
		  private String zip;
		  private String phonenumber;
        Entry(String first, String last, String address, String email, String city, String state, String zip, String phonenumber){
            this.first = first;
            this.last = last;
            this.address = address;
            this.email = email;
	    this.city = city;
	    this.state = state;
	    this.zip = zip;
	    this.phonenumber = phonenumber;
        }
        Entry(){
            first = "";
            last = "";
            address = "";
            email = "";
	    city = "";
	    state = "";
	    zip = "";
	    phonenumber = "";
        }
        public void readEntry(){
            System.out.println("First Name:"+first );
            System.out.println("Last Name:"+last );
            System.out.println("Address:"+address );
            System.out.println("Email:"+email );
	    System.out.println("City:"+city );
	    System.out.println("State:"+state );
	    System.out.println("Zip:"+zip );
            System.out.println("Phone Number:"+phonenumber );
        }
    }


    //Keeps track of how many entries are in the book
    private int entries = 0;
    Entry[] contents;
    public void initEntries(int e){
        contents = new Entry[e];
        for (int i = 0;i<contents.length;i++){      //Initializes an array of entries, then loops through to initialize each individual entry
            contents[i] = new Entry();
        }
    }
    public int getEntries(){
        return contents.length;
    }
    //Adds an entry to the book
    public void add(String first, String last, String address, String email, String city, String state, String zip, String phonenumber){
        if (entries<contents.length){
        contents[entries] = new Entry(first, last, address, email, city, state, zip, phonenumber);
        entries++;
        }
        else System.out.println("Error: book is full");
    }

    //Removes an entry from the book
    public void remove(int entry){
        if (entries>0){
            contents[entry] = new Entry();
            for (int i = 0;i<entries-entry;i++){
                if (entry+1==entries) contents[entry] = new Entry();
                else{
                    Entry temp = contents[entry+i];
                    contents[entry+i] = contents[entry+i+1]; //Removes an entry end moves each entry after it one backwards.
                    contents[entry+i+1] = temp;
                }
            }
            entries--;
            }
            else System.out.println("Error: book is empty.");
    }

    //Changes the values of an entry
    public void edit(String first, String last, String address, String email, String city, String state, String zip, String phonenumber, int selection){
        contents[selection].first = first;
        contents[selection].last = last;
        contents[selection].address = address;
        contents[selection].email = email;
		  contents[selection].city = city;
		  contents[selection].state = state;
		  contents[selection].zip = zip;
        contents[selection].phonenumber = phonenumber;
    }

    //Sorts the book based on a part of the entry
    //int n is used to tell which part of the entries to base the sort on
    public void sort(int n){
        for(int i = 0;i<contents.length;i++){
            for (int j = 0;j<contents.length;j++){
                switch(n){
                    case 1:
                        if (contents[i].first.compareTo(contents[j].first)<0){
                            Entry temp = contents[i];
                            contents[i] = contents[j];
                            contents[j] = temp;
                        }
                        break;
                    case 2:
                        if (contents[i].last.compareTo(contents[j].last)<0){
                            Entry temp = contents[i];
                            contents[i] = contents[j];
                            contents[j] = temp;
                        }
                        break;
                    case 3:
                        if (contents[i].address.compareTo(contents[j].address)<0){
                            Entry temp = contents[i];
                            contents[i] = contents[j];
                            contents[j] = temp;
                        }
                        break;
                    case 4:
                        if (contents[i].email.compareTo(contents[j].email)<0){
                            Entry temp = contents[i];
                            contents[i] = contents[j];
                            contents[j] = temp;
                        }
                        break;
                    case 5:
                        if (contents[i].city.compareTo(contents[j].city)<0){
                            Entry temp = contents[i];
                            contents[i] = contents[j];
                            contents[j] = temp;
                        }
                        break;
                    case 6:
                        if (contents[i].state.compareTo(contents[j].state)<0){
                            Entry temp = contents[i];
                            contents[i] = contents[j];
                            contents[j] = temp;
                        }
                        break;
                    case 7:
                        if (contents[i].zip.compareTo(contents[j].zip)<0){
                            Entry temp = contents[i];
                            contents[i] = contents[j];
                            contents[j] = temp;
                        }
                        break;
                    case 8:
                        if (contents[i].phonenumber.compareTo(contents[j].phonenumber)<0){
                            Entry temp = contents[i];
                            contents[i] = contents[j];
                            contents[j] = temp;
                        }
                        break;
                    default:
                        System.out.println("Error: invalid field");
                        break;
                }
            }
        }
    }
    public void addFromCopy(Entry e){
        if (entries<contents.length){
            contents[entries] = e;
            entries++;
            }
            else System.out.println("Error: book is full");
    }

}


public class AddressBook2 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.print("How many books do you want to create? ");
        int howManyBooks;
        int howManyEntries;

        Book[] library = new Book[0];


        while(true){
            howManyBooks = s.nextInt();
            if (howManyBooks>0){
                library = new Book[howManyBooks];                   //This code decides how many books are in the array of books/the library
                break;
            }
            else System.out.print("You must create at least 1 book.");
            }



        for (int i=0;i<library.length;i++){


            library[i] = new Book(); //Fixed reference to null because each book in the library had not been initialized yet.

            while(true){
                System.out.print("How many entries in book "+i+"? ");
                howManyEntries = s.nextInt();
                if (howManyEntries>0) {
                    library[i].initEntries(howManyEntries);                 //This code decides how many entries are in each book in the library
                    break;
                }
                else System.out.println("You must create at least 1 Entry.");
                }


        }
        boolean done = false;
        int selectedBook = 0;
        int selection;
        while (done==false){
            System.out.println("Book "+selectedBook+" is currently selected.");

            for (int i = 0;i<library[selectedBook].getEntries();i++){
                System.out.println("===========Entry "+i+" ===========");
                library[selectedBook].contents[i].readEntry(); //Accessing the array of entries INSIDE the array of books/the library
                System.out.println("================================");
            }


            System.out.println("Select an option!");
            System.out.println("1. Add an entry");
            System.out.println("2. Remove an entry");
            System.out.println("3. Edit an entry");
            System.out.println("4. Sort all entries in this book");
            System.out.println("5. Select another book");
            System.out.println("6. Exit the menu");
            System.out.print("> ");
            selection = s.nextInt();
            String first, last, address, email, city, state, zip, phonenumber;
            switch(selection){
            case 1: 
                System.out.print("First name? ");
                first = s.next();
                System.out.print("Last name? ");
                last = s.next();
                System.out.print("Address? ");
                address = s.next();
                System.out.print("Email? ");
                email = s.next();
                System.out.print("City? ");
                city = s.next();
                System.out.print("State? ");
                state = s.next();
                System.out.print("zip? ");
                zip = s.next();
                System.out.print("Phone Number? ");
                phonenumber = s.next();
                library[selectedBook].add(first, last, address, email, city, state, zip, phonenumber);
                break;
            case 2:
                System.out.print("Remove which entry? ");
                int entry = s.nextInt();
                library[selectedBook].remove(entry);
                break;
            case 3:
                System.out.print("Edit which entry?");
                int whichEntry = s.nextInt();
                System.out.print("First name? ");
                first = s.next();
                System.out.print("Last name? ");
                last = s.next();
                System.out.print("Address? ");
                address = s.next();
                System.out.print("Email? ");
                email = s.next();
                System.out.print("City? ");
                city = s.next();
                System.out.print("State? ");
                state = s.next();
                System.out.print("zip? ");
                zip = s.next();
                System.out.print("Phone Number? ");
                phonenumber = s.next();
                library[selectedBook].edit(first, last, address, email, city, state, zip, phonenumber, whichEntry);
                break;
            case 4:
                System.out.println("Sort alphabetically by which field?");
                System.out.println("1. Sort by first name");
                System.out.println("2. Sort by last name");
                System.out.println("3. Sort by address");
                System.out.println("4. Sort by email");
                System.out.println("5. Sort by city");
                System.out.println("6. Sort by state");
                System.out.println("7. Sort by zip");
                System.out.println("8. Sort by phonenumber");
                library[selectedBook].sort(s.nextInt());
                break;
            case 5:
                System.out.print("Select which book?");
                selectedBook = s.nextInt();
                break;
            case 6:
                done = true;
                break;
            default:
                System.out.print("Please choose a valid menu number");


            }

        }
    }
}
