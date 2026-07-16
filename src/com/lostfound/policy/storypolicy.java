package com.lostfound.policy;

import com.lostfound.model.userstory;

public class storypolicy {

    public boolean acceptancePassed(userstory story) {

        if (story == null) {
            return false;
        }

        if (story.getId() == null || story.getId().isEmpty()) {
            return false;
        }

        if (story.getTitle() == null || story.getTitle().isEmpty()) {
            return false;
        }

        if (story.getUseCase() == null || story.getUseCase().isEmpty()) {
            return false;
        }

        return true;
    }
}