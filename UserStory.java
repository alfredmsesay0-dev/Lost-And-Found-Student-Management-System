import java.util.ArrayList;
import java.util.List;

/**
 * Represents a single backlog user story, in the standard format:
 * "As a {role}, I want {goal}, so that {benefit}."
 */
public class UserStory {

    private final String id;
    private final String role;
    private final String goal;
    private final String benefit;
    private final String useCaseLink;
    private MoscowPriority priority;
    private final List<AcceptanceCriterion> acceptanceCriteria = new ArrayList<>();

    public UserStory(String id, String role, String goal, String benefit,
                      String useCaseLink, MoscowPriority priority) {
        this.id = id;
        this.role = role;
        this.goal = goal;
        this.benefit = benefit;
        this.useCaseLink = useCaseLink;
        this.priority = priority;
    }

    public void addAcceptanceCriterion(AcceptanceCriterion ac) {
        acceptanceCriteria.add(ac);
    }

    public String getId() {
        return id;
    }

    public MoscowPriority getPriority() {
        return priority;
    }

    public void setPriority(MoscowPriority priority) {
        this.priority = priority;
    }

    public String getUseCaseLink() {
        return useCaseLink;
    }

    public List<AcceptanceCriterion> getAcceptanceCriteria() {
        return acceptanceCriteria;
    }

    public String asStoryStatement() {
        String article = role.toLowerCase().matches("^[aeiou].*") ? "an" : "a";
        return String.format("As %s %s, I want %s, so that %s.", article, role, goal, benefit);
    }

    @Override
    public String toString() {
        return String.format("[%s] (%s) %s  -> %s",
                id, priority.getLabel(), asStoryStatement(), useCaseLink);
    }

    /**
     * A single Given-When-Then acceptance scenario attached to a user story.
     * `expectedOutcome` models the state the system should reach; `simulate()`
     * models running that scenario against the (simplified) system state and
     * reports whether it passed.
     */
    public static class AcceptanceCriterion {
        private final String id;
        private final String given;
        private final String when;
        private final String then;

        public AcceptanceCriterion(String id, String given, String when, String then) {
            this.id = id;
            this.given = given;
            this.when = when;
            this.then = then;
        }

        public String getId() {
            return id;
        }

        /**
         * Simulates executing the scenario. In this demo, every criterion is
         * modelled as passing, representing a green test run; in a real system
         * this would invoke the actual application logic and assert the result.
         */
        public boolean simulate() {
            return true;
        }

        @Override
        public String toString() {
            return String.format("%s - Given %s, when %s, then %s.", id, given, when, then);
        }
    }
}
