package me.whiteship.refactoring._01_smell_mysterious_name._01_before;

import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHIssueComment;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StudyDashboard {

    private Set<String> reviewers = new HashSet<>();

    private Set<String> reviews = new HashSet<>();

    private void loadReviews() throws IOException {
        GitHub gitHub = GitHub.connect();
        GHRepository repository = gitHub.getRepository("whiteship/live-study");
        GHIssue issue = repository.getIssue(30);

        List<GHIssueComment> reviews = issue.getComments();
        for (GHIssueComment review : reviews) {
            reviewers.add(review.getUserName());
            this.reviews.add(review.getBody());
        }
    }

    public Set<String> getReviewers() {
        return reviewers;
    }

    public Set<String> getReviews() {
        return reviews;
    }

    public static void main(String[] args) throws IOException {
        StudyDashboard studyDashboard = new StudyDashboard();
        studyDashboard.loadReviews();
        studyDashboard.getReviewers().forEach(System.out::println);
        studyDashboard.getReviews().forEach(System.out::println);
    }
}
