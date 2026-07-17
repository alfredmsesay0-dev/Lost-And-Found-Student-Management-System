import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Encapsulates the business rules for ordering and filtering the product backlog.
 * Rule 1: stories are ordered strictly by MoSCoW rank (Must Have first, Won't Have last).
 * Rule 2: only Must Have and Should Have stories are eligible for the next release (MVP).
 */
public class BacklogPrioritizationPolicy {

    /**
     * Returns the backlog sorted by MoSCoW priority (ascending rank), so the
     * highest-priority stories appear first — matching the required GitHub
     * Projects board ordering.
     */
    public List<UserStory> prioritize(List<UserStory> backlog) {
        return backlog.stream()
                .sorted(Comparator.comparingInt(s -> s.getPriority().getRank()))
                .collect(Collectors.toList());
    }

    /**
     * Applies the MVP-eligibility rule: only Must Have and Should Have stories
     * are included in the next release scope.
     */
    public List<UserStory> selectForNextRelease(List<UserStory> backlog) {
        return backlog.stream()
                .filter(s -> s.getPriority() == MoscowPriority.MUST_HAVE
                          || s.getPriority() == MoscowPriority.SHOULD_HAVE)
                .sorted(Comparator.comparingInt(s -> s.getPriority().getRank()))
                .collect(Collectors.toList());
    }
}
