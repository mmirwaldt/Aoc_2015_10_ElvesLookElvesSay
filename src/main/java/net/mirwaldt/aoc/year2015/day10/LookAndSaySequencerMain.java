package net.mirwaldt.aoc.year2015.day10;

public class LookAndSaySequencerMain {
    public static void main(String[] args) {
        final LookAndSaySequencer lookAndSaySequencer = new DefaultLookAndSaySequencer();

        // Part one:
        // result - 492982
        System.out.println(lookAndSaySequencer.sequenceLookAndSay("1321131112", 40).length());

        // Part two:
        // result - 6989950
        System.out.println(lookAndSaySequencer.sequenceLookAndSay("1321131112", 50).length());
    }
}
