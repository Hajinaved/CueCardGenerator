# Cue Card Generator App

## Overview
The **Cue Card Generator App** is a web application that generates IELTS-style cue cards dynamically. It consists of a **Spring Boot** backend, a **React Vite** frontend, and utilizes **Google Gemini AI** for generating unique, non-repeating cue card topics.

## Features
- Generate unique IELTS-style cue cards
- Ensures no repeated topics
- Fast and interactive user experience
- Uses Google Gemini AI for intelligent topic generation
- Seamless communication between backend and frontend

## Tech Stack
### Backend
- **Spring Boot** (REST API)
- **Spring Web** (for handling API requests)
- **Spring Boot Starter WebFlux** (for async communication with Google Gemini AI API)
- **Lombok** (to reduce boilerplate code)
- **Jackson** (for JSON processing)

### Frontend
- **React (Vite)** (for fast, optimized frontend development)
- **Axios** (for API requests)
- **Material UI** (for styling)
- **React Hooks** (for state management)

### External API
- **Google Gemini AI API** (for generating unique IELTS cue card topics)

## Installation & Setup

### Prerequisites
Ensure you have the following installed:
- **Java 17+** (for Spring Boot backend)
- **Node.js 18+** (for React frontend)
- **Maven** (for backend dependency management)
- **Google API Key** (for accessing Gemini AI)

### Backend Setup (Spring Boot)
1. Clone the repository:
   ```sh
   git clone https://github.com/your-repo/cuecard-generator.git
   cd cuecard-generator/backend
   ```
2. Configure API keys in `application.properties`(you have to pass it as environment variable while launching the backend):
   ```properties
   gemini.api.key=${GEMINI_API_KEY}
   gemini.api.url=${GEMINI_API_URL}
   ```
3. Build and run the Spring Boot application:
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```
4. The backend will be available at `http://localhost:8080`

### Frontend Setup (React Vite)
1. Navigate to the frontend directory:
   ```sh
   cd ../CCG-FrontEnd
   ```
2. Install dependencies:
   ```sh
   npm install
   ```
3. Configure API endpoints in `.env`:
   ```env
   BACKEND_URL=http://localhost:8080
   ```
4. Start the frontend:
   ```sh
   npm run dev
   ```
5. Open the app in the browser at `http://localhost:5173`

## API Endpoints
| Method | Endpoint               | Description                     |
|--------|------------------------|---------------------------------|
| GET    | `/ccg/getCard`         | Generate a new cue card topic  |

## Deployment
### Backend (Spring Boot)
- Use **Docker** or deploy on cloud platforms like **Heroku, AWS, or Render**.

### Frontend (React Vite)
- Deploy using **Vercel, Netlify, or Firebase Hosting**.

## Contributing
1. Fork the repository.
2. Create a new branch (`feature/new-feature`).
3. Commit changes and push to the branch.
4. Open a Pull Request.

## License
This project is licensed under the **ILOVEMAKINGSTUFF**.

## Contact
For queries,NO NO QUERIESS!!!!

