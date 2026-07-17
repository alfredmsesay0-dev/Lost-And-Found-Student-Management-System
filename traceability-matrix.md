# Requirements Traceability Matrix (RTM)

Traces each user story from `backlog.md` through its source requirement, use case, acceptance
criteria, priority, and verification (test case). Test case IDs reference the team project's
Testing Plan (TC01–TC07).

| Story ID | Functional Requirement | Use Case | Acceptance Criteria | MoSCoW Priority | Test Case(s) | Status |
|---|---|---|---|---|---|---|
| US-01 | FR-02: System shall allow a user to submit a Lost Item Report | UC-02 Report Lost Item | AC-01.1, AC-01.2 | Must Have | TC02 | Not started |
| US-02 | FR-03: System shall allow a user to submit a Found Item Report | UC-03 Report Found Item | AC-02.1, AC-02.2 | Must Have | TC02 (variant) | Not started |
| US-03 | FR-04: System shall allow search/filter of items | UC-04 Search Items | AC-03.1, AC-03.2 | Must Have | TC03 | Not started |
| US-04 | FR-05: System shall allow submission of a Claim | UC-05 Submit Claim | AC-04.1, AC-04.2 | Must Have | TC04 | Not started |
| US-05 | FR-06: System shall allow admin approval/rejection of a Claim | UC-06 Verify Claim | AC-05.1, AC-05.2, AC-05.3 | Must Have | TC05, TC06, TC07 | Not started |
| US-06 | FR-08: System shall allow admin to generate reports | UC-07 View Reports | AC-06.1 | Should Have | — (planned) | Not started |
| US-07 | FR-07: System shall send notifications on match/claim update | UC-08 Send Notification | AC-07.1 | Could Have | — (planned) | Not started |
| US-08 | N/A — explicitly out of scope | N/A | N/A | Won't Have | N/A | Excluded |

**Legend — Status:** `Not started` / `In progress` / `Implemented` / `Verified` / `Excluded`.
Update this column as work proceeds through the sprint/iteration.

**Coverage check:** every Must Have and Should Have story maps to at least one functional
requirement, one use case, and at least one acceptance criterion, satisfying end-to-end traceability
from requirement → design → verification.
