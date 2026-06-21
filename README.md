# 📅 Scheduling Platform

A smart meeting scheduling backend built with **Spring Boot**, designed to help users schedule meetings based on mutual availability and suggest optimal times using historical meeting patterns.

## 🚀 Features (In Progress)
- ✅ User Registration & JWT Authentication
- 🔄 Availability Management
- 🔄 Meeting Scheduling between Users
- 🔄 Conflict Detection
- 🔄 Smart Time Suggestions (based on history)
- 🔄 Email Notifications

## 🛠️ Tech Stack
- **Language:** Java 17
- **Framework:** Spring Boot
- **Security:** Spring Security + JWT
- **Database:** H2 (dev) → PostgreSQL (prod)
- **Build Tool:** Maven

## 📦 Getting Started

### Prerequisites
- Java 17+
- Maven

### Run Locally
```bash
git clone https://github.com/tanish-p-24/Scheduling-platform.git
cd Scheduling-platform
./mvnw spring-boot:run
```

### API Endpoints
| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| POST | `/api/auth/register` | Register a new user | No |
| POST | `/api/auth/login` | Login and get JWT token | No |
| GET | `/api/users/me` | Get current user profile | Yes |

## 🗄️ Database
Uses **H2 in-file mode** for development. Database file stored at `./data/schedulingdb.mv.db`.
Access H2 console at: `http://localhost:8080/h2-console`

## 📁 Project Structure
