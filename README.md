# Email Service Application

## Overview

This is a resilient email sending service built using JavaScript. It supports:
- Retry mechanism with exponential backoff
- Fallback between providers on failure
- Idempotency to prevent duplicate sends
- Rate limiting to control email send rate
- Status tracking for each email attempt

## Setup Instructions

1. **Clone the repository:**
   ```bash
   git clone https://github.com/yourusername/email-service.git
   cd email-service
