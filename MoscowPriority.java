/**
 * MoSCoW prioritization categories for backlog items.
 * Lower rank = higher priority (used for sorting the backlog).
 */
public enum MoscowPriority {
    MUST_HAVE(1),
    SHOULD_HAVE(2),
    COULD_HAVE(3),
    WONT_HAVE(4);

    private final int rank;

    MoscowPriority(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    public String getLabel() {
        return switch (this) {
            case MUST_HAVE -> "Must Have";
            case SHOULD_HAVE -> "Should Have";
            case COULD_HAVE -> "Could Have";
            case WONT_HAVE -> "Won't Have";
        };
    }
}
