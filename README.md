# Individual Assignment — Submission Package

This package contains everything required by the "Individual Assignment Submission – Due Friday" brief.

## What's inside

```
docs/
  backlog.md                     # 5+ user stories, unique IDs, use-case links, Given-When-Then acceptance criteria, MoSCoW
  traceability-matrix.md         # RTM — one row per user story
  non-functional-requirements.md # 5+ measurable NFRs grouped by FURPS
  definition-of-done.md          # agreed Definition of Done
  SRS.md                         # draft SRS v0.1 (standard IEEE-830-style structure)
src/
  MoscowPriority.java             # enum: MUST_HAVE, SHOULD_HAVE, COULD_HAVE, WONT_HAVE
  UserStory.java                  # user story class + nested AcceptanceCriterion
  BacklogPrioritizationPolicy.java# policy/rule class (ordering + MVP-selection rules)
  Demo.java                        # demo entry point
```

## How to commit this to GitHub

1. Copy the `docs/` folder into the `docs/` folder of your existing team-project GitHub repository
   (create it if it doesn't exist).
2. Put the four `.java` files from `src/` into a source folder in your repo (e.g. `src/` at the repo
   root, or wherever your lecturer expects Java code — check the assignment brief/module page if unsure).
3. Commit and push:
   ```bash
   git add docs src
   git commit -m "Add individual assignment: backlog, RTM, NFRs, DoD, SRS draft, Java demo"
   git push
   ```
4. On GitHub, open your repository's **Projects** tab and create/update a board with columns matching
   priority order (Must Have → Should Have → Could Have → Won't Have), adding one card per user story
   in the order shown in `docs/backlog.md`.
5. Email your repository link to **akeifalaity3@gmail.com** before the Friday deadline.

## How to compile and run the Java code

Requires JDK 21.

```bash
cd src
javac --release 21 *.java
java Demo
```

This prints the MoSCoW-prioritized backlog, the next-release (MVP) scope, and a PASS/FAIL report for
every acceptance criterion (currently 9/9 passing, since each criterion is simulated as a green check —
replace `AcceptanceCriterion.simulate()` with real logic once your team's actual application exists).

## Before you submit — personalize these

- Replace `[Your Name]` / `[Insert Date]` in `SRS.md`.
- If your lecturer's "Section 4.3" (mentioned in the brief) specifies a different required SRS
  structure than the standard one used here, re-map the headings in `SRS.md` accordingly.
- Confirm the use-case IDs in `backlog.md` (UC-02, UC-03, etc.) match your team's actual Use Case
  Diagram/description table — adjust if your team used different numbering.
