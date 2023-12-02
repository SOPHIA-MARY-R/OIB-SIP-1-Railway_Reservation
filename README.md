# Railway_Reservation
This is a Railway Reservation prototype implemented using Java Swing library

#java #java-swing #java-application #object-oriented-programming #collections #lambda-expressions #event-listeners

# Project Information
- **Language**: Java
- **Library**: Java Swing UI
- **IDE**: IntelliJ IDEA
- **Version Control System**: Git & GitHub

# Modules
- Authentication
- Train Selection
- Passenger Addition
- Ticket booking and display
- Ticket Cancellation

# Project Flow
- To begin, users need to create an account by providing a username, email address, and password.
- After registration, users will be directed to the login page, where they must enter their credentials.
- Upon successful authentication, users will be redirected to the Train Selection page.
- Users need to specify the departure and destination stations; currently, only train information for Dindigul Jn, Egmore Jn, and Central Jn is available in this prototype.
- Based on the selected stations, the system will display relevant trains in a list.
- Upon selecting a train, its number and timing will be automatically shown.
- Users are required to input the journey date and select the travel class ("SLEEPER" or "SEATER").
- Clicking the Book now button will redirect the user to the Add Passenger page, where they need to provide passenger details such as name, gender, and age.
- After adding the necessary passengers, users can proceed by clicking the Book button.
- The subsequent page will display the ticket with all relevant details, including a PNR number. Seat/berth allocation, along with coach details, seat/berth number, and booking status, will also be presented for each passenger.
- The total fare is calculated based on the chosen class type and the number of passengers.
- Users can cancel a ticket by entering the PNR number.
