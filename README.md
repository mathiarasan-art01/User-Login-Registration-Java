# 🔐 User Login & Registration System  
## 🏫 Mini Project – Calibal 15 Days Internship

---

## 📖 Project Overview
This project is a **User Login and Registration System** developed as a **Mini Project during a 15 Days Internship at Calibal**.  
The application allows users to **register, login securely, manage sessions**, and access a **protected dashboard**.

This project helped me gain **hands-on experience** in:
- Core Java
- JSP & Servlets
- JDBC
- MySQL  

along with understanding a **real-world Java web application structure**.

---

## 🎯 Internship Details
- **Internship Provider:** Calibal  
- **Duration:** 15 Days  
- **Project Type:** Mini Project  
- **Domain:** Full Stack Java *(Backend Focus)*  

---

## 🚀 Features
- ✅ User Registration  
- ✅ User Login Authentication  
- ✅ Session Management  
- ✅ Logout Functionality  
- ✅ Form Validation  
- ✅ JDBC Database Connectivity  
- ✅ MVC-based Project Structure  

---

## 🛠️ Technologies Used
- **Java (Core Java)**  
- **JSP & Servlets**  
- **JDBC**  
- **MySQL**  
- **Apache Tomcat**  
- **HTML, CSS**  
- **Eclipse IDE**  

---

## 🗂️ Project Structure 

```text
UserLoginRegistration/
├── src/
│   ├── com.auth.model
│   ├── com.auth.dao
│   ├── com.auth.servlet
│   └── com.auth.util
├── WebContent/
│   ├── login.jsp
│   ├── register.jsp
│   └── dashboard.jsp
├── database/
│   └── userdb.sql
|── screenshots/

```
## 🗄️ Database Table

```sql
CREATE TABLE users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50),
  email VARCHAR(100),
  password VARCHAR(100)
);
```

## ▶️ How to Run the Project

1. Install **JDK** and **Apache Tomcat**  
2. Import the project into **Eclipse IDE**  
3. Configure the **MySQL Database**  
4. Update database credentials in `DBConnection.java`  
5. Run the project on **Tomcat Server**  
6. Open browser and visit:


http://localhost:8080/loginANDregister/login.html


---

## 📸 Screenshots

📌 Add screenshots of the following pages:

- 🔐 Login Page  
- 📝 Registration Page  
- 📊 Dashboard Page  

> Screenshots help interviewers quickly understand the project workflow.

---

## 🔮 Future Enhancements

- 🔐 Password Encryption using **BCrypt**  
- 📧 Email Verification  
- 🔑 Forgot Password Feature  
- 🚀 Migration to **Spring Boot**  
- 🌐 REST API Integration  

---

## 👨‍💻 Author

**MADHIYARASU D D**  
Mini Project – **Calibal Internship**

---

## ⭐ Acknowledgement

I sincerely thank **Calibal** for providing this internship opportunity and guidance to successfully build this project.


