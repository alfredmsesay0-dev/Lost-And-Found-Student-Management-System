# Software Requirements Specification (SRS)
### Student Lost & Found Management System
**Version 0.1 (Draft)**

> Note: this draft follows a standard IEEE-830-style SRS outline. If your lecturer's Section 4.3
> specifies a different required structure, re-map these headings to match it before submission.

---

## 1. Introduction

### 1.1 Purpose
This document specifies the software requirements for the Student Lost & Found Management System
(SLFMS), a web-based application that allows students and staff to report, search for, and claim
lost or found items on campus.

### 1.2 Scope
The system will provide: lost/found item reporting, searchable item listings, a claim and
verification workflow, notifications, and an administrative reporting dashboard. It targets a
single-institution deployment (one campus) for this version.

### 1.3 Definitions, Acronyms, and Abbreviations
| Term | Definition |
|---|---|
| SLFMS | Student Lost & Found Management System |
| NFR | Non-Functional Requirement |
| MoSCoW | Must/Should/Could/Won't Have prioritization technique |
| ERD | Entity Relationship Diagram |
| DFD | Data Flow Diagram |
| RTM | Requirements Traceability Matrix |

### 1.4 References
- `backlog.md` — user stories and acceptance criteria
- `traceability-matrix.md` — requirement-to-test traceability
- `non-functional-requirements.md` — FURPS-grouped NFRs
- `definition-of-done.md` — completion criteria
- Team project documentation: Use Case Diagram, DFD, ERD, and Database Schema

### 1.5 Overview
Section 2 describes the product at a high level. Section 3 lists specific functional and
non-functional requirements. Section 4 covers data requirements. Section 5 lists assumptions and
constraints.

---

## 2. Overall Description

### 2.1 Product Perspective
SLFMS is a new, standalone web application following a 3-tier architecture (presentation layer,
application layer, data layer), built with HTML/CSS/JavaScript on the front end, PHP on the back
end, and a MySQL database.

### 2.2 Product Functions (Summary)
- Report a lost item / report a found item
- Search and filter items
- Submit and verify claims
- Send notifications
- View administrative reports and analytics

### 2.3 User Characteristics
| User Role | Description |
|---|---|
| Student | Primary end user; reports and searches for items, submits claims |
| Staff Member | Same permissions as a student; may also log items found on campus grounds |
| Administrator | Verifies claims, manages categories, views analytics, manages accounts |

### 2.4 Constraints
- Must run on standard web browsers (desktop and mobile), no native mobile app in this version.
- Must use MySQL as the data store, per the team's chosen technology stack.
- Development timeline is fixed at 8 weeks (per the project schedule).

### 2.5 Assumptions and Dependencies
- Each user has a unique institutional email address for account verification.
- The institution provides a server environment (or XAMPP/WAMP for local development/demo).
- Automatic image-based item matching (AI/ML recognition) is **out of scope** for this release
  (see backlog story US-08, prioritized Won't Have).

---

## 3. Specific Requirements

### 3.1 Functional Requirements
| ID | Requirement |
|---|---|
| FR-01 | The system shall allow users to register and log in using an institutional email. |
| FR-02 | The system shall allow a user to submit a Lost Item Report (category, description, date, location, optional photo). |
| FR-03 | The system shall allow a user (or staff) to submit a Found Item Report. |
| FR-04 | The system shall allow any logged-in user to search/filter items by category, date, and keyword. |
| FR-05 | The system shall allow a user to submit a Claim against a found item, including proof-of-ownership details. |
| FR-06 | The system shall allow an administrator to approve or reject a claim. |
| FR-07 | The system shall send an email/SMS notification when a match or claim update occurs. |
| FR-08 | The system shall allow an administrator to generate reports (items per category, claimed vs. unclaimed, monthly trends). |
| FR-09 | The system shall maintain an audit log of all report and claim actions. |

*(See `traceability-matrix.md` for how each requirement maps to a user story, use case, and test case.)*

### 3.2 Non-Functional Requirements
See `non-functional-requirements.md` for the complete, FURPS-grouped list (NFR-01 through NFR-08),
covering security, data integrity, usability, availability, auditability, performance, and
scalability/maintainability.

### 3.3 External Interface Requirements
- **User Interface:** responsive web UI accessible via modern desktop and mobile browsers.
- **Database Interface:** MySQL, accessed via the PHP application layer only (no direct client access).
- **Notification Interface:** outbound email (SMTP) and optionally SMS gateway integration.

### 3.4 Design Constraints
- 3-tier architecture (presentation / application / data), as documented in the team's Architecture Diagram.
- Role-based access control enforced at the application layer for all admin-only functions.

---

## 4. Data Requirements
The core data model consists of five entities: `USERS`, `ITEMS`, `CATEGORIES`, `CLAIMS`, and
`NOTIFICATIONS`, as specified in the team's Entity Relationship Diagram and database schema
documentation. Refer to those artifacts for full field-level definitions, keys, and constraints.

---

## 5. Appendices

### 5.1 Traceability
Full requirement-to-story-to-test traceability is maintained in `traceability-matrix.md`.

### 5.2 Revision History
| Version | Date | Author | Notes |
|---|---|---|---|
| 0.1 | [Insert Date] | [Your Name] | Initial draft for individual assignment submission |
