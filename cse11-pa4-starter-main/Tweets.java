import tester.*;

interface Tweet {
    boolean isReplyTo(Tweet other);
    int totalLikes();
    String allAuthors();
    boolean textAppearsOnThread(String text);
    int countPopularTweets(int minNumLikes);
}

class User {
    String username, displayName;
    int followers;
   
    User(String username, String displayName, int followers) {
        this.username = username;
        this.displayName = displayName;
        this.followers = followers;
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

    public boolean isReplyto(Tweet other) {
        return false;
    }

    public int totalLikes() {
        return this.likes;
    }
    public String allAuthors() {
        return this.author.username;
    }
    public boolean textAppearsOnThread(String text) {
        return this.contents.contains(text);
    }
    public int countPopularTweets(int minNumLikes) {
        if (this.likes == minNumLikes) {
            return 1;
        }
        else {
            return 0;
        }
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
    public boolean isReplyto(Tweet other) {
        return other == this.replyTo;
    }

    public int totalLikes() {
        return this.replyTo.totalLikes() + this.likes;
    }
    public String allAuthors() {
        return this.author.username + ";" + this.replyTo.allAuthors();
    }
    public boolean textAppearsOnThread(String text) {
        return this.contents.contains(text) || this.replyTo.textAppearsOnThread(text); 
    }
    public int countPopularTweets(int minNumLikes) {
        if (this.likes > minNumLikes) {
        return 1 + this.replyTo.countPopularTweets(minNumLikes);
        }
        else {
            return this.replyTo.countPopularTweets(minNumLikes);
        }
    }
}
class ExampleTweets {
    User greg = new User("gregory_miranda", "Greg Miranda", 9999);
    User sanmi = new User("sanmi_adeleye", "Sanmi Adeleye", 999);
    User sangeetha = new User("sangeetha_viswanathan_sakthivel", "Sangeetha Viswanathan Sakthivel", 1000000);
    Tweet t1 = new TextTweet("Java 17 has a cool feature called records", this.sanmi, 77);
    Tweet t2 = new ReplyTweet("Hmm I wonder if we could use it for CSE11", this.greg, 12, this.t1);
    Tweet t3 = new ReplyTweet("Thought about this more, probably not yet, too new.", this.greg, 73, this.t2);
    Tweet t4 = new ReplyTweet("Yeah, good point. Maybe in 2022.", this.sanmi, 10, this.t3);
    Tweet t5 = new ReplyTweet("Yeah... I don't want to rewrite the book right this minute", this.sangeetha, 1005, this.t2);

    void testIsReplyTo(Tester t) {
        t.checkExpect(this.t1.isReplyTo(this.t2), false);
        t.checkExpect(this.t2.isReplyTo(this.t1), true);
        t.checkExpect(this.t5.isReplyTo(this.t2), true);
        t.checkExpect(this.t2.isReplyTo(this.t2), false);
        t.checkExpect(this.t4.isReplyTo(this.t3), true);
    }

    void testTotalLikes(Tester t) {
        t.checkExpect(this.t5.totalLikes(), 1005 + 12 + 77);
        t.checkExpect(this.t4.totalLikes(), 10 + 73 + 12 + 77);
        t.checkExpect(this.t1.totalLikes(), 77);
    }

    void testAllAuthors(Tester t) {
        t.checkExpect(this.t1.allAuthors(), "sanmi_adeleye");
        t.checkExpect(this.t2.allAuthors(), "gregory_miranda;sanmi_adeleye");
        t.checkExpect(this.t3.allAuthors(), "gregory_miranda;gregory_miranda;sanmi_adeleye");
        t.checkExpect(this.t5.allAuthors(), "sangeetha_viswanathan_sakthivel;gregory_miranda;sanmi_adeleye");
    }

    void testTextAppearsOnThread(Tester t) {
        t.checkExpect(this.t1.textAppearsOnThread("sanmi_adeleye"), false);
        t.checkExpect(this.t1.textAppearsOnThread("2022"), false);
        t.checkExpect(this.t1.textAppearsOnThread("cool"), true);
        t.checkExpect(this.t4.textAppearsOnThread("wonder"), true);
        t.checkExpect(this.t4.textAppearsOnThread("Java"), true);
        t.checkExpect(this.t4.textAppearsOnThread("rewrite"), false);
        t.checkExpect(this.t4.textAppearsOnThread("2022"), true);
    }

    void testCountPopularTweets(Tester t) {
        t.checkExpect(this.t1.countPopularTweets(100), 0);
        t.checkExpect(this.t2.countPopularTweets(10), 2);
        t.checkExpect(this.t3.countPopularTweets(70), 2);
        t.checkExpect(this.t5.countPopularTweets(0), 3);
    }
}