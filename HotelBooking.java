// The "HotelBooking" class.
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.text.*;
public class HotelBooking extends JFrame implements ActionListener
{
    JButton search, book, del, clear;
    JLabel nameLbl, phoneLbl, cardLbl, title, cInLbl, cOutLbl, plpLbl, hotelLbl, roomLbl, numRoomLbl, hLbl, rLbl, pic;
    JComboBox hotelName, hotelRoom, plp, numRoom;
    JTextField nameTxt, phoneTxt, cardTxt, hExtra, rExtra, pExtra, rpExtra, gHExtra, gRExtra, cInTxt, cOutTxt; //or plp here
    ImageIcon getPic;
    Container frame;
    public HotelBooking ()
    {
	super ("HotelBooking"); // Set the frame's name
	frame = getContentPane ();

	//Custom layout
	frame.setLayout (null);

	try
	{
	    String file1 = "hotel.txt";
	    String file2 = "hotelTypes.txt";
	    String hNam[] = sortName (indexName (file1)); //calling the sortName method and sorting
	    String rNam[] = sortName (indexName (file2)); //calling the sortName method and sorting

	    //Picture Compnents
	    Toolkit dir = Toolkit.getDefaultToolkit ();
	    getPic = new ImageIcon (dir.getImage ("hotelPic2.jpg"));
	    pic = new JLabel (getPic); //setting label to the picture
	    pic.setBounds (510, 10, 100, 110); //setting the bounds

	    //Title Compnents
	    title = new JLabel ("Ontario Hotel Booking - By Parthiv Patel");
	    title.setFont (new Font ("Aharoni", Font.ITALIC, 22));
	    title.setBounds (10, 10, 400, 67);

	    //Name Components
	    nameLbl = new JLabel ("Name");
	    nameLbl.setFont (new Font ("Arial", Font.BOLD, 12));
	    nameLbl.setBounds (10, 145, 221, 67);

	    nameTxt = new JTextField (""); //textfield
	    nameTxt.setBounds (46, 170, 221, 20); //text field

	    //Phone Number Components
	    phoneLbl = new JLabel ("Phone Number");
	    phoneLbl.setFont (new Font ("Arial", Font.BOLD, 12));
	    phoneLbl.setBounds (288, 145, 221, 67);

	    phoneTxt = new JTextField ("");
	    phoneTxt.setBounds (374, 170, 221, 20); //405 or 405

	    //Credit Card Components
	    cardLbl = new JLabel ("Credit Card");
	    cardLbl.setFont (new Font ("Arial", Font.BOLD, 12));
	    cardLbl.setBounds (288, 185, 221, 67);

	    cardTxt = new JTextField ("");
	    cardTxt.setBounds (354, 210, 221, 20); //405 or 405

	    //Check-In Components
	    cInLbl = new JLabel ("Check-In Date");
	    cInLbl.setFont (new Font ("Arial", Font.BOLD, 12));
	    cInLbl.setBounds (10, 190, 221, 67);

	    cInTxt = new JTextField ("mm-dd-yy"); //textfield
	    cInTxt.setBounds (91, 215, 100, 20); //text field

	    //Check-Out Components
	    cOutLbl = new JLabel ("No. of Nights");
	    cOutLbl.setFont (new Font ("Arial", Font.BOLD, 12));
	    cOutLbl.setBounds (10, 214, 221, 67);

	    cOutTxt = new JTextField ("1"); //textfield
	    cOutTxt.setBounds (91, 240, 40, 20); //text field

	    //People Components
	    plpLbl = new JLabel ("No. of People");
	    plpLbl.setFont (new Font ("Arial", Font.BOLD, 12));
	    plpLbl.setBounds (10, 254, 221, 67);

	    String num[] = new String [9]; //setting size of maximum number of people
	    int inc = 1; //increment
	    for (int i = 0 ; i < num.length ; i++)
	    {
		num [i] = inc + ""; 
		inc++; //getting numbers frmo 1-9
	    }
	    plp = new JComboBox (num); //displaying numbers from 1-9
	    plp.setBounds (91, 265, 40, 50);

	    //Number of Rooms Components
	    numRoomLbl = new JLabel ("No. of Rooms");
	    numRoomLbl.setFont (new Font ("Arial", Font.BOLD, 12));
	    numRoomLbl.setBounds (10, 307, 221, 67);

	    String lim[] = new String [5]; //setting size of maximum number of rooms
	    int counter = 1; //counter
	    for (int i = 0 ; i < lim.length ; i++)
	    {
		lim [i] = counter + "";
		counter++; //getting numbers frmo 1-5
	    }
	    numRoom = new JComboBox (lim); //displaying numbers from 1-5
	    numRoom.setBounds (91, 318, 40, 50);

	    //Hotel Compnents *ADD THIS AT THE TOP SAME WITH HOTEL TYPE*
	    hotelLbl = new JLabel ("Hotel");
	    hotelLbl.setFont (new Font ("Arial", Font.BOLD, 16));
	    hotelLbl.setBounds (135, 60, 140, 45); //button bounds

	    hotelName = new JComboBox (hNam); //adding hotels sorted alphabetically
	    hotelName.setBounds (10, 100, 298, 50);

	    //Hotel Type Components
	    roomLbl = new JLabel ("Room Type");
	    roomLbl.setFont (new Font ("Arial", Font.BOLD, 16));
	    roomLbl.setBounds (374, 60, 140, 45); //button bounds

	    hotelRoom = new JComboBox (rNam); //adding rooms (hotelTypes) sort alphabetically
	    hotelRoom.setBounds (345, 100, 152, 50);

	    //Hotel Price Components
	    hLbl = new JLabel ("Hotel Price: ($)");
	    hLbl.setFont (new Font ("Arial", Font.BOLD, 12));
	    hLbl.setBounds (140, 214, 221, 67);

	    hExtra = new JTextField ("100.00");
	    hExtra.setBounds (224, 238, 52, 20);
	    hExtra.setEditable (false);

	    //Room Price Components
	    rLbl = new JLabel ("Room Price: ($)");
	    rLbl.setFont (new Font ("Arial", Font.BOLD, 12));
	    rLbl.setBounds (140, 242, 221, 67);

	    rExtra = new JTextField ("20.00");
	    rExtra.setBounds (228, 266, 52, 20);
	    rExtra.setEditable (false);

	    //Extra Components
	    pExtra = new JTextField ("1");
	    pExtra.setBounds (10, 435, 221, 20);
	    pExtra.setEditable (false);
	    pExtra.setVisible (false);

	    rpExtra = new JTextField ("1");
	    rpExtra.setBounds (10, 465, 221, 20);
	    rpExtra.setEditable (false);
	    rpExtra.setVisible (false);

	    gHExtra = new JTextField ("Bellamond Suites");
	    gHExtra.setBounds (10, 500, 221, 20);
	    gHExtra.setEditable (false);
	    gHExtra.setVisible (false);

	    gRExtra = new JTextField ("Double");
	    gRExtra.setBounds (10, 535, 221, 20);
	    gRExtra.setEditable (false);
	    gRExtra.setVisible (false);

	    //Buttons
	    //Search Components
	    search = new JButton ("Search a hotel"); //Button
	    search.setForeground (Color.RED); //button colour font
	    search.setBounds (290, 245, 140, 45); //button bounds

	    //Book Components
	    book = new JButton ("Make Booking"); //Button
	    book.setForeground (Color.RED); //button colour font
	    book.setBounds (290, 297, 140, 45); //button bounds

	    //Delete Components
	    del = new JButton ("Delete Booking"); //Button
	    del.setForeground (Color.RED); //button colour font
	    del.setBounds (440, 245, 140, 45); //button bounds

	    //Clear Components
	    clear = new JButton ("Clear");
	    clear.setForeground (Color.RED); //button colour font
	    clear.setBounds (440, 297, 140, 45); //button bounds

	    //press able
	    hotelName.addActionListener (this);
	    hotelRoom.addActionListener (this);
	    plp.addActionListener (this);
	    numRoom.addActionListener (this);
	    search.addActionListener (this);
	    book.addActionListener (this);
	    del.addActionListener (this);
	    clear.addActionListener (this);

	    //add to frame to display
	    frame.add (nameLbl);
	    frame.add (phoneLbl);
	    frame.add (cardLbl);
	    frame.add (cInLbl);
	    frame.add (cOutLbl);
	    frame.add (hotelLbl);
	    frame.add (roomLbl);
	    frame.add (plpLbl);
	    frame.add (hLbl);
	    frame.add (rLbl);
	    frame.add (numRoomLbl);
	    frame.add (title);
	    frame.add (hotelName);
	    frame.add (hotelRoom);
	    frame.add (plp);
	    frame.add (numRoom);
	    frame.add (nameTxt);
	    frame.add (phoneTxt);
	    frame.add (cardTxt);
	    frame.add (cInTxt);
	    frame.add (cOutTxt);
	    frame.add (search);
	    frame.add (book);
	    frame.add (del);
	    frame.add (clear);
	    frame.add (hExtra);
	    frame.add (rExtra);
	    frame.add (pExtra);
	    frame.add (rpExtra); //rp stands for roomPrice
	    frame.add (gHExtra);
	    frame.add (gRExtra);
	    frame.add (pic);
	}
	catch (java.io.IOException e)
	{
	    JOptionPane.showMessageDialog (null, "Please make sure you have all the files\n- hotel.txt and hotelTypes.txt");
	    System.exit (0);
	}

	setSize (650, 440); //replace 600 with 530     // Set the frame's size
	show ();                // Show the frame
    } // Constructor


    public void actionPerformed (ActionEvent e)
    {
	try
	{
	    try
	    {
		String file1 = "hotel.txt";
		String file2 = "hotelTypes.txt";
		String hNam[] = sortName (indexName (file1));
		double hPrice[] = sortPrice (indexName (file1), indexPrice (file1));
		String rNam[] = sortName (indexName (file2));
		double rPrice[] = sortPrice (indexName (file2), indexPrice (file2));
		
		DecimalFormat df = new DecimalFormat ("#.00"); //Decimal formating

		if (e.getSource () == hotelName) //hotelName list
		{
		    JComboBox cb = (JComboBox) e.getSource (); 
		    String text = (String) cb.getSelectedItem (); //getting the selected item

		    String val = "" + df.format (hPrice [cb.getSelectedIndex ()]); //getting the index of selected item

		    gHExtra.setText (text); //Output
		    hExtra.setText (val); //Output

		}
		else if (e.getSource () == hotelRoom)
		{
		    JComboBox hR = (JComboBox) e.getSource (); //hR stands for hotelRoom
		    String text2 = (String) hR.getSelectedItem (); //getting the selected item

		    String val2 = "" + df.format (rPrice [hR.getSelectedIndex ()]); //getting the index of selected item

		    gRExtra.setText (text2); //Output
		    rExtra.setText (val2); //Output
		}
		else if (e.getSource () == plp)
		{
		    JComboBox list = (JComboBox) e.getSource ();
		    String people = (String) list.getSelectedItem ();

		    pExtra.setText (people);
		}
		else if (e.getSource () == numRoom)
		{
		    JComboBox list2 = (JComboBox) e.getSource ();
		    String rooms = (String) list2.getSelectedItem ();

		    rpExtra.setText (rooms);
		}
		else if (e.getSource () == search) //search button
		{
		    try
		    {
			try
			{
			    String findMe = JOptionPane.showInputDialog ("Enter Hotel to search"); //input

			    int loc = findName (extraSpace (findMe.toUpperCase ()), hNam); // call findName (binary search) method with array and name and calls the extraSpace method
			    if (loc < 0) // -1 location means not found
			    {
				JOptionPane.showMessageDialog (null, findMe + " not found\n- Make sure there is no extra space (' ') in between the words or in the file\n- Also our searching supports inputs such as: '  hotel name' or 'hotel name   ' or '  hotel name  '"); //output
			    }
			    else
			    {
				JOptionPane.showMessageDialog (null, "Name: " + hNam [loc] + "\nPrice Per Night: $" + hPrice [loc]); //output
			    }
			}
			catch (java.lang.StringIndexOutOfBoundsException k)  //Nothing is inputted
			{
			    JOptionPane.showMessageDialog (null, "  not found\n- Make sure there is no extra space (' ') in between the words\n- Also our searching supports inputs such as: '  hotel name' or 'hotel name   ' or '  hotel name  '"); //output
			}
		    }
		    catch (java.lang.NullPointerException k)  //Cancel pressed
		    {
			JOptionPane.showMessageDialog (null, "Cancel?");
		    }
		}
		else if (e.getSource () == book) //book button
		{
		    //turning all textfields to getable strings
		    String getName = nameTxt.getText ();
		    String getPhone = phoneTxt.getText (); //we can make this float or int but string would be usefull
		    String getCard = hideChars (cardTxt.getText ());
		    String getDate = cInTxt.getText ();
		    String getHotelName = gHExtra.getText (); //Extra variable helps to get important information
		    String getRoomName = gRExtra.getText ();
		    double getHotel = Double.parseDouble (hExtra.getText ());
		    double getRoom = Double.parseDouble (rExtra.getText ());
		    int getNight = Integer.parseInt (cOutTxt.getText ());
		    int getPeople = Integer.parseInt (pExtra.getText ());
		    int getNumberOfRooms = Integer.parseInt (rpExtra.getText ());

		    double finalPrice = ((getHotel + (getRoom * getNumberOfRooms)) * getPeople * getNight) * 1.13; //formula with tax

		    if ((getName.equals ("") || (getPhone.equals("")) || (getCard.equals ("")) || (getDate.equals ("")) || (getNight < 0))) //if important stuff are not inputted
		    {
			JOptionPane.showMessageDialog (null, "Please Fill in the Requirements\n- Name\n- Credit Card\n- Phone Number [dash will be accepted]\n- Check-in Date\n- Number of nights [Only real numners]"); //Output
		    }
		    else //if all the areas are inputted then this will run
		    {
			int reply = JOptionPane.showConfirmDialog (null, "Hotel Name: " + getHotelName + "\nRoom Type: " + getRoomName +
				"\n\nName: " + getName + "\nPhone Number: " + getPhone +
				"\nCredit Card: " + getCard + "\nCheck-In: " + getDate + "\nNo. of Nights: " + getNight + "\nNo. of People: " + getPeople +
				"\nNo. of Rooms: " + getNumberOfRooms + "\nFinal Price (13% Tax): $" + df.format (finalPrice) +
				"\n\nBook it now?", "Book", JOptionPane.YES_NO_OPTION); //Yes or No option

			if (reply == JOptionPane.YES_OPTION) //if the yes option is pressed
			{
			    //Writing to new files
			    PrintWriter fw = new PrintWriter (new FileWriter ("parthivOutput.txt", true));
			    BufferedWriter bw = new BufferedWriter (fw); //move to if statement

			    JOptionPane.showMessageDialog (null, "Booking was successful\nPlease check your folder for the booking receipt!\nFile will be called parthivOutput.txt\nThank you for booking!"); //Output

			    bw.write ("Thank You For Choosing: " + getHotelName + "\nName: " + getName +
				    "\nRoom Type: " + getRoomName + "\nPhone Number: " + getPhone +
				    "\nCredit Card: " + getCard + "\nCheck-In: " + getDate + "\nNo. of Nights: " + getNight + "\nNo. of People: " + getPeople +
				    "\nNo. of Rooms: " + getNumberOfRooms + "\nFinal Price (13% Tax): $" + df.format (finalPrice) + "\n====================\n"); //file output

			    bw.close ();
			}
			else //if the no option is pressed
			{
			}
		    }
		}
		else if (e.getSource () == del) //delete button
		{
		    try
		    {
			FileWriter fwOb = new FileWriter ("parthivOutput2.txt", false); //we need this to obtain the file and clear it so it resets everytime
			PrintWriter pwOb = new PrintWriter (fwOb, false);
			pwOb.flush (); //flushing the data
			pwOb.close ();
			fwOb.close ();

			FileReader fr = new FileReader ("parthivOutput.txt");
			BufferedReader input = new BufferedReader (fr);

			PrintWriter fw2 = new PrintWriter (new FileWriter ("parthivOutput2.txt", true));

			String bookingName = JOptionPane.showInputDialog ("Enter name\n*Note: Enter according to uppercase and lowercase due to security purpose");
			deleteReservations ("Name: " + bookingName, input, fw2);
			JOptionPane.showMessageDialog (null, "Booking for " + bookingName + " was deleted successful\nNote: if the name name does not match to booking, nothing will be changed\nNote: Check the new parthivOutput2 file");
			fw2.println ("Successful deleted booking for " + bookingName + "\n====================\n"); //File Output

			fr.close ();
			fw2.close ();
		    }
		    catch (java.io.FileNotFoundException k)  //if the file is not found
		    {
			JOptionPane.showMessageDialog (null, "Receipt not found\nPlease make a booking first"); //Output
		    }
		}
		else //clear button
		{
		    nameTxt.setText (""); //setting text to ""
		    phoneTxt.setText (""); //setting text to ""
		    cardTxt.setText (""); //setting text to ""
		    cInTxt.setText ("mm-dd-yy"); //setting text to "mm-dd-yy"
		    cOutTxt.setText ("1"); //setting text to "1"
		    plp.setSelectedItem ("1"); //setting text to "1"
		    numRoom.setSelectedItem ("1"); //setting text to 1"
		    hotelRoom.setSelectedIndex (0); //setting combobox to the first index change hotelRoom to hotelType
		    hotelName.setSelectedIndex (0);
		}
	    }
	    catch (java.lang.NumberFormatException k)
	    {
		JOptionPane.showMessageDialog (null, "Please enter real numbers [i.e NO DECIMALS]\nOr no letters/special letters for No. of Nights Input"); //fix this msg dialog
	    }
	}
	catch (java.io.IOException k)
	{
	    JOptionPane.showMessageDialog (null, "Please make sure you have all the files\n- hotel.txt and hotelTypes.txt");
	}
    } //actionPerformed method


    public static void deleteReservations (String bookingName, BufferedReader input, PrintWriter output) throws IOException
    {
	String hotelStr;
	while ((hotelStr = input.readLine ()) != null)
	{
	    //reading all the lines from the output (receipt) file
	    String nameStr = input.readLine (); //Str means String
	    String roomTypeStr = input.readLine ();
	    String phoneStr = input.readLine ();
	    String cardStr = input.readLine ();
	    String checkInstr = input.readLine ();
	    String checkOutStr = input.readLine ();
	    String plpStr = input.readLine ();
	    String roomStr = input.readLine ();
	    String priceStr = input.readLine ();
	    String dashStr = input.readLine (); //dasStr means "===========" in the output file

	    //keep or delete
	    if (!nameStr.equals (bookingName))
	    {
		//priting to "" so it was deleted
		output.println (hotelStr);
		output.println (nameStr);
		output.println (roomTypeStr);
		output.println (phoneStr); //we cant use a loop all lines have contain different things
		output.println (cardStr);
		output.println (checkInstr);
		output.println (checkOutStr);
		output.println (plpStr);
		output.println (roomStr);
		output.println (priceStr);
		output.println (dashStr);
	    }
	}
    } //deleteReservations method


    public static int arraySize (String file) throws IOException
    {
	FileReader fr = new FileReader (file);
	BufferedReader input = new BufferedReader (fr);

	int counter = 0;
	try
	{
	    while (input.readLine () != null) //null to get the exact number of lines
	    {
		counter++;
	    }
	}
	catch (java.lang.NumberFormatException e)  //catches the error
	{
	}
	int newCounter = counter / 2; //dividing total lines by 2 since there are 2 elements
	return newCounter;
    } //arraySize method


    public static String[] indexName (String file) throws IOException //we can use this method to get all Names from both files
    {
	FileReader fr = new FileReader (file); //get the file
	BufferedReader input = new BufferedReader (fr);

	String nam[] = new String [arraySize (file)]; //calling the arraySize method so user can get all the hotels in the textfile
	double price[] = new double [arraySize (file)];

	// loops to read from file
	for (int i = 0 ; i < nam.length ; i++)
	{
	    nam [i] = input.readLine ();
	    price [i] = Double.parseDouble (input.readLine ());
	}

	fr.close ();
	return nam;
    } //indexName method


    public static double[] indexPrice (String file) throws IOException //we can use this method to get all Prices from both files
    {
	FileReader fr = new FileReader (file); //get the file
	BufferedReader input = new BufferedReader (fr);

	String nam[] = new String [arraySize (file)]; // calls the array size method and gets the size
	double price[] = new double [arraySize (file)];

	// loops to read from file
	for (int i = 0 ; i < nam.length ; i++)
	{
	    nam [i] = input.readLine ();
	    price [i] = Double.parseDouble (input.readLine ());
	}

	fr.close ();
	return price;
    } //indexPrice method


    public static int alphaSort (String nam1, String nam2)  //condition for the alphaSort method also need this for binary search, first we sort then seatch
    {
	String len = nam1;
	int check = 0, i;

	if (nam1.length () > nam2.length ())
	{
	    len = nam2;
	}

	for (i = 0 ; i < len.length () ; i++)
	{
	    if (nam1.charAt (i) != nam2.charAt (i)) //not the same
	    {
		check = i; //gets location
		break; //breaks loop
	    }
	}


	return check;
    } //alphaSort method


    public static String[] sortName (String[] str) throws IOException //sorting alphabetically
    {
	for (int i = 0 ; i < str.length ; i++)
	{
	    for (int j = 0 ; j < str.length - i - 1 ; j++)
	    {
		// compares two strings and exchanges them if not in
		// correct order
		int sort = alphaSort (str [j], str [j + 1]); //calling method to check for alphabetically conditions
		if (str [j].charAt (sort) > str [j + 1].charAt (sort))
		{
		    String temp = str [j]; //name
		    str [j] = str [j + 1];
		    str [j + 1] = temp;
		}
	    }
	}


	return str; //returns sorted alphabetically for hotel names and hotel types
    } //sortName method


    public static double[] sortPrice (String[] str, double[] price) throws IOException //getting the price accroding to the the sorting alphabetically hotel names and hotel types
    {
	for (int i = 0 ; i < str.length ; i++)
	{
	    for (int j = 0 ; j < str.length - i - 1 ; j++)
	    {
		// compares two strings and exchanges them if not in
		// correct order
		int sort = alphaSort (str [j], str [j + 1]);
		if (str [j].charAt (sort) > str [j + 1].charAt (sort))
		{
		    String temp = str [j]; //name
		    str [j] = str [j + 1];
		    str [j + 1] = temp;

		    double tempPrice = price [j]; //price according to name
		    price [j] = price [j + 1];
		    price [j + 1] = tempPrice;
		}
	    }
	}


	return price; //returns price according to the sorting alphabetically hotel names and hotel types
    } //sortPrice method


    public static int findName (String find, String[] name)  //using binary search
    {
	int l = 0;
	int h = name.length - 1;
	int mid;

	while (l <= h)
	{
	    mid = (h + l) / 2;
	    int temp = alphaSort (find, name [mid]); //condidtion so it checks more then the first letter
	    if (find.equalsIgnoreCase (name [mid]) == true)
	    {
		return mid;
	    }
	    else if (((int) (find.charAt (temp))) < ((int) name [mid].charAt (temp)))
	    {
		h = mid - 1;
	    }
	    else
	    {
		l = mid + 1;
	    }
	}


	return -1;
    } //findName method


    public static String hideChars (String s)
    {
	int length = s.length ();
	String stars = "";
	if (length < 4) //we need this if there is less than 4 char's inputted for the credit card input
	{
	    for (int i = 0 ; i < length ; i++)
	    {
		stars += '*'; //hiding the char with *
	    }
	    return stars; //returing new output
	}
	return s.substring (0, length - 4) + "****"; //replacing the last 4 char's of a string with a * to hide the credit card numbers
    } //hideChars method


    public static String extraSpace (String str)
    {
	int start = 0;
	int end = 0;
	for (int i = 0 ; i < str.length () ; i++) //for the starting spaces
	{
	    char c = str.charAt (i);
	    if (c != ' ') // or if ((int) c != 32)
	    {
		start = i;
		break; //break loop
	    }
	}
	for (int i = str.length () - 1 ; i >= 0 ; i--) //for the ending spaces
	{
	    char c = str.charAt (i);
	    if (c != ' ') //not a space
	    {
		end = i;
		break; //break loop
	    }
	}
	return str.substring (start, end + 1); //returing new output which will allow spaces
    } //extraSpace method


    public static void main (String[] args) throws IOException
    {
	JOptionPane.showMessageDialog (null, "Instructions\n\nReading Files: Make sure have you have 2 files hotel.txt and hoteTypes.txt\nWriting to Files: Final receipt named 'parthivOutput' and the updated receipt 'parthivOutput2' with the deleted bookings" +
		"\nSorting: Hotel Names will be sorted alphabetically in the combobox and then you can select them\nSearching: Uses Binary Search, you can search Hotel Names, you can search it like 'hotel name' or ' hotel name' or 'hotel name ' or ' hotel name '\nArray: Getting elements from the files and will be used for sorting and searching" +
		"\nHow to use: Enter Name, Phone Number, Credit Card. Check-in Date and from the combobox choose Hotel Name, Hotel/Room Type, Number of People and Number of Nights\nNote: Last 4 digits of the Credit Card number will be starred ('*')\n\nPress OK to continue to the program!\nThank you!"); //Output

	new HotelBooking ();    // Create a HotelBooking frame
    } // main method
} // HotelBooking class


