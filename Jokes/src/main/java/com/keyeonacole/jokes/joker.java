package com.keyeonacole.jokes;

import java.util.ArrayList;

public class joker {
    ArrayList<String > jokes = null;

    public String getJoke(int i){
        jokes = new ArrayList<>();
        jokes.add("Did you hear about the semi-colon that broke the law? He was given two consecutive sentences.");
        jokes.add("The world tongue-twister champion just got arrested. I hear they’re gonna give him a really tough sentence.");
        jokes.add("I own the world’s worst thesaurus. Not only is it awful, it’s awful.");
        jokes.add("What’s the difference between a good joke and a bad joke timing.");
        jokes.add("I woke up this morning and forgot which side the sun rises from, then it dawned on me.");
        jokes.add("I’ve just written a song about tortillas; actually, it’s more of a rap.");
        jokes.add("Velcro – what a rip-off!");
        jokes.add("I recently decided to sell my vacuum cleaner as all it was doing was gathering dust.");
        jokes.add("Don’t you hate it when someone answers their own questions? I do.");
        jokes.add("250 lbs here on Earth is 94.5 lbs on Mercury. No, I’m not fat. I’m just not on the right planet.");
        jokes.add("The best thing about good old days is that we were neither good nor old.");
        jokes.add("I have clean conscience. I haven’t used it once till now.");
        jokes.add("Do I lose when the police officer says papers and I say scissors?");
        jokes.add("If I got 50 cents for every failed math exam, I’d have $ 6.30 now.");
        jokes.add("“Um.” —First horse that got ridden");
        jokes.add("A lot of people cry when they cut onions. The trick is not to form an emotional bond.");
        jokes.add("The four most beautiful words in our common language: I told you so. Gore Vidal");
        jokes.add("Some people just have a way with words, and other people … oh … not have way. Steve Martin");
        jokes.add("I bought one of those tapes to teach you Spanish in your sleep. During the night, the tape skipped. Now I can only stutter in Spanish. Steven Wright");
        jokes.add("THE ALIENS are here to kidnap the smart, beautiful and increddibly handsome!");
        jokes.add("Probably the worst thing you can hear when you’re wearing a bikini is “Good for you!” @ElizaBayne");
        jokes.add("A conference call is the best way for a dozen people to say “bye” 300 times. @DamienFahey");
        jokes.add("Luke Skywalker is my favorite hero that looks 100 percent prepared to figure skate at all times. @thenatewolf (Nathan Usher)");
        jokes.add("When I told my son where milk comes from, he asked, “Mama, how do the cows sit on those little bottles?”");
        jokes.add("Why should you never breakup with a goalie? Because he’s a keeper.");
        String joke = jokes.get(i);
        return joke;
    }

    public int getJokesCount(){
        int size = jokes.size();
        return size;
    }

    public String getCredits(){
        String credit = "Want more don't forget to visit Reader Digest!";
        return credit;
    }

    public String getCreditUrl(){
        String url = "https://www.rd.com/jokes/one-liners/";
        return url;
    }
}
