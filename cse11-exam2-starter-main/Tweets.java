// EXAM INSTRUCTIONS:
// All of your code for Task 2 goes in this file.
// Add new method headers and implementations as appropriate to these classes
// Add examples to the ExamplesTweets class.
import tester.*;

interface Tweet {
    // Task 2.1: mostPopularAuthorOnThread
    // Your code here
    User mostPopularAuthorOnThread();
    // Task 2.2: shortestTweetOnThread
    // Your code here
    Tweet shortestTweetOnThread();
    // Provided methods, DO NOT MODIFY
    User getAuthor();
    String getContents();
    int getLikes();
    Tweet getReplyTo();
}

// User class, DO NOT MODIFY
class User {
    String username, displayName;
    int followers;
    User(String username, String displayName, int followers) {
        this.username = username;
        this.displayName = displayName;
        this.followers = followers;
    }

    String toText() {
        return username + " @" + displayName;
    }
}

class TextTweet implements Tweet {
    User author;
    String contents;
    int likes;
    TextTweet(String contents, User author, int likes) {
        this.author = author;
        this.contents = contents;
        this.likes = likes;
    }

    // Task 2.1: mostPopularAuthorOnThread
    // Your code here
    public User mostPopularAuthorOnThread() {
        return author;
    }
    // Task 2.2: shortestTweetOnThread
    // Your code here
    public Tweet shortestTweetOnThread() {
        return this;
    }
    // Provided methods, DO NOT MODIFY
    public User getAuthor() {
        return author;
    }

    public String getContents() {
        return contents;
    }

    public int getLikes() {
        return likes;
    }

    public Tweet getReplyTo() {
        return null;
    }

}

class ReplyTweet implements Tweet {
    User author;
    String contents;
    int likes;
    Tweet replyTo;
    ReplyTweet(String contents, User author, int likes, Tweet replyTo) {
        this.author = author;
        this.contents = contents;
        this.likes = likes;
        this.replyTo = replyTo;
    }

    // Task 2.1: mostPopularAuthorOnThread
    // Your code here
    public User mostPopularAuthorOnThread() {
        if (this.author.followers == replyTo.mostPopularAuthorOnThread().followers) {
            return author;
        }
        else if (this.author.followers > replyTo.mostPopularAuthorOnThread().followers) {
            return author;
        }
        else {
            return replyTo.mostPopularAuthorOnThread();
        }
    }
    // Task 2.2: shortestTweetOnThread
    // Your code here
    public Tweet shortestTweetOnThread() {
        if (this.getContents().length() < replyTo.getContents().length()) {
            return this.shortestTweetOnThread();
        }
        else {
            return replyTo.shortestTweetOnThread();
        }
    }
    // Provided methods, DO NOT MODIFY
    public User getAuthor() {
        return author;
    }

    public String getContents() {
        return contents;
    }

    public int getLikes() {
        return likes;
    }

    public Tweet getReplyTo() {
        return replyTo;
    }
}
class ExampleTweets {
    // Video Task
    // Your code here
    User greg = new User("gregory_miranda", "Greg Miranda", 9999);
    User sanmi = new User("sanmi_adeleye", "Sanmi Adeleye", 999);
    User sangeetha = new User("sangeetha_viswanathan_sakthivel", "Sangeetha Viswanathan Sakthivel", 1000000);
    Tweet t1 = new TextTweet("Java 17", this.sanmi, 77);
    Tweet t2 = new ReplyTweet("Hmm The class of the method called", this.greg, 12, this.t1);
    Tweet t3 = new ReplyTweet("Thought about this more, probably not yet, too new.", this.greg, 73, this.t2);
    Tweet t4 = new ReplyTweet("Yeah, good point. Maybe in 2022.", this.sanmi, 10, this.t3);
    Tweet t5 = new ReplyTweet("Not the shortest tweet Not the shortest tweet", this.sangeetha, 1005, this.t2);

    Tweet test =  t5.shortestTweetOnThread();
    /*

    class	method                  reference   return value
    RT      shortestTweetOnThread   :1          :2
    RT      shortestTweetOnThread   :2          :3
    TT      shortestTweetOnThread   :3          :3
    */

    void testShortestTweetOnThread(Tester t) {
        t.checkExpect(t5.shortestTweetOnThread(), t1);
    }
}

    