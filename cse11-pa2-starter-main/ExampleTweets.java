class User {
    String username;
    String displayName;
    int numberOfFollowers;

    User(String username, String displayName, int numberOfFollowers) {
        this.username = username;
        this.displayName = displayName;
        this.numberOfFollowers = numberOfFollowers;
    }
    String toText(){
        return displayName + " @" + username;
    }
}
class Tweet {
    String content;
    User author;
    int tweetLikes;
    String tweetID;

    Tweet(String content, User author, int tweetLikes, String tweetID) {
        this.content = content;
        this.author = author;
        this.tweetLikes = tweetLikes;
        this.tweetID = tweetID;
    }
    boolean longerThan(Tweet other) {
        return this.content.length()>other.content.length();
    }
    boolean moreLikes(Tweet other) {
        return this.tweetLikes>other.tweetLikes;
    }
    String toText() {
        return this.author.toText() + " : " + this.content + " : " + this.tweetLikes + " Likes"; 
    }
    String toLink() {
        return "https://twitter.com/"+this.author.username+"/status/"+tweetID;
    }
}
class ExampleTweets {
    User user1 = new User("acmucsd","ACM @ UCSD",40);
    User user2 = new User("OmarAlghabra","Omar Alghabra", 30600);
    User user3 = new User("kprather88", "Kimberly Prather, Ph.D.", 60900);

    //https://twitter.com/acmucsd/status/1441932607764131846?cxt=HHwWjMCrvaWE44IoAAAA can't represent the image
    Tweet tweet1 = new Tweet("2 MORE DAYS!!!",user1,1,"1441932607764131846?cxt=HHwWjMCrvaWE44IoAAAA");
    //https://twitter.com/acmucsd/status/1442345648422998019?cxt=HHwWhsCqmbbunoQoAAAA can't represent the image
    Tweet tweet2 = new Tweet("ONE MORE DAY TILL KICKOFF!!!",user1,3,"1442345648422998019?cxt=HHwWhsCqmbbunoQoAAAA");
    //https://twitter.com/OmarAlghabra/status/1483517776966914053 can't represent the video
    Tweet tweet3 = new Tweet("It’s official! The National Supply Chain Summit will be on January 31st. Minister @mclaudebibeau, Minister @FP_Champagne and Minister @mary_ng will join me to talk with our partners on how to strengthen our supply chain.", user2, 69, "1483517776966914053");
    //https://twitter.com/kprather88/status/1481737535646679042?cxt=HHwWhICq6YScmJApAAAA can't represent the link
    Tweet tweet4 = new Tweet("Lots of Q's about schools: Omicron is making it very difficult. This video from August webinar has info on how to make schools safer.  A key layer is air filtration using CR boxes--all of this is included--as well as a discussion on Q's to ask your school.",user3,109,"1481737535646679042?cxt=HHwWhICq6YScmJApAAAA");

    String one = this.user1.toText(); //expected outcome "ACM @ UCSD @acmucsd"
    String two = this.user3.toText(); //expected outcome "Kimberly Prather, Ph.D. @kprather88"

    boolean three = this.tweet1.longerThan(tweet2); //expected outcome false
    boolean four = this.tweet3.longerThan(tweet2); //expected outcome true

    boolean five = this.tweet1.moreLikes(tweet2); //expected outcome false
    boolean six = this.tweet4.moreLikes(tweet3); //expected outcome true

    String seven = this.tweet1.toText(); //expected outcome "ACM @ UCSD @acmucsd : 2 MORE DAYS!!! : 1 Likes"
    String eight = this.tweet3.toText(); //expected outcome "Omar Alghabra @OmarAlghabra : It’s official! The National Supply Chain Summit will be on January 31st. Minister @mclaudebibeau, Minister @FP_Champagne and Minister @mary_ng will join me to talk with our partners on how to strengthen our supply chain. : 69 Likes"

    String nine = this.tweet1.toLink(); //expected outcome "https://twitter.com/acmucsd/status/1441932607764131846?cxt=HHwWjMCrvaWE44IoAAAA"
    String ten = this.tweet3.toLink(); //expected outcome "https://twitter.com/OmarAlghabra/status/1483517776966914053"
}
