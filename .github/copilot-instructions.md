# Copilot Instructions for escrow-e-com

## 1. Vision
Create a curated, trusted e-commerce marketplace in Bangladesh for verified brands, celebrities, and established businesses. Strict seller onboarding with document verification. Not open for everyone.

**Core Values:**
- Trust: Only authentic sellers
- Refund Guarantee: Escrow protects buyers
- Authenticity: Verified brands get trust badges
- Long-term: SaaS platform for selling, analytics, marketing, engagement

## 2. Core Features (All Phases)
**Authentication & Authorization**
- JWT-based auth
- Roles: Customer, Seller, Admin
- OAuth2 (Google/Facebook) planned

**Seller Onboarding**
- Seller applies with trade license, NID, tax docs
- Admin manually approves/rejects
- Approved seller gets storefront page

**Product Management**
- Sellers upload products (images, description, price, stock)
- Image pipeline: resize, watermark, compression
- SEO metadata auto-generated

**Payments & Escrow**
- Local gateways: bKash, Nagad, Rocket
- Buyer pays → money goes to escrow
- Seller paid after delivery confirmed
- Refunds handled by platform

**Reviews & Reputation**
- Only verified buyers can review
- Ratings, comments, media upload
- Seller profile: aggregate rating, trust badge

**Product Discovery**
- Full-text search, filtering (category, brand, rating)
- SEO-first catalog (sitemaps, metadata)
- Verified Trust Badge on products/sellers

**Admin Tools**
- Approve/reject sellers
- Refund/dispute management
- Fraud detection dashboard

## 3. System Design (High-Level)
**Microservices (Spring Boot)**
- Auth Service: login/register, JWT, roles
- Seller Service: onboarding, storefront
- Product Service: catalog, search, SEO
- Image Service: upload, resize, compress, watermark
- Order & Payment Service: cart, checkout, escrow, refunds
- Review Service: buyer reviews, trust badges
- Admin Service: seller verification, disputes, fraud detection

**Storage**
- Database: PostgreSQL
- Cache: Redis
- File Storage: AWS S3 / Cloudflare R2 / MinIO

**Tech Stack**
- Backend: Spring Boot (Java 17+)
- Frontend: Next.js (React, SEO)
- Messaging: RabbitMQ (async tasks)
- Image Processing: Imgscalr / ImageMagick
- Payments: bKash, Nagad APIs
- Deployment: Docker Compose (MVP), Kubernetes (scale)

## 4. User Journeys
**Customer Flow**
- Browse products → Add to cart → Checkout → Pay via gateway (escrow) → Confirm delivery → Seller paid → Leave review

**Seller Flow**
- Apply with documents → Admin approves → Storefront live → Upload products → Receive orders → Deliver → Escrow released → View analytics

**Admin Flow**
- Verify sellers → Manage disputes/refunds → Fraud monitoring → Approve categories

## 5. Phased Development Roadmap
**Phase 1 (MVP):** JWT auth, seller onboarding, product catalog, checkout (escrow simulation), buyer-only reviews, simple admin dashboard
**Phase 2:** Real payment integration, image pipeline, search/filtering, seller analytics, advanced refunds
**Phase 3:** Fraud detection, AI features (description generator, image tagging, influencer drops, SaaS subscriptions)
**Phase 4:** Mobile app, multi-currency, affiliate system, marketing automation

## 6. Example API Endpoints
Auth: `POST /auth/register`, `POST /auth/login`
Seller: `POST /sellers/apply`, `GET /sellers/:id`, `PUT /sellers/:id/approve`
Products: `POST /products`, `GET /products?page=1&limit=10`, `GET /products/:id`
Orders: `POST /orders`, `GET /orders/:id`
Reviews: `POST /reviews`, `GET /products/:id/reviews`

## 7. Future Enhancements
- AI trust score for sellers
- AI customer support agent
- Logistics integration
- Multi-language (Bangla-first)
- SaaS monetization (subscriptions)

## 8. Guiding Principles
- Trust first: every feature builds credibility
- SEO-first: organic discovery
- Local-first: tailored for Bangladesh
- Scalable SaaS: future brands can self-serve

---
For project-based learning, build one feature/service at a time. Reference backend structure in `backend/e-com`, main class in `src/main/java/com/example/escrow/e_com/EComApplication.java`, and config in `src/main/resources/application.properties`. Use provided API endpoints and workflows as starting points.
