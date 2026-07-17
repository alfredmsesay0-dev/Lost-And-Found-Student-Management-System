import java.util.ArrayList;
import java.util.List;

/**
 * Demo entry point.
 * Builds the backlog from docs/backlog.md, prioritizes it using
 * BacklogPrioritizationPolicy, and runs each story's acceptance criteria,
 * printing a PASS/FAIL report.
 *
 * Compile:  javac *.java
 * Run:      java Demo
 */
public class Demo {

    public static void main(String[] args) {
        List<UserStory> backlog = buildBacklog();
        BacklogPrioritizationPolicy policy = new BacklogPrioritizationPolicy();

        System.out.println("=================================================");
        System.out.println(" PRIORITIZED BACKLOG (MoSCoW order)");
        System.out.println("=================================================");
        List<UserStory> ordered = policy.prioritize(backlog);
        for (UserStory story : ordered) {
            System.out.println(story);
        }

        System.out.println();
        System.out.println("=================================================");
        System.out.println(" NEXT RELEASE SCOPE (Must Have + Should Have only)");
        System.out.println("=================================================");
        for (UserStory story : policy.selectForNextRelease(backlog)) {
            System.out.println(story.getId() + " - " + story.asStoryStatement());
        }

        System.out.println();
        System.out.println("=================================================");
        System.out.println(" ACCEPTANCE CHECKS");
        System.out.println("=================================================");
        int total = 0, passed = 0;
        for (UserStory story : ordered) {
            for (UserStory.AcceptanceCriterion ac : story.getAcceptanceCriteria()) {
                total++;
                boolean result = ac.simulate();
                if (result) passed++;
                System.out.printf("[%s] %-6s %s%n", story.getId(), result ? "PASS" : "FAIL", ac);
            }
        }
        System.out.println();
        System.out.printf("Result: %d/%d acceptance criteria passed.%n", passed, total);
    }

    private static List<UserStory> buildBacklog() {
        List<UserStory> backlog = new ArrayList<>();

        UserStory us01 = new UserStory("US-01", "student or staff member",
                "to report a lost item with a category, description, date, and location",
                "it is logged in the system and can be matched against found items",
                "UC-02 Report Lost Item", MoscowPriority.MUST_HAVE);
        us01.addAcceptanceCriterion(new UserStory.AcceptanceCriterion("AC-01.1",
                "I am logged in", "I submit the lost-item form with all required fields",
                "the item is saved with status 'searching' and appears in my reports"));
        us01.addAcceptanceCriterion(new UserStory.AcceptanceCriterion("AC-01.2",
                "I am logged in", "I submit the form with a required field missing",
                "the system rejects the submission and highlights the missing field"));
        backlog.add(us01);

        UserStory us02 = new UserStory("US-02", "student or staff member",
                "to report an item I found on campus",
                "it is logged and can be safely returned to its owner",
                "UC-03 Report Found Item", MoscowPriority.MUST_HAVE);
        us02.addAcceptanceCriterion(new UserStory.AcceptanceCriterion("AC-02.1",
                "I am logged in", "I submit a found-item report with all required fields",
                "the item is saved with status 'unclaimed' and becomes searchable"));
        backlog.add(us02);

        UserStory us03 = new UserStory("US-03", "student or staff member",
                "to search and filter reported items by category, keyword, or date",
                "I can quickly check whether my lost item has been found",
                "UC-04 Search Items", MoscowPriority.MUST_HAVE);
        us03.addAcceptanceCriterion(new UserStory.AcceptanceCriterion("AC-03.1",
                "items exist in the database", "I filter by a category",
                "only items in that category are returned"));
        backlog.add(us03);

        UserStory us04 = new UserStory("US-04", "student or staff member",
                "to submit a claim on a found item with proof of ownership",
                "I can retrieve my belonging securely",
                "UC-05 Submit Claim", MoscowPriority.MUST_HAVE);
        us04.addAcceptanceCriterion(new UserStory.AcceptanceCriterion("AC-04.1",
                "a found item has status 'unclaimed'", "I submit a claim with claim details",
                "the item status changes to 'pending' and the claim is created"));
        backlog.add(us04);

        UserStory us05 = new UserStory("US-05", "administrator",
                "to review and approve or reject a submitted claim",
                "items are only released to their rightful owner",
                "UC-06 Verify Claim", MoscowPriority.MUST_HAVE);
        us05.addAcceptanceCriterion(new UserStory.AcceptanceCriterion("AC-05.1",
                "a claim has status 'pending'", "an admin approves it",
                "the claim becomes 'approved', the item becomes 'claimed', and the claimant is notified"));
        us05.addAcceptanceCriterion(new UserStory.AcceptanceCriterion("AC-05.2",
                "a non-admin user", "they attempt to open the claim verification screen",
                "access is denied"));
        backlog.add(us05);

        UserStory us06 = new UserStory("US-06", "administrator",
                "to view dashboards on item and claim trends",
                "I can inform campus item-security policy",
                "UC-07 View Reports", MoscowPriority.SHOULD_HAVE);
        us06.addAcceptanceCriterion(new UserStory.AcceptanceCriterion("AC-06.1",
                "items exist across multiple categories", "I open the analytics dashboard",
                "I see a breakdown of items per category and claimed-vs-unclaimed ratios"));
        backlog.add(us06);

        UserStory us07 = new UserStory("US-07", "student or staff member",
                "to receive an email/SMS notification when a claim update or item match occurs",
                "I stay informed without repeatedly checking the system",
                "UC-08 Send Notification", MoscowPriority.COULD_HAVE);
        us07.addAcceptanceCriterion(new UserStory.AcceptanceCriterion("AC-07.1",
                "my claim status changes", "the change is saved",
                "I receive an email notification within 5 minutes"));
        backlog.add(us07);

        UserStory us08 = new UserStory("US-08", "student",
                "the system to automatically suggest matches using photo recognition",
                "I don't have to manually search through categories",
                "N/A - out of scope this release", MoscowPriority.WONT_HAVE);
        backlog.add(us08);

        return backlog;
    }
}
