# Proposed Improved Design Using CRC Cards

## CRC Card 1
**Class:** Order  
**Responsibilities:**  
- Store order data such as customer name, email, item, and base price  
- Provide access to order information  
- Represent a single order as a domain object  

**Collaborators:**  
- PricingService  
- ReceiptGenerator  
- OrderRepository  
- NotificationService  

---

## CRC Card 2
**Class:** PricingService  
**Responsibilities:**  
- Calculate tax for an order  
- Apply discount rules  
- Compute the final total price  

**Collaborators:**  
- Order  

---

## CRC Card 3
**Class:** ReceiptGenerator  
**Responsibilities:**  
- Generate a receipt for an order  
- Format customer, item, tax, discount, and total information  
- Print or return receipt text  

**Collaborators:**  
- Order  
- PricingService  

---

## CRC Card 4
**Class:** OrderRepository  
**Responsibilities:**  
- Save order information to persistent storage  
- Isolate file or database access from business logic  
- Support future replacement of file storage with another storage mechanism  

**Collaborators:**  
- Order  
- PricingService  

---

## CRC Card 5
**Class:** NotificationService  
**Responsibilities:**  
- Send order confirmation notifications  
- Use customer contact information to confirm successful processing  

**Collaborators:**  
- Order  

---

## CRC Card 6
**Class:** LoggerService  
**Responsibilities:**  
- Record order-processing activity  
- Log timestamps and important processing events  

**Collaborators:**  
- OrderProcessor  
- Order  

---

## CRC Card 7
**Class:** OrderProcessor  
**Responsibilities:**  
- Coordinate the overall order-processing workflow  
- Use other classes to process an order step by step  
- Delegate pricing, receipt generation, storage, notification, and logging to specialized classes  

**Collaborators:**  
- Order  
- PricingService  
- ReceiptGenerator  
- OrderRepository  
- NotificationService  
- LoggerService