const express = require('express');
const cors = require('cors');
const helmet = require('helmet');
const cookieParser = require('cookie-parser');
const rateLimit = require('express-rate-limit');
const config = require('./config');
const errorHandler = require('./middleware/errorHandler');
const speechRoutes = require('./routes/speechRoutes');

// Import Route Handlers
const authRoutes = require('./routes/authRoutes');
const profileRoutes = require('./routes/profileRoutes');
const questionRoutes = require('./routes/questionRoutes');
const interviewRoutes = require('./routes/interviewRoutes');

const app = express();

// Security Middlewares
app.use(helmet());
app.use(
  cors({
    origin: config.frontendUrl || 'http://localhost:5173',
    credentials: true,
  })
);

// Body Parsers & Cookies
app.use(express.json({ limit: '10mb' }));
app.use(express.urlencoded({ extended: true, limit: '10mb' }));
app.use(cookieParser());
app.use('/api/speech', speechRoutes);

// Rate Limiter
const limiter = rateLimit({
  windowMs: 15 * 60 * 1000, // 15 minutes
  max: 300, // limit each IP to 300 requests per windowMs
  standardHeaders: true,
  legacyHeaders: false,
  message: 'Too many requests from this IP, please try again later.',
});
app.use('/api', limiter);

// Interactive avatar sessions consume account resources; access is authenticated and rate limited.
const synthesiaRoutes = require('./routes/synthesiaRoutes');
app.use('/api/synthesia', synthesiaRoutes);

// Health Check API
app.get('/api/health', (req, res) => {
  res.status(200).json({ status: 'ok', timestamp: new Date().toISOString() });
});

// API Routes
app.use('/api/auth', authRoutes);
app.use('/api/profile', profileRoutes);
app.use('/api/questions', questionRoutes);
app.use('/api/interviews', interviewRoutes);

// Central Error Handler
app.use(errorHandler);

module.exports = app;
