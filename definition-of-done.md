# Definition of Done (DoD)

A user story is considered **Done** only when all of the following are true:

1. **Code complete** — the feature is implemented and merged into the main branch via a reviewed pull request.
2. **Meets acceptance criteria** — every Given–When–Then scenario listed for the story in `backlog.md` passes, verified manually or via an automated check.
3. **Tested** — relevant unit test(s) exist and pass; the corresponding test case(s) in the team's Testing Plan (`TC01`–`TC07`) have been executed with a recorded result.
4. **No known critical or high-severity defects** remain open against the story.
5. **Code reviewed** — at least one other team member has reviewed and approved the change.
6. **Documentation updated** — `traceability-matrix.md` status column is updated, and any affected section of `SRS.md` or the ERD/schema docs is kept in sync with the implementation.
7. **Non-functional requirements respected** — the change does not violate any applicable NFR in `non-functional-requirements.md` (e.g., a new query does not push search response time above 2 seconds).
8. **Deployed to the test/staging environment** and demonstrated to at least one other team member or the product owner.
9. **Committed to GitHub** in the correct location (`docs/` for documentation, appropriate source folder for code) with a clear, descriptive commit message referencing the story ID (e.g., `US-04: implement claim submission form`).

A story that fails any of the above remains **In Progress** and returns to the backlog for further work.
