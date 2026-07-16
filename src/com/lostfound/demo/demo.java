package com.lostfound.demo;

import com.lostfound.model.moscowpriority;
import com.lostfound.model.userstory;
import com.lostfound.policy.storypolicy;

public class demo {

    public static void main(String[] args) {

        userstory[] backlog = {

                new userstory(
                        "US-001",
                        "Report Lost Item",
                        "UC-01",
                        moscowpriority.MUST_HAVE),

                new userstory(
                        "US-002",
                        "Report Found Item",
                        "UC-02",
                        moscowpriority.MUST_HAVE),

                new userstory(
                        "US-003",
                        "Search Lost Items",
                        "UC-03",
                        moscowpriority.MUST_HAVE),

                new userstory(
                        "US-004",
                        "Approve Reports",
                        "UC-04",
                        moscowpriority.SHOULD_HAVE),

                new userstory(
                        "US-005",
                        "Receive Notifications",
                        "UC-05",
                        moscowpriority.COULD_HAVE)

        };

        storypolicy policy = new storypolicy();

        System.out.println("========================================");
        System.out.println(" LOST AND FOUND STUDENT MANAGEMENT SYSTEM");
        System.out.println("========================================");

        System.out.println("\nPRIORITISED PRODUCT BACKLOG");

        for (userstory story : backlog) {
            System.out.println(story);
        }

        System.out.println("\nACCEPTANCE CHECK RESULTS");

        for (userstory story : backlog) {

            if (policy.acceptancePassed(story)) {
                System.out.println(story.getId() + " : PASS");
            } else {
                System.out.println(story.getId() + " : FAIL");
            }

        }

    }
}