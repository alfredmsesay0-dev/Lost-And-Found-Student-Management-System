# Product Backlog — Student Lost & Found Management System

> Assumption: "team project" = the Student Lost & Found Management System. Each story links to a use case
> from the team's system design (see Use Case Diagram / Use Case Description table). Update the links if
> your team's use-case IDs differ.

Board ordering (top → bottom) reflects priority: **Must Have** first, then **Should Have**, **Could Have**,
**Won't Have** last. Mirror this exact order as columns/cards on the GitHub Projects board.

---

## US-01 — Report a Lost Item
**As a** student or staff member,
**I want** to report a lost item with a category, description, date, and location,
**so that** it is logged in the system and can be matched against found items.

- **Use Case link:** UC-02 Report Lost Item
- **MoSCoW Priority:** Must Have

**Acceptance Criteria**
- AC-01.1 — **Given** I am logged in, **when** I submit the lost-item form with all required fields, **then** the item is saved with status `searching` and appears in my "My Reports" list.
- AC-01.2 — **Given** I am logged in, **when** I submit the form with a required field missing, **then** the system rejects the submission and highlights the missing field.

---

## US-02 — Report a Found Item
**As a** student or staff member,
**I want** to report an item I found on campus,
**so that** it is logged and can be safely returned to its owner.

- **Use Case link:** UC-03 Report Found Item
- **MoSCoW Priority:** Must Have

**Acceptance Criteria**
- AC-02.1 — **Given** I am logged in, **when** I submit a found-item report with category, description, location and date, **then** the item is saved with status `unclaimed` and becomes searchable.
- AC-02.2 — **Given** I upload a photo with the report, **when** the report is saved, **then** the photo is stored and displayed on the item's detail page.

---

## US-03 — Search and Filter Items
**As a** student or staff member,
**I want** to search and filter reported items by category, keyword, or date,
**so that** I can quickly check whether my lost item has been found.

- **Use Case link:** UC-04 Search Items
- **MoSCoW Priority:** Must Have

**Acceptance Criteria**
- AC-03.1 — **Given** items exist in the database, **when** I filter by a category, **then** only items in that category are returned.
- AC-03.2 — **Given** a database of up to 10,000 records, **when** I run a search, **then** results return within 2 seconds.

---

## US-04 — Submit a Claim
**As a** student or staff member,
**I want** to submit a claim on a found item with proof of ownership,
**so that** I can retrieve my belonging securely.

- **Use Case link:** UC-05 Submit Claim
- **MoSCoW Priority:** Must Have

**Acceptance Criteria**
- AC-04.1 — **Given** a found item has status `unclaimed`, **when** I submit a claim with claim details, **then** the item status changes to `pending` and the claim is created with status `pending`.
- AC-04.2 — **Given** I have already submitted a pending claim on an item, **when** I try to submit a second claim on the same item, **then** the system blocks the duplicate submission.

---

## US-05 — Verify a Claim (Admin)
**As an** administrator,
**I want** to review and approve or reject a submitted claim,
**so that** items are only released to their rightful owner.

- **Use Case link:** UC-06 Verify Claim
- **MoSCoW Priority:** Must Have

**Acceptance Criteria**
- AC-05.1 — **Given** a claim has status `pending`, **when** an admin approves it, **then** the claim status becomes `approved`, the item status becomes `claimed`, and the claimant is notified.
- AC-05.2 — **Given** a claim has status `pending`, **when** an admin rejects it, **then** the claim status becomes `rejected` and the item status reverts to `unclaimed`.
- AC-05.3 — **Given** a non-admin user, **when** they attempt to open the claim verification screen, **then** access is denied.

---

## US-06 — View Reports and Analytics (Admin)
**As an** administrator,
**I want** to view dashboards on item and claim trends,
**so that** I can inform campus item-security policy.

- **Use Case link:** UC-07 View Reports
- **MoSCoW Priority:** Should Have

**Acceptance Criteria**
- AC-06.1 — **Given** items exist across multiple categories, **when** I open the analytics dashboard, **then** I see a breakdown of items per category and claimed-vs-unclaimed ratios.

---

## US-07 — Receive Notifications
**As a** student or staff member,
**I want** to receive an email/SMS notification when a claim update or item match occurs,
**so that** I stay informed without repeatedly checking the system.

- **Use Case link:** UC-08 Send Notification
- **MoSCoW Priority:** Could Have

**Acceptance Criteria**
- AC-07.1 — **Given** my claim status changes, **when** the change is saved, **then** I receive an email notification within 5 minutes.

---

## US-08 — AI-Based Photo Matching (Out of Scope)
**As a** student,
**I want** the system to automatically suggest matches using photo recognition,
**so that** I don't have to manually search through categories.

- **Use Case link:** N/A — not modelled in current Use Case Diagram
- **MoSCoW Priority:** Won't Have (this release)

**Acceptance Criteria**
- Not defined — explicitly excluded from this release's scope (see `SRS.md` §2.5 Limitations).

---

## MoSCoW Summary (GitHub Projects board order)

| Order | Story | Priority |
|---|---|---|
| 1 | US-01 Report a Lost Item | Must Have |
| 2 | US-02 Report a Found Item | Must Have |
| 3 | US-03 Search and Filter Items | Must Have |
| 4 | US-04 Submit a Claim | Must Have |
| 5 | US-05 Verify a Claim (Admin) | Must Have |
| 6 | US-06 View Reports and Analytics | Should Have |
| 7 | US-07 Receive Notifications | Could Have |
| 8 | US-08 AI-Based Photo Matching | Won't Have |
