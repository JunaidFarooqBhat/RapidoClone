# API Documentation

## GetApi

### Request details:
- **Http method:** GET
- **URI:** /checkFare
- **Request parameters:** 
  - Pickup location and drop location in the form of latitude and longitude.
  - (Optional) Requires authentication token and user email for authentication.


### Response:
- **Response:** Fare of all vehicles.

---

### Request details:
- **Http method:** GET
- **URI:** /myrides
- **Request parameters:** 
  - Requires email and token for authentication.

### Response:
- **Response:** List of rides and the user which is the logged-in user.

---

## Create Order API

### User Signup

### Request details:
- **Http method:** POST
- **URI:** /user/signup
- **Request Parameters:** 
  - All user details required for signup.

### Response:
- **Response:** Information about the user created if not exists.

### User SignIn

### Request details:
- **Http method:** POST
- **URI:** /user/signIn/{email}/{password}
- **Request Parameters:** 
  - Email and password for signin.

### Response:
- **Response:** Authentication token for accessing protected APIs.

### BookRide

### Request details:
- **Http method:** POST
- **URI:** /bookRide
- **Request Parameters:** 
  - Pickup location, drop location, user email, and token for authentication.

### Response:
- **Response:** Information about the booked ride.

---

## Order Update

### Request Details
- **Http method:** PUT
- **URI:** /updateStatus
- **Request Parameters Description:** 
  - Status to update, booking id, email, and auth token of driver for authentication.

### Response:
- **Response:** Information about the status update.

---

## SignOut API

### Request Details
- **Http method:** DELETE
- **URI:** /user/signOut
- **Request Parameters Description:** 
  - Email and token to logout the user.

### Response: 
- **Response:** Information about successful user logout.

### Request Details
- **Http method:** DELETE
- **URI:** /driver/signOut
- **Request Parameters Description:** 
  - Email and token to logout the driver.

### Response: 
- **Response:** Information about successful driver logout.

---

## Cancel Order API

### Request Details
- **Http method:** DELETE
- **URI:** /cancelBooking/user
- **Request Parameters:** 
  - Authentication token, user email, status set to 'cancel', and booking id to cancel the booking.

### Response:
- **Response:** Information about the canceled ride.

