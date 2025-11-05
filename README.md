# 🏨 Hotel Management System

A full-featured **Spring Boot REST API** for managing hotels, admins, rooms, customers, and bookings — built using **Spring Boot**, **Spring Data JPA**, **MySQL**, and **Swagger (OpenAPI)** for live documentation.

This project demonstrates **enterprise-grade backend architecture**, exception handling, and entity relationships through a clean layered design.

---

## 🚀 Overview

The **Hotel Management System** provides complete management functionality for:
- Hotels  
- Rooms  
- Customers  
- Admins  
- Bookings  

It ensures room availability and capacity are validated before booking, supports booking updates and closures, and provides descriptive responses through Swagger and structured APIs.

---

## ✨ Key Features

✅ CRUD for Hotels, Rooms, Admins, Customers, and Bookings  
✅ Room capacity and availability validation  
✅ Booking lifecycle: book → update → close with rating  
✅ Custom exception handling  
✅ Response wrapping using `ResponseStructure<T>`  
✅ Live interactive API documentation using **Swagger UI**  
✅ Clear entity relationships (One-to-One, One-to-Many, Many-to-One)  

---

## ⚙️ Tech Stack

| Component | Technology |
|------------|-------------|
| **Language** | Java 17 |
| **Framework** | Spring Boot 3.x |
| **ORM** | Spring Data JPA (Hibernate) |
| **Database** | MySQL |
| **Documentation** | Swagger (Springdoc OpenAPI 3) |
| **Build Tool** | Maven |
| **IDE** | Spring Tool Suite / IntelliJ IDEA |
| **Testing** | Postman |
| **Version Control** | Git & GitHub |

---

## 🧠 Architecture

```
Controller → Service → DAO → Repository → Database
```

- **Controller**: Handles HTTP requests (REST APIs)  
- **Service**: Implements business logic and validation  
- **DAO**: Communicates with the repository layer  
- **Repository**: Uses JPA to manage entity persistence  
- **Utilities**: Contains reusable structures for response and exception handling  

---

## 🗂️ Folder Structure

```
com.hotel.app
├── controller
│   ├── AdminController.java
│   ├── BookingController.java
│   ├── CustomerController.java
│   ├── HotelController.java
│   └── RoomController.java
│
├── service
│   ├── AdminService.java
│   ├── BookingService.java
│   ├── CustomerService.java
│   ├── HotelService.java
│   └── RoomService.java
│
├── dao
│   ├── AdminDao.java
│   ├── BookingDao.java
│   ├── CustomerDao.java
│   ├── HotelDao.java
│   └── RoomDao.java
│
├── dto
│   ├── Admin.java
│   ├── Booking.java
│   ├── Customer.java
│   ├── Hotel.java
│   └── Room.java
│
├── repository
│   ├── AdminRepo.java
│   ├── BookingRepo.java
│   ├── CustomerRepo.java
│   ├── HotelRepo.java
│   └── RoomRepo.java
│
├── exception
│   ├── IdNotFoundException.java
│   ├── RoomFullException.java
│   └── RoomNotAvailableException.java
│
└── utilities
    ├── ExceptionStructure.java
    └── ResponseStructure.java
```

---

## 🧬 Entity Relationships

| Entity | Relationship | Description |
|---------|---------------|-------------|
| Admin ↔ Hotel | One-to-One | Each hotel has one admin |
| Hotel ↔ Room | One-to-Many | Each hotel can have multiple rooms |
| Customer ↔ Booking | One-to-Many | Each customer can make multiple bookings |
| Room ↔ Booking | One-to-One | Each room can have one active booking |

---

## 🧾 API Endpoints (Summary)

### 🏨 Hotel APIs
| Method | Endpoint | Description |
|---------|-----------|-------------|
| POST | `/hotel/saveHotel` | Create a single hotel |
| POST | `/hotel/saveHotels` | Save multiple hotels |
| PUT | `/hotel/updateHotel?hotelId={id}` | Update a hotel |
| GET | `/hotel/getHotelById?hotelId={id}` | Get hotel by ID |
| GET | `/hotel/getAllHotels` | Get all hotels |
| DELETE | `/hotel/deleteHotel?hotelId={id}` | Delete hotel |

### 🧑‍💼 Admin APIs
| Method | Endpoint | Description |
|---------|-----------|-------------|
| POST | `/admin/saveAdmin?hotelId={id}` | Create an admin for a hotel |
| PUT | `/admin/updateAdmin?adminId={id}` | Update admin details |
| GET | `/admin/getAdminById?adminId={id}` | Get admin by ID |
| DELETE | `/admin/deleteAdmin?adminId={id}` | Delete admin by ID |

### 🚪 Room APIs
| Method | Endpoint | Description |
|---------|-----------|-------------|
| POST | `/room/saveRoom?hotelId={id}` | Add room to hotel |
| PUT | `/room/updateRoom?roomId={id}` | Update room |
| GET | `/room/getRoomById?roomId={id}` | Get room by ID |
| GET | `/room/getAllRooms` | Get all rooms |
| DELETE | `/room/deleteRoom?roomId={id}` | Delete room by ID |

### 👤 Customer APIs
| Method | Endpoint | Description |
|---------|-----------|-------------|
| POST | `/customer/saveCustomer` | Add a customer |
| PUT | `/customer/updateCustomer?customerId={id}` | Update customer |
| GET | `/customer/getCustomerById?customerId={id}` | Get customer by ID |
| GET | `/customer/getAllCustomers` | List all customers |
| DELETE | `/customer/deleteCustomerById?customerId={id}` | Delete customer |

### 📘 Booking APIs
| Method | Endpoint | Description |
|---------|-----------|-------------|
| POST | `/booking/saveBooking?customerId={id}&roomId={id}` | Book a room |
| PUT | `/booking/updateBooking?bookingId={id}` | Update a booking |
| PUT | `/booking/closeBooking?bookingId={id}&rating={value}` | Close booking (checkout) |
| GET | `/booking/getBookingById?bookingId={id}` | Get booking by ID |
| GET | `/booking/getAllBookings` | Get all bookings |
| DELETE | `/booking/deleteBooking?bookingId={id}` | Delete a booking |

---

## 🧭 Swagger (OpenAPI) Integration

Swagger UI provides an **interactive interface** to explore and test all endpoints.

### 🪄 Access Swagger
Once your application is running, open:
```
http://localhost:8080/swagger-ui/index.html
```

You’ll see:
- All controllers and endpoints  
- Example request/response models  
- Ability to test API calls directly from the browser  

---

## ⚙️ Setup & Run Instructions

1. Clone the repository:
   ```bash
   git clone https://github.com/Padmapriyan25/Hotel-Management-System
   cd Hotel-Management
   ```

2. Configure database in `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/hoteldb
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

4. Visit Swagger UI:
   ```
   http://localhost:8080/swagger-ui/index.html
   ```

5. Test APIs using Postman or Swagger directly.

---

## 🚨 Exception Handling

| Exception | Triggered When | Response |
|------------|----------------|-----------|
| `IdNotFoundException` | Invalid ID is provided | 404 |
| `RoomFullException` | Booking exceeds room capacity | 400 |
| `RoomNotAvailableException` | Room already booked | 400 |

---

## 🧾 Sample Data for Quick Testing

### Hotel Example
```json
{
  "hotel_name": "Tokyo Inn",
  "hotel_gst": "GSTIN00123",
  "hotel_address": "Shibuya, Tokyo",
  "hotel_manager": "Gojo Satoru",
  "hotel_owner": "Yaga Masamichi",
  "hotel_rating": 5
}
```

### Room Example
```json
{
  "room_no": "A101",
  "room_type": "Deluxe",
  "room_price": 4000,
  "no_beds": 2,
  "max_people": 4,
  "availability": "Y"
}
```

### Customer Example
```json
{
  "c_name": "Yuji Itadori",
  "c_email": "yuji@jjkmail.com",
  "c_address": "Shibuya, Tokyo",
  "c_password": "sukuna!",
  "c_phone": 900000001,
  "c_aadhar": "0000-0000-0001"
}
```

---

## 🧭 Future Enhancements

- [ ] Role-based authentication (Admin vs Customer)
- [ ] Email notifications for bookings
- [ ] Search and filtering APIs
- [ ] Pagination and sorting
- [ ] Docker + CI/CD pipeline
- [ ] Frontend dashboard using React or Angular

---

## 🪪 License
This project is open-source under the **MIT License**.
