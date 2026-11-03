# HireSim AI

## Research Title
**"An Adaptive, Resume-Aware RAG-Based Framework for Personalized Interview Question Selection"**

HireSim AI is an intelligent, resume-aware interview simulation framework. It combines Retrieval-Augmented Generation (RAG), vector similarity search (`pgvector`), structured resume parsing, real-time LLM-based answer evaluation, and a transparent adaptive scoring engine to dynamically select personalized technical interview questions.

---

## Architecture & Data Flow

```text
Resume (PDF/DOCX)
       ↓
Resume Parser (OpenAI LLM / Structured Extractor)
       ↓
Candidate Profile (Skills, Experience, Projects)
       ↓
Question Knowledge Base (50+ Original Seed Questions across 13 Topics)
       ↓
Embeddings (1536-dim vectors via text-embedding-3-small)
       ↓
Vector Search (PostgreSQL + pgvector Similarity Query)
       ↓
RAG Pipeline (Candidate Context + Target Role + Vector Pool → LLM Question Selection)
       ↓
Candidate Answer Submission
       ↓
Answer Evaluation (Correctness, Relevance, Completeness, Conceptual Score)
       ↓
Adaptive Selection Engine (Recalculate Topic Need, Difficulty Fit, Skill Gap Priority)
       ↓
Next Question Selection
```

---

## Technology Stack

### Frontend
- **Framework**: React.js (Vite)
- **Language**: JavaScript (ES6+) — *Strictly No TypeScript*
- **Styling**: Tailwind CSS + Custom Dark Glassmorphism UI
- **Routing**: React Router DOM (v6)
- **HTTP Client**: Axios (with credentials / HTTP-only cookie support)
- **Forms & Validation**: React Hook Form + Zod

### Backend
- **Runtime**: Node.js & Express.js
- **Language**: JavaScript (CommonJS) — *Strictly No TypeScript*
- **Database & ORM**: PostgreSQL + Prisma ORM + `pgvector` vector extension
- **Security & Auth**: JWT, `bcryptjs`, HTTP-only cookies, Helmet, CORS, Rate Limiting
- **File Processing**: Multer, `pdf-parse`, `mammoth`
- **AI Infrastructure**: OpenAI API (`gpt-4o-mini`, `text-embedding-3-small`), RAG Pipeline, Adaptive Engine

---

## Database Models (Prisma Schema)

The core database consists of 16 relational & vector models:
1. `User` - Authentication and role management.
2. `CandidateProfile` - Extracted structured candidate details.
3. `Resume` - File records and raw parsed text.
4. `Skill` & `CandidateSkill` - Normalized technical skills and proficiencies.
5. `Project` - Extracted projects and technologies.
6. `Experience` - Previous employment history.
7. `Education` - Academic background.
8. `Certification` - Technical certifications.
9. `Question` - Question bank containing `vector(1536)` embeddings.
10. `Interview` - Interview session config and overall score breakdown.
11. `InterviewQuestion` - Ordered question sequence per session.
12. `Answer` & `AnswerEvaluation` - Submitted answer text and 4-metric evaluation score.
13. `CandidatePerformance` & `SkillPerformance` - Aggregated metrics for candidate dashboard.

---

## Environment Setup & Installation

### Prerequisites
- Node.js (v18+)
- PostgreSQL (v14+ with `pgvector` extension enabled)

### Step 1: Clone & Install Dependencies
```bash
# Install backend dependencies
cd backend
npm install

# Install frontend dependencies
cd ../frontend
npm install
```

### Step 2: Environment Variables (`backend/.env`)
Create `backend/.env` based on `.env.example`:
```env
PORT=5000
NODE_ENV=development
DATABASE_URL="postgresql://postgres:postgres@localhost:5432/hiresim_db?schema=public"
JWT_SECRET="hiresim_super_secret_jwt_key_2026"
JWT_EXPIRES_IN="7d"
OPENAI_API_KEY="your_openai_api_key_here"
FRONTEND_URL="http://localhost:5173"
```

### Step 3: Database Migration & Seeding
```bash
cd backend
npx prisma generate
npx prisma db push
npm run db:seed
```

---

## Running the Application

### 1. Start Backend Server
```bash
cd backend
npm run dev
# Server running at http://localhost:5000
```

### 2. Start Frontend Dev Server
```bash
cd frontend
npm run dev
# Frontend running at http://localhost:5173
```

---

## API Overview

### Authentication
- `POST /api/auth/register` — Register a candidate account
- `POST /api/auth/login` — Sign in candidate & set HTTP-only cookie
- `POST /api/auth/logout` — Clear session cookie
- `GET /api/auth/me` — Fetch currently authenticated user

### Candidate Profile & Resume
- `GET /api/profile` — Retrieve candidate profile
- `PUT /api/profile` — Update skills, experience, and projects
- `POST /api/profile/resume` — Upload PDF/DOCX resume & run AI parser

### Question Admin & Knowledge Base
- `GET /api/questions` — List questions (filters by topic, difficulty, role)
- `GET /api/questions/:id` — Fetch question details
- `POST /api/questions` — Create new question & generate embedding
- `PUT /api/questions/:id` — Update question & refresh vector
- `DELETE /api/questions/:id` — Remove question

### Adaptive Interview Engine
- `POST /api/interviews` — Create new interview configuration
- `GET /api/interviews` — Fetch user's interview sessions
- `GET /api/interviews/:id` — Fetch session details & transcript
- `POST /api/interviews/:id/start` — Start session & select first question via RAG
- `POST /api/interviews/:id/answer` — Submit answer & run AI evaluation
- `POST /api/interviews/:id/next-question` — Trigger Adaptive Selection Engine for next question

---

## Verification & Testing

### Complete Verified End-to-End User Flow
```text
REGISTER → LOGIN → UPLOAD RESUME → PARSE PROFILE → CREATE INTERVIEW → VECTOR RETRIEVAL → RAG QUESTION SELECTION → ANSWER SUBMISSION → LLM EVALUATION → ADAPTIVE NEXT QUESTION → INTERVIEW SUMMARY
```
All endpoints and UI interactions have been tested and verified functional for Phase 1.
