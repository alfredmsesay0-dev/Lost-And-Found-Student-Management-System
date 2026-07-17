# Non-Functional Requirements (NFRs)

Grouped using the **FURPS** model (Functionality, Usability, Reliability, Performance, Supportability).
Each requirement is stated so it can be objectively measured/tested.

## Functionality
- **NFR-01 (Security):** Only users with the `admin` role may access the claim-verification and
  analytics modules; all other roles attempting access receive an HTTP 403 / access-denied response.
  *Measure: 100% of non-admin access attempts to admin routes are blocked in testing.*
- **NFR-02 (Data Integrity):** All required fields on the lost/found report form must be validated
  both client-side and server-side before a record is persisted.
  *Measure: 0 records saved to the database with a missing required field, across all test submissions.*

## Usability
- **NFR-03 (Learnability):** A first-time user must be able to complete a lost-item report in under
  2 minutes without external help.
  *Measure: average task completion time ≤ 2 minutes across a 5-user usability test.*

## Reliability
- **NFR-04 (Availability):** The system must be available 99% of the time in any calendar month,
  excluding scheduled maintenance windows announced 24 hours in advance.
  *Measure: monthly uptime ≥ 99%, tracked via server uptime logs.*
- **NFR-05 (Auditability):** Every claim approval/rejection action must be recorded in an audit log
  with user ID, timestamp, and action taken, and must be immutable (no deletion via the application).
  *Measure: 100% of claim actions in test scenarios produce a corresponding audit log entry.*

## Performance
- **NFR-06 (Response Time):** Search/filter queries must return results within 2 seconds for a
  database of up to 10,000 item records.
  *Measure: 95th-percentile search response time ≤ 2000 ms under a load test of 10,000 seeded records.*

## Supportability
- **NFR-07 (Scalability):** The database schema must support adding additional campuses/branches
  without a breaking schema change (e.g., via a nullable `campus_id` foreign key on `items`).
  *Measure: a new campus can be added via an INSERT statement with no ALTER TABLE required.*
- **NFR-08 (Maintainability):** Back-end code must follow a layered/MVC structure so a new module
  (e.g., a new report type) can be added without modifying unrelated modules.
  *Measure: adding a new item category or field type touches ≤ 3 files outside of configuration.*

---
*Minimum of 5 measurable NFRs required by the assignment brief — 8 are provided above for stronger
coverage across all five FURPS categories.*
